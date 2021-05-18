package ru.dmitriymx.plugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class BanCommand implements CommandExecutor {

	private final Logger logger;

	@Autowired
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	public BanCommand(@Qualifier("bukkitLogger") Logger logger) {
		this.logger = logger;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		logger.info("Call '" + label + "' command");
		return true;
	}
}
