package loser.zon2008.controller;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import loser.zon2008.model.Card;
import loser.zon2008.model.Player;

@Controller
public class DixitController {
	ArrayList<Card> cards;
	int countCards = 126;
	int numberPlayers;
	int notUsedCard;
	ArrayList<Player> players;

	@RequestMapping(path = "/startGame", method = RequestMethod.POST)
	public String startGame(HttpServletRequest request) {
		createCards();
		return "redirect:/";
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