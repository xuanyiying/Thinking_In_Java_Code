package com.buleheart.thinking.code.io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput{
	public static void main(String[] args) throws IOException{
		StringReader in = new StringReader(
		BufferedInputFile.read("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/MemoryInput.java"));
		int c;
		while((c = in.read()) != -1)
			System.out.println((char)c);
	}
}
