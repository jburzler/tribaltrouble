package com.oddlabs.util;

import java.io.*;
import java.nio.channels.FileChannel;

public final strictfp class FileUtils {
	public static void copyFile(File src, File dst) throws IOException {
            FileChannel dst_channel;
            try (FileChannel src_channel = new FileInputStream(src).getChannel()) {
                dst_channel = new FileOutputStream(dst).getChannel();
                src_channel.transferTo(0, Long.MAX_VALUE, dst_channel);
            }
		dst_channel.close();
	}
}
