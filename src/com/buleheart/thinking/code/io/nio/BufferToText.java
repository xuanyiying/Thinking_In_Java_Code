package com.buleheart.thinking.code.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
	private final static int BSIZE = 1024;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		FileChannel fc = new FileOutputStream("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some Text".getBytes()));
		fc.close();
		fc = new FileInputStream("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/data2.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		fc.read(buffer);
		buffer.flip();
		//Does't work:
		System.out.println(buffer.asCharBuffer());
		//Decode using this system's default charset
		buffer.rewind();
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decode using " + encoding + ":"
				+ Charset.forName(encoding).decode(buffer));
		fc = new FileOutputStream("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some test".getBytes("UTF-8")));
		fc.close();
		//Now try read again:
		fc = new FileInputStream("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/data2.txt").getChannel();
		buffer.clear();
		buffer.flip();
		fc.read(buffer);
		System.out.println(buffer.asCharBuffer());
		//use a CharBuffer to Write through
		fc = new FileOutputStream("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/data2.txt").getChannel();
		buffer = ByteBuffer.allocate(24);//More than needed
		buffer.asCharBuffer().put("Some text");
		fc.write(buffer);
		fc.close();
		//Read and display:
		fc = new FileInputStream("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/data2.txt").getChannel();
		buffer.clear();
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
		
		
	}

}
