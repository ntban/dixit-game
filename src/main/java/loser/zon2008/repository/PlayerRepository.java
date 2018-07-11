package loser.zon2008.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import loser.zon2008.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	@Transactional
	@Modifying
	@Query("DELETE FROM Player p WHERE p.name = ?1")
	public void deletePlayer(String name);

}