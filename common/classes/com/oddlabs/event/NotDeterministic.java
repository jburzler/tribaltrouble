package com.oddlabs.event;

import java.nio.*;

public final strictfp class NotDeterministic extends Deterministic {
        @Override
	public final boolean isPlayback() {
		return false;
	}

        @Override
	public final void endLog() {
	}

        @Override
	protected final byte log(byte b, byte def) {
		return b;
	}

        @Override
	protected final char log(char c, char def) {
		return c;
	}

        @Override
	protected final int log(int i, int def) {
		return i;
	}

        @Override
	protected final long log(long l, long def) {
		return l;
	}

        @Override
	protected final float log(float f, float def) {
		return f;
	}
	
        @Override
	protected final Object logObject(Object o) {
		return o;
	}
	
        @Override
	protected final void logBuffer(ByteBuffer b) {
		b.position(b.limit());
	}
}
