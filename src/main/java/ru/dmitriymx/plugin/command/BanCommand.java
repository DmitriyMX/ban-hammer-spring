package ru.dmitriymx.plugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.dmitriymx.plugin.service.BannedUserService;

import java.util.logging.Logger;

@Component
public class BanCommand implements CommandExecutor {

	private final Logger logger;
	private final BannedUserService service;

	@Autowired
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	public BanCommand(@Qualifier("bukkitLogger") Logger logger, BannedUserService service) {
		this.logger = logger;
		this.service = service;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		logger.info("Call '" + label + "' command");

		if (args.length == 0) {
			return true;
		}

		boolean result = service.inBanned(args[0]);
		logger.info("Player '" + args[0] + "': " + (result ? "is banned" : "not banned"));

		return true;
	}
}
