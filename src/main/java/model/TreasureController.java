package model;

import view.FrontView;

import java.util.List;

public class TreasureController {

	private static TreasureController instance;


	private TreasureController() {

	}

	public static TreasureController getInstance() {
		if(TreasureController.instance == null){
			TreasureController.instance = new TreasureController();
		}
		return TreasureController.instance;
	}

	public void chooseTreasure(List<Treasure> treasures) throws Exception {
		try {
			FrontView.getInstance().outputChooseTreasure(treasures);
			Treasure choosenTreasure = FrontView.getInstance().inputChooseTreasure();
			choosenTreasure.provideReward();
			String description = choosenTreasure.giveTreasureDescription();
			FrontView.getInstance().outputChoosenTreasure(description);
		}
		catch (Exception e){
			e.printStackTrace();
			FrontView.getInstance().outputError("l'operazione inserita non è valida");
			if(FrontView.getInstance().inputError()) this.chooseTreasure(treasures);
		}

	}

}