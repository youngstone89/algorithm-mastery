// a Singly Linked List with head, tail references and size variable
class Node {
	constructor(data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    addToFront(data) {
        const node = new Node(data)
        if (this.head === null) {
            this.head = node
            this.tail = node
            return
        }
        // let firstNode = this.head
        // node.next = firstNode
        node.next = this.head
        this.head = node

    }
	addToBack(data) {
		// handle edge cases
		// edge case 1: list is empty, set the new node to the head and the tail reference
        // because we can't verify if the next reference is null or not in empty list
        const node = new Node(data)
        if (this.head === null) {
            this.head = node
            this.tail = node
            return
        }

        // common case : list is not empty, set the new node to the next pointer of the last node
        // find the last node ( next pointer of the last node is null )
        let current = this.head
        while (current.next !== null) { 
            current = current.next
        }
        current.next = node

        this.tail = node

    }
    
    printList() {
        console.log('head: ', this.head)
        let current = this.head
        let str = ''
        while (current.next !== null) {
            str += current.data + ' '
            current = current.next
        }
        str += current.data + ' '
        console.log(str)
        console.log('tail: ', this.tail)
    }
}

let list = new LinkedList();
list.addToFront(0)
list.addToFront(1)
list.addToFront(2)
list.printList()

