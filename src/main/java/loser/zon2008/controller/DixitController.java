package loser.zon2008.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import loser.zon2008.model.Card;
import loser.zon2008.model.Player;
import loser.zon2008.repository.CardRepository;
import loser.zon2008.repository.PlayerRepository;

@Controller
public class DixitController {
	List<Card> cards;
	ArrayList<Player> players = new ArrayList<>();

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private CardRepository cardRepository;

	@RequestMapping(path = "/startGame", method = RequestMethod.POST)
	public String startGame(HttpServletRequest request) {
		createCards();
		return "redirect:/";
	}

	@RequestMapping(path = "/registerGame", method = RequestMethod.POST)
	public String registerGame(HttpServletRequest request, Model model) {
		String username = (String) request.getSession().getAttribute("username");
		
		if(username == null){
			return "redirect:/";
		}
		
		if(players.size() == 0){
			cards = cardRepository.findAll();
		}
		
		Player player = new Player(username);
		player = playerRepository.save(player);
		
		if(players.size() == 0){
			player.setFirstPlayer("TRUE");
		}
		
		request.getSession().setAttribute("player", player);
		players.add(player);
				
		return "redirect:/";
	}

	private void createCards() {
		Collections.shuffle(cards);

		//set for players
		int i = 0;
		for(Player p:players){
			String cardOfPlayer = "";
			for (int j = 0; j < 6; j++) {
				cardOfPlayer += cards.get(i++).getId()+",";
			}
			p.setCards(cardOfPlayer);
		}
	}
}