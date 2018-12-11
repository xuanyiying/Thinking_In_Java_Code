package com.buleheart.thinking.code.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Creating a very large file using mapping
 * @author wangying
 *
 */
public class LargeMappedFiles {
	static int length = 0x8FFFFFF;//128M
	public static void main(String[] args) throws Exception, IOException {
		@SuppressWarnings("resource")
		MappedByteBuffer out = new RandomAccessFile("testdata.txt","rw")
				.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++) {
			out.put((byte)'x');
		}
		System.out.print("Finished writing");
		for (int i = 0; i < length; i++) {
		 System.out.print((char)out.get(i));
		}
	}
	
	
}
