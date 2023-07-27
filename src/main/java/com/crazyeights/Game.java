package com.crazyeights;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crazyeight/api/v1.0/game")
public class Game {
	
	
	private Deque<pairStackInit> gameStarterCard = new LinkedList<>();
	private Deque<pairStackInit> remaingCard = new LinkedList<>();
	

	public Deque<pairStackInit> getGameStarterCard() {
		return gameStarterCard;
	}

	public void setGameStarterCard(Deque<pairStackInit> gameStarterCard) {
		this.gameStarterCard = gameStarterCard;
	}

	public Deque<pairStackInit> getRemaingCard() {
		return remaingCard;
	}

	public void setRemaingCard(Deque<pairStackInit> remaingCard) {
		this.remaingCard = remaingCard;
	}
	
	public void AddPlayerCardIngameStarterCard(pairStackInit PairStackInit ) {
		gameStarterCard.addFirst(PairStackInit);	
	}
	
	@GetMapping("/gameInit")
	public Deque<pairStackInit> gameInit() {
		Deck d = new Deck();
//		pairStackInit pair = new pairStackInit();
		for(Map.Entry<Cards, Boolean> i : d.getCardDeck().entrySet()) {
			if(i.getValue() == true) {
				continue;
			}
			if(i.getKey().getCardType() == "8") {
				continue;
			}

			pairStackInit pair = new pairStackInit();
			i.setValue(true);

			pair.setCardName(i.getKey().getCardName());
			pair.setCardType(i.getKey().getCardType());

			gameStarterCard.addLast(pair);
			break;
		}
				
		for(Map.Entry<Cards, Boolean> i : d.getCardDeck().entrySet()) {
				
			if(i.getValue() == true) {
				continue;
			}
			pairStackInit pair = new pairStackInit();
			
			pair.setCardName(i.getKey().getCardName());
			pair.setCardType(i.getKey().getCardType());
			
				
			remaingCard.addLast(pair);
		
		}
		
		return gameStarterCard;
	}
	
	@GetMapping("/gameStartDeck")
	public Deque<pairStackInit> gameStartDeck() {
		return gameStarterCard;
	}
}
