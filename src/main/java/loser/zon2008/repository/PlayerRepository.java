package loser.zon2008.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import loser.zon2008.model.Player;

@Repository
public interface  PlayerRepository extends JpaRepository<Player, Integer>  {

}