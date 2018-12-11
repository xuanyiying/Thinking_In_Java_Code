package com.buleheart.thinking.code.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
	private final static int BSIZE = 1024;
	public static void main(String[] args) throws IOException {
		if(args.length !=2){
			System.out.println("arguments: sourceFile destfile");
			System.exit(1);
		}
		@SuppressWarnings("resource")
		FileChannel in = new FileInputStream(args[0]).getChannel(),
				out = new FileOutputStream(args[1]).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while (in.read(buffer) != -1){
			//Prepare for writing
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
	}
	
}
