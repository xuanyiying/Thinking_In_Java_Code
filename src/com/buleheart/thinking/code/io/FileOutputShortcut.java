package com.buleheart.thinking.code.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
	static String file = "FileOutputShortcut.out";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(
				new StringReader(
						BufferedInputFile.read("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/FileOutputShortcut.java")));
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while ((s = in.readLine()) != null)
			out.println(lineCount++ + ":" + s);
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}
}
