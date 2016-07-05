package com.varhzj.lab.network.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class DigestThread extends Thread {

	private String fileName;

	public DigestThread(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		try {
			InputStream in = new FileInputStream(fileName);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while (din.read() != -1)
				;
			din.close();
			byte[] digest = sha.digest();

			StringBuilder sb = new StringBuilder(fileName);
			sb.append(":");
			sb.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(sb);
		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		File[] files = new File(System.getProperty("user.dir")).listFiles();
		for (File file : files) {
			if (!file.isDirectory()) {
				new DigestThread(file.getAbsolutePath()).start();
			}
		}
	}

}
