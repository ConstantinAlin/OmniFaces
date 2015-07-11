package usecase.validator;

import java.io.Serializable;

/**
 *
 * @author Constantin Alin
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pattern;
	private String field;
	private String label;

	public Person() {
	}

	public Person(String pattern, String field, String label) {
		this.pattern = pattern;
		this.field = field;
		this.label = label;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getLabel() {
		return label;
	}
}
