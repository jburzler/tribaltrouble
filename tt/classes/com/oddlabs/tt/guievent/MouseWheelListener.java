package com.oddlabs.tt.guievent;

@FunctionalInterface
public strictfp interface MouseWheelListener extends EventListener {
	public void mouseScrolled(int amount);
}
