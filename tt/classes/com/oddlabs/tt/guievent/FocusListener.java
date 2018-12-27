package com.oddlabs.tt.guievent;

@FunctionalInterface
public strictfp interface FocusListener extends EventListener {
	public void activated(boolean activated);
}
