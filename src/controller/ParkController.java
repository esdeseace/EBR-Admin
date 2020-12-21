package controller;

import api.ParkApi;
import beans.Park;
import components.CRUDTable;
import interfaces.AController;
import interfaces.IController;

public class ParkController extends AController<Park> implements IController<Park> {

	public ParkController(CRUDTable<Park> table, ParkApi api) {
		super(table, api);
	}

}
