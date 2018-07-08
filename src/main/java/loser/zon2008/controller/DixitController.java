package loser.zon2008.controller;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import loser.zon2008.model.Card;
import loser.zon2008.model.Player;
import loser.zon2008.repository.PlayerRepository;

@Controller
public class DixitController {
	ArrayList<Card> cards;
	int countCards = 126;
	int numberPlayers;
	int notUsedCard;
	ArrayList<Player> players;

	@Autowired
	private PlayerRepository playerRepository;

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
		
		Player player = new Player(username);
		player = playerRepository.save(player);
		request.getSession().setAttribute("player", player);
		model.addAttribute("username", username);
		
		return "chat";
	}

	private void createCards() {
		ArrayList<Integer> images = new ArrayList<>();
		for (int i = 0; i < countCards; i++) {
			images.add(i);
		}
		Collections.shuffle(images);

		cards = new ArrayList<>();
		for (int i = 0; i < countCards; i++) {
			cards.add(new Card("_" + images.get(i) + ".jpg"));
		}

	}
}