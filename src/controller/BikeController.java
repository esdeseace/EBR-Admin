package controller;

import java.util.ArrayList;

import api.BikeApi;
import beans.Bike;
import interfaces.IController;

public class BikeController implements IController<Bike> {

	@Override
	public void onCreate(Bike bike) {

	}

	@Override
	public void onRead(Bike bike) {
		System.out.println(bike);
	}

	@Override
	public void onUpdate(Bike bike) {
		System.out.println(bike);
//		UpdateDialog updateDialog = new UpdateDialog();
//		updateDialog.setVisible(true);
	}

	@Override
	public void onDelete(Bike bike) {
		System.out.println(bike);
	}

}
