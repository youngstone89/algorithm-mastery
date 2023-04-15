class DoublyLinkedList {
    constructor() {
        this.head = null
        this.tail = null
        this.size = 0
    }
    addToFront(data) {
        const newNode = new Node(data)
        // empty list
        if (this.head === null && this.tail === null && this.size === 0) {
            this.head = newNode
            this.tail = newNode
            this.size += 1
            return
        }
        newNode.next = this.head
        newNode.next.prev = newNode
        this.head = newNode
    }
    addToBack(data) {
        const newNode = new Node(data)
        // empty list
        if (this.head === null && this.tail === null && this.size === 0) {
            this.head = newNode
            this.tail = newNode
        } else { 
            this.tail.next = newNode
            newNode.prev = this.tail
            this.tail = newNode
        }
        this.size += 1

    }
    addAtIndex(data, idx) {
        console.log(`size: ${this.size}, index: ${idx}`)
        if (idx < 0) {
            throw new RangeError(`Invalid index`)
        }
        if (idx >= this.size) {
            return this.append(data)
        }
        const newNode = new Node(data)
        // add to the front
        if (idx === 0) {
            newNode.next = this.head
            this.head.prev = newNode
            this.head = newNode
        } else {
            let current = this.head
            for (let i = 1; i <= idx-1; i++) { 
                current = current.next
            }
            let prevNode = current
            let nextNode = current.next
            
            prevNode.next = newNode
            newNode.next = nextNode
            newNode.prev = prevNode
            nextNode.prev = newNode
        }
        this.size++
    }

    append(data) {
        const newNode = new Node(data)

        // if list is empty
        if (this.head === null && this.tail === null && this.size === 0) {
            this.head = newNode
        } else { 
            this.tail.next = newNode
            newNode.prev = this.tail
        }
        this.tail = newNode
        this.size += 1
    }
    removeFromFront() {
        // edge case 1 : empty list
        if (this.head === null && this.tail === null && this.size === 0) { 
            // nothing to do
            return
        }
        // edge case 2:  when list size is 1
        if (this.size === 1) {
            this.head = null
            this.tail = null
        // common case : when size is greater than equal to 2
        } else { 
            //  head: (ref:0), tail: (ref:2)
            // before  list : (null,0,ref->1) - (ref<-0, 1, ref->2) - (ref<-1, 2, null)
            // after #1  list : (null,0,ref->1) - (null, 1, ref->2) - (ref<-1, 2, null)
            // after #2  head: (ref:1), tail: (ref:2)
            this.head.next.prev = null
            this.head = this.head.next
        }
        // regardless decrement size
        this.size -= 1
        
    }
    printList() {
        let current = this.head;
        let result = ''
        while (current !== null) {
            result += current.data + ' '
            current = current.next
        }
        console.log(result)

        current = this.tail
        result = ''
        while (current !== null) { 
            result += current.data + ' '
            current = current.prev
        }
        console.log(result)
    }
}

class Node {
    constructor(data) {
        this.prev = null
        this.next = null
        this.data = data
    }
}


// driver code
const dll = new DoublyLinkedList();

dll.addToBack(0)
dll.addToBack(1)
dll.addToBack(2)
dll.addToBack(3)
dll.addToBack(4)
dll.addToBack(5)
dll.addToBack(6)
dll.printList()
dll.removeFromFront()
dll.printList()