package com.oddlabs.tt.guievent;

@FunctionalInterface
public strictfp interface CheckBoxListener extends EventListener {
	public void checked(boolean marked);
}
