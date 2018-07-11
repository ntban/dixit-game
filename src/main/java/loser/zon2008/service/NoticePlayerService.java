package loser.zon2008.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import loser.zon2008.model.ChatMessage;
import loser.zon2008.model.Player;
import loser.zon2008.repository.PlayerRepository;

@Service
public class NoticePlayerService {
	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	private PlayerRepository playerRepository;
	
	public void noticeAdd(String username) {
		List<Player> players = playerRepository.findAll();
		
		ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.PLAY);
        chatMessage.setContent(players.size()+"");
        chatMessage.setSender(username);
		
		this.template.convertAndSend("/topic/publicChatRoom", chatMessage);
	}
}
