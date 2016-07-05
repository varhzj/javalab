package com.varhzj.lab.zookeeper.zkclient;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

public class ZkClientConn {

	private static final String CONN_STRING = "127.0.0.1:2181";
	private static final String PATH = "/zk-book";

	public static void main(String[] args) throws InterruptedException {
		ZkClient zkClient = new ZkClient(CONN_STRING, 5000);
		System.out.println("ZooKeeper session established");
		zkClient.subscribeChildChanges(PATH, new IZkChildListener() {

			@Override
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				System.out.println(parentPath + "'s child changed, current: " + currentChilds);
			}

		});


		zkClient.createPersistent(PATH);
		Thread.sleep(1000);

		zkClient.createPersistent(PATH + "/c1");
		Thread.sleep(1000);

		zkClient.createPersistent(PATH + "/c2");
		Thread.sleep(1000);

		zkClient.deleteRecursive(PATH);
		Thread.sleep(Integer.MAX_VALUE);
	}

}
