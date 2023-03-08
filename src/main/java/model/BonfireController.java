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
		FrontView.getInstance().outputSkipRest(percentage);
		if (!FrontView.getInstance().inputSkipRest()){
			Adventurer.getInstance().restorePercentageHp(percentage);
		}
	}

}