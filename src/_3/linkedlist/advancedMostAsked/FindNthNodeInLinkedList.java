package _3.linkedlist.advancedMostAsked;

import _3.linkedlist.LL;

public class FindNthNodeInLinkedList {
    public static void main(String[] args) {
        LL list = new LL();
        list.addLast("1");
        list.addLast("2");
        list.printList();
        list.addLast("3");
        list.addLast("4");
        list.printList();
       LL.Node nTh =list.findNthNode(list.head,2);
        System.out.println(nTh.data);
    }
}
