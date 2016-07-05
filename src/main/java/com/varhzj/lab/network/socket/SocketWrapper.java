package com.varhzj.lab.network.socket;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by huangzhijian on 16-6-17.
 */
public class SocketWrapper implements Closeable {

	private static final int PAGE_SIZE = 1024 * 1024;

	private Socket socket;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;

	public SocketWrapper(Socket socket) throws IOException {
		this.socket = socket;
		processStream();
	}

	public SocketWrapper(String host, int port) throws IOException {
		this.socket = new Socket();
		this.socket.connect(new InetSocketAddress(host, port));
		this.socket.setKeepAlive(true);
		this.socket.setTcpNoDelay(true);
		processStream();
	}

	private void processStream() throws IOException {
		this.inputStream = new DataInputStream(socket.getInputStream());
		this.outputStream = new DataOutputStream(socket.getOutputStream());
	}

	public void write(byte b) throws IOException {
		this.outputStream.write(b);
	}

	public void write(short s) throws IOException {
		this.outputStream.writeShort(s);
	}

	public void write(int i) throws IOException {
		this.outputStream.writeInt(i);
	}

	public void write(long l) throws IOException {
		this.outputStream.writeLong(l);
	}

	public void write(String s) throws IOException {
		this.outputStream.writeUTF(s);
	}

	public void write(byte[] bytes) throws IOException {
		this.outputStream.write(bytes);
	}

	public void write(byte[] bytes, int lenght) throws IOException {
		this.outputStream.write(bytes, 0, lenght);
	}

	public void write(String value, String charset) throws IOException {
		if (value != null) {
			write(value.getBytes(charset));
		}
	}

	public byte readByte() throws IOException {
		return this.inputStream.readByte();
	}

	public short readShort() throws IOException {
		return this.inputStream.readShort();
	}

	public int readInt() throws IOException {
		return this.inputStream.readInt();
	}

	public long readLong() throws IOException {
		return this.inputStream.readLong();
	}

	public void readFull(byte[] bytes) throws IOException {
		this.inputStream.read(bytes);
	}

	public int read(byte[] bytes) throws IOException {
		return this.inputStream.read(bytes);
	}

	public SocketAddress getRemoteSocketAddress() {
		return this.socket.getRemoteSocketAddress();
	}

	public void sendFile(String path) throws IOException {
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			try (FileInputStream fileInputStream = new FileInputStream(file)) {
				long fileLength = file.length();
				if (fileLength > PAGE_SIZE) {
					int allLength = 0;
					byte[] bytes = new byte[PAGE_SIZE];
					int length = fileInputStream.read(bytes);
					while (length > 0) {
						allLength += length;
						this.write(bytes, length);
						length = fileInputStream.read(bytes);
						System.out.print(".");
					}
					System.out.println("the file send length: " + allLength);
				} else {
					this.write(inputStream.read(new byte[(int) fileLength]));
				}
			}
		} else {
			throw new RuntimeException("file not exists or you have chosen a directory");
		}
	}

	@Override
	public void close() throws IOException {
		this.socket.close();
	}
}
