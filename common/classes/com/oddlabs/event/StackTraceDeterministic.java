package com.oddlabs.event;

import java.nio.ByteBuffer;

public final strictfp class StackTraceDeterministic extends Deterministic {
	private final Deterministic deterministic;
	private final Deterministic stack_deterministic;

	public StackTraceDeterministic(Deterministic deterministic, Deterministic stack_deterministic) {
		this.deterministic = deterministic;
		this.stack_deterministic = stack_deterministic;
	}

        @Override
	public final boolean isPlayback() {
		return deterministic.isPlayback();
	}

        @Override
	public final void endLog() {
		deterministic.endLog();
		stack_deterministic.endLog();
	}

	private final void logTrace() {
		int stack_trace_hash = getTraceId();
		int old_stack_trace_hash =  stack_deterministic.log(stack_trace_hash);
		if (old_stack_trace_hash != stack_trace_hash)
			throw new Error("old_stack_trace_hash = " + old_stack_trace_hash + " | stack_trace_hash = " + stack_trace_hash);
	}
	
        @Override
	protected final byte log(byte b, byte def) {
		logTrace();
		return deterministic.log(b, def);
	}

        @Override
	protected final char log(char c, char def) {
		logTrace();
		return deterministic.log(c, def);
	}

        @Override
	protected final int log(int i, int def) {
		logTrace();
		return deterministic.log(i, def);
	}

        @Override
	protected final long log(long l, long def) {
		logTrace();
		return deterministic.log(l, def);
	}

        @Override
	protected final float log(float f, float def) {
		logTrace();
		return deterministic.log(f, def);
	}
	
        @Override
	protected final Object logObject(Object o) {
		logTrace();
		return deterministic.log(o);
	}
	
        @Override
	protected final void logBuffer(ByteBuffer b) {
		logTrace();
		deterministic.log(b);
	}
}
