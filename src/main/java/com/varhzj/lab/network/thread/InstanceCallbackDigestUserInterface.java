package com.varhzj.lab.network.thread;

import java.io.File;
import java.io.FileFilter;

import javax.xml.bind.DatatypeConverter;

public class InstanceCallbackDigestUserInterface {

	public void reciveDigest(byte[] digest, String fileName) {
		StringBuilder sb = new StringBuilder(fileName);
		sb.append(":");
		sb.append(DatatypeConverter.printHexBinary(digest));
		System.out.println(sb);
	}

	public static void main(String[] args) {
		File[] files = new File(System.getProperty("user.dir")).listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory())
					return false;
				return true;
			}
		});
		System.out.println(files);

		for (File file : files) {
			new Thread(new InstanceCallbackDigest(file.getAbsolutePath(), new InstanceCallbackDigestUserInterface()))
					.start();
		}
	}

}
