package controller;

import java.util.LinkedHashMap;

import api.BikeApi;
import beans.Bike;
import common.Constants;
import components.CRUDTable;
import components.OptionPane;
import interfaces.AController;

public class BikeController extends AController<Bike> {

	private OptionPane<Bike> updateDialog;
	private OptionPane<Bike> createDialog;

	public BikeController(CRUDTable<Bike> table, BikeApi api) {
		super(table, api);

		updateDialog = new OptionPane<>(Bike.getUpdateFields());
		updateDialog.initialize("Cập nhật xe", "Cập nhật");

		createDialog = new OptionPane<>(Bike.getCreateFields());
		createDialog.initialize("Thêm xe", "Thêm");

	}

	@Override
	public Bike onUpdate(Bike bike) {
		updateDialog.updateDate(bike);
		LinkedHashMap<String, String> result = updateDialog.showDialog();
		if (result != null) {
			bike = Constants.mapper.convertValue(result, Bike.class);
			return super.onUpdate(bike);
		}
		return null;
	}

	public Bike onCreate() {
		LinkedHashMap<String, String> result = createDialog.showDialog();
		if (result != null) {
			Bike bike = Constants.mapper.convertValue(result, Bike.class);
			return super.onCreate(bike);
		}
		return null;
	}

}
