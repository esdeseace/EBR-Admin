package helpers;

public class FieldOption {

	private String key;
	private String value;
	private boolean isPassword = false;
	private boolean isEditable = true;

	public FieldOption(String key, String value, boolean isPassword, boolean isEditable) {
		super();
		this.key = key;
		this.value = value;
		this.isPassword = isPassword;
		this.isEditable = isEditable;
	}

	public FieldOption(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isPassword() {
		return isPassword;
	}

	public void setPassword(boolean isPassword) {
		this.isPassword = isPassword;
	}

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	@Override
	public String toString() {
		return "FieldOption [key=" + key + ", value=" + value + ", isPassword=" + isPassword + ", isEditable="
				+ isEditable + "]";
	}

}
