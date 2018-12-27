package com.oddlabs.tt.guievent;

@FunctionalInterface
public strictfp interface EnterListener extends EventListener {
	public void enterPressed(CharSequence text);
}
