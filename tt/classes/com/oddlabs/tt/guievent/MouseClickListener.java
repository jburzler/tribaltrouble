package com.oddlabs.tt.guievent;

@FunctionalInterface
public strictfp interface MouseClickListener extends EventListener {
	public void mouseClicked(int button, int x, int y, int clicks);
}
