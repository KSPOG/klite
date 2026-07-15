/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import com.google.common.collect.ImmutableList;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Deque;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Friend;
import net.runelite.api.FriendContainer;
import net.runelite.api.FriendsChatManager;
import net.runelite.api.FriendsChatMember;
import net.runelite.api.GameState;
import net.runelite.api.GraphicsObject;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.HintArrowType;
import net.runelite.api.Ignore;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemComposition;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.MessageNode;
import net.runelite.api.NameableContainer;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.Scene;
import net.runelite.api.Skill;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.TileObject;
import net.runelite.api.World;
import net.runelite.api.WorldView;
import net.runelite.api.clan.ClanChannel;
import net.runelite.api.clan.ClanChannelMember;
import net.runelite.api.clan.ClanID;
import net.runelite.api.clan.ClanMember;
import net.runelite.api.clan.ClanRank;
import net.runelite.api.clan.ClanSettings;
import net.runelite.api.clan.ClanTitle;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.worldmap.WorldMap;
import net.runelite.api.worldmap.WorldMapData;

/** Default thread-safe implementation of the public KLite client API. */
@Singleton
public class DefaultKLiteClientApi implements KLiteClientApi
{

	private static final int VENOM_THRESHOLD = 1_000_000;
	private static final int[] DIALOG_CONTINUE_COMPONENTS =
	{
		InterfaceID.ChatBoth.CONTINUE,
		InterfaceID.ChatLeft.CONTINUE,
		InterfaceID.ChatRight.CONTINUE,
		InterfaceID.Messagebox.CONTINUE,
		InterfaceID.LevelupDisplay.CONTINUE
	};
	private static final MenuAction[] NPC_ACTIONS =
	{
		MenuAction.NPC_FIRST_OPTION,
		MenuAction.NPC_SECOND_OPTION,
		MenuAction.NPC_THIRD_OPTION,
		MenuAction.NPC_FOURTH_OPTION,
		MenuAction.NPC_FIFTH_OPTION
	};
	private static final MenuAction[] OBJECT_ACTIONS =
	{
		MenuAction.GAME_OBJECT_FIRST_OPTION,
		MenuAction.GAME_OBJECT_SECOND_OPTION,
		MenuAction.GAME_OBJECT_THIRD_OPTION,
		MenuAction.GAME_OBJECT_FOURTH_OPTION,
		MenuAction.GAME_OBJECT_FIFTH_OPTION
	};
	private final Client client;
	private final KLiteThreadGateway threadGateway;

	@Inject
	DefaultKLiteClientApi(Client client, KLiteThreadGateway threadGateway)
	{
		this.client = client;
		this.threadGateway = threadGateway;
	}

	@Override
	public CompletableFuture<KLiteClientSnapshot> snapshot()
	{
		return threadGateway.submit(() ->
		{
			Player player = client.getLocalPlayer();
			WorldPoint location = player == null ? null : player.getWorldLocation();
			return new KLiteClientSnapshot(
				client.getGameState(),
				location,
				client.getWorld(),
				System.currentTimeMillis());
		});
	}

