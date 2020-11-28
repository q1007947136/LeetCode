package medium;

import java.util.*;

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

  

 进阶：

 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 */
public class T24 {

    public static void main(String args[]){
         T24 t = new T24();
         Solution s = t.new Solution();
         int[] a = {5};
         int[] b = {5};
        ListNode l1 = t.create(a);
        ListNode l2 = t.create(b);
//        l1.printListNode();
         s.addTwoNumbers(l1, l2);

    }

    public ListNode create(int[] a){
        ListNode l = new ListNode(a[0]);
        int index = 1;
        ListNode temp = l;
        while(index < a.length){
            ListNode next = new ListNode(a[index]);
            temp.next = next;
            temp = next;
            index++;
        }
        return l;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


        public void printListNode(){
            if(this.next == null){
                System.out.print(this.val);
            }else {
                System.out.print(this.val + "->");
                this.next.printListNode();
            }
        }
    }


    class Solution {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = add(l1,l2);
            result.printListNode();
            return result;
        }

        public ListNode add(ListNode l1, ListNode l2){
            while(l1 != null){
                list1.add(l1.val);
                l1 = l1.next;
            }
            while(l2 != null){
                list2.add(l2.val);
                l2 = l2.next;
            }
            if(list1.size() > list2.size()){
                int count = list1.size() - list2.size();
                for(int i=count;i>0;i--){
                    list2.add(0, 0);
                }
            }else if(list1.size() < list2.size()){
                int count = list2.size() - list1.size();
                for(int i=count;i>0;i--){
                    list1.add(0, 0);
                }
            }
            ListNode next = null;
            int sum = 0;
            int div = 0;
            int rem = 0;
            for(int i=list1.size()-1;i>=0;i--){
                sum = list1.get(i) + list2.get(i) + div;
                div = sum / 10;
                rem = sum % 10;
                ListNode l = new ListNode(rem);
                l.next = next;
                next = l;
            }
            if(div > 0){
                ListNode temp = next;
                next = new ListNode(div);
                next.next = temp;
            }
            return next;
        }

    }
}
