package com.heroku.rlegendi.pokr;

/**
 * Simple POJO for Hints returned by the REST API.
 * 
 * <p>
 * Note that auto-marshalling needs mutable state (nullary constructor and
 * getter/setters).
 * </p>
 * 
 * @author rlegendi
 */
public class Hint {
	private String message;

	public Hint() {
		this("N/A");
	}

	public Hint(final String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Hint other = (Hint) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hint [message=" + message + "]";
	}
}
