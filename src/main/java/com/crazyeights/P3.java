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
@RequestMapping("crazyeight/api/v1.0/Player3")
public class P3 {
	
	@Autowired 
	private Game game;
	
	private LinkedList<pairStackInit> cartForPlayer3 = new LinkedList<>();
	
	private Players p3 = new Players(); 
	
	@GetMapping("/cardDistribute")  // For player one

	public LinkedList<pairStackInit> showCardPlayer3() {
		
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
			cartForPlayer3.add(pairStackInit);
			
			x++;
			
		}
		p3.setPlayerCard(cartForPlayer3);
	
		return p3.getPlayerCard();  
		
	}
	
	@PostMapping("/ThrowCard{pair_p1}")
	public pairStackInit gameStarter(@RequestBody pairStackInit pair_p1){
		
		System.out.print(pair_p1.getCardName() + " " + pair_p1.getCardType());
		this.game.AddPlayerCardIngameStarterCard(pair_p1);
		System.out.println(this.p3.getPlayerCard());
		
		for(int i = 0; i < this.p3.getPlayerCard().size();++i) {
			
			if(p3.getPlayerCard().get(i).getCardType().equals(pair_p1.getCardType())) {
//				System.out.println("Yes..........");
				p3.RemoveCardFromPlayer(i);
				break;
			}
		}
		
		return pair_p1;
	}
		
	@GetMapping("/PlayerAvailableCard")
	public LinkedList<pairStackInit> PlayerAvailableCard() {

		return p3.getPlayerCard();
	}
	
	@GetMapping("/PlayerWantCard")
	public pairStackInit PlayerWantGetCardFromRemaingDeack() {
		
		pairStackInit PairStackInit =  this.game.getRemaingCard().getLast();
		p3.insertNewcard(PairStackInit);
		return PairStackInit;
		
	}

}