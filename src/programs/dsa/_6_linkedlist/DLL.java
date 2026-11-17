package programs.dsa._6_linkedlist;

public class DLL {
    static class DLLNode{
        int data;
        DLLNode prev;
        DLLNode next;

        DLLNode(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    DLLNode head;
    DLLNode tail;
    int size;
    DLL(){
        this.head = null;
        this.tail = null;
        size = 0;
    }
}
