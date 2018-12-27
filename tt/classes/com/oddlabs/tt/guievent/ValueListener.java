package com.oddlabs.tt.guievent;

@FunctionalInterface
public strictfp interface ValueListener extends EventListener {
	public void valueSet(int value);
}
