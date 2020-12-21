package dialog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import helpers.FieldOption;

public class Dialog<T> extends JDialog {

	private static final long serialVersionUID = 1L;

	private ArrayList<FieldOption> fields;
	private LinkedHashMap<String, JComponent> textFields;

	public Dialog(ArrayList<FieldOption> fields) {
		super();
		this.fields = fields;
		this.textFields = new LinkedHashMap<>();
	}

	public void initialize(String bannerText, String buttonText) {
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(40, 40, 40, 40));

		BorderLayout layout = new BorderLayout();
		contentPane.setLayout(layout);
		setContentPane(contentPane);

		JLabel banner = new JLabel(bannerText, SwingConstants.CENTER);
		banner.setBorder(new EmptyBorder(0, 0, 10, 0));
		banner.setFont(new Font(banner.getFont().getName(), Font.PLAIN, 20));
		this.add(banner, BorderLayout.NORTH);

		GridBagLayout gbLayout = new GridBagLayout();
		JPanel panel = new JPanel();
		panel.setLayout(gbLayout);
		this.add(panel, BorderLayout.CENTER);
		GridBagConstraints c = new GridBagConstraints();

		for (int index = 0; index < fields.size(); index++) {
			FieldOption option = fields.get(index);

			JLabel label = new JLabel(option.getValue());
			c.insets = new Insets(10, 0, 5, 0);
			c.gridx = 0;
			c.gridy = index;
			panel.add(label, c);

			JComponent field;
			c.gridx = 1;
			c.gridy = index;

			if (option.isPassword()) {
				field = new JPasswordField(20);
				((JPasswordField) field).setEditable(option.isEditable());
			} else {
				field = new JTextField(20);
				((JTextField) field).setEditable(option.isEditable());
			}

			panel.add(field, c);
			textFields.put(option.getKey(), field);
		}

		JButton button = new JButton(buttonText);
		button.setBorder(new EmptyBorder(20, 0, 0, 0));
		button.addActionListener(new Event());
		this.add(button, BorderLayout.SOUTH);

		this.pack();
		this.setLocationRelativeTo(null);
	}

	public void updateDate(T data) {
		Field[] fields = data.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				Object value = field.get(data);
				JComponent component = textFields.get(field.getName());
				if (component != null) {
					if (component instanceof JTextField) {
						((JTextField) component).setText(value.toString());
					} else if (component instanceof JPasswordField) {
						((JPasswordField) component).setText(value.toString());
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private class Event extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Set<String> keys = textFields.keySet();
			for (String key : keys) {
				JComponent component = textFields.get(key);
				String value = null;
				if (component instanceof JTextField) {
					value = ((JTextField) component).getText();
				} else if (component instanceof JPasswordField) {
					value = String.valueOf(((JPasswordField) component).getPassword());
				}
				System.out.println(value);
			}
		}
	}
}