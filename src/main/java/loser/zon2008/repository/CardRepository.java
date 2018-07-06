package loser.zon2008.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import loser.zon2008.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>  {

	@Query(nativeQuery=true, value="SELECT * FROM Card c WHERE c.used='unused' ORDER BY id LIMIT 6")
	public List<Card> getFirstSix();
}