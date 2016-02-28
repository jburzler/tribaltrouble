package com.oddlabs.tt.util;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public final strictfp class GLStateStack {
	private static GLStateStack current;
	
	private final List state_stack = new ArrayList();

	public static void setCurrent(GLStateStack stack) {
		current = stack;
	}
	
	public GLStateStack() {
		state_stack.add(new GLState());
	}
	
	private GLState getCurrentState() {
		return (GLState)state_stack.get(state_stack.size() - 1);
	}

	public static void pushState() {
		current.doPushState();
	}

	private void doPushState() {
		try {
			state_stack.add((GLState)getCurrentState().clone());
			GL11.glPushClientAttrib(GL11.GL_ALL_CLIENT_ATTRIB_BITS);
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void popState() {
		current.doPopState();
	}

	private void doPopState() {
		GL11.glPopClientAttrib();
		state_stack.remove(state_stack.size() - 1);
	}

	public static void switchState(int client_flags) {
		current.doSwitchState(client_flags);
	}

	private void doSwitchState(int client_flags) {
		GLState current_state = getCurrentState();
		current_state.switchState(client_flags);
	}
}
