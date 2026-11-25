package programs.dsa._6_linkedlist.implementation.kotlin

class CircularDoublyLinkedList {

    class Node(var data: Int) {
        var next: Node? = null
        var prev: Node? = null
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
            head!!.prev = tail
        } else {
            newNode.next = head
            head!!.prev = newNode
            head = newNode
            tail!!.next = head
            head!!.prev = tail
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
            head!!.prev = tail
        } else {
            newNode.next = head
            head!!.prev = newNode
            tail!!.next = newNode
            newNode.prev = tail
            tail = newNode
        }

        size++
    }

    // Insert at position | position is 1-based indexing
    fun insertAtPosition(position: Int, data: Int) {

        if (position < 1 || position > size + 1) {
            println("invalid position!")
            return
        }

        if (position == 1) {
            insertAtHead(data)
            return
        }

        if (position == size + 1) {
            insertAtTail(data)
        } else {
            var prevNode = head!!

            for (i in 1..position - 2) {
                prevNode = prevNode.next!!
            }

            val currNode = Node(data)
            val nextNode = prevNode.next!!

            currNode.prev = prevNode
            currNode.next = nextNode
            prevNode.next = currNode
            nextNode.prev = currNode

            size++
        }
    }

    // ====================
    // Traversal
    // ====================

    fun printList() {

        if (head == null) {
            println("LinkedList is empty!")
            return
        }

        var curr = head!!

        print("${curr.data} ")
        curr = curr.next!!

        while (curr !== head) {
            print("${curr.data} ")
            curr = curr.next!!
        }

        println()
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
            return
        } else {
            head = head!!.next
            head!!.prev = tail
            tail!!.next = head
            size--
        }
    }

    // Delete end
    fun deleteTail() {

        if (head == null) {
            println("LinkedList is empty!")
            return
        }

        if (head === tail) {
            head = null
            tail = null
            size = 0
        } else {
            val prevNode = tail!!.prev!!

            prevNode.next = head
            head!!.prev = prevNode
            tail = prevNode

            size--
        }
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
            var prevNode = head!!

            for (i in 1..position - 2) {
                prevNode = prevNode.next!!
            }

            val nextNode = prevNode.next!!.next!!

            prevNode.next = nextNode
            nextNode.prev = prevNode

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
            println("Found!")
            return true
        }

        curr = curr.next!!

        while (curr !== head) {
            if (curr.data == target) {
                println("Found!")
                return true
            }

            curr = curr.next!!
        }

        println("Not Found!")
        return false
    }
}

fun main() {

    val list = CircularDoublyLinkedList()

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
    println("Size: ${list.size}")

    // ====================
    // Searching
    // ====================

    println("\nSearching 30:")
    list.search(30)

    println("Searching 100:")
    list.search(100)

    // ====================
    // Deletion
    // ====================

    println("\nAfter deleting head:")
    list.deleteHead()
    list.printList()

    println("\nAfter deleting tail:")
    list.deleteTail()
    list.printList()

    println("\nAfter deleting position 2:")
    list.deleteAtPosition(2)
    list.printList()

    println("Size: ${list.size}")

    // ====================
    // Circularity validation
    // ====================

    println("\nCircularity validation:")
    println(list.tail!!.next === list.head)
    println(list.head!!.prev === list.tail)

    // ====================
    // Invalid positions
    // ====================

    println("\nInvalid position testing:")
    list.insertAtPosition(10, 100)
    list.deleteAtPosition(10)

    // ====================
    // Single node testing
    // ====================

    list.deleteHead()

    println("\nSingle node:")
    list.printList()

    println("Size: ${list.size}")

    // ====================
    // Empty list testing
    // ====================

    list.deleteTail()

    println("\nEmpty list testing:")
    list.printList()
    list.deleteHead()
    list.deleteTail()
    list.search(10)

    println("Size: ${list.size}")

    // ====================
    // Reinsertion
    // ====================

    list.insertAtHead(100)
    list.insertAtTail(200)

    println("\nAfter reinsertion:")
    list.printList()

    println("Size: ${list.size}")
}
