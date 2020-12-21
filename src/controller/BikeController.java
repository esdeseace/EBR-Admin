package controller;

import api.BikeApi;
import beans.Bike;
import components.CRUDTable;
import interfaces.AController;

public class BikeController extends AController<Bike> {

	public BikeController(CRUDTable<Bike> table, BikeApi api) {
		super(table, api);
	}

}
