package com.varhzj.lab.zookeeper.simple;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.AsyncCallback.StringCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperConnect implements Watcher {

	private static final String CONN_STRING = "127.0.0.1:2181";
	private static CountDownLatch latch = new CountDownLatch(1);

	public static void simple() throws Exception {
		ZooKeeper zookeeper = new ZooKeeper(CONN_STRING, 5000, new ZooKeeperConnect());
		System.out.println("ZooKeeper state: " + zookeeper.getState());
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ZooKeeper session established.");
		zookeeper.addAuthInfo("digest", "admin:admin123".getBytes());
		zookeeper.addAuthInfo("digest", "user:password".getBytes());
		zookeeper.create("/zk_test_auth", "admin123".getBytes(), Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);
		zookeeper.create("/zk_test_auth/1", "1".getBytes(), Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);
		zookeeper.create("/zk_test_auth/2", "2".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

		String znode1 = zookeeper.create("/zk-test-", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		System.out.println("Create znode: " + znode1);

//		String znode2 = zookeeper.create("/zk-test/test", "test".getBytes(), Ids.OPEN_ACL_UNSAFE,
//				CreateMode.EPHEMERAL_SEQUENTIAL);
//		System.out.println("Create znode: " + znode2);

//		zookeeper.getData(znode2, false, null);

		zookeeper.create("/zk-test-async/test", "hello".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
				new StringCallback() {

					@Override
					public void processResult(int rc, String path, Object ctx, String name) {
						System.out.println("Create znode result: [" + rc + ", " + path + ", " + ctx
								+ ", real path name: " + name + "]");
					}
				}, "I am context");

		zookeeper.create("/zk-test-async", "hello world".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
				new StringCallback() {

					@Override
					public void processResult(int rc, String path, Object ctx, String name) {
						System.out.println("Create znode result: [" + rc + ", " + path + ", " + ctx
								+ ", real path name: " + name + "]");
					}
				}, "I am context");

		Thread.sleep(Integer.MAX_VALUE);
	}

	public static void useSidPwd() throws Exception {
		ZooKeeper zookeeper = new ZooKeeper(CONN_STRING, 5000, new ZooKeeperConnect());
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long sid = zookeeper.getSessionId();
		byte[] passwd = zookeeper.getSessionPasswd();

		zookeeper = new ZooKeeper(CONN_STRING, 5000, new ZooKeeperConnect(), 1l, "test".getBytes());
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		zookeeper = new ZooKeeper(CONN_STRING, 50000, new ZooKeeperConnect(), sid, passwd);

		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			simple();
			// useSidPwd();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(WatchedEvent event) {
		System.out.println("receive watched event: " + event);
		if (KeeperState.SyncConnected == event.getState())
			latch.countDown();
	}

}
