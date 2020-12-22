package controller;

import java.util.LinkedHashMap;

import api.ParkApi;
import beans.Park;
import common.Constants;
import components.CRUDTable;
import components.OptionPane;
import interfaces.AController;
import interfaces.IController;

public class ParkController extends AController<Park> implements IController<Park> {

	private OptionPane<Park> updateDialog;
	private OptionPane<Park> createDialog;

	public ParkController(CRUDTable<Park> table, ParkApi api) {
		super(table, api);

		updateDialog = new OptionPane<>(Park.getUpdateFields());
		updateDialog.initialize("Cập nhật bãi xe", "Cập nhật");

		createDialog = new OptionPane<>(Park.getCreateFields());
		createDialog.initialize("Thêm bãi xe", "Thêm");

	}

	@Override
	public Park onUpdate(Park park) {
		updateDialog.updateDate(park);
		LinkedHashMap<String, String> result = updateDialog.showDialog();
		if (result != null) {
			park = Constants.mapper.convertValue(result, Park.class);
			return super.onUpdate(park);
		}
		return null;
	}

	public Park onCreate() {
		LinkedHashMap<String, String> result = createDialog.showDialog();
		if (result != null) {
			Park park = Constants.mapper.convertValue(result, Park.class);
			super.onCreate(park);
		}
		return null;
	}

}
