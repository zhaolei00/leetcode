package com.zl;

/**
 * @Author : zhaolei
 * @Date : Create in 2021-05-11 10:34
 * @Description :
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * <p>
 * 示例 1 :
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2 :
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3 :
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        ListNode res = new ListNode((l1.val + l2.val) % 10);
        ListNode temp = res;
        a = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            int var1 = 0;
            if (l1 != null) {
                var1 = l1.val;
                l1 = l1.next;
            }
            int var2 = 0;
            if (l2 != null) {
                var2 = l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode((var1 + var2 + a) % 10);
            temp = temp.next;
            a = (var1 + var2 + a) / 10;
        }
        if (a != 0) {
            temp.next = new ListNode(a);
        }
        return res;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * ListNode1 = [9, 9, 9, 9, 9, 9, 9]
     * ListNode2 = [9, 9, 9, 9]
     * result = [8, 9, 9, 9, 0, 0, 0, 1]
     *
     * @param args
     */
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        AddTwoNumbers.ListNode ListNode1 = new AddTwoNumbers.ListNode(9,
                new AddTwoNumbers.ListNode(9,
                        new AddTwoNumbers.ListNode(9,
                                new AddTwoNumbers.ListNode(9,
                                        new AddTwoNumbers.ListNode(9,
                                                new AddTwoNumbers.ListNode(9,
                                                        new AddTwoNumbers.ListNode(9)))))));
        AddTwoNumbers.ListNode ListNode2 = new AddTwoNumbers.ListNode(9,
                new AddTwoNumbers.ListNode(9,
                        new AddTwoNumbers.ListNode(9,
                                new AddTwoNumbers.ListNode(9))));
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(ListNode1, ListNode2);
        do {
            System.out.println(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);
    }
}