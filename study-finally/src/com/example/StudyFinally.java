package com.example;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyFinally {

	public static void main(String[] args) throws Exception {
		fun();

	}

	public static void fun() throws Exception {
		// try-with-resources
		try (FileInputStream fis = new FileInputStream(new File("c:/tmp/sakla.txt"));
				PreciousResource res1 = new PreciousResource(1);
				PreciousResource res2 = new PreciousResource(2);) {
			throw new RuntimeException("Ooopss");
		} /*
			 * finally { try { res1.close(); } catch (Exception e) { e.printStackTrace(); }
			 * finally { try { res2.close(); } catch (Exception e) { e.printStackTrace(); }
			 * } }
			 */
	}
}

class PreciousResource implements AutoCloseable {
	private int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public void close() throws Exception {
		System.err.println("Closing the resource " + id + ".");
		throw new Exception("Something is wrong!");
	}
}
