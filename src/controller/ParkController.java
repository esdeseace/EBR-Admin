package controller;

import beans.Park;
import components.CRUDTable;
import interfaces.AController;
import interfaces.IController;

public class ParkController extends AController<Park> implements IController<Park> {

	public ParkController(CRUDTable<Park> table) {
		super(table);
	}

	@Override
	public Park onCreate(Park park) {
		System.out.println(park);
		return null;
	}

	@Override
	public Park onRead(Park park) {
		System.out.println(park);
		return null;
	}

	@Override
	public Park onUpdate(Park park) {
		System.out.println(park);
		return null;
	}

	@Override
	public boolean onDelete(Park park) {
		System.out.println(park);
		return false;
	}

}
