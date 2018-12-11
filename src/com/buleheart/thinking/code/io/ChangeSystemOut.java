package com.buleheart.thinking.code.io;

import java.io.PrintWriter;

public class ChangeSystemOut {
	//Turn System.out  into a PrintWriter
	public static void main(String[] args) {
		// PrintWriter constructor is PrintWriter(OutputStream out, boolean autoFlush)
		PrintWriter out = new PrintWriter(
				System.out, true);
		out.println("Hello, world");
	}

}
