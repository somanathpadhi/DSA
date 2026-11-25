package programs.dsa._8_linkedlist.kotlin

class SinglyLinkedList {

    class Node(var data: Int) {
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
            tail!!.next = newNode
            tail = newNode
        }

        size++
    }

    // Insert at position | 1-based indexing
    fun insertAtPosition(position: Int, data: Int) {

        if (position <= 0 || position > size + 1) {
            println("invalid position!")
            return
        }

        val newNode = Node(data)

        if (head == null && tail == null) {
            head = newNode
            tail = newNode
        } else if (position == 1) {
            newNode.next = head
            head = newNode
        } else if (position == size + 1) {
            tail!!.next = newNode
            tail = newNode
        } else {
            var curr = head

            for (i in 0 until position - 2) {
                curr = curr!!.next
            }

            newNode.next = curr!!.next
            curr.next = newNode
        }

        size++
    }

    // Optimized insertion at position
    fun insertAtPositionOptimized(position: Int, data: Int) {

        if (position < 1 || position > size + 1) {
            println("Invalid position!")
            return
        }

        if (position == 1) {
            insertAtHead(data)
        } else if (position == size + 1) {
            insertAtTail(data)
        } else {
            val newNode = Node(data)
            var curr = head

            for (i in 1..position - 2) {
                curr = curr!!.next
            }

            newNode.next = curr!!.next
            curr.next = newNode
            size++
        }
    }

    // ====================
    // Traversal
    // ====================

    fun printList() {

        if (head == null) {
            println("Linked list is empty!")
            return
        }

        var curr = head

        while (curr != null) {
            print("${curr.data} -> ")
            curr = curr.next
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

    fun getHeadNode(): Node?{
        return head
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

        if (head == null) {
            println("LinkedList is empty!")
            return
        }

        head = head!!.next
        size--

        if (head == null) {
            tail = null
        }
    }

    // Delete end
    fun deleteTail() {

        if (tail == null) {
            println("LinkedList is empty!")
            return
        } else if (tail === head) {
            head = null
            tail = null
        } else {
            var curr = head!!

            while (curr.next !== tail) {
                curr = curr.next!!
            }

            tail = curr
            curr.next = null
        }

        size--
    }

    // Delete at position | 1-based indexing
    fun deleteAtPosition(position: Int) {

        if (position < 1 || position > size) {
            println("Invalid position!")
            return
        }

        if (head == null || tail == null) {
            println("LinkedList is empty!")
        } else if (position == 1) {
            deleteHead()
        } else if (position == size) {
            deleteTail()
        } else {
            var prevNode = head!!

            for (i in 1..position - 2) {
                prevNode = prevNode.next!!
            }

            prevNode.next = prevNode.next!!.next
            size--
        }
    }

    // ====================
    // Searching
    // ====================

    // Returns true if value exists
    fun search(target: Int): Boolean {

        var curr = head

        while (curr != null) {
            if (curr.data == target) {
                return true
            }

            curr = curr.next
        }

        return false
    }

    // Returns 1-based position
    fun findPosition(target: Int): Int {

        var position = 1
        var curr = head

        while (curr != null) {
            if (curr.data == target) {
                return position
            }

            curr = curr.next
            position++
        }

        return -1
    }

    // ====================
    // Update
    // ====================

    // Update using position
    fun updateUsingPosition(position: Int, data: Int) {

        if (position < 1 || position > size) {
            println("invalid position!")
            return
        }

        if (head == null && tail == null) {
            println("LinkedList is empty!")
            return
        }

        if (position == 1) {
            head!!.data = data
        } else if (position == size) {
            tail!!.data = data
        } else {
            var tempPosition = 1
            var curr = head

            while (curr != null) {
                if (position == tempPosition) {
                    curr.data = data
                    return
                }

                curr = curr.next
                tempPosition++
            }
        }
    }

    // Update using position - Alternative
    fun updateUsingPosition2(position: Int, data: Int) {

        if (position < 1 || position > size) {
            println("Invalid positions!")
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

        if (head == null && tail == null) {
            println("LinkedList is empty!")
            return false
        }

        var curr = head

        while (curr != null) {
            if (curr.data == oldValue) {
                curr.data = newValue
                return true
            }

            curr = curr.next
        }

        return false
    }
}

fun main() {

    val sll = SinglyLinkedList()

    if (sll.isEmpty()) {
        println("LinkedList is empty!")
    }

    println("size is: ${sll.getSize()}")

    sll.insertAtHead(10)
    sll.printList()

    sll.insertAtHead(20)
    sll.printList()

    sll.insertAtHead(30)
    sll.printList()

    sll.insertAtTail(100)
    sll.printList()

    sll.insertAtTail(110)
    sll.printList()

    sll.insertAtTail(120)
    sll.printList()

    sll.insertAtPosition(1, 40)
    sll.printList()

    sll.insertAtPosition(8, 200)
    sll.printList()

    sll.insertAtPosition(5, 500)
    sll.printList()

    println("head data: ${sll.getHead()}")
    println("tail data: ${sll.getTail()}")

    println(sll.search(500))
    println(sll.findPosition(200))

    sll.updateUsingPosition2(6, 2000)
    sll.printList()

    println(sll.updateValue(2000, 35))
    sll.printList()

    sll.deleteHead()
    sll.printList()

    sll.deleteTail()
    sll.printList()

    sll.deleteAtPosition(4)
    sll.printList()

    sll.insertAtPositionOptimized(8, 55)

    sll.deleteHead()
    sll.printList()

    sll.deleteHead()
    sll.printList()

    sll.deleteHead()
    sll.printList()

    sll.deleteHead()
    sll.printList()

    sll.deleteHead()
    sll.printList()

    sll.deleteTail()
    sll.printList()

    sll.deleteHead()
    sll.printList()
}

