package com.saranshbhalla.leetcode.easy;

public class MergeTwoSortedLists_21 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode();
        ListNode head = current;
        while(list1!=null && list2!=null){
            int l1 = list1.val;
            int l2 = list2.val;

            if(l1<=l2) {
                current.next = list1;
                list1 = list1.next;
            }
            else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }
        if(list1!=null)
            current.next = list1;
        else if (list2!=null)
            current.next = list2;
        return head.next;
    }
}
