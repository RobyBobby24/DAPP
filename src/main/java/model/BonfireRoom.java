package model;

import services.ConfigurationReader;

import java.io.IOException;

public class BonfireRoom extends Room {


	private int percentageRestore;
	public BonfireRoom() throws IOException {
		this.percentageRestore = ConfigurationReader.getInstance().getBonfirePercentage();
	}


	public int getPercentageRestore() {
		return percentageRestore;
	}

	public void setPercentageRestore(int percentageRestore) {
		this.percentageRestore = percentageRestore;
	}

	@Override
	public void setID(int value) {

	}

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void enterRoom() {
        FrontController.getInstance().skipRest(this.percentageRestore);
	}
}