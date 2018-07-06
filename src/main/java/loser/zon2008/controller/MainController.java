package loser.zon2008.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import loser.zon2008.model.Card;
import loser.zon2008.model.Player;
import loser.zon2008.repository.CardRepository;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
		String username = (String) request.getSession().getAttribute("username");

		if (username == null || username.isEmpty()) {
			return "redirect:/login";
		}
		model.addAttribute("username", username);

		return "chat";
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request, @RequestParam(defaultValue = "") String username) {
		username = username.trim();

		if (username.isEmpty()) {
			return "login";
		}

		request.getSession().setAttribute("username", username);

		return "redirect:/";
	}

	@RequestMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession(true).invalidate();

		return "redirect:/login";
	}

	@Autowired
	CardRepository cardRepository;

	@RequestMapping(path = "/card-page", method = RequestMethod.GET)
	public String showCardPage(Model model) {
		List<Card> cards = cardRepository.getFirstSix();

		List<Card> cards1 = new ArrayList<>();
		for (int i = 0; i < 3; i++){
			cards1.add(cards.get(i));
			cards.get(i).setUsed("used");
		}
		model.addAttribute("highCards", cards1);

		List<Card> cards2 = new ArrayList<>();
		for (int i = 3; i < 6; i++){
			cards2.add(cards.get(i));
			cards.get(i).setUsed("used");
		}
		model.addAttribute("lowCards", cards2);
		
		cardRepository.saveAll(cards);
		return "card-page";
	}

}