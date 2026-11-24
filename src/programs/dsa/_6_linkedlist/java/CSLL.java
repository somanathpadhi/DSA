package programs.dsa._6_linkedlist.java;

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
        if (head == null && tail == null) {
            System.out.println("LinkedList is empty!");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
        } else {
            head = head.next;
            tail.next = head;
            size--;
        }
    }

    // Delete end
    public void deleteTail() {
        if (head == null && tail == null) {
            System.out.println("LinkedList is empty!");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node curr = head;
        for (int i = 1; i <= size - 2; i++) {
            curr = curr.next;
        }
        tail = curr;
        curr.next = head;
        size--;
    }

    // Delete at position | position is 1 based indexing
    public void deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            deleteHead();
            return;
        }
        if (position == size) {
            deleteTail();
        } else {
            Node curr = head;
            for (int i = 1; i <= position - 2; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            size--;
        }
    }

    // ====================
    // Searching
    // ====================

    // Returns true if value exists
    public boolean search(int target) {
        if (head == null) {
            System.out.println("LinkedList is empty!");
            return false;
        }
        Node curr = head;
        if (curr.data == target) {
            return true;
        }
        curr = curr.next;
        while (curr != head) {
            if (curr.data == target) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        CSLL list = new CSLL();

        // ====================
        // Insertion
        // ====================

        list.insertAtHead(20);
        list.insertAtHead(10);
        list.insertAtTail(40);
        list.insertAtTail(50);
        list.insertAtPosition(3, 30);

        System.out.println("After insertion:");
        list.printList();

        // ====================
        // Searching
        // ====================

        System.out.println("Search 10: " + list.search(10));
        System.out.println("Search 30: " + list.search(30));
        System.out.println("Search 50: " + list.search(50));
        System.out.println("Search 100: " + list.search(100));

        // ====================
        // Deletion
        // ====================

        list.deleteHead();
        System.out.println("After deleting head:");
        list.printList();

        list.deleteTail();
        System.out.println("After deleting tail:");
        list.printList();

        list.deleteAtPosition(2);
        System.out.println("After deleting position 2:");
        list.printList();

        // ====================
        // List information
        // ====================

        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);
        System.out.println("Size: " + list.size);

        // Verify circularity
        System.out.println("Is circular: " + (list.tail.next == list.head));

        // ====================
        // Edge cases
        // ====================

        list.deleteHead();
        list.deleteTail();

        System.out.println("After deleting all nodes:");
        list.printList();

        System.out.println("Head: " + list.head);
        System.out.println("Tail: " + list.tail);
        System.out.println("Size: " + list.size);

        // Invalid operations
        list.deleteHead();
        list.deleteTail();
        list.deleteAtPosition(1);
        list.insertAtPosition(5, 100);
        System.out.println("Search 10: " + list.search(10));
    }
}
