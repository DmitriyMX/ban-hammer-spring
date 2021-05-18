package ru.dmitriymx.plugin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ban_users")
public class BannedUserEntity {

	@Id
	private Integer id;

	@Column(
			name = "player_name",
			unique = true,
			nullable = false,
			length = 16
	)
	private String playerName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BannedUserEntity)) return false;
		BannedUserEntity that = (BannedUserEntity) o;
		return playerName.equals(that.playerName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerName);
	}

	@Override
	public String toString() {
		return "BannedUserEntity{" +
				"id=" + id +
				", playerName='" + playerName + '\'' +
				'}';
	}
}
