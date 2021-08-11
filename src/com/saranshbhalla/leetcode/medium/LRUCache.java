package com.saranshbhalla.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This is an implementation of Linked Hashmap
 * 1. There is a doubly linked list that contains all the data
 * 2. the map only contains ref to the list node against the original key
 */
public class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
    }

    Map<Integer, Node> map;
    LinkedList<Node> linkedList = new LinkedList<Node>();
    int capacity;
    Node tail = null;
    Node head = null;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
    }


    public int get(int key){
        if(!map.containsKey(key))
            return -1;
        Node target =  map.get(key);
        moveToEnd(target);
        return target.value;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node target = map.get(key);
            target.value = value;
            moveToEnd(target);
            return;
        }
        else if(map.size()==capacity) {
            map.remove(head.key);
            head = head.next;
            if(head!=null)
                head.prev = null;
            else
                tail = null;
        }

        Node node = new Node();
        node.key = key;
        node.value = value;
        map.put(key, node);

        if(head ==null){
            node.prev = null;
            node.next = null;
            head = node;
            tail=node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }

    private void moveToEnd(Node node){
        if(node.next==null)
            return;
        else if(node.prev ==null){
            head = node.next;
            head.prev = null;
        }
        else {
            Node prevNode = node.prev;
            prevNode.next = node.next;
            node.next.prev = prevNode;
        }
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(0,10);
        cache.put(1, 20);
        cache.put(0, 30);
        cache.put(2, 40);
        System.out.println(cache.get(0));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
