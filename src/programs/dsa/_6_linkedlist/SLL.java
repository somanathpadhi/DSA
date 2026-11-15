package programs.dsa._6_linkedlist;


public class SLL {

    static class Node {

        int data;
        Node next;

        //constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    //constructor
    SLL() {
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
        } else {
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
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    // Insert at position | position is 1 based indexing
    public void insertAtPosition(int position, int data) {

        if (position <= 0 || position > size + 1) {
            System.out.println("invalid position!");
            return;
        }

        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else if (position == size + 1) {
            tail.next = newNode;
            tail = newNode;

        } else {
            Node curr = head;
            for (int i = 0; i < position - 2; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        size++;
    }

    public void insertAtPosition2(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        Node newNode = new Node(data);
        if (position == 1) {
            insertAtHead(data);
        } else if (position == size + 1) {
            insertAtTail(data);
        } else {
            Node curr = head;
            for (int i = 0; i < position - 2; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        size++;
    }


    // ====================
    // Traversal
    // ====================

    public void printList() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        }
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    // ====================
    // Utility Functions
    // ====================

    public int getSize() {
        //TODO
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getHead() {
        //TODO
        return -1;
    }

    public int getTail() {
        //TODO
        return -1;
    }

    public void clear() {
        //TODO
    }


    // ====================
    // Deletion
    // ====================

    // Delete first
    public void deleteHead() {
        //TODO
    }

    // Delete end
    public void deleteTail() {
        //TODO
    }

    // Delete at position | position is 1 based indexing
    public void deleteAtPosition(int position) {
        //TODO
    }

    // ====================
    // Searching
    // ====================

    // Returns true if value exists
    public boolean search(int target) {
        //TODO
        return false;
    }

    // Returns 1-based position
    public int findPosition(int target) {
        //TODO
        return -1;
    }

    // ====================
    // Update
    // ====================

    // Update using position
    public void updateUsingPosition(int position, int data) {
        //TODO
    }

    // Update first occurrence of value
    public boolean updateValue(int oldValue, int newValue) {
        //TODO
        return false;
    }


    static void main(String[] args) {
        SLL sll = new SLL();
        sll.insertAtHead(5);
        sll.insertAtHead(4);
        sll.insertAtHead(3);
        sll.insertAtTail(9);
        sll.insertAtTail(10);
        sll.insertAtPosition2(7, 7);
        sll.printList();
    }
}
