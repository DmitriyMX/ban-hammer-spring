package ru.dmitriymx.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitriymx.plugin.service.BannedUserService;

@Component
public class PlayerListener implements Listener {

	private final BannedUserService service;

	@Autowired
	public PlayerListener(BannedUserService service) {
		this.service = service;
	}

	@EventHandler
	@SuppressWarnings("unused")
	public void onLogin(PlayerLoginEvent event) {
		if (service.isBanned(event.getPlayer())) {
			event.disallow(PlayerLoginEvent.Result.KICK_BANNED, "You banned!");
		}
	}
}
