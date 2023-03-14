package controller;

import model.Adventurer;
import model.Card;
import view.FrontView;

import java.util.List;

import static java.lang.System.exit;

public class MerchantController {

	private static MerchantController instance;


	private MerchantController() {

	}

	public static MerchantController getInstance() {
		if(MerchantController.instance == null){
			MerchantController.instance = new MerchantController();
		}
		return MerchantController.instance;
	}

	/**
	 *
	 * @param purchasableCards
	 */
	public void chooseCardToBuy(List<Card> purchasableCards) {
		try{
			Card choosenCard;
			do {
				FrontView.getInstance().outputAdventurerState();
				FrontView.getInstance().outputChooseCardToBuy(purchasableCards);
				choosenCard = FrontView.getInstance().inputChooseCardToBuy();
				if( choosenCard != null ){
					boolean bought = Adventurer.getInstance().buyACard(choosenCard);
					if( !bought ) FrontView.getInstance().outputDidNotBuy();
					else FrontView.getInstance().outputAdventurerState();
				}
			} while (choosenCard != null);
		}
		catch( Exception e ){
			e.printStackTrace();
			FrontView.getInstance().outputError("l'acquisto della carta non è andato a buon fine");
			if(FrontView.getInstance().inputError()) this.chooseCardToBuy(purchasableCards);
			else FrontController.getInstance().restartGame();
			exit(0);
		}

	}
}