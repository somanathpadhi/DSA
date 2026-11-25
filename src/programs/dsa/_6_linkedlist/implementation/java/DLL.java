package programs.dsa._6_linkedlist.implementation.java;

public class DLL {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    DLL() {
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
            head.prev = newNode;
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
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Insert at position | position is 1 based indexing
    public void insertAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("invalid postion");
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
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            size++;
        }
    }

// ====================
// Traversal
// ====================

    public void printList() {
        if (head == null && tail == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void printBackward() {
        if (head == null && tail == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

// ====================
// Utility Functions
// ====================

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getHead() {
        if (head == null) {
            return -1;
        } else {
            return head.data;
        }
    }

    public int getTail() {
        if (tail == null) {
            return -1;
        } else {
            return tail.data;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

// ====================
// Deletion
// ====================

    // Delete first
    public void deleteHead() {
        if (head == null && tail == null) {
            System.out.println("not able to delete.Linkedlist is empty!");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    // Delete end
    public void deleteTail() {
        if (head == null && tail == null) {
            System.out.println("not able to delete.Linkedlist is empty!");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
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
        } else if (position == size) {
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
        if (head == null && tail == null) {
            System.out.println("linkedlist is empty!");
            return false;
        } else {
            Node curr = head;
            while (curr != null) {
                if (curr.data == target) {
                    System.out.println("Found!");
                    return true;
                }
                curr = curr.next;
            }
            System.out.println("Not found!");
            return false;
        }
    }

    // Returns 1-based position
    public int findPosition(int target) {
        int position = 1;
        Node curr = head;
        while (curr != null) {
            if (curr.data == target) {
                return position;
            } else {
                curr = curr.next;
                position++;
            }
        }
        return -1;
    }

// ====================
// Update
// ====================

    // Update using position
    public void updateUsingPosition(int position, int data) {
        if (position < 1 || position > size) {
            System.out.println("invalid position!");
            return;
        }
        Node curr = head;
        for (int i = 1; i <= position - 1; i++) {
            curr = curr.next;
        }
        curr.data = data;
    }

    //    // Update first occurrence of value
    public boolean updateValue(int oldValue, int newValue) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == oldValue) {
                curr.data = newValue;
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }


    static void main(String[] args) {
        DLL dll = new DLL();
        if (dll.isEmpty()) {
            System.out.println("LinkedList is empty!");
        }
        dll.insertAtHead(40);
        dll.printList();
        dll.insertAtHead(30);
        dll.printList();
        dll.insertAtHead(20);
        dll.printList();
        dll.insertAtTail(50);
        dll.printList();
        dll.insertAtPosition(3, 35);
        dll.printList();
        dll.insertAtPosition(1, 5);
        dll.printList();
        dll.insertAtPosition(6, 60);
        dll.printList();
        dll.insertAtPosition(8, 80);
        dll.printList();
        dll.printBackward();
        dll.deleteTail();
        dll.printList();
        dll.deleteHead();
        dll.printList();
        dll.deleteAtPosition(5);
        dll.printList();
        dll.deleteAtPosition(1);
        dll.printList();
        dll.deleteAtPosition(4);
        dll.printList();
        System.out.println(dll.search(35));
        dll.printList();
        System.out.println(dll.updateValue(35, 60));
        dll.printList();
        System.out.println(dll.findPosition(40));
        dll.printList();
        dll.updateUsingPosition(2, 35);
        dll.printList();
    }

    //Method	Purpose	Priority
    //reverse()	Reverse the DLL by swapping pointers	High
    //deleteByValue(int value)	Delete first matching node	High
    //getAtPosition(int position)	Retrieve value at position	High
    //insertBefore(int target, int data)	Insert before a given value	Medium
    //insertAfter(int target, int data)	Insert after a given value	Medium
    //deleteAllOccurrences(int value)	Remove all matching nodes	Medium
    //updateAllOccurrences(int oldValue, int newValue)	Update every matching value	Medium
    //containsDuplicates()	Check for duplicate values	Low
}