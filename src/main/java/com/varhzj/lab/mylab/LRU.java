package com.varhzj.lab.mylab;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {

    private Node head;
    private Node tail;
    private Map<K, Node> map;
    private int maxSize;

    public LRU(int maxSize) {
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
        this.map = new HashMap<>(maxSize * 4 / 3 + 1);
        this.maxSize = maxSize;
    }

    public V get(K key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        delNode(node);
        putHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node oldNode = map.get(key);
        if (oldNode != null) {
            delNode(oldNode);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        putHead(node);

        if (map.size() > maxSize) {
            Node rmNode = removeTail();
            map.remove(rmNode.key);
        }
    }

    private Node removeTail() {
        Node node = tail.pre;
        tail.pre = node.pre;
        node.pre.next = tail;

        node.pre = null;
        node.next = null;

        return node;
    }

    private void delNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    private void putHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private class Node {
        K key;
        V value;
        Node pre;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
