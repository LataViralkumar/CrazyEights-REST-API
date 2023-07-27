package com.crazyeights;

public class Cards {
	
	private String cardType;
	private String cardName;
	

	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	
	public Cards(String cardType, String cardName) {
		super();
		this.cardType = cardType;
		this.cardName = cardName;
	}
	public Cards() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
