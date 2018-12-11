package com.buleheart.thinking.code.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {
	public static void main(String[] args){
		try {
			DataInputStream in = new DataInputStream(
					new ByteArrayInputStream(BufferedInputFile.read(
							"D:\\work\\Thinking_In_Java_Code\\src\\com\\buleheart\\thinking\\code\\io\\FormattedMemoryInput.java")
							.getBytes()));
			while(in.available() != 0)
				System.out.println((char)in.readByte());
		} catch (IOException e) {
			System.out.println("End of stream");
		}
	}
	
}
