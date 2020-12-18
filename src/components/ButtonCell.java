package components;

import java.awt.BorderLayout;
import java.awt.Component;
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
			setLayout(new BorderLayout());

			button = new JButton(buttonName);
			button.setFont(new Font("Calibri", Font.BOLD, 17));
			button.setFocusable(false);
			button.setRolloverEnabled(false);
			button.setAction(action);
			add(button, BorderLayout.CENTER);
		}
	}
}