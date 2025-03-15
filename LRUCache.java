// https://leetcode.com/problems/lru-cache/
package LeetCode;

import java.util.HashMap;
import java.util.Map;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev, next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList<K, V> {
    Node head;
    Node tail;
    Node cur;

    public DoublyLinkedList() {
        head = new Node<Integer, Integer>(-1, -1);
        tail = new Node<Integer, Integer>(-1, -1);
        head.next = tail;
        tail.prev = head;
        cur = null;
    }

    public void insertAfFront(Node node) {
        if (head.next == tail) {
            head.next = node;
            node.next = tail;
            node.prev = head;
            tail.prev = node;
            return;
        }

        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    public K deleteLastNode() {
        Node deletedNode = tail.prev;
        Node secondLast = tail.prev.prev;
        secondLast.next = tail;
        tail.prev = secondLast;

        deletedNode.next = null;
        deletedNode.prev = null;

        return (K) deletedNode.key;
    }
}

public class LRUCache {
    DoublyLinkedList<Integer, Integer> list;
    int capacity;
    Map<Integer, Node<Integer, Integer>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new DoublyLinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        list.deleteNode(map.get(key));
        list.insertAfFront(map.get(key));

        return (int) map.get(key).value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key) && (int) map.get(key).value == value) {
            list.deleteNode(map.get(key));
            list.insertAfFront(map.get(key));
            return;
        }
        if (map.containsKey(key) && (int) map.get(key).value != value) {
            list.deleteNode(map.get(key));
            map.remove(key);
        }

        if (map.size() == capacity) {
            int deletedNodeKey = list.deleteLastNode();
            map.remove(deletedNodeKey);
        }

        Node<Integer, Integer> newNode = new Node<>(key, value);
        list.insertAfFront(newNode);
        map.put(key, newNode);
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(4);
        System.out.println(obj.get(2));

        obj.put(2, 6);
        obj.put(4, 7);
        obj.put(8, 11);
        obj.put(7, 10);

        System.out.println(obj.get(2));
        System.out.println(obj.get(8));

        System.out.println(obj.map);
        obj.put(5, 6);
        System.out.println(obj.map);

        System.out.println(obj.get(7));
        obj.put(5, 7);

    }
}
