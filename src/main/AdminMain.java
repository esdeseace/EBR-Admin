package main;

import java.awt.EventQueue;
import javax.swing.JFrame;

import com.github.weisj.darklaf.LafManager;
//import com.github.weisj.darklaf.theme.DarculaTheme;

import common.Constants;
import panels.RootPane;

public class AdminMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					LafManager.install(new DarculaTheme());
					LafManager.install();
					new AdminMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminMain() {
		initialize();
	}

	private void initialize() {
		JFrame frame = new JFrame();
		frame.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("EBR-Admin");
		frame.setLocationRelativeTo(null);

		RootPane rootPane = new RootPane();
		frame.setContentPane(rootPane);
		frame.setVisible(true);
	}
}