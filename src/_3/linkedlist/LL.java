package _3.linkedlist;

public class LL {
    public Node head;
    private int size;

    public LL() {
        this.size = 0;
    }

    public class Node {
        public String data;
        public Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // add - first , last
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //add last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // print
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // delete

    public void deleteFromFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteFromLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    public int getSize() {
        return size;
    }
    public void reverseLinkedList(){
        if (head == null || head.next == null){
            return;
        }
        Node prev = head;
        Node curr = head.next;


        while(curr != null){
            Node nextNode = curr.next;
            curr.next = prev;

            //update
            prev = curr;
            curr = nextNode;
        }
        head.next = null;
        head = prev;
    }
    public Node reverseRecursive(Node head){
        if (head == null || head.next == null){
            return  head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
         return newHead;
    }

    public Node findNthNode(Node head, int nthNode){
        if (head == null){
            return null;
        }
        Node curr = head;
        int size = 0;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        int toReachNthNode = size - nthNode+1;
        Node nthNodeToFind = head;
        int i = 1;
        while (i < toReachNthNode){
            nthNodeToFind = nthNodeToFind.next;
            i++;
        }
        return nthNodeToFind;
    }
    public void isLinkedListAPalindrome(){
        //find middle node slow/fast
        //reverse the linked list from middle to last
        //check with the initial list with the new half list

    }

    public static void main(String[] args) {
        LL list = new LL();
//        list.addFirst("a");
//        list.addFirst("is");
//        list.printList();
//        list.addLast("list");
//        list.printList();
//        list.addFirst("this");
//        list.printList();
//        list.deleteFromFirst();
//        list.printList();
//        list.deleteFromLast();
//        list.printList();
//        System.out.println(list.getSize());
//        list.addFirst("this");
//        System.out.println(list.getSize());
        list.addLast("1");
        list.addLast("2");
        list.printList();
        list.head = list.reverseRecursive(list.head);
        list.printList();
    }
}