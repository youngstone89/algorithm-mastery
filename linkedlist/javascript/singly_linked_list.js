class Node {
    constructor(data) {
      this.data = data;
      this.next = null;
    }
  }
  
  class LinkedList {
    constructor() {
      this.head = null;
      this.size = 0;
    }
  
    add(data) {
      const node = new Node(data);
      let current;
  
      if (this.head == null) {
        this.head = node;
      } else {
        current = this.head;
  
        while (current.next != null) {
          current = current.next;
        }
  
        current.next = node;
      }
  
      this.size++;
    }
  
    insertAt(data, index) {
      if (index > 0 && index > this.size) {
        return false;
      } else {
        const node = new Node(data);
        let current, previous;
  
        current = this.head;
  
        if (index == 0) {
          node.next = this.head;
          this.head = node;
        } else {
          current = this.head;
          let i = 0;
  
          while (i < index) {
            i++;
            previous = current;
            current = current.next;
          }
  
          node.next = current;
          previous.next = node;
        }
  
        this.size++;
      }
    }
  
    removeFrom(index) {
      if (index > 0 && index > this.size) {
        return -1;
      } else {
        let current, previous, i = 0;
        current = this.head;
        previous = current;
  
        if (index === 0) {
          this.head = current.next;
        } else {
          while (i < index) {
            i++;
            previous = current;
            current = current.next;
          }
  
          previous.next = current.next;
        }
  
        this.size--;
  
        return current.data;
      }
    }
  
    removeData(data) {
      let current = this.head;
      let previous = null;
  
      while (current != null) {
        if (current.data === data) {
          if (previous == null) {
            this.head = current.next;
          } else {
            previous.next = current.next;
          }
  
          this.size--;
          return current.data;
        }
  
        previous = current;
        current = current.next;
      }
  
      return -1;
    }
  
    indexOf(data) {
      let count = 0;
      let current = this.head;
  
      while (current != null) {
        if (current.data === data) {
          return count;
        }
  
        count++;
        current = current.next;
      }
  
      return -1;
    }
  
    isEmpty() {
      return this.size === 0;
    }
  
    getSize() {
      return this.size;
    }
  
    printList() {
      let current = this.head;
      let str = "";
  
      while (current) {
        str += current.data + " ";
        current = current.next;
      }
  
      console.log(str);
    }
  }
  
  // example usage:
  const list = new LinkedList();
  
  list.add(1);
  list.add(2);
  list.add(3);
  
  list.printList(); // prints "1 2 3"
  
  list.insertAt(4, 2);
  
  list.printList(); // prints "1 2 4 3"
  
  list.removeData(2);
  
  list.printList(); // prints "1 4 3"
  