//package panels;
//
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.util.LinkedHashMap;
//
//import javax.swing.AbstractAction;
//import javax.swing.Action;
//import javax.swing.JPanel;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import api.UserApi;
//import beans.Bike;
//import common.Constants;
//import components.CRUDTable;
//import components.OptionPane;
//import controller.UserController;
//
//public class UsedBikManger extends JPanel {
//	private static final long serialVersionUID = 1L;
//
//	private CRUDTable<Bike> table;
//	private UserController usedBikeController;
//	private OptionPane<Bike> updateDialog;
//	private OptionPane<Bike> createDialog;
//	private UserApi userApi;
//
//	public UsedBikManger() {
//		super();
//		initialize();
//	}
//
//	private void initialize() {
//		BorderLayout layout = new BorderLayout();
//		this.setLayout(layout);
//
//		LinkedHashMap<String, Action> events = new LinkedHashMap<>();
//		events.put(Constants.UPDATE, new UpdateEvent());
//		events.put(Constants.DELETE, new DeleteEvent());
//
//		table = new CRUDTable<>(Bike.getFields());
//		table.initialize(events, new CreateEvent());
//
//		userApi = new UserApi();
//		usedBikeController = new UserController(table, userApi);
//		table.updateData(userApi.getAll());
//
//		updateDialog = new OptionPane<>(Bike.getUpdateFields());
//		updateDialog.initialize("Cập nhật người dùng", "Cập nhật");
//
//		createDialog = new OptionPane<>(Bike.getCreateFields());
//		createDialog.initialize("Thêm người dùng", "Thêm");
//
//		this.add(table, BorderLayout.CENTER);
//	}
//
//	private class UpdateEvent extends AbstractAction {
//		private static final long serialVersionUID = 1L;
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			Object bean = table.getSelectedBean();
//
//			if (bean instanceof Bike) {
//				Bike bike = (Bike) bean;
//				updateDialog.updateDate(bike);
//			}
//
//			LinkedHashMap<String, String> result = updateDialog.showDialog();
//			if (result != null) {
//				ObjectMapper mapper = new ObjectMapper();
//				Bike bike = mapper.convertValue(result, Bike.class);
//				usedBikeController.onUpdate(bike);
//			}
//		}
//	}
//
//	private class DeleteEvent extends AbstractAction {
//		private static final long serialVersionUID = 1L;
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			Object bean = table.getSelectedBean();
//			if (bean instanceof Bike) {
//				Bike bike = (Bike) bean;
//				usedBikeController.onDelete(bike);
//			}
//		}
//	}
//
//	private class CreateEvent extends AbstractAction {
//		private static final long serialVersionUID = 1L;
//
//		@Override
//		public void actionPerformed(ActionEvent event) {
//			LinkedHashMap<String, String> result = createDialog.showDialog();
//			if (result != null) {
//				ObjectMapper mapper = new ObjectMapper();
//				Bike bike = mapper.convertValue(result, Bike.class);
//				usedBikeController.onCreate(bike);
//			}
//		}
//	}
//
//}
