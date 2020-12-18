package panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RootPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public RootPanel() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		JTabbedPane tabbedPane = new JTabbedPane();
		this.add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.addTab("Compact Discs", null, new ParkManager(), "Quản lý bãi xe");
		tabbedPane.addTab("Xe đang sử dụng", null, new UsedBikeManager(), "Quản lý xe đang sử dụng");
		tabbedPane.addTab("Digital Video Discs", null, new UserManager(), "Quản lý người dùng");

	}

}
