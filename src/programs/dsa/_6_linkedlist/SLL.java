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

    public void insertAtPositionOptimized(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            insertAtHead(data);
        } else if (position == size + 1) {
            insertAtTail(data);
        } else {
            Node newNode = new Node(data);
            Node curr = head;
            for (int i = 1; i <= position - 2; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }
    }

    // ====================
    // Traversal
    // ====================

    public void printList() {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return;
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
        head = null;
        tail = null;
        size = 0;
    }

    // ====================
    // Deletion
    // ====================

    // Delete first
    public void deleteHead() {
        if (head == null) {
            System.out.println("LInkedList is empty!");
            return;
        }
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
    }

    // Delete end
    public void deleteTail() {
        if (tail == null) {
            System.out.println("LInkedList is empty!");
            return;
        } else if (tail == head) {
            head = null;
            tail = null;
        } else {
            Node curr = head;
            while (curr.next != tail) {
                curr = curr.next;
            }
            tail = curr;
            curr.next = null;
        }
        size--;
    }

    // Delete at position | position is 1 based indexing
    public void deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid position!");
            return;
        }
        if (head == null || tail == null) {
            System.out.println("LinkedList is empty!");
        } else if (position == 1) {
            deleteHead();
        } else if (position == size) {
            deleteTail();
        } else {
            Node prevNode = head;
            for (int i = 1; i <= position - 2; i++) {
                prevNode = prevNode.next;
            }
            prevNode.next = prevNode.next.next;
            size--;
        }
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
        if (head == null && tail == null) {
            System.out.println("LinkedList is empty!");
            return false;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.data == oldValue) {
                curr.data = newValue;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    //1. Additional functions to implement

    //Basic operations — recommended next
    //#	Function	Purpose	Priority
    //1	reverse()	Reverse the entire linked list	High
    //2	findMiddle()	Find the middle node	High
    //3	getNthFromEnd(int n)	Find Nth node from the end	High
    //4	deleteByValue(int value)	Delete first matching node	High
    //5	deleteAllOccurrences(int value)	Delete every matching node	Medium
    //6	contains(int value)	Already covered by search()	Done
    //7	countOccurrences(int value)	Count how often a value appears	Medium
    //8	getAtPosition(int position)	Retrieve data at a position	High
    //9	removeDuplicates()	Remove duplicate values	High
    //10	toArray()	Convert linked list to an array	Low
    //

    //Intermediate operations — interview preparation
    //#	Function	Purpose
    //11	hasCycle()	Detect a cycle using slow and fast pointers
    //12	findCycleStart()	Find where a cycle begins
    //13	removeCycle()	Remove a cycle
    //14	isPalindrome()	Check whether the list is a palindrome
    //15	reverseRecursive()	Reverse using recursion
    //16	mergeSortedLists()	Merge two sorted linked lists
    //17	findIntersection()	Find the common node of two lists
    //18	rotateRight(int k)	Rotate the list by K positions
    //19	reverseInGroups(int k)	Reverse nodes in groups of K
    //20	swapPairs()	Swap adjacent nodes
    //

    //Advanced operations — optional
    //#	Function	Purpose
    //21	mergeSort()	Sort the linked list
    //22	partition(int x)	Partition nodes around a value
    //23	reorderList()	Reorder first, last, second, second-last
    //24	removeNthFromEnd(int n)	Delete Nth node from end
    //25	addTwoNumbers()

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
        sll.insertAtPosition(1, 40);
        sll.printList();
        sll.insertAtPosition(8, 200);
        sll.printList();
        sll.insertAtPosition(5, 500);
        sll.printList();
        System.out.println("head data: " + sll.getHead());
        System.out.println("tail data: " + sll.getTail());
        System.out.println(sll.search(500));
        System.out.println(sll.findPosition(200));
        sll.updateUsingPosition2(6, 2000);
        sll.printList();
        System.out.println(sll.updateValue(2000, 35));
        sll.printList();
        sll.deleteHead();
        sll.printList();
        sll.deleteTail();
        sll.printList();
        sll.deleteAtPosition(4);
        sll.printList();
        sll.insertAtPositionOptimized(8, 55);
        sll.deleteHead();
        sll.printList();
        sll.deleteHead();
        sll.printList();
        sll.deleteHead();
        sll.printList();
        sll.deleteHead();
        sll.printList();
        sll.deleteHead();
        sll.printList();
        sll.deleteTail();
        sll.printList();
        sll.deleteHead();
        sll.printList();
    }
}