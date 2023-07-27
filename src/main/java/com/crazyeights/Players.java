package com.crazyeights;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@RestController
public class Players {

	private Integer state;
	
//	private Map<Cards, Boolean> playerCard = new HashMap<>();
	
	private LinkedList<pairStackInit> playerCard = new LinkedList<>();

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public LinkedList<pairStackInit> getPlayerCard() {
		return playerCard;
	}

	public void setPlayerCard(LinkedList<pairStackInit> playerCard) {
		this.playerCard = playerCard;
	}
	
	public void insertNewcard( pairStackInit PairStackInit ) {
		playerCard.add(PairStackInit);
	}
	
	public void RemoveCardFromPlayer(int index) {
		playerCard.remove(index);
	}

	
	
}
