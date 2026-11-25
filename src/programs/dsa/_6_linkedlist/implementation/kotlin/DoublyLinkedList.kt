
package programs.dsa._6_linkedlist.implementation.kotlin

class DoublyLinkedList {

    class Node(var data: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private var head: Node? = null
    private var tail: Node? = null
    private var size: Int = 0

    // ====================
    // Insertion
    // ====================

    // Insert at beginning
    fun insertAtHead(data: Int) {
        val newNode = Node(data)

        if (head == null && tail == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head!!.prev = newNode
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
        } else {
            newNode.prev = tail
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

            val nextNode = prevNode.next!!

            prevNode.next = newNode
            newNode.prev = prevNode
            newNode.next = nextNode
            nextNode.prev = newNode

            size++
        }
    }

    // ====================
    // Traversal
    // ====================

    fun printList() {

        if (head == null && tail == null) {
            println("Linked list is empty!")
            return
        }

        var curr = head

        while (curr != null) {
            print("${curr.data} ")
            curr = curr.next
        }

        println()
    }

    fun printBackward() {

        if (head == null && tail == null) {
            println("Linked list is empty!")
            return
        }

        var curr = tail

        while (curr != null) {
            print("${curr.data} ")
            curr = curr.prev
        }

        println()
    }

    // ====================
    // Utility Functions
    // ====================

    fun getSize(): Int {
        return size
    }

    fun isEmpty(): Boolean {
        return head == null
    }

    fun getHead(): Int {
        return head?.data ?: -1
    }

    fun getTail(): Int {
        return tail?.data ?: -1
    }

    fun clear() {
        head = null
        tail = null
        size = 0
    }

    // ====================
    // Deletion
    // ====================

    // Delete first
    fun deleteHead() {

        if (head == null && tail == null) {
            println("Not able to delete. LinkedList is empty!")
            return
        }

        head = head!!.next

        if (head == null) {
            tail = null
        } else {
            head!!.prev = null
        }

        size--
    }

    // Delete end
    fun deleteTail() {

        if (head == null && tail == null) {
            println("Not able to delete. LinkedList is empty!")
            return
        }

        if (head === tail) {
            head = null
            tail = null
        } else {
            tail = tail!!.prev
            tail!!.next = null
        }

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
        } else if (position == size) {
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

        if (head == null && tail == null) {
            println("LinkedList is empty!")
            return false
        } else {
            var curr = head

            while (curr != null) {
                if (curr.data == target) {
                    println("Found!")
                    return true
                }

                curr = curr.next
            }

            println("Not found!")
            return false
        }
    }

    // Returns 1-based position
    fun findPosition(target: Int): Int {

        var position = 1
        var curr = head

        while (curr != null) {
            if (curr.data == target) {
                return position
            } else {
                curr = curr.next
                position++
            }
        }

        return -1
    }

    // ====================
    // Update
    // ====================

    // Update using position
    fun updateUsingPosition(position: Int, data: Int) {

        if (position < 1 || position > size) {
            println("Invalid position!")
            return
        }

        var curr = head!!

        for (i in 1..position - 1) {
            curr = curr.next!!
        }

        curr.data = data
    }

    // Update first occurrence of value
    fun updateValue(oldValue: Int, newValue: Int): Boolean {

        var curr = head

        while (curr != null) {
            if (curr.data == oldValue) {
                curr.data = newValue
                return true
            } else {
                curr = curr.next
            }
        }

        return false
    }
}

fun main() {

    val dll = DoublyLinkedList()

    if (dll.isEmpty()) {
        println("LinkedList is empty!")
    }

    dll.insertAtHead(40)
    dll.printList()

    dll.insertAtHead(30)
    dll.printList()

    dll.insertAtHead(20)
    dll.printList()

    dll.insertAtTail(50)
    dll.printList()

    dll.insertAtPosition(3, 35)
    dll.printList()

    dll.insertAtPosition(1, 5)
    dll.printList()

    dll.insertAtPosition(6, 60)
    dll.printList()

    dll.insertAtPosition(8, 80)
    dll.printList()

    dll.printBackward()

    dll.deleteTail()
    dll.printList()

    dll.deleteHead()
    dll.printList()

    dll.deleteAtPosition(5)
    dll.printList()

    dll.deleteAtPosition(1)
    dll.printList()

    dll.deleteAtPosition(4)
    dll.printList()

    println(dll.search(35))
    dll.printList()

    println(dll.updateValue(35, 60))
    dll.printList()

    println(dll.findPosition(40))
    dll.printList()

    dll.updateUsingPosition(2, 35)
    dll.printList()
}

