class Node {
	constructor(data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	constructor() {
		this.head = null;
	}
	addToBack(data) {
		// handle edge cases
		// edge case 1: list is empty, set the new node to the head
        // because we can't verify if the next reference is null or not in empty list
        const node = new Node(data)
        if (this.head === null) {
            this.head = node;
            return
        }

        // common case : list is not empty, set the new node to the next pointer of the last node
        // find the last node ( next pointer of the last node is null )
        let current = this.head
        while (current.next !== null) { 
            current = current.next
        }
        current.next = node

    }
    
    printList() {
        let current = this.head
        let str = ''
        while (current.next !== null) {
            str += current.data + ' '
            current = current.next
        }
        str += current.data + ' '
        console.log(str)
    }
}

let list = new LinkedList();
list.addToBack(0);
list.addToBack(1);
list.addToBack(2);
list.printList()

