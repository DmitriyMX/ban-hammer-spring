package ru.dmitriymx.plugin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dmitriymx.plugin.entity.BannedUserEntity;

import java.util.Optional;

@Repository
public interface BannedUserRepository extends JpaRepository<BannedUserEntity, Integer> {

	Optional<BannedUserEntity> findByPlayerName(String playerName);

	@Modifying
	@Query("delete from #{#entityName} b where b.playerName = :playerName")
	void deleteByPlayerName(@Param("playerName") String playerName);
}
