package com.oddlabs.tt.model.behaviour;

import com.oddlabs.tt.model.Selectable;

public final strictfp class NullBehaviour implements Behaviour {
	public NullBehaviour() {
	}

        @Override
	public final int animate(float t) {
		return Selectable.INTERRUPTIBLE;
	}

        @Override
	public final boolean isBlocking() {
		return true;
	}

        @Override
	public final void forceInterrupted() {
	}
}
