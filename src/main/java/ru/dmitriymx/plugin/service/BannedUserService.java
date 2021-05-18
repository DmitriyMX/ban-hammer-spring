package ru.dmitriymx.plugin.service;

import org.bukkit.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dmitriymx.plugin.repository.BannedUserRepository;

@Service
public class BannedUserService {

	private final BannedUserRepository repository;

	@Autowired
	public BannedUserService(BannedUserRepository repository) {
		this.repository = repository;
	}

	public boolean inBanned(Player player) {
		return inBanned(player.getName());
	}

	public boolean inBanned(String playerName) {
		return repository.findByPlayerName(playerName.toLowerCase()).isPresent();
	}
}
