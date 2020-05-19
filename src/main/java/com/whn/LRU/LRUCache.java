package com.whn.LRU;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        // map中不包含返回-1
        if (!map.containsKey(key))
            return -1;
        // map中取到对应的val
        int val = map.get(key).val;
        // 将（key，value）插入链表
        put(key, val);
        return val;
    }

    private void put(int key, int val) {
        // 将（key，node）封装成node
        Node x = new Node(key, val);
        // map中包含key
        if (map.containsKey(key)) {
            // 移除旧节点
            cache.remove(map.get(key));
            // 将新节点添加到链表头部
            cache.addFirst(x);
            // 更新map映射
            map.put(key, x);
        } else {
            // 判断链表容量
            if (cache.size() == cap) {
                // 删除链表最后的节点
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 将新节点添加到链表头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}

class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleList {
    // 在链表头部添加节点 x，时间 O(1)
    public void addFirst(Node x) {

    }

    ;

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x) {

    }

    ;

    // 删除链表中最后一个节点，并返回该节点，时间 O(1)
    public Node removeLast() {
        return new Node(0, 0);
    }

    ;

    // 返回链表长度，时间 O(1)
    public int size() {
        return 0;
    }
}
