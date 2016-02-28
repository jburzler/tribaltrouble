package com.oddlabs.tt.util;

import java.io.IOException;
import java.io.OutputStream;

public final strictfp class LoggerOutputStream extends OutputStream {
	private final OutputStream[] streams;
	
	public LoggerOutputStream(OutputStream[] streams) {
		this.streams = streams;
	}

        @Override
	public void write(byte[] bytes, int offset, int length) throws IOException {
            for (OutputStream stream : streams) {
                stream.write(bytes, offset, length);
            }
	}

        @Override
	public void write(int b) throws IOException {
            for (OutputStream stream : streams) {
                stream.write(b);
            }
	}
}
