package com.saranshbhalla.leetcode.medium;

import java.util.List;

public class AddTwoNumbers_2 {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int carry = 0;
      ListNode head = null;
      ListNode curr = null;
      while(l1!=null || l2!=null || carry!=0) {
          int n1 = l1!=null ? l1.val : 0;
          int n2 = l2!=null ? l2.val : 0;
          int sum = n1 + n2 + carry;
          ListNode node = new ListNode(sum%10);
          carry = sum/10;
          if(curr == null)
              head = curr = node;
          else{
              curr.next = node;
              curr = node;
          }
          l1 = l1!=null ? l1.next : null;
          l2 = l2!=null ? l2.next : null;
      }
      return head;

    }
}
