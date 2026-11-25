package programs.dsa._6_linkedlist.implementation.kotlin

class CircularSinglyLinkedList {

    class Node(var data: Int) {
        var next: Node? = null
    }

    var head: Node? = null
    var tail: Node? = null
    var size: Int = 0

    // ====================
    // Insertion
    // ====================

    // Insert at beginning
    fun insertAtHead(data: Int) {
        val newNode = Node(data)

        if (head == null && tail == null) {
            head = newNode
            tail = newNode
            tail!!.next = head
        } else {
            tail!!.next = newNode
            newNode.next = head
            head = newNode
        }

        size++
    }

    // Insert at end
    fun insertAtTail(data: Int) {
        val newNode = Node(data)

        if (head == null && tail == null) {
            head = newNode
            tail = newNode
            tail!!.next = head
        } else {
            newNode.next = head
            tail!!.next = newNode
            tail = newNode
        }

        size++
    }

    // Insert at position | position is 1-based indexing
    fun insertAtPosition(position: Int, data: Int) {

        if (position < 1 || position > size + 1) {
            println("Invalid position!")
        } else if (position == 1) {
            insertAtHead(data)
        } else if (position == size + 1) {
            insertAtTail(data)
        } else {
            val newNode = Node(data)
            var prevNode = head!!

            for (i in 1..position - 2) {
                prevNode = prevNode.next!!
            }

            val nextNode = prevNode.next

            prevNode.next = newNode
            newNode.next = nextNode

            size++
        }
    }

    // ====================
    // Traversal
    // ====================

    fun printList() {

        if (head == null) {
            println("LinkedList is empty!")
        } else {
            var curr = head!!

            do {
                print("${curr.data} ")
                curr = curr.next!!
            } while (curr !== head)

            println()
        }
    }

    // ====================
    // Deletion
    // ====================

    // Delete first
    fun deleteHead() {

        if (head == null && tail == null) {
            println("LinkedList is empty!")
            return
        }

        if (head === tail) {
            head = null
            tail = null
            size = 0
        } else {
            head = head!!.next
            tail!!.next = head
            size--
        }
    }

    // Delete end
    fun deleteTail() {

        if (head == null && tail == null) {
            println("LinkedList is empty!")
            return
        }

        if (head === tail) {
            head = null
            tail = null
            size = 0
            return
        }

        var curr = head!!

        for (i in 1..size - 2) {
            curr = curr.next!!
        }

        tail = curr
        curr.next = head
        size--
    }

    // Delete at position | position is 1-based indexing
    fun deleteAtPosition(position: Int) {

        if (position < 1 || position > size) {
            println("Invalid position!")
            return
        }

        if (position == 1) {
            deleteHead()
            return
        }

        if (position == size) {
            deleteTail()
        } else {
            var curr = head!!

            for (i in 1..position - 2) {
                curr = curr.next!!
            }

            curr.next = curr.next!!.next
            size--
        }
    }

    // ====================
    // Searching
    // ====================

    // Returns true if value exists
    fun search(target: Int): Boolean {

        if (head == null) {
            println("LinkedList is empty!")
            return false
        }

        var curr = head!!

        if (curr.data == target) {
            return true
        }

        curr = curr.next!!

        while (curr !== head) {
            if (curr.data == target) {
                return true
            } else {
                curr = curr.next!!
            }
        }

        return false
    }
}

fun main() {

    val list = CircularSinglyLinkedList()

    // ====================
    // Insertion
    // ====================

    list.insertAtHead(20)
    list.insertAtHead(10)
    list.insertAtTail(40)
    list.insertAtTail(50)
    list.insertAtPosition(3, 30)

    println("After insertion:")
    list.printList()

    // ====================
    // Searching
    // ====================

    println("Search 10: ${list.search(10)}")
    println("Search 30: ${list.search(30)}")
    println("Search 50: ${list.search(50)}")
    println("Search 100: ${list.search(100)}")

    // ====================
    // Deletion
    // ====================

    list.deleteHead()
    println("After deleting head:")
    list.printList()

    list.deleteTail()
    println("After deleting tail:")
    list.printList()

    list.deleteAtPosition(2)
    println("After deleting position 2:")
    list.printList()

    // ====================
    // List information
    // ====================

    println("Head: ${list.head?.data}")
    println("Tail: ${list.tail?.data}")
    println("Size: ${list.size}")

    // Verify circularity
    println("Is circular: ${list.tail?.next === list.head}")

    // ====================
    // Edge cases
    // ====================

    list.deleteHead()
    list.deleteTail()

    println("After deleting all nodes:")
    list.printList()

    println("Head: ${list.head}")
    println("Tail: ${list.tail}")
    println("Size: ${list.size}")

    // Invalid operations
    list.deleteHead()
    list.deleteTail()
    list.deleteAtPosition(1)
    list.insertAtPosition(5, 100)

    println("Search 10: ${list.search(10)}")
}

