package ru.dmitriymx.plugin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dmitriymx.plugin.entity.BannedUserEntity;

import java.util.Optional;

@Repository
public interface BannedUserRepository extends CrudRepository<BannedUserEntity, Integer> {

	Optional<BannedUserEntity> findByPlayerName(String playerName);
}
