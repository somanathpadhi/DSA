package programs.dsa._6_linkedlist;

public class DLL {
    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;
    DLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
