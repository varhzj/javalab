package com.varhzj.lab.network.thread;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CallbackDigest implements Runnable {

	private String fileName;

	public CallbackDigest(String fileName) {
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

			CallbackDigestUserInterface.reciveDigest(digest, fileName);
		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

}
