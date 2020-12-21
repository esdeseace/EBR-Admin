package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.UserApi;
import beans.User;
import common.Constants;
import components.CRUDTable;
import components.OptionPane;
import controller.UserController;

public class UserManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<User> table;
	private UserController userController;
	private OptionPane<User> updateDialog;
	private OptionPane<User> createDialog;

	public UserManager() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		LinkedHashMap<String, Action> events = new LinkedHashMap<>();
		events.put(Constants.UPDATE, new UpdateEvent());
		events.put(Constants.DELETE, new DeleteEvent());

		table = new CRUDTable<>(User.getFields());
		table.initialize(events, new CreateEvent());

		userController = new UserController();
		table.updateData(UserApi.getAll());

		updateDialog = new OptionPane<>(User.getUpdateFields());
		updateDialog.initialize("Cập nhật người dùng", "Cập nhật");

		createDialog = new OptionPane<>(User.getCreateFields());
		createDialog.initialize("Thêm người dùng", "Thêm");

		this.add(table, BorderLayout.CENTER);
	}

	private class UpdateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();

			if (bean instanceof User) {
				User user = (User) bean;
				updateDialog.updateDate(user);
			}

			LinkedHashMap<String, String> result = updateDialog.showDialog();
			if (result != null) {
				try {
					ObjectMapper mapper = new ObjectMapper();
					User user = mapper.convertValue(result, User.class);
					userController.onUpdate(user);
				} catch (Exception error) {
					error.printStackTrace();
					JOptionPane.showMessageDialog(null, "Create error", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private class DeleteEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();
			if (bean instanceof User) {
				User user = (User) bean;
				int isDelete = JOptionPane.showConfirmDialog(null,
						"Việc này không thể hoàn tác. Bạn có chắc chắn muốn xóa không?!", "Xóa",
						JOptionPane.YES_NO_OPTION);
				if (isDelete == JOptionPane.YES_OPTION) {
					try {
						userController.onDelete(user);
						table.updateData(UserApi.getAll());
					} catch (Exception error) {
						error.printStackTrace();
						JOptionPane.showMessageDialog(null, "Create error", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}

	private class CreateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent event) {
			LinkedHashMap<String, String> result = createDialog.showDialog();
			if (result != null) {
				try {
					ObjectMapper mapper = new ObjectMapper();
					User user = mapper.convertValue(result, User.class);
					userController.onCreate(user);
					table.updateData(UserApi.getAll());
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Create error", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
