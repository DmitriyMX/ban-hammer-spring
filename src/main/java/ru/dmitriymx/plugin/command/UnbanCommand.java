package ru.dmitriymx.plugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.logging.Logger;

public class UnbanCommand implements CommandExecutor {

	private final Logger logger;

	public UnbanCommand(Logger logger) {
		this.logger = logger;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		logger.info("Call '" + label + "' command");
		return true;
	}
}
