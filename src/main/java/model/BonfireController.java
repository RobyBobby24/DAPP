package model;

import view.FrontView;

public class BonfireController {

	private static BonfireController instance;

	private BonfireController() {

	}

	public static BonfireController getInstance() {
		if(BonfireController.instance == null){
			BonfireController.instance = new BonfireController();
		}
		return BonfireController.instance;
	}

	public void skipRest(int percentage) {
		try{
			FrontView.getInstance().outputAdventurerState();
			FrontView.getInstance().outputSkipRest(percentage);
			if ( FrontView.getInstance().inputSkipRest() ){
				Adventurer.getInstance().restorePercentageHp(percentage);
			}
		}
		catch(Exception e){
			FrontView.getInstance().outputError("il recupero degli hp non è andato a buon fine!!!");
			if(FrontView.getInstance().inputError()) this.skipRest( percentage );
			else FrontController.getInstance().restartGame();
		}
	}

}