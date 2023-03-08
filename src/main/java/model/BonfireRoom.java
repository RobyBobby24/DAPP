package model;

import services.ConfigurationReader;

import java.io.IOException;

public class BonfireRoom implements Room {


	private int percentageRestore;
	public BonfireRoom() {
		try {
			this.percentageRestore = ConfigurationReader.getInstance().getBonfirePercentage();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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