package panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RootPane extends JPanel {
	private static final long serialVersionUID = 1L;

	public RootPane() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		JTabbedPane tabbedPane = new JTabbedPane();
		this.add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.addTab("Quản lý người dùng", null, new UserManager());
		tabbedPane.addTab("Quản lý bãi xe", null, new ParkManager());
		tabbedPane.addTab("Quản lý xe đang sử dụng", null, new UsedBikeManager());

	}

}
