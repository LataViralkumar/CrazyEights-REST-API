package com.crazyeights;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("crazyeight/api/v1.0/Player2")
public class P2 {
	
	@Autowired 
	private Game game;
	
	private LinkedList<pairStackInit> cartForPlayer2 = new LinkedList<>();
	
	private Players p2 = new Players(); 
	
	@GetMapping("/cardDistribute")  // For player one

	public LinkedList<pairStackInit> showCardPlayer2() {
		
		Deck d = new Deck();   		                     
		int x =0;
		System.out.println( d.getCardDeck().size());
		for(Map.Entry<Cards, Boolean> i : d.getCardDeck().entrySet()) {
			
			if(x == 7) {
				break;
			}

			if(i.getValue() == true) {
				continue;
			}
			
			i.setValue(true);
			
			pairStackInit pairStackInit= new pairStackInit();
			pairStackInit.setCardName(i.getKey().getCardName());
			pairStackInit.setCardType(i.getKey().getCardType());
			cartForPlayer2.add(pairStackInit);
			
			x++;
			
		}
		p2.setPlayerCard(cartForPlayer2);
	
		return p2.getPlayerCard();  
		
	}
	
	@PostMapping("/ThrowCard{pair_p1}")
	public pairStackInit gameStarter(@RequestBody pairStackInit pair_p1){
		
		System.out.print(pair_p1.getCardName() + " " + pair_p1.getCardType());
		this.game.AddPlayerCardIngameStarterCard(pair_p1);
		System.out.println(this.p2.getPlayerCard());
		
		for(int i = 0; i < this.p2.getPlayerCard().size();++i) {
			
			if(p2.getPlayerCard().get(i).getCardType().equals(pair_p1.getCardType())) {
//				System.out.println("Yes..........");
				p2.RemoveCardFromPlayer(i);
				break;
			}
		}
		
		return pair_p1;
	}
		
	@GetMapping("/PlayerAvailableCard")
	public LinkedList<pairStackInit> PlayerAvailableCard() {

		return p2.getPlayerCard();
	}
	
	@GetMapping("/PlayerWantCard")
	public pairStackInit PlayerWantGetCardFromRemaingDeack() {
		
		pairStackInit PairStackInit =  this.game.getRemaingCard().getLast();
		p2.insertNewcard(PairStackInit);
		return PairStackInit;
		
	}

}