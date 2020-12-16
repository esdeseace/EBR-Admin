package main;

import java.awt.EventQueue;
import javax.swing.JFrame;

import com.github.weisj.darklaf.LafManager;
//import com.github.weisj.darklaf.theme.DarculaTheme;

import panels.RootPanel;

public class Main {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					LafManager.install(new DarculaTheme());
					LafManager.install();
					new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		JFrame frame = new JFrame();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("EBR-Admin");

		RootPanel rootPanel = new RootPanel();
		frame.setContentPane(rootPanel);
		frame.setVisible(true);
	}
}