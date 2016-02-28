package com.oddlabs.tt.viewer;

import com.oddlabs.tt.render.Renderer;

public final strictfp class Cheat {
	private final boolean can_enable;
	private boolean enabled = false;
	public boolean draw_trees = true;
	public boolean line_mode = false;

	public Cheat() {
		this(false);
	}

	Cheat(boolean can_enable) {
		this.can_enable = can_enable;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void enable() {
		if (Renderer.isRegistered() && can_enable)
			enabled = true;
	}
}
