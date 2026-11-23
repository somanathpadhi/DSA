package programs.dsa._6_linkedlist;

public class CSLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;
    int size;

    CSLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // ====================
    // Insertion
    // ====================

    // Insert at beginning
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Insert at end
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Insert at position | position is 1 based indexing
    public void insertAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
        } else if (position == 1) {
            insertAtHead(data);
        } else if (position == size + 1) {
            insertAtTail(data);
        } else {
            Node newNode = new Node(data);
            Node prevNode = head;
            for (int i = 1; i <= position - 2; i++) {
                prevNode = prevNode.next;
            }
            Node nextNode = prevNode.next;
            prevNode.next = newNode;
            newNode.next = nextNode;
            size++;
        }
    }

    // ====================
    // Traversal
    // ====================

    public void printList() {
        if (head == null) {
            System.out.println("LinkedList is empty!");
        } else {
            Node curr = head;
            do {
                System.out.print(curr.data + " ");
                curr = curr.next;
            } while (curr != head);
            System.out.println();
        }
    }

    // ====================
    // Deletion
    // ====================

    // Delete first
    public void deleteHead() {

    }

    // Delete end
    public void deleteTail() {

    }

    // Delete at position | position is 1 based indexing
    public void deleteAtPosition(int position) {

    }

    // ====================
    // Searching
    // ====================

    // Returns true if value exists
    public boolean search(int target) {
        return false;
    }
}
