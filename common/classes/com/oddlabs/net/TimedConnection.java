package com.oddlabs.net;

public final strictfp class TimedConnection {
	private final long timeout;
	private final Connection conn;

	public TimedConnection(long timeout, Connection conn) {
		this.timeout = timeout;
		this.conn = conn;
	}

	public final long getTimeout() {
		return timeout;
	}

	public final Connection getConnection() {
		return conn;
	}

        @Override
	public final boolean equals(Object other) {
		if (!(other instanceof TimedConnection))
			return false;
		TimedConnection other_timed = (TimedConnection)other;
		return other_timed.conn.equals(this.conn);
	}

        @Override
	public final int hashCode() {
		return conn.hashCode();
	}
}
