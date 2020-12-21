package controller;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.UserApi;
import beans.Bike;
import beans.ResponseCustom;
import beans.User;
import components.CRUDTable;
import interfaces.AController;
import interfaces.IController;

public class UserController extends AController<User> implements IController<User> {

	public UserController(CRUDTable<User> table) {
		super(table);
	}

	@Override
	public User onCreate(User user) {
		System.out.print(user);
		try {
			User newUser = UserApi.add(user);
			table.updateData(UserApi.getAll());
			return newUser;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Create error", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	@Override
	public User onRead(User user) {
		return null;
	}

	@Override
	public User onUpdate(User user) {
		System.out.print(user);
		try {
			User newUser = UserApi.add(user);
			table.updateData(UserApi.getAll());
			return newUser;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Create error", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	@Override
	public boolean onDelete(User user) {
		int isDelete = JOptionPane.showConfirmDialog(null,
				"Việc này không thể hoàn tác. Bạn có chắc chắn muốn xóa không?!", "Xóa", JOptionPane.YES_NO_OPTION);
		boolean isOk = false;
		if (isDelete == JOptionPane.YES_OPTION) {
			try {
				isOk = UserApi.delete(user.getId());
				table.updateData(UserApi.getAll());
			} catch (Exception error) {
				error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Create error", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return isOk;
	}

}
