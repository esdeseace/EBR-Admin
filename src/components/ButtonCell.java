package components;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ButtonCell {

	private String buttonName;
	private Action action;

	public ButtonCell(String buttonName, Action action) {
		this.buttonName = buttonName;
		this.action = action;
	}

	public void setColumnButton(TableColumn column) {
		column.setCellRenderer(new ButtonsRenderer());
		column.setCellEditor(new ButtonEditor());
	}

	private class ButtonsRenderer implements TableCellRenderer {

		private final ButtonPane button = new ButtonPane();
		private final JLabel label = new JLabel(buttonName, SwingConstants.CENTER);

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				return label;
			} else {
				button.setText(buttonName);
				return button;
			}
		}
	}

	private class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

		private static final long serialVersionUID = 1L;

		private final ButtonPane button = new ButtonPane();

		@Override
		public Component getTableCellEditorComponent(JTable tbl, Object value, boolean isSelected, int row,
				int column) {
			button.setText(buttonName);
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			return "";
		}

	}

	private class ButtonPane extends JButton {

		private static final long serialVersionUID = 1L;

		public ButtonPane() {
			super(buttonName);
			this.setFocusable(false);
			this.setRolloverEnabled(false);
			this.setAction(action);
		}
	}
}