	@Override
	public CompletableFuture<KLiteLoginSnapshot> loginSnapshot()
	{
		return threadGateway.submit(() -> new KLiteLoginSnapshot(
			client.getLoginIndex(),
			client.getCurrentLoginField(),
			client.getLauncherDisplayName()));
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setLoginUsername(String username)
	{
		return threadGateway.submit(() ->
		{
			if (username == null)
			{
				return KLiteInteractionResult.invalidRequest(
					"Login username must not be null");
			}
			client.setUsername(username);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setLoginPassword(String password)
	{
		return threadGateway.submit(() ->
		{
			if (password == null)
			{
				return KLiteInteractionResult.invalidRequest(
					"Login password must not be null");
			}
			client.setPassword(password);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setLoginOtp(String otp)
	{
		return threadGateway.submit(() ->
		{
			if (otp == null)
			{
				return KLiteInteractionResult.invalidRequest(
					"Login OTP must not be null");
			}
			client.setOtp(otp);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteRuntimeSnapshot> runtimeSnapshot()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			ImmutableList.Builder<Integer> mapRegions = ImmutableList.builder();
			if (worldView != null && worldView.getMapRegions() != null)
			{
				for (int mapRegion : worldView.getMapRegions())
				{
					mapRegions.add(mapRegion);
				}
			}
			return new KLiteRuntimeSnapshot(
				client.getGameState(),
				client.getWorld(),
				client.getWorldHost(),
				ImmutableList.copyOf(client.getWorldType()),
				client.getTickCount(),
				client.getGameCycle(),
				client.getFPS(),
				worldView == null ? -1 : worldView.getPlane(),
				client.isInInstancedRegion(),
				mapRegions.build(),
				System.currentTimeMillis());
		});
	}

	@Override
	public CompletableFuture<Integer> idleTimeout()
	{
		return threadGateway.submit(client::getIdleTimeout);
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setIdleTimeout(int ticks)
	{
		return threadGateway.submit(() ->
		{
			if (client.getIdleTimeout() == ticks)
			{
				return KLiteInteractionResult.noActionRequired(
					"Idle timeout is already set");
			}
			client.setIdleTimeout(ticks);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteMinimapSnapshot> minimapSnapshot()
	{
		return threadGateway.submit(() -> new KLiteMinimapSnapshot(
			client.isMinimapZoom(),
			client.getMinimapZoom()));
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setMinimapZoomEnabled(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			if (client.isMinimapZoom() == enabled)
			{
				return KLiteInteractionResult.noActionRequired(
					enabled ? "Minimap zoom is already enabled" : "Minimap zoom is already disabled");
			}
			client.setMinimapZoom(enabled);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setMinimapZoom(double pixelsPerTile)
	{
		return threadGateway.submit(() ->
		{
			if (!Double.isFinite(pixelsPerTile))
			{
				return KLiteInteractionResult.invalidRequest(
					"Minimap zoom must be finite");
			}
			if (Double.compare(client.getMinimapZoom(), pixelsPerTile) == 0)
			{
				return KLiteInteractionResult.noActionRequired(
					"Minimap zoom is already set");
			}
			client.setMinimapZoom(pixelsPerTile);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInputSnapshot> inputSnapshot()
	{
		return threadGateway.submit(() -> new KLiteInputSnapshot(
			client.getMouseCanvasPosition(),
			client.getMouseIdleTicks(),
			client.getMouseLastPressedMillis(),
			client.getKeyboardIdleTicks()));
	}

	@Override
	public CompletableFuture<KLiteDisplaySnapshot> displaySnapshot()
	{
		return threadGateway.submit(() ->
		{
			Dimension stretched = client.getStretchedDimensions();
			Dimension real = client.getRealDimensions();
			return new KLiteDisplaySnapshot(
				client.getCanvasWidth(),
				client.getCanvasHeight(),
				client.getViewportXOffset(),
				client.getViewportYOffset(),
				client.getViewportWidth(),
				client.getViewportHeight(),
				client.getScale(),
				client.isResized(),
				client.isStretchedEnabled(),
				client.isStretchedFast(),
				stretched == null ? -1 : stretched.width,
				stretched == null ? -1 : stretched.height,
				real == null ? -1 : real.width,
				real == null ? -1 : real.height);
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setStretchedEnabled(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			if (client.isStretchedEnabled() == enabled)
			{
				return KLiteInteractionResult.noActionRequired(
					enabled ? "Stretching is already enabled" : "Stretching is already disabled");
			}
			client.setStretchedEnabled(enabled);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setStretchedFast(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			if (client.isStretchedFast() == enabled)
			{
				return KLiteInteractionResult.noActionRequired(
					enabled ? "Fast stretching is already enabled" : "Fast stretching is already disabled");
			}
			client.setStretchedFast(enabled);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setStretchedIntegerScaling(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			client.setStretchedIntegerScaling(enabled);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setStretchedKeepAspectRatio(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			client.setStretchedKeepAspectRatio(enabled);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setScalingFactor(int factor)
	{
		return threadGateway.submit(() ->
		{
			client.setScalingFactor(factor);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> invalidateStretching(boolean resize)
	{
		return threadGateway.submit(() ->
		{
			client.invalidateStretching(resize);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<Integer> musicVolume()
	{
		return threadGateway.submit(client::getMusicVolume);
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setMusicVolume(int volume)
	{
		return threadGateway.submit(() ->
		{
			if (volume < 0 || volume > 255)
			{
				return KLiteInteractionResult.invalidRequest(
					"Music volume must be between 0 and 255");
			}
			if (client.getMusicVolume() == volume)
			{
				return KLiteInteractionResult.noActionRequired(
					"Music volume is already set");
			}
			client.setMusicVolume(volume);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> playSoundEffect(int soundId)
	{
		return threadGateway.submit(() ->
		{
			client.playSoundEffect(soundId);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> playSoundEffectAtVolume(
		int soundId, int volume)
	{
		return threadGateway.submit(() ->
		{
			client.playSoundEffect(soundId, volume);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> playAreaSoundEffect(
		int soundId, int x, int y, int range)
	{
		return threadGateway.submit(() ->
		{
			client.playSoundEffect(soundId, x, y, range);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> playAreaSoundEffect(
		int soundId, int x, int y, int range, int delay)
	{
		return threadGateway.submit(() ->
		{
			client.playSoundEffect(soundId, x, y, range, delay);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteCameraSnapshot> cameraSnapshot()
	{
		return threadGateway.submit(() -> new KLiteCameraSnapshot(
			client.getCameraX(),
			client.getCameraY(),
			client.getCameraZ(),
			client.getCameraPitch(),
			client.getCameraYaw(),
			client.getCameraPitchTarget(),
			client.getCameraYawTarget()));
	}

	@Override
	public CompletableFuture<KLiteFreeCameraSnapshot> freeCameraSnapshot()
	{
		return threadGateway.submit(() ->
		{
			int modeId = client.getCameraMode();
			return new KLiteFreeCameraSnapshot(
				KLiteCameraMode.fromId(modeId),
				modeId,
				client.getCameraFocalPointX(),
				client.getCameraFocalPointY(),
				client.getCameraFocalPointZ());
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteWorldMapSnapshot>> worldMapSnapshot()
	{
		return threadGateway.submit(() ->
		{
			WorldMap worldMap = client.getWorldMap();
			if (worldMap == null)
			{
				return Optional.empty();
			}
			Point position = worldMap.getWorldMapPosition();
			return position == null
				? Optional.empty()
				: Optional.of(new KLiteWorldMapSnapshot(
					position, worldMap.getWorldMapZoom()));
		});
	}

	@Override
	public CompletableFuture<Boolean> worldMapContains(WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			if (location == null)
			{
				return false;
			}
			WorldMap worldMap = client.getWorldMap();
			WorldMapData data = worldMap == null ? null : worldMap.getWorldMapData();
			return data != null
				&& data.surfaceContainsPosition(location.getX(), location.getY());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setWorldMapPositionTarget(
		WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			if (location == null)
			{
				return KLiteInteractionResult.invalidRequest(
					"World-map target must not be null");
			}
			WorldMap worldMap = client.getWorldMap();
			if (worldMap == null)
			{
				return KLiteInteractionResult.targetNotFound(
					"World map is unavailable");
			}
			Point position = worldMap.getWorldMapPosition();
			if (position != null
				&& position.getX() == location.getX()
				&& position.getY() == location.getY())
			{
				return KLiteInteractionResult.noActionRequired(
					"World map is already centered on this position");
			}
			worldMap.setWorldMapPositionTarget(location);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<Optional<WorldPoint>> destination()
	{
		return threadGateway.submit(() ->
		{
			LocalPoint destination = client.getLocalDestinationLocation();
			return destination == null ? Optional.empty() : Optional.of(WorldPoint.fromLocalInstance(client, destination));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteHintArrowSnapshot>> hintArrow()
	{
		return threadGateway.submit(() ->
		{
			if (!client.hasHintArrow())
			{
				return Optional.empty();
			}
			int typeId = client.getHintArrowType();
			Player player = typeId == HintArrowType.PLAYER ? client.getHintArrowPlayer() : null;
			NPC npc = typeId == HintArrowType.NPC ? client.getHintArrowNpc() : null;
			WorldPoint point = typeId == HintArrowType.COORDINATE ? client.getHintArrowPoint() : null;
			return Optional.of(new KLiteHintArrowSnapshot(
				KLiteHintArrowType.fromId(typeId),
				typeId,
				point,
				player == null ? null : playerSnapshot(player, player == client.getLocalPlayer()),
				npc == null ? null : npcSnapshot(npc)));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setHintArrow(WorldPoint point)
	{
		return threadGateway.submit(() ->
		{
			if (point == null)
			{
				return KLiteInteractionResult.invalidRequest("Hint-arrow point must not be null");
			}
			if (client.getHintArrowType() == HintArrowType.COORDINATE
				&& point.equals(client.getHintArrowPoint()))
			{
				return KLiteInteractionResult.noActionRequired("Hint arrow already targets this point");
			}
			client.setHintArrow(point);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setHintArrowNpc(int index)
	{
		return threadGateway.submit(() ->
		{
			if (index < 0)
			{
				return KLiteInteractionResult.invalidRequest("NPC index must be non-negative");
			}
			NPC npc = findNpc(client.getTopLevelWorldView(), index);
			if (npc == null)
			{
				return KLiteInteractionResult.targetNotFound("NPC index is not present: " + index);
			}
			if (client.getHintArrowType() == HintArrowType.NPC && client.getHintArrowNpc() == npc)
			{
				return KLiteInteractionResult.noActionRequired("Hint arrow already targets this NPC");
			}
			client.setHintArrow(npc);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setHintArrowPlayer(int id)
	{
		return threadGateway.submit(() ->
		{
			if (id < 0)
			{
				return KLiteInteractionResult.invalidRequest("Player id must be non-negative");
			}
			Player player = findPlayer(client.getTopLevelWorldView(), id);
			if (player == null)
			{
				return KLiteInteractionResult.targetNotFound("Player id is not present: " + id);
			}
			if (client.getHintArrowType() == HintArrowType.PLAYER
				&& client.getHintArrowPlayer() == player)
			{
				return KLiteInteractionResult.noActionRequired("Hint arrow already targets this player");
			}
			client.setHintArrow(player);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> clearHintArrow()
	{
		return threadGateway.submit(() ->
		{
			if (!client.hasHintArrow())
			{
				return KLiteInteractionResult.noActionRequired("No hint arrow is active");
			}
			client.clearHintArrow();
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setCameraYawTarget(int yaw)
	{
		return threadGateway.submit(() ->
		{
			int normalizedYaw = Math.floorMod(yaw, 16_384);
			if (client.getCameraYawTarget() == normalizedYaw)
			{
				return KLiteInteractionResult.noActionRequired("Camera yaw is already targeted");
			}
			client.setCameraYawTarget(normalizedYaw);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setCameraPitchTarget(int pitch)
	{
		return threadGateway.submit(() ->
		{
			if (pitch < 0 || pitch >= 16_384)
			{
				return KLiteInteractionResult.invalidRequest("Camera pitch must be a JAU14 angle");
			}
			if (client.getCameraPitchTarget() == pitch)
			{
				return KLiteInteractionResult.noActionRequired("Camera pitch is already targeted");
			}
			client.setCameraPitchTarget(pitch);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setFreeCameraEnabled(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			int mode = enabled ? KLiteCameraMode.FREE.getId() : KLiteCameraMode.NORMAL.getId();
			if (client.getCameraMode() == mode)
			{
				return KLiteInteractionResult.noActionRequired(
					enabled ? "Free camera is already enabled" : "Free camera is already disabled");
			}
			client.setCameraMode(mode);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setFreeCameraFocalPoint(
		float x, float y, float z)
	{
		return threadGateway.submit(() ->
		{
			if (!Float.isFinite(x) || !Float.isFinite(y) || !Float.isFinite(z))
			{
				return KLiteInteractionResult.invalidRequest(
					"Free-camera focal coordinates must be finite");
			}
			if (client.getCameraMode() != KLiteCameraMode.FREE.getId())
			{
				return KLiteInteractionResult.invalidRequest(
					"Free-camera focal point requires free-camera mode");
			}
			if (Float.compare(client.getCameraFocalPointX(), x) == 0
				&& Float.compare(client.getCameraFocalPointY(), y) == 0
				&& Float.compare(client.getCameraFocalPointZ(), z) == 0)
			{
				return KLiteInteractionResult.noActionRequired(
					"Free-camera focal point is already targeted");
			}
			client.setCameraFocalPointX(x);
			client.setCameraFocalPointY(y);
			client.setCameraFocalPointZ(z);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setFreeCameraSpeed(int speed)
	{
		return threadGateway.submit(() ->
		{
			if (speed < 0)
			{
				return KLiteInteractionResult.invalidRequest(
					"Free-camera speed must be non-negative");
			}
			client.setFreeCameraSpeed(speed);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setCameraSpeed(float speed)
	{
		return threadGateway.submit(() ->
		{
			if (!Float.isFinite(speed))
			{
				return KLiteInteractionResult.invalidRequest(
					"Camera speed must be finite");
			}
			client.setCameraSpeed(speed);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setCameraMouseButtonMask(int mask)
	{
		return threadGateway.submit(() ->
		{
			client.setCameraMouseButtonMask(mask);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setCameraPitchRelaxerEnabled(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			client.setCameraPitchRelaxerEnabled(enabled);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setInvertYaw(boolean inverted)
	{
		return threadGateway.submit(() ->
		{
			client.setInvertYaw(inverted);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setInvertPitch(boolean inverted)
	{
		return threadGateway.submit(() ->
		{
			client.setInvertPitch(inverted);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> openWorldHopper()
	{
		return threadGateway.submit(() ->
		{
			client.openWorldHopper();
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<List<KLiteWorldSnapshot>> worlds()
	{
		return threadGateway.submit(this::worldSnapshots);
	}

	@Override
	public CompletableFuture<Optional<KLiteWorldSnapshot>> world(int worldId)
	{
		return threadGateway.submit(() ->
		{
			World world = findWorld(worldId);
			return world == null ? Optional.empty() : Optional.of(worldSnapshot(world));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> hopToWorld(int worldId)
	{
		return threadGateway.submit(() ->
		{
			if (worldId <= 0)
			{
				return KLiteInteractionResult.invalidRequest("World id must be positive");
			}
			if (client.getWorld() == worldId)
			{
				return KLiteInteractionResult.noActionRequired("Already on world " + worldId);
			}
			World world = findWorld(worldId);
			if (world == null)
			{
				return KLiteInteractionResult.targetNotFound(
					"World is not present in the loaded world list: " + worldId);
			}
			if (client.getGameState() == GameState.LOGIN_SCREEN)
			{
				client.changeWorld(world);
				return KLiteInteractionResult.dispatched();
			}
			if (!isVisible(client.getWidget(InterfaceID.Worldswitcher.BUTTONS)))
			{
				return KLiteInteractionResult.targetNotFound("World hopper is not open");
			}
			client.hopToWorld(world);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<List<KLiteFriendSnapshot>> friends()
	{
		return threadGateway.submit(() ->
		{
			FriendContainer friends = client.getFriendContainer();
			if (friends == null || friends.getMembers() == null)
			{
				return ImmutableList.of();
			}
			ImmutableList.Builder<KLiteFriendSnapshot> snapshots = ImmutableList.builder();
			for (Friend friend : friends.getMembers())
			{
				if (friend != null)
				{
					snapshots.add(new KLiteFriendSnapshot(
						friend.getName(), friend.getPrevName(), friend.getWorld()));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<Boolean> isFriend(String name, boolean mustBeLoggedIn)
	{
		return threadGateway.submit(() -> name != null && client.isFriended(name, mustBeLoggedIn));
	}

	@Override
	public CompletableFuture<List<KLiteIgnoreSnapshot>> ignores()
	{
		return threadGateway.submit(() ->
		{
			NameableContainer<Ignore> ignores = client.getIgnoreContainer();
			if (ignores == null || ignores.getMembers() == null)
			{
				return ImmutableList.of();
			}
			ImmutableList.Builder<KLiteIgnoreSnapshot> snapshots = ImmutableList.builder();
			for (Ignore ignored : ignores.getMembers())
			{
				if (ignored != null)
				{
					snapshots.add(new KLiteIgnoreSnapshot(ignored.getName(), ignored.getPrevName()));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<Boolean> isIgnored(String name)
	{
		return threadGateway.submit(() ->
		{
			NameableContainer<Ignore> ignores = client.getIgnoreContainer();
			return name != null && ignores != null && ignores.findByName(name) != null;
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteFriendsChatSnapshot>> friendsChat()
	{
		return threadGateway.submit(() ->
		{
			FriendsChatManager friendsChat = client.getFriendsChatManager();
			return friendsChat == null
				? Optional.empty()
				: Optional.of(friendsChatSnapshot(friendsChat));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteFriendsChatMemberSnapshot>> friendsChatMember(String name)
	{
		return threadGateway.submit(() ->
		{
			FriendsChatManager friendsChat = client.getFriendsChatManager();
			if (name == null || friendsChat == null)
			{
				return Optional.empty();
			}
			FriendsChatMember member = friendsChat.findByName(name);
			return member == null ? Optional.empty() : Optional.of(friendsChatMemberSnapshot(member));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteClanChannelSnapshot>> clanChannel(KLiteClanType type)
	{
		return threadGateway.submit(() ->
		{
			if (type == null)
			{
				return Optional.empty();
			}
			ClanChannel channel = clanChannelFor(type);
			return channel == null
				? Optional.empty()
				: Optional.of(clanChannelSnapshot(type, channel, clanSettingsFor(type)));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteClanSettingsSnapshot>> clanSettings(KLiteClanType type)
	{
		return threadGateway.submit(() ->
		{
			if (type == null)
			{
				return Optional.empty();
			}
			ClanSettings settings = clanSettingsFor(type);
			return settings == null
				? Optional.empty()
				: Optional.of(clanSettingsSnapshot(type, settings));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteClanChannelMemberSnapshot>> clanChannelMember(
		KLiteClanType type, String name)
	{
		return threadGateway.submit(() ->
		{
			if (type == null || isBlank(name))
			{
				return Optional.empty();
			}
			ClanChannel channel = clanChannelFor(type);
			if (channel == null)
			{
				return Optional.empty();
			}
			ClanChannelMember member = channel.findMember(name);
			return member == null
				? Optional.empty()
				: Optional.of(clanChannelMemberSnapshot(member, clanSettingsFor(type)));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteClanMemberSnapshot>> clanMember(
		KLiteClanType type, String name)
	{
		return threadGateway.submit(() ->
		{
			if (type == null || isBlank(name))
			{
				return Optional.empty();
			}
			ClanSettings settings = clanSettingsFor(type);
			ClanMember member = settings == null ? null : settings.findMember(name);
			return member == null ? Optional.empty() : Optional.of(clanMemberSnapshot(member, settings));
		});
	}

	@Override
	public CompletableFuture<List<KLiteChatMessageSnapshot>> chatMessages()
	{
		return threadGateway.submit(() -> chatMessageSnapshots(null));
	}

	@Override
	public CompletableFuture<List<KLiteChatMessageSnapshot>> chatMessages(ChatMessageType type)
	{
		return threadGateway.submit(() -> chatMessageSnapshots(type));
	}

	@Override
	public CompletableFuture<Optional<KLiteChatMessageSnapshot>> chatMessage(int id)
	{
		return threadGateway.submit(() ->
		{
			if (id < 0 || client.getMessages() == null)
			{
				return Optional.empty();
			}
			MessageNode message = client.getMessages().get(id);
			return message == null ? Optional.empty() : Optional.of(chatMessageSnapshot(message));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> addLocalChatMessage(
		ChatMessageType type, String name, String message, String sender, boolean postEvent)
	{
		return threadGateway.submit(() ->
		{
			if (type == null)
			{
				return KLiteInteractionResult.invalidRequest(
					"Chat message type must not be null");
			}
			if (name == null)
			{
				return KLiteInteractionResult.invalidRequest(
					"Chat message name must not be null");
			}
			client.addChatMessage(type, name, message, sender, postEvent);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> refreshChat()
	{
		return threadGateway.submit(() ->
		{
			client.refreshChat();
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteCombatSnapshot> combatSnapshot()
	{
		return threadGateway.submit(() ->
		{
			Player player = client.getLocalPlayer();
			int poison = client.getVarpValue(VarPlayerID.POISON);
			return new KLiteCombatSnapshot(
				client.getBoostedSkillLevel(Skill.HITPOINTS),
				client.getRealSkillLevel(Skill.HITPOINTS),
				client.getBoostedSkillLevel(Skill.PRAYER),
				client.getRealSkillLevel(Skill.PRAYER),
				client.getEnergy(),
				client.getWeight(),
				client.getVarpValue(VarPlayerID.OPTION_RUN) != 0,
				client.getVarpValue(VarPlayerID.SA_ENERGY),
				client.getVarpValue(VarPlayerID.SA_ATTACK) != 0,
				poison,
				poison > 0 && poison < VENOM_THRESHOLD,
				poison >= VENOM_THRESHOLD,
				client.getVarbitValue(VarbitID.INSIDE_WILDERNESS) != 0,
				player == null ? -1 : player.getAnimation(),
				player == null ? -1 : player.getPoseAnimation(),
				player == null ? null : actorName(player.getInteracting()),
				activePrayerSnapshot());
		});
	}

	@Override
	public CompletableFuture<List<Prayer>> activePrayers()
	{
		return threadGateway.submit(this::activePrayerSnapshot);
	}

	@Override
	public CompletableFuture<Boolean> prayerActive(Prayer prayer)
	{
		return threadGateway.submit(() -> prayer != null && client.getVarbitValue(prayer.getVarbit()) != 0);
	}

	@Override
	public CompletableFuture<Boolean> isGrandExchangeOpen()
	{
		return threadGateway.submit(() -> client.getWidget(InterfaceID.GeOffers.FRAME) != null);
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> collectAllGrandExchange()
	{
		return interactWidget(InterfaceID.GeOffers.COLLECTALL, "Collect");
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> collectGrandExchangeOffer()
	{
		return interactWidget(InterfaceID.GeOffers.DETAILS_COLLECT, "Collect");
	}

	@Override
	public CompletableFuture<List<KLiteGrandExchangeOfferSnapshot>> grandExchangeOffers()
	{
		return threadGateway.submit(() ->
		{
			GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
			if (offers == null)
			{
				return ImmutableList.of();
			}
			ImmutableList.Builder<KLiteGrandExchangeOfferSnapshot> snapshots = ImmutableList.builder();
			for (int slot = 0; slot < offers.length; slot++)
			{
				GrandExchangeOffer offer = offers[slot];
				if (offer != null)
				{
					snapshots.add(grandExchangeOfferSnapshot(slot, offer));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteGrandExchangeOfferSnapshot>> grandExchangeOffer(int slot)
	{
		return threadGateway.submit(() ->
		{
			GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
			if (offers == null || slot < 0 || slot >= offers.length || offers[slot] == null)
			{
				return Optional.empty();
			}
			return Optional.of(grandExchangeOfferSnapshot(slot, offers[slot]));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteItemContainerSnapshot>> itemContainer(int containerId)
	{
		return threadGateway.submit(() ->
		{
			if (containerId < 0)
			{
				return Optional.empty();
			}
			ItemContainer container = client.getItemContainer(containerId);
			return container == null
				? Optional.empty()
				: Optional.of(itemContainerSnapshot(container));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteItemStack>> itemContainerItem(
		int containerId, int slot)
	{
		return threadGateway.submit(() ->
		{
			if (containerId < 0 || slot < 0)
			{
				return Optional.empty();
			}
			Item item = itemAt(containerId, slot);
			return item == null
				? Optional.empty()
				: Optional.of(new KLiteItemStack(slot, item.getId(), item.getQuantity()));
		});
	}

	@Override
	public CompletableFuture<Long> itemContainerCount(int containerId, int itemId)
	{
		return threadGateway.submit(() ->
			containerId < 0 ? 0L : itemCount(containerId, itemId));
	}

	@Override
	public CompletableFuture<Boolean> itemContainerContains(int containerId, int itemId)
	{
		return threadGateway.submit(() ->
			containerId >= 0 && findItemSlot(containerId, itemId).isPresent());
	}

	@Override
	public CompletableFuture<Optional<Integer>> firstItemContainerSlot(
		int containerId, int itemId)
	{
		return threadGateway.submit(() ->
			containerId < 0 ? Optional.empty() : findItemSlot(containerId, itemId));
	}

	@Override
	public CompletableFuture<List<KLiteItemStack>> inventory()
	{
		return itemStacks(InventoryID.INV);
	}

	@Override
	public CompletableFuture<List<KLiteItemStack>> equipment()
	{
		return itemStacks(InventoryID.WORN);
	}

	@Override
	public CompletableFuture<Long> equipmentCount(int itemId)
	{
		return threadGateway.submit(() -> itemCount(InventoryID.WORN, itemId));
	}

	@Override
	public CompletableFuture<Boolean> equipmentContains(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.WORN, itemId).isPresent());
	}

	@Override
	public CompletableFuture<Optional<KLiteItemStack>> equipmentItem(EquipmentInventorySlot slot)
	{
		return threadGateway.submit(() ->
		{
			if (slot == null)
			{
				return Optional.empty();
			}
			Item item = itemAt(InventoryID.WORN, slot.getSlotIdx());
			if (item == null || item.getId() < 0 || item.getQuantity() <= 0)
			{
				return Optional.empty();
			}
			return Optional.of(new KLiteItemStack(
				slot.getSlotIdx(), item.getId(), item.getQuantity()));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactEquipmentItem(
		EquipmentInventorySlot slot, String option)
	{
		return threadGateway.submit(() ->
		{
			int componentId = equipmentComponent(slot);
			return componentId < 0
				? KLiteInteractionResult.invalidRequest("Equipment slot has no public item widget")
				: interactWidget(client.getWidget(componentId), option);
		});
	}

	@Override
	public CompletableFuture<List<KLiteItemStack>> bankItems()
	{
		return itemStacks(InventoryID.BANK);
	}

	@Override
	public CompletableFuture<Long> bankCount(int itemId)
	{
		return threadGateway.submit(() -> itemCount(InventoryID.BANK, itemId));
	}

	@Override
	public CompletableFuture<Boolean> bankContains(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.BANK, itemId).isPresent());
	}

	@Override
	public CompletableFuture<Optional<Integer>> firstBankSlot(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.BANK, itemId));
	}

	@Override
	public CompletableFuture<Long> inventoryCount(int itemId)
	{
		return threadGateway.submit(() -> itemCount(InventoryID.INV, itemId));
	}

	@Override
	public CompletableFuture<Boolean> inventoryContains(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.INV, itemId).isPresent());
	}

	@Override
	public CompletableFuture<Optional<Integer>> firstInventorySlot(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.INV, itemId));
	}

	@Override
	public CompletableFuture<Integer> inventoryFreeSlots()
	{
		return threadGateway.submit(() ->
		{
			ItemContainer inventory = client.getItemContainer(InventoryID.INV);
			if (inventory == null)
			{
				return 0;
			}
			int freeSlots = 0;
			for (Item item : inventory.getItems())
			{
				if (item.getId() < 0 || item.getQuantity() <= 0)
				{
					freeSlots++;
				}
			}
			return freeSlots;
		});
	}

	@Override
	public CompletableFuture<List<KLiteSkillSnapshot>> skills()
	{
		return threadGateway.submit(() ->
		{
			ImmutableList.Builder<KLiteSkillSnapshot> snapshots = ImmutableList.builder();
			for (Skill skill : Skill.values())
			{
				snapshots.add(new KLiteSkillSnapshot(
					skill,
					client.getRealSkillLevel(skill),
					client.getBoostedSkillLevel(skill),
					client.getSkillExperience(skill)));
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<Optional<QuestState>> questState(Quest quest)
	{
		return threadGateway.submit(() -> quest == null
			? Optional.empty()
			: Optional.of(quest.getState(client)));
	}

	@Override
	public CompletableFuture<List<KLitePlayerSnapshot>> players()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			if (worldView == null)
			{
				return ImmutableList.of();
			}
			Player localPlayer = client.getLocalPlayer();
			ImmutableList.Builder<KLitePlayerSnapshot> snapshots = ImmutableList.builder();
			for (Player player : worldView.players())
			{
				snapshots.add(playerSnapshot(player, player == localPlayer));
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLiteNpcSnapshot>> npcs()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			if (worldView == null)
			{
				return ImmutableList.of();
			}
			ImmutableList.Builder<KLiteNpcSnapshot> snapshots = ImmutableList.builder();
			for (NPC npc : worldView.npcs())
			{
				snapshots.add(npcSnapshot(npc));
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteNpcSnapshot>> follower()
	{
		return threadGateway.submit(() -> Optional.ofNullable(client.getFollower())
			.map(DefaultKLiteClientApi::npcSnapshot));
	}

	@Override
	public CompletableFuture<List<KLiteGroundItemSnapshot>> groundItems()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			if (worldView == null || worldView.getScene() == null)
			{
				return ImmutableList.of();
			}

			ImmutableList.Builder<KLiteGroundItemSnapshot> snapshots = ImmutableList.builder();
			addGroundItems(worldView.getScene(), snapshots);
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLiteProjectileSnapshot>> projectiles()
	{
		return threadGateway.submit(() ->
		{
			Deque<Projectile> projectiles = client.getProjectiles();
			if (projectiles == null)
			{
				return ImmutableList.of();
			}
			ImmutableList.Builder<KLiteProjectileSnapshot> snapshots = ImmutableList.builder();
			for (Projectile projectile : projectiles)
			{
				if (projectile != null)
				{
					snapshots.add(new KLiteProjectileSnapshot(
						projectile.getId(), projectile.getSourceLevel(), projectile.getSourcePoint(),
						actorName(projectile.getSourceActor()), projectile.getTargetLevel(), projectile.getTargetPoint(),
						actorName(projectile.getTargetActor()), projectile.getEndHeight(), projectile.getStartCycle(),
						projectile.getEndCycle(), projectile.getRemainingCycles(), projectile.getSlope(),
						projectile.getStartPos(), projectile.getStartHeight(), projectile.getX(), projectile.getY(),
						projectile.getZ(), projectile.getOrientation(), projectile.getAnimationFrame()));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLiteGraphicsObjectSnapshot>> graphicsObjects()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			if (worldView == null || worldView.getGraphicsObjects() == null)
			{
				return ImmutableList.of();
			}
			ImmutableList.Builder<KLiteGraphicsObjectSnapshot> snapshots = ImmutableList.builder();
			for (GraphicsObject graphicsObject : worldView.getGraphicsObjects())
			{
				if (graphicsObject != null)
				{
					snapshots.add(new KLiteGraphicsObjectSnapshot(
						graphicsObject.getId(), graphicsObject.getLocation(), graphicsObject.getStartCycle(),
						graphicsObject.getLevel(), graphicsObject.getZ(), graphicsObject.finished(),
						graphicsObject.getAnimationFrame()));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLiteSceneObjectSnapshot>> sceneObjects()
	{
		return threadGateway.submit(this::currentSceneObjectSnapshots);
	}

	@Override
	public CompletableFuture<Optional<KLitePlayerSnapshot>> nearestPlayer(String name)
	{
		return threadGateway.submit(() -> nearestPlayerSnapshot(name));
	}

	@Override
	public CompletableFuture<Optional<KLiteNpcSnapshot>> nearestNpc(int npcId)
	{
		return threadGateway.submit(() -> nearestNpcSnapshot(npcId, null));
	}

	@Override
	public CompletableFuture<Optional<KLiteNpcSnapshot>> nearestNpc(String name)
	{
		return threadGateway.submit(() -> nearestNpcSnapshot(-1, name));
	}

	@Override
	public CompletableFuture<Optional<KLiteGroundItemSnapshot>> nearestGroundItem(int itemId)
	{
		return threadGateway.submit(() -> nearestGroundItemSnapshot(itemId, null));
	}

	@Override
	public CompletableFuture<Optional<KLiteGroundItemSnapshot>> nearestGroundItem(String name)
	{
		return threadGateway.submit(() -> nearestGroundItemSnapshot(-1, name));
	}

	@Override
	public CompletableFuture<Optional<KLiteSceneObjectSnapshot>> nearestSceneObject(int objectId)
	{
		return threadGateway.submit(() -> nearestSceneObjectSnapshot(objectId, null));
	}

	@Override
	public CompletableFuture<Optional<KLiteSceneObjectSnapshot>> nearestSceneObject(String name)
	{
		return threadGateway.submit(() -> nearestSceneObjectSnapshot(-1, name));
	}

	@Override
	public CompletableFuture<Optional<KLiteItemDefinition>> itemDefinition(int itemId)
	{
		return threadGateway.submit(() -> itemId < 0
			? Optional.empty()
			: Optional.of(itemDefinitionSnapshot(client.getItemDefinition(itemId))));
	}

	@Override
	public CompletableFuture<Optional<KLiteNpcDefinition>> npcDefinition(int npcId)
	{
		return threadGateway.submit(() ->
		{
			if (npcId < 0)
			{
				return Optional.empty();
			}
			NPCComposition composition = client.getNpcDefinition(npcId);
			if (composition.getConfigs() != null)
			{
				NPCComposition transformed = composition.transform();
				if (transformed != null)
				{
					composition = transformed;
				}
			}
			return Optional.of(npcDefinitionSnapshot(composition));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteObjectDefinition>> objectDefinition(int objectId)
	{
		return threadGateway.submit(() ->
		{
			if (objectId < 0)
			{
				return Optional.empty();
			}
			ObjectComposition composition = client.getObjectDefinition(objectId);
			if (composition.getImpostorIds() != null)
			{
				ObjectComposition transformed = composition.getImpostor();
				if (transformed != null)
				{
					composition = transformed;
				}
			}
			return Optional.of(objectDefinitionSnapshot(composition));
		});
	}

	@Override
	public CompletableFuture<Optional<Integer>> distanceTo(WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			Player player = client.getLocalPlayer();
			return player == null || location == null
				? Optional.empty()
				: Optional.of(player.getWorldLocation().distanceTo(location));
		});
	}

	@Override
	public CompletableFuture<Boolean> hasLineOfSightTo(WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			Player player = client.getLocalPlayer();
			WorldView worldView = client.getTopLevelWorldView();
			return player != null && worldView != null && location != null
				&& player.getWorldArea().hasLineOfSightTo(worldView, location);
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteWidgetSnapshot>> widget(int componentId)
	{
		return threadGateway.submit(() -> componentId < 0
			? Optional.empty()
			: Optional.ofNullable(client.getWidget(componentId))
				.map(DefaultKLiteClientApi::widgetSnapshot));
	}

	@Override
	public CompletableFuture<Optional<KLiteWidgetSnapshot>> widgetChild(
		int componentId, int childIndex)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0 || childIndex < 0)
			{
				return Optional.empty();
			}
			Widget parent = client.getWidget(componentId);
			return Optional.ofNullable(parent == null ? null : parent.getChild(childIndex))
				.map(DefaultKLiteClientApi::widgetSnapshot);
		});
	}

	@Override
	public CompletableFuture<List<KLiteWidgetSnapshot>> widgetChildren(int componentId)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0)
			{
				return ImmutableList.of();
			}
			Widget parent = client.getWidget(componentId);
			Widget[] children = parent == null ? null : parent.getChildren();
			if (children == null)
			{
				return ImmutableList.of();
			}

			ImmutableList.Builder<KLiteWidgetSnapshot> snapshots = ImmutableList.builder();
			for (Widget child : children)
			{
				if (child != null)
				{
					snapshots.add(widgetSnapshot(child));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteWidgetSnapshot>> selectedWidget()
	{
		return threadGateway.submit(() -> Optional.ofNullable(client.getSelectedWidget())
			.map(DefaultKLiteClientApi::widgetSnapshot));
	}

	@Override
	public CompletableFuture<Boolean> widgetTargetSelected()
	{
		return threadGateway.submit(client::isWidgetSelected);
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> clearWidgetTarget()
	{
		return threadGateway.submit(() ->
		{
			if (!client.isWidgetSelected())
			{
				return KLiteInteractionResult.noActionRequired(
					"No widget target is selected");
			}
			client.setWidgetSelected(false);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<Optional<WorldPoint>> selectedSceneTile()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			Tile tile = worldView == null ? null : worldView.getSelectedSceneTile();
			return Optional.ofNullable(tile == null ? null : tile.getWorldLocation());
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteWidgetSnapshot>> focusedInputWidget()
	{
		return threadGateway.submit(() -> Optional.ofNullable(client.getFocusedInputFieldWidget())
			.map(DefaultKLiteClientApi::widgetSnapshot));
	}

	@Override
	public CompletableFuture<Boolean> isBankOpen()
	{
		return threadGateway.submit(() -> isVisible(client.getWidget(InterfaceID.Bankmain.ITEMS)));
	}

	@Override
	public CompletableFuture<Boolean> isShopOpen()
	{
		return threadGateway.submit(() -> client.getWidget(InterfaceID.Shopmain.ITEMS) != null);
	}

	@Override
	public CompletableFuture<Boolean> isTradeOpen()
	{
		return threadGateway.submit(() -> client.getWidget(InterfaceID.Trademain.CONTAINER) != null
			|| client.getWidget(InterfaceID.Tradeconfirm.FRAME) != null);
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> acceptTrade()
	{
		return threadGateway.submit(() ->
		interactWidget(firstWidget(InterfaceID.Trademain.ACCEPT, InterfaceID.Tradeconfirm.TRADE2ACCEPT), "Accept"));
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> declineTrade()
	{
		return threadGateway.submit(() ->
		interactWidget(firstWidget(InterfaceID.Trademain.DECLINE, InterfaceID.Tradeconfirm.TRADE2DECLINE), "Decline"));
	}

	@Override
	public CompletableFuture<List<KLiteDialogOption>> dialogOptions()
	{
		return threadGateway.submit(() ->
		{
			Widget options = client.getWidget(InterfaceID.Chatmenu.OPTIONS);
			Widget[] children = options == null ? null : options.getChildren();
			if (children == null)
			{
				return ImmutableList.of();
			}

			ImmutableList.Builder<KLiteDialogOption> result = ImmutableList.builder();
			for (Widget child : children)
			{
				if (child != null && child.getIndex() > 0 && !child.isHidden()
					&& !isBlank(child.getText()))
				{
					result.add(new KLiteDialogOption(child.getIndex(), child.getText()));
				}
			}
			return result.build();
		});
	}

	@Override
	public CompletableFuture<Integer> varbit(int varbitId)
	{
		return threadGateway.submit(() -> client.getVarbitValue(varbitId));
	}

	@Override
	public CompletableFuture<Integer> serverVarbit(int varbitId)
	{
		return threadGateway.submit(() -> client.getServerVarbitValue(varbitId));
	}

	@Override
	public CompletableFuture<Integer> varp(int varpId)
	{
		return threadGateway.submit(() -> client.getVarpValue(varpId));
	}

	@Override
	public CompletableFuture<Integer> serverVarp(int varpId)
	{
		return threadGateway.submit(() -> client.getServerVarpValue(varpId));
	}

	@Override
	public CompletableFuture<Integer> varcInt(int varcId)
	{
		return threadGateway.submit(() -> client.getVarcIntValue(varcId));
	}

	@Override
	public CompletableFuture<String> varcString(int varcId)
	{
		return threadGateway.submit(() -> client.getVarcStrValue(varcId));
	}

	@Override
	public CompletableFuture<Void> setVarcInt(int varcId, int value)
	{
		return threadGateway.execute(() -> client.setVarcIntValue(varcId, value));
	}

	@Override
	public CompletableFuture<Void> setVarcString(int varcId, String value)
	{
		return threadGateway.execute(() -> client.setVarcStrValue(varcId, value));
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactInventoryItem(int slot, String option)
	{
		return threadGateway.submit(() ->
		{
			if (slot < 0 || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest("Slot must be non-negative and option must not be blank");
			}

			ItemContainer inventory = client.getItemContainer(InventoryID.INV);
			if (inventory == null || slot >= inventory.getItems().length)
			{
				return KLiteInteractionResult.targetNotFound("No inventory item exists in slot " + slot);
			}

			Item item = inventory.getItems()[slot];
			if (item.getId() < 0 || item.getQuantity() <= 0)
			{
				return KLiteInteractionResult.targetNotFound("No inventory item exists in slot " + slot);
			}

			ItemComposition composition = client.getItemDefinition(item.getId());
			int actionIndex = findAction(composition.getInventoryActions(), option);
			if (actionIndex < 0)
			{
				return KLiteInteractionResult.optionNotFound(
					"Inventory item does not expose option: " + option);
			}

			String action = composition.getInventoryActions()[actionIndex];
			client.menuAction(slot, InterfaceID.Inventory.ITEMS, itemMenuAction(actionIndex),
				actionIndex + 1, item.getId(), action, composition.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> selectInventoryItem(int slot)
	{
		return threadGateway.submit(() ->
		{
			Item item = itemAt(InventoryID.INV, slot);
			if (slot < 0)
			{
				return KLiteInteractionResult.invalidRequest("Slot must be non-negative");
			}
			if (item == null)
			{
				return KLiteInteractionResult.targetNotFound(
					"No inventory item exists in slot " + slot);
			}

			ItemComposition composition = client.getItemDefinition(item.getId());
			client.menuAction(slot, InterfaceID.Inventory.ITEMS, MenuAction.WIDGET_TARGET,
				0, item.getId(), "Use", composition.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnInventoryItem(int slot)
	{
		return threadGateway.submit(() ->
		{
			if (slot < 0)
			{
				return KLiteInteractionResult.invalidRequest("Slot must be non-negative");
			}
			Item item = itemAt(InventoryID.INV, slot);
			if (item == null)
			{
				return KLiteInteractionResult.targetNotFound(
					"No inventory item exists in slot " + slot);
			}
			if (!client.isWidgetSelected() || client.getSelectedWidget() == null)
			{
				return KLiteInteractionResult.noWidgetSelected();
			}
			return dispatchSelectedTarget(slot, InterfaceID.Inventory.ITEMS,
				MenuAction.WIDGET_TARGET_ON_WIDGET, 0, item.getId(),
				client.getItemDefinition(item.getId()).getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactBankItem(int slot, String option)
	{
		return interactWidgetChild(InterfaceID.Bankmain.ITEMS, slot, option);
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactBankInventoryItem(int slot, String option)
	{
		return interactWidgetChild(InterfaceID.Bankside.ITEMS, slot, option);
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> withdrawBankItem(
		int slot, KLiteBankQuantity quantity)
	{
		return bankItemInteraction(
			InterfaceID.Bankmain.ITEMS, slot,
			quantity == null ? null : quantity.getWithdrawOption());
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> depositBankInventoryItem(
		int slot, KLiteBankQuantity quantity)
	{
		return bankItemInteraction(
			InterfaceID.Bankside.ITEMS, slot,
			quantity == null ? null : quantity.getDepositOption());
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> depositInventory()
	{
		return interactWidget(InterfaceID.Bankmain.DEPOSITINV, "Deposit inventory");
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> depositEquipment()
	{
		return interactWidget(InterfaceID.Bankmain.DEPOSITWORN, "Deposit worn items");
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setRunEnabled(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			boolean current = client.getVarpValue(VarPlayerID.OPTION_RUN) != 0;
			return current == enabled
				? KLiteInteractionResult.noActionRequired("Run is already " + stateName(enabled))
				: interactFirstWidgetAction(client.getWidget(InterfaceID.Orbs.ORB_RUNENERGY));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setSpecialAttackEnabled(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			boolean current = client.getVarpValue(VarPlayerID.SA_ATTACK) != 0;
			return current == enabled
				? KLiteInteractionResult.noActionRequired(
					"Special attack is already " + stateName(enabled))
				: interactFirstWidgetAction(client.getWidget(InterfaceID.CombatInterface.SPECIAL_ATTACK));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> selectWidgetTarget(int componentId)
	{
		return threadGateway.submit(() -> componentId < 0
			? KLiteInteractionResult.invalidRequest("Widget component id must be non-negative")
			: selectWidgetTarget(client.getWidget(componentId)));
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> selectWidgetTargetChild(
		int componentId, int childIndex)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0 || childIndex < 0)
			{
				return KLiteInteractionResult.invalidRequest(
					"Widget component id and child index must be non-negative");
			}
			Widget parent = client.getWidget(componentId);
			return selectWidgetTarget(parent == null ? null : parent.getChild(childIndex));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactWidget(int componentId, String option)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0)
			{
				return KLiteInteractionResult.invalidRequest("Widget component id must be non-negative");
			}
			return interactWidget(client.getWidget(componentId), option);
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactWidgetChild(
		int componentId, int childIndex, String option)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0 || childIndex < 0)
			{
				return KLiteInteractionResult.invalidRequest(
					"Widget component id and child index must be non-negative");
			}
			Widget parent = client.getWidget(componentId);
			return interactWidget(parent == null ? null : parent.getChild(childIndex), option);
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactNpc(int index, String option)
	{
		return threadGateway.submit(() ->
		{
			if (index < 0 || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest("NPC index must be non-negative and option must not be blank");
			}

			WorldView worldView = client.getTopLevelWorldView();
			NPC npc = findNpc(worldView, index);
			if (npc == null)
			{
				return KLiteInteractionResult.targetNotFound("NPC index is not present: " + index);
			}

			NPCComposition composition = npc.getTransformedComposition();
			if (composition == null)
			{
				composition = npc.getComposition();
			}
			int actionIndex = findAction(composition.getActions(), option);
			if (actionIndex < 0)
			{
				return KLiteInteractionResult.optionNotFound("NPC does not expose option: " + option);
			}

			String action = composition.getActions()[actionIndex];
			client.menuAction(0, 0, NPC_ACTIONS[actionIndex], index, -1, action, composition.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactPlayer(int id, String option)
	{
		return threadGateway.submit(() ->
		{
			if (id < 0 || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest("Player id must be non-negative and option must not be blank");
			}

			WorldView worldView = client.getTopLevelWorldView();
			Player player = findPlayer(worldView, id);
			if (player == null)
			{
				return KLiteInteractionResult.targetNotFound("Player id is not present: " + id);
			}

			String[] options = client.getPlayerOptions();
			int actionIndex = findAction(options, option);
			int[] menuTypes = client.getPlayerMenuTypes();
			if (actionIndex < 0 || menuTypes == null || actionIndex >= menuTypes.length)
			{
				return KLiteInteractionResult.optionNotFound("Player does not expose option: " + option);
			}

			MenuAction action = MenuAction.of(menuTypes[actionIndex]);
			if (action == MenuAction.UNKNOWN)
			{
				return KLiteInteractionResult.optionNotFound("Player option has an unknown menu action: " + option);
			}

			client.menuAction(0, 0, action, id, -1, options[actionIndex], player.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactSceneObject(
		int objectId, WorldPoint location, String option)
	{
		return threadGateway.submit(() ->
		{
			if (objectId < 0 || location == null || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest(
					"Object id and location must be valid and option must not be blank");
			}

			TileObject object = findSceneObject(client.getTopLevelWorldView(), objectId, location);
			if (object == null)
			{
				return KLiteInteractionResult.targetNotFound("Scene object is no longer present");
			}

			ObjectComposition composition = objectComposition(object);
			String[] actions = resolveObjectActions(object, composition);
			int actionIndex = findAction(actions, option);
			if (actionIndex < 0)
			{
				return KLiteInteractionResult.optionNotFound("Scene object does not expose option: " + option);
			}

			LocalPoint local = object.getLocalLocation();
			client.menuAction(local.getSceneX(), local.getSceneY(), OBJECT_ACTIONS[actionIndex],
				object.getId(), -1, actions[actionIndex], composition.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactGroundItem(
		int itemId, WorldPoint location, String option)
	{
		return threadGateway.submit(() ->
		{
			if (itemId < 0 || location == null || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest(
					"Item id and location must be valid and option must not be blank");
			}
			if (!"Take".equalsIgnoreCase(option.trim()))
			{
				return KLiteInteractionResult.optionNotFound(
					"Only RuneLite's verified ground-item Take action is supported");
			}

			Tile tile = findTile(client.getTopLevelWorldView(), location);
			if (tile == null || !containsGroundItem(tile, itemId))
			{
				return KLiteInteractionResult.targetNotFound("Ground item is no longer present");
			}

			ItemComposition composition = client.getItemDefinition(itemId);
			LocalPoint local = tile.getLocalLocation();
			client.menuAction(local.getSceneX(), local.getSceneY(), MenuAction.GROUND_ITEM_THIRD_OPTION,
				itemId, itemId, "Take", composition.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnNpc(int index)
	{
		return threadGateway.submit(() ->
		{
			if (index < 0)
			{
				return KLiteInteractionResult.invalidRequest("NPC index must be non-negative");
			}
			NPC npc = findNpc(client.getTopLevelWorldView(), index);
			if (npc == null)
			{
				return KLiteInteractionResult.targetNotFound("NPC index is not present: " + index);
			}
			return dispatchSelectedTarget(0, 0, MenuAction.WIDGET_TARGET_ON_NPC,
				index, -1, npc.getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnPlayer(int id)
	{
		return threadGateway.submit(() ->
		{
			if (id < 0)
			{
				return KLiteInteractionResult.invalidRequest("Player id must be non-negative");
			}
			Player player = findPlayer(client.getTopLevelWorldView(), id);
			if (player == null)
			{
				return KLiteInteractionResult.targetNotFound("Player id is not present: " + id);
			}
			return dispatchSelectedTarget(0, 0, MenuAction.WIDGET_TARGET_ON_PLAYER,
				id, -1, player.getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnSceneObject(
		int objectId, WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			if (objectId < 0 || location == null)
			{
				return KLiteInteractionResult.invalidRequest("Object id and location must be valid");
			}
			TileObject object = findSceneObject(client.getTopLevelWorldView(), objectId, location);
			if (object == null)
			{
				return KLiteInteractionResult.targetNotFound("Scene object is no longer present");
			}
			LocalPoint local = object.getLocalLocation();
			return dispatchSelectedTarget(local.getSceneX(), local.getSceneY(),
				MenuAction.WIDGET_TARGET_ON_GAME_OBJECT, object.getId(), -1,
				objectComposition(object).getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnGroundItem(
		int itemId, WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			if (itemId < 0 || location == null)
			{
				return KLiteInteractionResult.invalidRequest("Item id and location must be valid");
			}
			Tile tile = findTile(client.getTopLevelWorldView(), location);
			if (tile == null || !containsGroundItem(tile, itemId))
			{
				return KLiteInteractionResult.targetNotFound("Ground item is no longer present");
			}
			LocalPoint local = tile.getLocalLocation();
			return dispatchSelectedTarget(local.getSceneX(), local.getSceneY(),
				MenuAction.WIDGET_TARGET_ON_GROUND_ITEM, itemId, itemId,
				client.getItemDefinition(itemId).getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> chooseDialogOption(int index)
	{
		return threadGateway.submit(() ->
		{
			if (index < 1)
			{
				return KLiteInteractionResult.invalidRequest(
					"Dialogue option index must be at least 1");
			}
			Widget parent = client.getWidget(InterfaceID.Chatmenu.OPTIONS);
			Widget option = parent == null ? null : parent.getChild(index);
			if (!isVisible(option) || isBlank(option.getText()))
			{
				return KLiteInteractionResult.targetNotFound(
					"Dialogue option is not present: " + index);
			}
			client.menuAction(option.getIndex(), option.getId(), MenuAction.WIDGET_CONTINUE,
				0, option.getItemId(), option.getText(), "");
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> continueDialog()
	{
		return threadGateway.submit(() ->
		{
			for (int componentId : DIALOG_CONTINUE_COMPONENTS)
			{
				Widget widget = client.getWidget(componentId);
				if (isVisible(widget))
				{
					client.menuAction(widget.getIndex(), widget.getId(), MenuAction.WIDGET_CONTINUE,
						0, widget.getItemId(), "Continue", "");
					return KLiteInteractionResult.dispatched();
				}
			}
			return KLiteInteractionResult.targetNotFound("No supported continue dialogue is open");
		});
	}

	@Override
	public CompletableFuture<KLiteMenuSnapshot> menuSnapshot()
	{
		return threadGateway.submit(() ->
		{
			Menu menu = client.getMenu();
			if (menu == null)
			{
				return new KLiteMenuSnapshot(
					client.isMenuOpen(), client.isMenuScrollable(), client.getMenuScroll(),
					0, 0, 0, 0, ImmutableList.of());
			}
			MenuEntry[] entries = menu.getMenuEntries();
			ImmutableList.Builder<KLiteMenuEntrySnapshot> snapshots = ImmutableList.builder();
			if (entries != null)
			{
				for (int index = 0; index < entries.length; index++)
				{
					if (entries[index] != null)
					{
						snapshots.add(menuEntrySnapshot(index, entries[index]));
					}
				}
			}
			return new KLiteMenuSnapshot(
				client.isMenuOpen(),
				client.isMenuScrollable(),
				client.getMenuScroll(),
				menu.getMenuX(),
				menu.getMenuY(),
				menu.getMenuWidth(),
				menu.getMenuHeight(),
				snapshots.build());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactMenuEntry(int index)
	{
		return threadGateway.submit(() ->
		{
			if (index < 0)
			{
				return KLiteInteractionResult.invalidRequest("Menu entry index must be non-negative");
			}
			Menu menu = client.getMenu();
			MenuEntry[] entries = menu == null ? null : menu.getMenuEntries();
			if (entries == null || index >= entries.length || entries[index] == null)
			{
				return KLiteInteractionResult.targetNotFound(
					"Menu entry is not present at index " + index);
			}
			MenuEntry entry = entries[index];
			if (entry.getType() == null)
			{
				return KLiteInteractionResult.optionNotFound("Menu entry has no action");
			}
			client.menuAction(
				entry.getParam0(), entry.getParam1(), entry.getType(), entry.getIdentifier(),
				entry.getItemId(), nullToEmpty(entry.getOption()), nullToEmpty(entry.getTarget()));
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> runScript(Object... arguments)
	{
		Object[] copiedArguments = arguments == null ? null : arguments.clone();
		return threadGateway.submit(() ->
		{
			if (copiedArguments == null || copiedArguments.length == 0)
			{
				return KLiteInteractionResult.invalidRequest(
					"Client script arguments must include a script identifier");
			}
			client.runScript(copiedArguments);
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<Void> menuAction(KLiteMenuActionRequest request)
	{
		return threadGateway.execute(() -> client.menuAction(
			request.getParam0(),
			request.getParam1(),
			request.getAction(),
			request.getIdentifier(),
			request.getItemId(),
			request.getOption(),
			request.getTarget()));
	}

	@Override
	public CompletableFuture<Void> onClientThread(Runnable action)
	{
		return threadGateway.execute(action);
	}

	private List<Prayer> activePrayerSnapshot()
	{
		ImmutableList.Builder<Prayer> prayers = ImmutableList.builder();
		for (Prayer prayer : Prayer.values())
		{
			if (client.getVarbitValue(prayer.getVarbit()) != 0)
			{
				prayers.add(prayer);
			}
		}
		return prayers.build();
	}

	private KLiteInteractionResult interactFirstWidgetAction(@Nullable Widget widget)
	{
		if (!isVisible(widget))
		{
			return KLiteInteractionResult.targetNotFound("Widget is absent or hidden");
		}
		String[] actions = widget.getActions();
		if (actions != null)
		{
			for (String action : actions)
			{
				if (!isBlank(action))
				{
					return interactWidget(widget, action);
				}
			}
		}
		return KLiteInteractionResult.optionNotFound("Widget does not expose an action");
	}

	private KLiteInteractionResult selectWidgetTarget(@Nullable Widget widget)
	{
		if (!isVisible(widget))
		{
			return KLiteInteractionResult.targetNotFound("Widget is absent or hidden");
		}
		String verb = widget.getTargetVerb();
		if (isBlank(verb))
		{
			return KLiteInteractionResult.optionNotFound("Widget is not a selectable target");
		}
		String target = isBlank(widget.getName()) ? widget.getText() : widget.getName();
		client.menuAction(widget.getIndex(), widget.getId(), MenuAction.WIDGET_TARGET,
			0, widget.getItemId(), verb, target == null ? "" : target);
		return KLiteInteractionResult.dispatched();
	}

	private static String stateName(boolean enabled)
	{
		return enabled ? "enabled" : "disabled";
	}
	private CompletableFuture<KLiteInteractionResult> bankItemInteraction(
		int componentId, int slot, @Nullable String option)
	{
		return threadGateway.submit(() ->
		{
			if (slot < 0 || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest(
					"Bank slot must be non-negative and quantity must be provided");
			}
			Widget parent = client.getWidget(componentId);
			return interactWidget(parent == null ? null : parent.getChild(slot), option);
		});
	}

	private static KLiteGrandExchangeOfferSnapshot grandExchangeOfferSnapshot(
		int slot, GrandExchangeOffer offer)
	{
		return new KLiteGrandExchangeOfferSnapshot(slot, offer.getItemId(), offer.getQuantitySold(),
			offer.getTotalQuantity(), offer.getPrice(), offer.getSpent(), offer.getState());
	}

	private static int equipmentComponent(@Nullable EquipmentInventorySlot slot)
	{
		if (slot == null)
		{
			return -1;
		}
		switch (slot)
		{
			case HEAD: return InterfaceID.Wornitems.SLOT0;
			case CAPE: return InterfaceID.Wornitems.SLOT1;
			case AMULET: return InterfaceID.Wornitems.SLOT2;
			case WEAPON: return InterfaceID.Wornitems.SLOT3;
			case BODY: return InterfaceID.Wornitems.SLOT4;
			case SHIELD: return InterfaceID.Wornitems.SLOT5;
			case LEGS: return InterfaceID.Wornitems.SLOT7;
			case GLOVES: return InterfaceID.Wornitems.SLOT9;
			case BOOTS: return InterfaceID.Wornitems.SLOT10;
			case RING: return InterfaceID.Wornitems.SLOT12;
			case AMMO: return InterfaceID.Wornitems.SLOT13;
			default: return -1;
		}
	}

	@Nullable
	private Widget firstWidget(int firstComponentId, int secondComponentId)
	{
		Widget first = client.getWidget(firstComponentId);
		return first == null ? client.getWidget(secondComponentId) : first;
	}

	private List<KLiteWorldSnapshot> worldSnapshots()
	{
		World[] worlds = client.getWorldList();
		if (worlds == null)
		{
			return ImmutableList.of();
		}
		ImmutableList.Builder<KLiteWorldSnapshot> snapshots = ImmutableList.builder();
		for (World world : worlds)
		{
			if (world != null)
			{
				snapshots.add(worldSnapshot(world));
			}
		}
		return snapshots.build();
	}

	@Nullable
	private World findWorld(int worldId)
	{
		World[] worlds = client.getWorldList();
		if (worldId <= 0 || worlds == null)
		{
			return null;
		}
		for (World world : worlds)
		{
			if (world != null && world.getId() == worldId)
			{
				return world;
			}
		}
		return null;
	}

	private static KLiteWorldSnapshot worldSnapshot(World world)
	{
		return new KLiteWorldSnapshot(
			world.getId(), world.getIndex(), world.getPlayerCount(), world.getLocation(),
			world.getActivity(), world.getAddress(),
			world.getTypes() == null ? ImmutableList.of() : ImmutableList.copyOf(world.getTypes()));
	}

	@Nullable
	private ClanChannel clanChannelFor(KLiteClanType type)
	{
		switch (type)
		{
			case PRIMARY:
				return client.getClanChannel();
			case GUEST:
				return client.getGuestClanChannel();
			case GROUP_IRONMAN:
				return client.getClanChannel(ClanID.GROUP_IRONMAN);
			default:
				return null;
		}
	}

	@Nullable
	private ClanSettings clanSettingsFor(KLiteClanType type)
	{
		switch (type)
		{
			case PRIMARY:
				return client.getClanSettings();
			case GUEST:
				return client.getGuestClanSettings();
			case GROUP_IRONMAN:
				return client.getClanSettings(ClanID.GROUP_IRONMAN);
			default:
				return null;
		}
	}

	private static KLiteClanChannelSnapshot clanChannelSnapshot(
		KLiteClanType type, ClanChannel channel, @Nullable ClanSettings settings)
	{
		ImmutableList.Builder<KLiteClanChannelMemberSnapshot> members = ImmutableList.builder();
		List<ClanChannelMember> currentMembers = channel.getMembers();
		if (currentMembers != null)
		{
			for (ClanChannelMember member : currentMembers)
			{
				if (member != null)
				{
					members.add(clanChannelMemberSnapshot(member, settings));
				}
			}
		}
		return new KLiteClanChannelSnapshot(type, channel.getName(), members.build());
	}

	private static KLiteClanSettingsSnapshot clanSettingsSnapshot(
		KLiteClanType type, ClanSettings settings)
	{
		ImmutableList.Builder<KLiteClanMemberSnapshot> members = ImmutableList.builder();
		List<ClanMember> currentMembers = settings.getMembers();
		if (currentMembers != null)
		{
			for (ClanMember member : currentMembers)
			{
				if (member != null)
				{
					members.add(clanMemberSnapshot(member, settings));
				}
			}
		}
		return new KLiteClanSettingsSnapshot(type, settings.getName(), members.build());
	}

	private static KLiteClanChannelMemberSnapshot clanChannelMemberSnapshot(
		ClanChannelMember member, @Nullable ClanSettings settings)
	{
		ClanRank rank = member.getRank();
		return new KLiteClanChannelMemberSnapshot(
			member.getName(),
			member.getPrevName(),
			member.getWorld(),
			rank,
			clanTitleSnapshot(settings, rank));
	}

	private static KLiteClanMemberSnapshot clanMemberSnapshot(
		ClanMember member, ClanSettings settings)
	{
		ClanRank rank = member.getRank();
		return new KLiteClanMemberSnapshot(
			member.getName(),
			rank,
			member.getJoinDate(),
			clanTitleSnapshot(settings, rank));
	}

	@Nullable
	private static KLiteClanTitleSnapshot clanTitleSnapshot(
		@Nullable ClanSettings settings, @Nullable ClanRank rank)
	{
		if (settings == null || rank == null)
		{
			return null;
		}
		ClanTitle title = settings.titleForRank(rank);
		return title == null ? null : new KLiteClanTitleSnapshot(title.getId(), title.getName());
	}

	private static KLiteFriendsChatSnapshot friendsChatSnapshot(FriendsChatManager friendsChat)
	{
		ImmutableList.Builder<KLiteFriendsChatMemberSnapshot> members = ImmutableList.builder();
		FriendsChatMember[] currentMembers = friendsChat.getMembers();
		if (currentMembers != null)
		{
			for (FriendsChatMember member : currentMembers)
			{
				if (member != null)
				{
					members.add(friendsChatMemberSnapshot(member));
				}
			}
		}
		return new KLiteFriendsChatSnapshot(
			friendsChat.getOwner(),
			friendsChat.getName(),
			friendsChat.getMyRank(),
			friendsChat.getKickRank(),
			members.build());
	}

	private static KLiteFriendsChatMemberSnapshot friendsChatMemberSnapshot(FriendsChatMember member)
	{
		return new KLiteFriendsChatMemberSnapshot(
			member.getName(), member.getPrevName(), member.getWorld(), member.getRank());
	}

	private List<KLiteChatMessageSnapshot> chatMessageSnapshots(@Nullable ChatMessageType type)
	{
		if (client.getMessages() == null)
		{
			return ImmutableList.of();
		}
		ImmutableList.Builder<KLiteChatMessageSnapshot> messages = ImmutableList.builder();
		for (MessageNode message : client.getMessages())
		{
			if (message != null && (type == null || type == message.getType()))
			{
				messages.add(chatMessageSnapshot(message));
			}
		}
		return messages.build();
	}

	private static KLiteChatMessageSnapshot chatMessageSnapshot(MessageNode message)
	{
		return new KLiteChatMessageSnapshot(
			message.getId(),
			message.getType(),
			message.getName(),
			message.getSender(),
			message.getValue(),
			message.getRuneLiteFormatMessage(),
			message.getTimestamp());
	}

	private long itemCount(int inventoryId, int itemId)
	{
		if (itemId < 0)
		{
			return 0L;
		}
		long count = 0L;
		ItemContainer container = client.getItemContainer(inventoryId);
		if (container != null)
		{
			for (Item item : container.getItems())
			{
				if (item != null && item.getId() == itemId && item.getQuantity() > 0)
				{
					count += item.getQuantity();
				}
			}
		}
		return count;
	}

	private Optional<Integer> findItemSlot(int inventoryId, int itemId)
	{
		if (itemId < 0)
		{
			return Optional.empty();
		}
		ItemContainer container = client.getItemContainer(inventoryId);
		if (container == null)
		{
			return Optional.empty();
		}
		Item[] items = container.getItems();
		for (int slot = 0; slot < items.length; slot++)
		{
			Item item = items[slot];
			if (item != null && item.getId() == itemId && item.getQuantity() > 0)
			{
				return Optional.of(slot);
			}
		}
		return Optional.empty();
	}

	private Optional<KLitePlayerSnapshot> nearestPlayerSnapshot(@Nullable String name)
	{
		WorldView worldView = client.getTopLevelWorldView();
		Player localPlayer = client.getLocalPlayer();
		if (worldView == null || localPlayer == null || isBlank(name))
		{
			return Optional.empty();
		}
		Player nearest = null;
		int nearestDistance = Integer.MAX_VALUE;
		for (Player player : worldView.players())
		{
			if (name.equalsIgnoreCase(player.getName()))
			{
				int distance = localPlayer.getWorldLocation().distanceTo(player.getWorldLocation());
				if (nearest == null || distance < nearestDistance)
				{
					nearest = player;
					nearestDistance = distance;
				}
			}
		}
		return nearest == null ? Optional.empty()
			: Optional.of(playerSnapshot(nearest, nearest == localPlayer));
	}

	private Optional<KLiteNpcSnapshot> nearestNpcSnapshot(int npcId, @Nullable String name)
	{
		WorldView worldView = client.getTopLevelWorldView();
		Player localPlayer = client.getLocalPlayer();
		if (worldView == null || localPlayer == null || npcId < 0 && isBlank(name))
		{
			return Optional.empty();
		}
		NPC nearest = null;
		int nearestDistance = Integer.MAX_VALUE;
		for (NPC npc : worldView.npcs())
		{
			boolean matches = npcId >= 0 ? npc.getId() == npcId : name.equalsIgnoreCase(npc.getName());
			if (matches)
			{
				int distance = localPlayer.getWorldLocation().distanceTo(npc.getWorldLocation());
				if (nearest == null || distance < nearestDistance)
				{
					nearest = npc;
					nearestDistance = distance;
				}
			}
		}
		return nearest == null ? Optional.empty() : Optional.of(npcSnapshot(nearest));
	}

	private Optional<KLiteGroundItemSnapshot> nearestGroundItemSnapshot(
		int itemId, @Nullable String name)
	{
		WorldView worldView = client.getTopLevelWorldView();
		Player localPlayer = client.getLocalPlayer();
		if (worldView == null || worldView.getScene() == null || localPlayer == null
			|| itemId < 0 && isBlank(name))
		{
			return Optional.empty();
		}
		KLiteGroundItemSnapshot nearest = null;
		int nearestDistance = Integer.MAX_VALUE;
		for (Tile[][] plane : worldView.getScene().getTiles())
		{
			for (Tile[] row : plane)
			{
				for (Tile tile : row)
				{
					if (tile == null)
					{
						continue;
					}
					for (TileItem item : tile.getGroundItems())
					{
						boolean matches = itemId >= 0 ? item.getId() == itemId
							: name.equalsIgnoreCase(client.getItemDefinition(item.getId()).getName());
						int distance = localPlayer.getWorldLocation().distanceTo(tile.getWorldLocation());
						if (matches && (nearest == null || distance < nearestDistance))
						{
							nearest = groundItemSnapshot(item, tile.getWorldLocation());
							nearestDistance = distance;
						}
					}
				}
			}
		}
		return Optional.ofNullable(nearest);
	}

	private Optional<KLiteSceneObjectSnapshot> nearestSceneObjectSnapshot(
		int objectId, @Nullable String name)
	{
		Player localPlayer = client.getLocalPlayer();
		if (localPlayer == null || objectId < 0 && isBlank(name))
		{
			return Optional.empty();
		}
		KLiteSceneObjectSnapshot nearest = null;
		int nearestDistance = Integer.MAX_VALUE;
		for (KLiteSceneObjectSnapshot object : currentSceneObjectSnapshots())
		{
			boolean matches = objectId >= 0 ? object.getObjectId() == objectId
				: name.equalsIgnoreCase(object.getName());
			int distance = localPlayer.getWorldLocation().distanceTo(object.getLocation());
			if (matches && (nearest == null || distance < nearestDistance))
			{
				nearest = object;
				nearestDistance = distance;
			}
		}
		return Optional.ofNullable(nearest);
	}

	private List<KLiteSceneObjectSnapshot> currentSceneObjectSnapshots()
	{
		WorldView worldView = client.getTopLevelWorldView();
		if (worldView == null || worldView.getScene() == null)
		{
			return ImmutableList.of();
		}
		Set<String> seenObjects = new HashSet<>();
		ImmutableList.Builder<KLiteSceneObjectSnapshot> snapshots = ImmutableList.builder();
		for (Tile[][] plane : worldView.getScene().getTiles())
		{
			for (Tile[] row : plane)
			{
				for (Tile tile : row)
				{
					if (tile == null)
					{
						continue;
					}
					for (TileObject gameObject : tile.getGameObjects())
					{
						addSceneObject(gameObject, KLiteSceneObjectType.GAME, seenObjects, snapshots);
					}
					addSceneObject(tile.getWallObject(), KLiteSceneObjectType.WALL, seenObjects, snapshots);
					addSceneObject(tile.getGroundObject(), KLiteSceneObjectType.GROUND, seenObjects, snapshots);
					addSceneObject(tile.getDecorativeObject(), KLiteSceneObjectType.DECORATIVE,
						seenObjects, snapshots);
				}
			}
		}
		return snapshots.build();
	}

	private static KLitePlayerSnapshot playerSnapshot(Player player, boolean localPlayer)
	{
		return new KLitePlayerSnapshot(
			player.getId(), player.getName(), player.getCombatLevel(), player.getWorldLocation(),
			player.getAnimation(), player.getPoseAnimation(), localPlayer, player.isFriend(),
			player.isFriendsChatMember(), player.isClanMember(), actorName(player.getInteracting()));
	}

	private static KLiteNpcSnapshot npcSnapshot(NPC npc)
	{
		return new KLiteNpcSnapshot(
			npc.getId(), npc.getIndex(), npc.getName(), npc.getCombatLevel(), npc.getWorldLocation(),
			npc.getAnimation(), npc.getPoseAnimation(), npc.getHealthRatio(), npc.getHealthScale(),
			actorName(npc.getInteracting()));
	}

	private static KLiteGroundItemSnapshot groundItemSnapshot(TileItem item, WorldPoint location)
	{
		return new KLiteGroundItemSnapshot(
			item.getId(), item.getQuantity(), location, item.getVisibleTime(), item.getDespawnTime(),
			item.getOwnership(), item.isPrivate());
	}

	private static KLiteItemDefinition itemDefinitionSnapshot(ItemComposition composition)
	{
		return new KLiteItemDefinition(
			composition.getId(), composition.getName(), composition.getMembersName(),
			composition.getPrice(), composition.getHaPrice(), composition.isMembers(),
			composition.isStackable(), composition.isTradeable(), composition.isGeTradeable(),
			composition.getLinkedNoteId(), composition.getPlaceholderId(),
			immutableActions(composition.getInventoryActions()));
	}

	private static KLiteNpcDefinition npcDefinitionSnapshot(NPCComposition composition)
	{
		return new KLiteNpcDefinition(
			composition.getId(), composition.getName(), composition.getCombatLevel(),
			composition.getSize(), composition.isInteractible(), composition.isMinimapVisible(),
			composition.isFollower(), immutableActions(composition.getActions()));
	}

	private static KLiteObjectDefinition objectDefinitionSnapshot(ObjectComposition composition)
	{
		return new KLiteObjectDefinition(
			composition.getId(), composition.getName(), composition.getSizeX(), composition.getSizeY(),
			composition.getMapSceneId(), composition.getMapIconId(), composition.getVarbitId(),
			composition.getVarPlayerId(), immutableActions(composition.getActions()));
	}

	private static List<String> immutableActions(@Nullable String[] actions)
	{
		ImmutableList.Builder<String> result = ImmutableList.builder();
		if (actions != null)
		{
			for (String action : actions)
			{
				if (!isBlank(action))
				{
					result.add(action);
				}
			}
		}
		return result.build();
	}

	@Nullable
	private Item itemAt(int inventoryId, int slot)
	{
		if (slot < 0)
		{
			return null;
		}
		ItemContainer container = client.getItemContainer(inventoryId);
		if (container == null || slot >= container.getItems().length)
		{
			return null;
		}
		Item item = container.getItems()[slot];
		return item != null && item.getId() >= 0 && item.getQuantity() > 0 ? item : null;
	}

	private KLiteInteractionResult dispatchSelectedTarget(
		int param0, int param1, MenuAction action, int identifier, int itemId, @Nullable String target)
	{
		Widget selected = client.getSelectedWidget();
		if (!client.isWidgetSelected() || selected == null)
		{
			return KLiteInteractionResult.noWidgetSelected();
		}
		String option = isBlank(selected.getTargetVerb()) ? "Use" : selected.getTargetVerb();
		client.menuAction(param0, param1, action, identifier, itemId,
			option, target == null ? "" : target);
		return KLiteInteractionResult.dispatched();
	}

	private static boolean isVisible(@Nullable Widget widget)
	{
		return widget != null && !widget.isHidden();
	}
	private KLiteInteractionResult interactWidget(@Nullable Widget widget, @Nullable String option)
	{
		if (isBlank(option))
		{
			return KLiteInteractionResult.invalidRequest("Widget option must not be blank");
		}
		if (widget == null || widget.isHidden())
		{
			return KLiteInteractionResult.targetNotFound("Widget is absent or hidden");
		}

		String[] actions = widget.getActions();
		int actionIndex = findAction(actions, option);
		if (actionIndex < 0)
		{
			return KLiteInteractionResult.optionNotFound("Widget does not expose option: " + option);
		}

		int operation = actionIndex + 1;
		MenuAction action = operation >= 6 ? MenuAction.CC_OP_LOW_PRIORITY : MenuAction.CC_OP;
		String target = widget.getName() == null ? "" : widget.getName();
		client.menuAction(widget.getIndex(), widget.getId(), action, operation,
			widget.getItemId(), actions[actionIndex], target);
		return KLiteInteractionResult.dispatched();
	}

	private static KLiteWidgetSnapshot widgetSnapshot(Widget widget)
	{
		Rectangle bounds = widget.getBounds();
		ImmutableList.Builder<KLiteWidgetAction> actions = ImmutableList.builder();
		String[] widgetActions = widget.getActions();
		if (widgetActions != null)
		{
			for (int index = 0; index < widgetActions.length; index++)
			{
				String option = widgetActions[index];
				if (!isBlank(option))
				{
					actions.add(new KLiteWidgetAction(index + 1, option));
				}
			}
		}
		return new KLiteWidgetSnapshot(
			widget.getId(),
			widget.getIndex(),
			widget.getParentId(),
			widget.getType(),
			widget.getContentType(),
			widget.getText(),
			widget.getName(),
			widget.getItemId(),
			widget.getItemQuantity(),
			widget.isHidden(),
			bounds.x,
			bounds.y,
			bounds.width,
			bounds.height,
			actions.build());
	}
	private static MenuAction itemMenuAction(int actionIndex)
	{
		return actionIndex < 3 ? MenuAction.CC_OP : MenuAction.CC_OP_LOW_PRIORITY;
	}
	private static int findAction(@Nullable String[] actions, String requested)
	{
		if (actions == null)
		{
			return -1;
		}
		String normalized = requested.trim();
		for (int index = 0; index < actions.length; index++)
		{
			if (actions[index] != null && actions[index].equalsIgnoreCase(normalized))
			{
				return index;
			}
		}
		return -1;
	}

	private static KLiteMenuEntrySnapshot menuEntrySnapshot(int index, MenuEntry entry)
	{
		return new KLiteMenuEntrySnapshot(
			index,
			entry.getOption(),
			entry.getTarget(),
			entry.getType(),
			entry.getIdentifier(),
			entry.getParam0(),
			entry.getParam1(),
			entry.getItemId(),
			entry.getItemOp(),
			entry.getWorldViewId(),
			entry.isForceLeftClick(),
			entry.isDeprioritized());
	}

	private static String nullToEmpty(@Nullable String value)
	{
		return value == null ? "" : value;
	}

	private static boolean isBlank(@Nullable String value)
	{
		return value == null || value.isBlank();
	}

	@Nullable
	private static NPC findNpc(@Nullable WorldView worldView, int index)
	{
		return worldView == null ? null : worldView.npcs().byIndex(index);
	}

	@Nullable
	private static Player findPlayer(@Nullable WorldView worldView, int id)
	{
		return worldView == null ? null : worldView.players().byIndex(id);
	}

	@Nullable
	private static TileObject findSceneObject(
		@Nullable WorldView worldView, int objectId, WorldPoint location)
	{
		Tile tile = findTile(worldView, location);
		if (tile == null)
		{
			return null;
		}
		for (TileObject object : tile.getGameObjects())
		{
			if (matchesObject(object, objectId, location))
			{
				return object;
			}
		}
		if (matchesObject(tile.getWallObject(), objectId, location))
		{
			return tile.getWallObject();
		}
		if (matchesObject(tile.getGroundObject(), objectId, location))
		{
			return tile.getGroundObject();
		}
		return matchesObject(tile.getDecorativeObject(), objectId, location)
			? tile.getDecorativeObject() : null;
	}

	private static boolean matchesObject(
		@Nullable TileObject object, int objectId, WorldPoint location)
	{
		return object != null && object.getId() == objectId && location.equals(object.getWorldLocation());
	}

	@Nullable
	private static Tile findTile(@Nullable WorldView worldView, WorldPoint location)
	{
		if (worldView == null || worldView.getScene() == null)
		{
			return null;
		}
		for (Tile[][] plane : worldView.getScene().getTiles())
		{
			for (Tile[] row : plane)
			{
				for (Tile tile : row)
				{
					if (tile != null && location.equals(tile.getWorldLocation()))
					{
						return tile;
					}
				}
			}
		}
		return null;
	}

	private static boolean containsGroundItem(Tile tile, int itemId)
	{
		for (TileItem item : tile.getGroundItems())
		{
			if (item.getId() == itemId)
			{
				return true;
			}
		}
		return false;
	}

	private ObjectComposition objectComposition(TileObject object)
	{
		ObjectComposition composition = client.getObjectDefinition(object.getId());
		if (composition.getImpostorIds() != null)
		{
			ObjectComposition transformed = composition.getImpostor();
			if (transformed != null)
			{
				return transformed;
			}
		}
		return composition;
	}

	private static String[] resolveObjectActions(
		TileObject object, ObjectComposition composition)
	{
		String[] compositionActions = composition.getActions();
		String[] actions = new String[compositionActions.length];
		for (int index = 0; index < compositionActions.length; index++)
		{
			String override = object.getOpOverride(index);
			actions[index] = override == null ? compositionActions[index] : override;
		}
		return actions;
	}

	private void addSceneObject(
		@Nullable TileObject object,
		KLiteSceneObjectType type,
		Set<String> seenObjects,
		ImmutableList.Builder<KLiteSceneObjectSnapshot> snapshots)
	{
		if (object == null || !seenObjects.add(type + ":" + object.getHash()))
		{
			return;
		}

		ObjectComposition composition = client.getObjectDefinition(object.getId());
		if (composition.getImpostorIds() != null)
		{
			ObjectComposition transformed = composition.getImpostor();
			if (transformed != null)
			{
				composition = transformed;
			}
		}

		ImmutableList.Builder<String> actions = ImmutableList.builder();
		String[] compositionActions = composition.getActions();
		for (int index = 0; index < compositionActions.length; index++)
		{
			String override = object.getOpOverride(index);
			String action = override == null ? compositionActions[index] : override;
			if (action != null && !action.isBlank())
			{
				actions.add(action);
			}
		}
		snapshots.add(new KLiteSceneObjectSnapshot(
			object.getId(), composition.getName(), type, object.getWorldLocation(), actions.build()));
	}

	private CompletableFuture<List<KLiteItemStack>> itemStacks(int inventoryId)
	{
		return threadGateway.submit(() ->
		{
			ItemContainer container = client.getItemContainer(inventoryId);
			return container == null ? ImmutableList.of() : itemStackSnapshots(container);
		});
	}

	private static KLiteItemContainerSnapshot itemContainerSnapshot(ItemContainer container)
	{
		return new KLiteItemContainerSnapshot(
			container.getId(), container.size(), container.count(), itemStackSnapshots(container));
	}

	private static List<KLiteItemStack> itemStackSnapshots(ItemContainer container)
	{
		ImmutableList.Builder<KLiteItemStack> items = ImmutableList.builder();
		Item[] itemArray = container.getItems();
		for (int slot = 0; slot < itemArray.length; slot++)
		{
			Item item = itemArray[slot];
			if (item != null && item.getId() >= 0 && item.getQuantity() > 0)
			{
				items.add(new KLiteItemStack(slot, item.getId(), item.getQuantity()));
			}
		}
		return items.build();
	}

	private static void addGroundItems(
		Scene scene, ImmutableList.Builder<KLiteGroundItemSnapshot> snapshots)
	{
		for (Tile[][] plane : scene.getTiles())
		{
			for (Tile[] row : plane)
			{
				for (Tile tile : row)
				{
					if (tile == null)
					{
						continue;
					}
					for (TileItem item : tile.getGroundItems())
					{
						snapshots.add(new KLiteGroundItemSnapshot(
							item.getId(),
							item.getQuantity(),
							tile.getWorldLocation(),
							item.getVisibleTime(),
							item.getDespawnTime(),
							item.getOwnership(),
							item.isPrivate()));
					}
				}
			}
		}
	}

	@Nullable
	private static String actorName(@Nullable Actor actor)
	{
		return actor == null ? null : actor.getName();
	}
}
