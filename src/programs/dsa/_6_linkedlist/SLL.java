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
        } else return head.data;
    }

    public int getTail() {
        if (tail == null) {
            return -1;
        } else return tail.data;
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
        Node curr = head;
        while (curr != null) {
            if (curr.data == target) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // Returns 1-based position
    public int findPosition(int target) {
        int position = 1;
        Node curr = head;
        while (curr != null) {
            if (curr.data == target) {
                return position;
            }
            curr = curr.next;
            position++;
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

        if (head == null && tail == null) {
            System.out.println("LinkedList is empty!");
            return;
        }
        if (position == 1) {
            head.data = data;
        } else if (position == size) {
            tail.data = data;
        } else {
            int tempPositon = 1;
            Node curr = head;
            while (curr != null) {
                if (position == tempPositon) {
                    curr.data = data;
                    return;
                }
                curr = curr.next;
                tempPositon++;
            }
        }
    }

    public void updateUsingPosition2(int position, int data) {
        if (position < 1 || position > size) {
            System.out.println("Invalid positions!");
            return;
        }
        Node curr = head;
        for (int i = 1; i <= position - 1; i++) {
            curr = curr.next;
        }
        curr.data = data;
    }

    // Update first occurrence of value
    public boolean updateValue(int oldValue, int newValue) {
        //TODO
        return false;
    }


    static void main(String[] args) {
        SLL sll = new SLL();
        if (sll.isEmpty()) {
            System.out.println("LinkedList is empty!");
        }
        System.out.println("size is: " + sll.getSize());
        sll.insertAtHead(10);
        sll.printList();

        sll.insertAtHead(20);
        sll.printList();

        sll.insertAtHead(30);
        sll.printList();

        sll.insertAtTail(100);
        sll.printList();

        sll.insertAtTail(110);
        sll.printList();

        sll.insertAtTail(120);
        sll.printList();

        sll.insertAtPosition(1, 22);
        sll.printList();

        sll.insertAtPosition(8, 200);
        sll.printList();

        sll.insertAtPosition(5, 500);
        sll.printList();

        System.out.println("head data: " + sll.getHead());
        System.out.println("tail data: " + sll.getTail());
        System.out.println(sll.search(500));
        System.out.println(sll.findPosition(200));
        sll.updateUsingPosition2(10, 900);

    }
}

