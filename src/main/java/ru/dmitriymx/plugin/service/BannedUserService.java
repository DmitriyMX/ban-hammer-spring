package ru.dmitriymx.plugin.service;

import org.bukkit.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitriymx.plugin.entity.BannedUserEntity;
import ru.dmitriymx.plugin.repository.BannedUserRepository;

@Service
@Transactional
public class BannedUserService {

	private final BannedUserRepository repository;

	@Autowired
	public BannedUserService(BannedUserRepository repository) {
		this.repository = repository;
	}

	public boolean isBanned(Player player) {
		return isBanned(player.getName());
	}

	public boolean isBanned(String playerName) {
		return repository.findByPlayerName(playerName.toLowerCase()).isPresent();
	}

	public void ban(String playerName) {
		BannedUserEntity entity = new BannedUserEntity();
		entity.setPlayerName(playerName);
		repository.save(entity);
	}

	public void unban(String playerName) {
		repository.deleteByPlayerName(playerName);
	}
}
