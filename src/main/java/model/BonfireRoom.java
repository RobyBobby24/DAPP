package model;

import services.ConfigurationReader;

import java.io.IOException;

public class BonfireRoom extends Room {


	private int percentageRestore;
	public BonfireRoom() throws IOException {
		super();
		this.percentageRestore = ConfigurationReader.getInstance().getBonfirePercentage();
	}


	public int getPercentageRestore() {
		return percentageRestore;
	}

	public void setPercentageRestore(int percentageRestore) {
		this.percentageRestore = percentageRestore;
	}

	@Override
	public void enterRoom() {
        FrontController.getInstance().skipRest( this.percentageRestore );
	}
}