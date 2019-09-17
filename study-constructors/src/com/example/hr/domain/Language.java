package com.example.hr.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Language {
	private final String name;
	private byte level;
	private boolean certified;

	public Language(String name) {
		this(name, (byte) 1);
	}

	public Language(String name, byte level, boolean certified) {
		this.name = name;
		this.level = level;
		this.certified = certified;
	}

	public Language(String name, byte level) {
		this(name, level, false);
	}

	public String getName() {
		return name;
	}

	public byte getLevel() {
		return level;
	}

	public boolean isCertified() {
		return certified;
	}

	public void setLevel(byte level) {
		if (certified)
			this.level = level;
	}

	public void setCertified(boolean certified) {
		this.certified = certified;
	}

	@Override
	public String toString() {
		return "Language [name=" + name + ", level=" + level + ", certified=" + certified + "]";
	}

}
