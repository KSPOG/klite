/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.debug;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.AppenderBase;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Singleton;
import org.slf4j.LoggerFactory;

/** Shared in-memory log used by the KLite client and dynamically loaded plugins. */
@Singleton
public final class KLiteClientLogBuffer
{
	private static final int MAX_ENTRIES = 2_000;
	private static final DateTimeFormatter LOG_TIME = DateTimeFormatter.ofPattern("HH:mm:ss")
		.withZone(ZoneId.systemDefault());

	private final List<String> entries = new CopyOnWriteArrayList<>();
	private final AppenderBase<ILoggingEvent> appender;

	public KLiteClientLogBuffer()
	{
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		appender = new AppenderBase<ILoggingEvent>()
		{
			@Override
			protected void append(ILoggingEvent event)
			{
				StringBuilder message = new StringBuilder()
					.append('[').append(LOG_TIME.format(Instant.ofEpochMilli(event.getTimeStamp()))).append("] [")
					.append(event.getLevel()).append("] [")
					.append(shortLoggerName(event.getLoggerName())).append("] ")
					.append(event.getFormattedMessage());
				if (event.getThrowableProxy() != null)
				{
					message.append(System.lineSeparator())
						.append(ThrowableProxyUtil.asString(event.getThrowableProxy()));
				}
				appendEntry(message.toString());
			}
		};
		appender.setName("KLiteClientLogBuffer");
		appender.setContext(context);
		appender.start();
		context.getLogger(Logger.ROOT_LOGGER_NAME).addAppender(appender);
		info("KLite", "Client and plugin diagnostics initialized.");
	}

	public void debug(String source, String message)
	{
		record("DEBUG", source, message, null);
	}

	public void info(String source, String message)
	{
		record("INFO", source, message, null);
	}

	public void warn(String source, String message)
	{
		record("WARN", source, message, null);
	}

	public void error(String source, String message, Throwable error)
	{
		record("ERROR", source, message, error);
	}

	public String text()
	{
		if (entries.isEmpty())
		{
			return "No client or plugin diagnostic entries have been recorded.";
		}
		return String.join(System.lineSeparator(), entries);
	}

	public void clear()
	{
		entries.clear();
		info("KLite", "Client and plugin diagnostics cleared.");
	}

	private void record(String level, String source, String message, Throwable error)
	{
		StringBuilder entry = new StringBuilder()
			.append('[').append(LOG_TIME.format(Instant.now())).append("] [")
			.append(level).append("] [")
			.append(source == null || source.trim().isEmpty() ? "KLite" : source.trim())
			.append("] ")
			.append(message == null ? "" : message);
		if (error != null)
		{
			entry.append(System.lineSeparator()).append(stackTrace(error));
		}
		appendEntry(entry.toString());
	}

	private synchronized void appendEntry(String entry)
	{
		entries.add(entry);
		while (entries.size() > MAX_ENTRIES)
		{
			entries.remove(0);
		}
	}

	private static String shortLoggerName(String loggerName)
	{
		if (loggerName == null || loggerName.isEmpty())
		{
			return "client";
		}
		int separator = loggerName.lastIndexOf('.');
		return separator < 0 ? loggerName : loggerName.substring(separator + 1);
	}

	private static String stackTrace(Throwable error)
	{
		java.io.StringWriter writer = new java.io.StringWriter();
		error.printStackTrace(new java.io.PrintWriter(writer));
		return writer.toString();
	}
}
