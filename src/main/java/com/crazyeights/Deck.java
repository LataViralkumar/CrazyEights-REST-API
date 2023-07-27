package com.crazyeights;

import java.util.HashMap;
import java.util.Map;


public class Deck {
	
	public  Map<Cards ,Boolean> cardDeck = new HashMap<>();
	
	public Map<Cards ,Boolean> getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(HashMap<Cards ,Boolean>  cardDeck) {
		this.cardDeck = cardDeck;
	}
	
	private void heartFill() {

		Cards t = new Cards("HEART" ,"A" );
		cardDeck.put(t, false);
		for(int i = 2; i <=10;++i) {
			Cards x = new Cards("HEART" ,Integer.toString(i) );
			cardDeck.put(x , false);
		}
		Cards j = new Cards("HEART" ,"J" );
		cardDeck.put(j,false);
		Cards q = new Cards("HEART" ,"Q" );
		cardDeck.put(q , false);
		Cards k = new Cards("HEART" ,"K" );
		cardDeck.put(k , false);
			
	}
	
	private void dimondFill() {

		Cards t = new Cards("DIMONDS" ,"A" );
		cardDeck.put(t , false);
		for(int i = 2; i <=10;++i) {
			Cards x = new Cards("DIMONDS" ,Integer.toString(i) );
			cardDeck.put(x , false);
		}
		Cards j = new Cards("DIMONDS" ,"J" );
		cardDeck.put(j , false);
		Cards q = new Cards("DIMONDS" ,"Q" );
		cardDeck.put(q , false);
		Cards k = new Cards("DIMONDS" ,"K" );
		cardDeck.put(k , false);
			
	}
	
	private void spadesFill() {

		Cards t = new Cards("SPADES" ,"A" );
		cardDeck.put(t , false);
		for(int i = 2; i <=10;++i) {
			Cards x = new Cards("SPADES" ,Integer.toString(i) );
			cardDeck.put(x , false);
		}
		Cards j = new Cards("SPADES" ,"J" );
		cardDeck.put(j , false);
		Cards q = new Cards("SPADES" ,"Q" );
		cardDeck.put(q , false);
		Cards k = new Cards("SPADES" ,"K" );
		cardDeck.put(k , false);
			
	}
	
	private void clubFill() {

		Cards t = new Cards("CLUB" ,"A" );
		cardDeck.put(t , false);
		for(int i = 2; i <=10;++i) {
			Cards x = new Cards("CLUB" ,Integer.toString(i) );
			cardDeck.put(x , false);
		}
		Cards j = new Cards("CLUB" ,"J" );
		cardDeck.put(j , false);
		Cards q = new Cards("CLUB" ,"Q" );
		cardDeck.put(q , false);
		Cards k = new Cards("CLUB" ,"K" );
		cardDeck.put(k , false);
			
	}

	public Deck() {
		
		// init deac array
		spadesFill();
		clubFill();
		heartFill();
		dimondFill();
	}
	
	
}
