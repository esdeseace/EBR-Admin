package components;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableButton {

	private String buttonName;
	private Action action;

	public TableButton(String buttonName, Action action) {
		this.buttonName = buttonName;
		this.action = action;
	}

	public ButtonsRenderer getButtonsRenderer() {
		return new ButtonsRenderer();
	}

	public ButtonEditor getButtonEditor(JTable table) {
		return new ButtonEditor(table);
	}

	private class ButtonsRenderer implements TableCellRenderer {

		private final ButtonPane panel = new ButtonPane();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
			return panel;
		}
	}

	private class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

		private static final long serialVersionUID = 1L;

		private final ButtonPane panel = new ButtonPane();
		private final JTable table;

		private class EditingStopHandler extends MouseAdapter implements ActionListener {

			@Override
			public void mousePressed(MouseEvent e) {
				Object o = e.getSource();
				if (o instanceof TableCellEditor) {
					actionPerformed(null);
				} else if (o instanceof JButton) {
					ButtonModel m = ((JButton) e.getComponent()).getModel();
					if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
						panel.setBackground(table.getBackground());
					}
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(() -> fireEditingStopped());
			}
		}

		protected ButtonEditor(JTable table) {

			this.table = table;

			EditingStopHandler handler = new EditingStopHandler();
			panel.button.addMouseListener(handler);
			panel.button.addActionListener(handler);
			panel.button.setAction(action);
			panel.addMouseListener(handler);
		}

		@Override
		public Component getTableCellEditorComponent(JTable tbl, Object value, boolean isSelected, int row,
				int column) {
			panel.setBackground(tbl.getSelectionBackground());
			return panel;
		}

		@Override
		public Object getCellEditorValue() {
			return "";
		}

	}

	private class ButtonPane extends JPanel {

		private static final long serialVersionUID = 1L;

		public final JButton button;

		public ButtonPane() {

			setOpaque(true);
//			setBorder(new EmptyBorder(5, 5, 5, 5));

			button = new JButton(buttonName);
			button.setFont(new Font("Calibri", Font.BOLD, 17));
			button.setFocusable(false);
			button.setRolloverEnabled(false);
			add(button);
		}
	}
}