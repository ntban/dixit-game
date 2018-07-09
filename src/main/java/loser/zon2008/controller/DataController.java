package loser.zon2008.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loser.zon2008.model.Card;
import loser.zon2008.repository.CardRepository;
import loser.zon2008.repository.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class DataController {

	@Autowired
	CardRepository cardRepository;
	
	@GetMapping("/create-cards")
	public void createCards() {
		List<Card> cards = new ArrayList<>();
		for(int i=0;i<150;i++){
			Card c = new Card("_"+i+".jpg");
			c.setId(i);
			cards.add(c);
		}
		cardRepository.saveAll(cards);
	}
	
}
