package com.varhzj.lab.zookeeper.curator;

import java.io.IOException;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorConn {

	private static final String CONN_STRING = "127.0.0.1:2181";

	public static void main(String[] args) {
		CuratorFramework client = CuratorFrameworkFactory.builder()//
				.connectString(CONN_STRING)//
				.sessionTimeoutMs(5000)//
				.retryPolicy(new ExponentialBackoffRetry(1000, 3))//
				.build();
		client.start();

		try {
			client.delete().deletingChildrenIfNeeded().forPath("/zk-book");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			client.create().forPath("/zk-book/test");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				client.create().creatingParentsIfNeeded().forPath("/zk-book/test");
				System.out.println("create path /zk-book/test success");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		try {
			client.setData().forPath("/zk-book/test", "test".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println(new String(client.getData().forPath("/zk-book/test")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		LeaderSelector selector1 = new LeaderSelector(client, "/master-select", new LeaderSelectorListenerAdapter() {

			@Override
			public void takeLeadership(CuratorFramework arg0) throws Exception {
				System.out.println("selector1 Got leader");
				client.setData().forPath("/master-select", "selector1".getBytes());
				Thread.sleep(3000);
				System.out.println("selector1 release leader");
			}
		});

		LeaderSelector selector2 = new LeaderSelector(client, "/master-select", new LeaderSelectorListenerAdapter() {

			@Override
			public void takeLeadership(CuratorFramework arg0) throws Exception {
				System.out.println("selector2 Got leader");
				client.setData().forPath("/master-select", "selector2".getBytes());
				Thread.sleep(3000);
				System.out.println("selector2 release leader");
			}
		});

		new Thread(new Runnable() {

			@Override
			public void run() {
				selector2.autoRequeue();
				selector2.start();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				selector1.autoRequeue();
				selector1.start();
			}
		}).start();

		PathChildrenCache childCache = new PathChildrenCache(client, "/master-select", true);
		try {
			childCache.start(StartMode.BUILD_INITIAL_CACHE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		childCache.getListenable().addListener(new PathChildrenCacheListener() {

			@Override
			public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
				switch (event.getType()) {
				case CHILD_ADDED:
					System.out.println("CHILD_ADDED: " + event.getData());
					break;
				case CHILD_UPDATED:
					System.out.println("CHILD_UPDATED: " + event.getData());
					break;
				case CHILD_REMOVED:
					System.out.println("CHILD_REMOVED: " + event.getData());
					break;
				default:
					break;
				}
			}
		});

		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		selector1.close();
		selector2.close();
		try {
			childCache.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
