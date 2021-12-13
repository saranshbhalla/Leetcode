package com.saranshbhalla.leetcode.medium;

import java.util.*;

public class CloneGraph_133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        return dfs(node, new HashMap<>());

    }

    public Node dfs (Node root, Map<Node, Node> visited){
        Node newNode = new Node(root.val);
        visited.put(root, newNode);
        for (Node neighbor: root.neighbors) {
            if(!visited.containsKey(neighbor))
                newNode.neighbors.add(dfs(neighbor, visited));
            else
                newNode.neighbors.add(visited.get(neighbor));
        }
        return newNode;
    }
}
