package com.oddlabs.util;

public final strictfp class HashEntry extends ListElementImpl {
	private Object hash_entry;
	private final int key;

	public HashEntry(int key, Object entry) {
		this.key = key;
		this.hash_entry = entry;
	}

	public Object getEntry() {
		return hash_entry;
	}

	public Object setEntry(Object entry) {
		Object old = hash_entry;
		hash_entry = entry;
		return old;
	}

	public int getKey() {
		return key;
	}
}
