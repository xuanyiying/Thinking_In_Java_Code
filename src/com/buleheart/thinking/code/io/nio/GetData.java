package com.buleheart.thinking.code.io.nio;

import java.nio.ByteBuffer;

public class GetData {
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		//Allcoation automatically zeroers the ByteBuffer;
		int i = 0;
		while (i++ < buffer.limit()){
			if(buffer.get() != 0){
				System.out.println("nonzero");
			}
			System.out.println("i = " + i);
			buffer.rewind();
			//Store and read a char array.
			buffer.asCharBuffer().put("Howdy!");
			char c;
			while((c = buffer.getChar())!= 0){
				System.out.println(c + " ");
			}
			System.out.println();
			buffer.rewind();
			//Store and read a short:
			buffer.asShortBuffer().put((short)471142);
			System.out.println(buffer.getShort());
		}
	}
	

}
