class Node {
	constructor(data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

class DoublyLinkedList {
	constructor() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	addToBack(data) {
		const newNode = new Node(data);
		if (this.head === null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.size++;
	}

	addToFront(data) {
		const newNode = new Node(data);
		if (this.head === null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		this.size++;
	}

	removeFromBack() {
		if (this.tail === null) {
			return null;
		}
		const removedNode = this.tail;
		if (this.head === this.tail) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = removedNode.prev;
			this.tail.next = null;
			removedNode.prev = null;
		}
		this.size--;
		return removedNode.data;
	}

	removeFromFront() {
		if (this.head === null) {
			return null;
		}
		const removedNode = this.head;
		if (this.head === this.tail) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = removedNode.next;
			this.head.prev = null;
			removedNode.next = null;
		}
		this.size--;
		return removedNode.data;
	}

	removeAtIndex(index) {
		if (index < 0 || index >= this.size) {
			return null;
		}
		if (index === 0) {
			return this.removeFromFront();
		}
		if (index === this.size - 1) {
			return this.removeFromBack();
		}
		let currentNode = this.head;
		for (let i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		const removedNode = currentNode;
		currentNode.prev.next = currentNode.next;
		currentNode.next.prev = currentNode.prev;
		currentNode.prev = null;
		currentNode.next = null;
		this.size--;
		return removedNode.data;
	}
}
