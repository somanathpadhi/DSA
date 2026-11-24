package programs.dsa._6_linkedlist.java;

public class CDLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;
    int size;

    CDLL() {
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
            head.prev = tail;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            tail.next = head;
            head.prev = tail;
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
            head.prev = tail;
        } else {
            newNode.next = head;
            head.prev = newNode;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Insert at position | position is 1 based indexing
    public void insertAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("invalid position!");
            return;
        }
        if (position == 1) {
            insertAtHead(data);
            return;
        }
        if (position == size + 1) {
            insertAtTail(data);
        } else {
            Node prevNode = head;
            for (int i = 1; i <= position - 2; i++) {
                prevNode = prevNode.next;
            }
            Node currNode = new Node(data);
            Node nextNode = prevNode.next;
            currNode.prev = prevNode;
            currNode.next = nextNode;
            prevNode.next = currNode;
            nextNode.prev = currNode;
            size++;
        }
    }

    // ====================
    // Traversal
    // ====================

    public void printList() {
        if (head == null) {
            System.out.println("LinkedList is empty!");
            return;
        }
        Node curr = head;
        System.out.print(curr.data + " ");
        curr = curr.next;
        while (curr != head) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
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
            return;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
            size--;
        }
    }

    // Delete end
    public void deleteTail() {
        if (head == null) {
            System.out.println("LinkedList is empty!");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
        } else {
            Node prevNode = tail.prev;
            prevNode.next = head;
            head.prev = prevNode;
            tail = prevNode;
            size--;
        }
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
            Node prevNode = head;
            for (int i = 1; i <= position - 2; i++) {
                prevNode = prevNode.next;
            }
            Node nextNode = prevNode.next.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
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
            System.out.println("Found!");
            return true;
        }
        curr = curr.next;
        while (curr != head) {
            if (curr.data == target) {
                System.out.println("Found!");
                return true;
            }
            curr = curr.next;
        }
        System.out.println("Not Found!");
        return false;
    }

    static void main(String[] args) {

        CDLL list = new CDLL();

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
        System.out.println("Size: " + list.size);

        // ====================
        // Searching
        // ====================

        System.out.println("\nSearching 30:");
        list.search(30);

        System.out.println("Searching 100:");
        list.search(100);

        // ====================
        // Deletion
        // ====================

        System.out.println("\nAfter deleting head:");
        list.deleteHead();
        list.printList();

        System.out.println("\nAfter deleting tail:");
        list.deleteTail();
        list.printList();

        System.out.println("\nAfter deleting position 2:");
        list.deleteAtPosition(2);
        list.printList();

        System.out.println("Size: " + list.size);

        // ====================
        // Circularity validation
        // ====================

        System.out.println("\nCircularity validation:");
        System.out.println(list.tail.next == list.head);
        System.out.println(list.head.prev == list.tail);

        // ====================
        // Invalid positions
        // ====================

        System.out.println("\nInvalid position testing:");
        list.insertAtPosition(10, 100);
        list.deleteAtPosition(10);

        // ====================
        // Single node testing
        // ====================

        list.deleteHead();

        System.out.println("\nSingle node:");
        list.printList();

        System.out.println("Size: " + list.size);

        // ====================
        // Empty list testing
        // ====================

        list.deleteTail();

        System.out.println("\nEmpty list testing:");
        list.printList();
        list.deleteHead();
        list.deleteTail();
        list.search(10);

        System.out.println("Size: " + list.size);

        // ====================
        // Reinsertion
        // ====================

        list.insertAtHead(100);
        list.insertAtTail(200);

        System.out.println("\nAfter reinsertion:");
        list.printList();

        System.out.println("Size: " + list.size);
    }
}

