package com.varhzj.lab.network.socket;

/**
 * Created by huangzhijian on 16-6-17.
 */
public interface Commons {

	public interface MSG_TYPE {
		public static final byte SEND_MESSAGE = 1;
		public static final byte SEND_FILE = 2;
		public static final byte SEND_B_FILE = 3;
		public static final byte GET_FILE = 4;
	}

}
