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

		tabbedPane.addTab("Quản lý người dùng", null, new UserManager(), "Quáº£n lÃ½ ngÆ°á»�i dÃ¹ng");
		tabbedPane.addTab("Quản lý xe", null, new BikeManager(), "Quản lí xe đang xử dụng");
		

	}

}
