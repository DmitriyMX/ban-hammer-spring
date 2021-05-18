package ru.dmitriymx.plugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitriymx.plugin.service.BannedUserService;

@Component
public class BanCommand implements CommandExecutor {

	private final BannedUserService service;

	@Autowired
	public BanCommand(BannedUserService service) {
		this.service = service;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			return false;
		}
		String playerName = args[0];

		if (service.isBanned(playerName)) {
			sender.sendMessage("Player '" + playerName + "' already banned");
		} else {
			service.ban(playerName);
			sender.sendMessage("Player '" + playerName + "' now banned");
		}

		return true;
	}
}
