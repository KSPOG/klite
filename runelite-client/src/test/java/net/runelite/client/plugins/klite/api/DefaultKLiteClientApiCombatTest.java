/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.Arrays;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultKLiteClientApiCombatTest
{
	private Client client;
	private DefaultKLiteClientApi api;

	@Before
	public void setUp()
	{
		client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));
	}

	@Test
	public void combatSnapshotUsesCurrentClientState() throws Exception
	{
		Player player = mock(Player.class);
		Actor target = mock(Actor.class);
		when(client.getLocalPlayer()).thenReturn(player);
		when(player.getAnimation()).thenReturn(100);
		when(player.getPoseAnimation()).thenReturn(200);
		when(player.getInteracting()).thenReturn(target);
		when(target.getName()).thenReturn("Target");
		when(client.getBoostedSkillLevel(Skill.HITPOINTS)).thenReturn(80);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(75);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(40);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(50);
		when(client.getEnergy()).thenReturn(8_500);
		when(client.getWeight()).thenReturn(12);
		when(client.getVarpValue(VarPlayerID.OPTION_RUN)).thenReturn(1);
		when(client.getVarpValue(VarPlayerID.SA_ENERGY)).thenReturn(750);
		when(client.getVarpValue(VarPlayerID.SA_ATTACK)).thenReturn(1);
		when(client.getVarpValue(VarPlayerID.POISON)).thenReturn(1_000_000);
		when(client.getVarbitValue(VarbitID.INSIDE_WILDERNESS)).thenReturn(1);
		when(client.getVarbitValue(Prayer.PIETY.getVarbit())).thenReturn(1);
		when(client.getVarbitValue(Prayer.PROTECT_FROM_MELEE.getVarbit())).thenReturn(1);

		KLiteCombatSnapshot snapshot = api.combatSnapshot().get();

		assertEquals(80, snapshot.getHitpoints());
		assertEquals(75, snapshot.getMaximumHitpoints());
		assertEquals(8_500, snapshot.getRunEnergy());
		assertEquals(750, snapshot.getSpecialAttackEnergy());
		assertTrue(snapshot.isRunEnabled());
		assertTrue(snapshot.isSpecialAttackEnabled());
		assertFalse(snapshot.isPoisoned());
		assertTrue(snapshot.isVenomed());
		assertTrue(snapshot.isInWilderness());
		assertEquals("Target", snapshot.getInteractingName());
		assertTrue(snapshot.getActivePrayers().containsAll(
			Arrays.asList(Prayer.PIETY, Prayer.PROTECT_FROM_MELEE)));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void prayerReadsUseVarbitsInsteadOfDeprecatedClientHelper() throws Exception
	{
		when(client.getVarbitValue(Prayer.RIGOUR.getVarbit())).thenReturn(1);

		assertTrue(api.prayerActive(Prayer.RIGOUR).get());
		assertFalse(api.prayerActive(Prayer.AUGURY).get());
		assertTrue(api.activePrayers().get().contains(Prayer.RIGOUR));
		verify(client, never()).isPrayerActive(org.mockito.ArgumentMatchers.any(Prayer.class));
	}

	@Test
	public void runToggleAvoidsUnnecessaryAction() throws Exception
	{
		when(client.getVarpValue(VarPlayerID.OPTION_RUN)).thenReturn(1);

		KLiteInteractionResult result = api.setRunEnabled(true).get();

		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED, result.getStatus());
		verify(client, never()).getWidget(InterfaceID.Orbs.ORB_RUNENERGY);
	}

	@Test
	public void runToggleUsesCurrentWidgetAction() throws Exception
	{
		Widget widget = actionWidget(InterfaceID.Orbs.ORB_RUNENERGY, "Toggle Run");
		when(client.getWidget(InterfaceID.Orbs.ORB_RUNENERGY)).thenReturn(widget);

		KLiteInteractionResult result = api.setRunEnabled(true).get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(-1, InterfaceID.Orbs.ORB_RUNENERGY,
			MenuAction.CC_OP, 1, -1, "Toggle Run", "Run");
	}

	@Test
	public void widgetTargetSelectionUsesLiveTargetVerb() throws Exception
	{
		int componentId = 0x12340001;
		Widget widget = mock(Widget.class);
		when(client.getWidget(componentId)).thenReturn(widget);
		when(widget.getId()).thenReturn(componentId);
		when(widget.getIndex()).thenReturn(-1);
		when(widget.getItemId()).thenReturn(-1);
		when(widget.getTargetVerb()).thenReturn("Cast");
		when(widget.getName()).thenReturn("Fire Strike");

		KLiteInteractionResult result = api.selectWidgetTarget(componentId).get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(-1, componentId, MenuAction.WIDGET_TARGET,
			0, -1, "Cast", "Fire Strike");
	}

	private static Widget actionWidget(int componentId, String action)
	{
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(componentId);
		when(widget.getIndex()).thenReturn(-1);
		when(widget.getItemId()).thenReturn(-1);
		when(widget.getName()).thenReturn("Run");
		when(widget.getActions()).thenReturn(new String[]{action});
		return widget;
	}
}
