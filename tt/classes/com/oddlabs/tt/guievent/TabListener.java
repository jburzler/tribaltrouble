package com.oddlabs.tt.guievent;

@FunctionalInterface
public strictfp interface TabListener extends EventListener {
	public void tabPressed(String[] words);
}
