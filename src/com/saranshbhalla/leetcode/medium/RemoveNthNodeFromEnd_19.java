package com.saranshbhalla.leetcode.medium;

public class RemoveNthNodeFromEnd_19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode nNode = null, nPrevNode = null;

        ListNode currentNode = head;
        while (currentNode != null) {

            if(count==n)
                nNode = head;
            else if(count>n){
                nPrevNode = nNode;
                nNode = nNode.next;
            }
            currentNode = currentNode.next;
            count++;
        }

        if(nNode==null)
            return head;
        else if(nPrevNode==null)
            return head.next;

        nPrevNode.next = nNode.next;
        return head;
    }
}
