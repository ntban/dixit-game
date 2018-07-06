package loser.zon2008.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import loser.zon2008.model.Player;
 
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
        
        ArrayList<Player> players = (ArrayList<Player>)request.getSession().getAttribute("players");
        if(players == null){
        	players = new ArrayList<>();
        }
        Player player = new Player(username);
        players.add(player);
        request.getSession().setAttribute("players", players);
        
        request.getSession().setAttribute("username", players.size()+"-"+username);
 
        return "redirect:/";
    }
 
    @RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession(true).invalidate();
         
        return "redirect:/login";
    }
    
}