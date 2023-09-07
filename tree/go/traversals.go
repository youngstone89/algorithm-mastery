package main

import "fmt"

type genericList []any
type dataList *genericList

type Traversals struct {
	root *TreeNode
}

func NewTraversals(root *TreeNode) *Traversals {
	return &Traversals{
		root: root,
	}
}

func (t *Traversals) getPreOrder() []any {
	list := make(genericList, 0)
	preorder(&list, t.root)
	return list
}

func preorder(list dataList, root *TreeNode) {
	if root == nil {
		return
	}
	*list = append(*list, root.data)
	preorder(list, root.left)
	preorder(list, root.right)
	return
}

func (t *Traversals) getLevelOrder() []any {
	list := make(genericList, 0)
	levelorder(&list, t.root)
	return list
}

func levelorder(list dataList, root *TreeNode) {
	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	for len(queue) > 0 {
		node := queue[0]
		*list = append(*list, node.data)
		queue = queue[1:]
		if node.left != nil {
			queue = append(queue, node.left)
		}
		if node.right != nil {
			queue = append(queue, node.right)
		}
	}

}

type TreeNode struct {
	data  any
	left  *TreeNode
	right *TreeNode
}

func (tn *TreeNode) getData() any {
	return tn.data
}

func NewTreeNode(data any) *TreeNode {
	return &TreeNode{
		data,
		nil,
		nil,
	}
}

func main() {
	root := NewTreeNode(50)
	n25 := NewTreeNode(25)
	root.left = n25
	n10 := NewTreeNode(10)
	n25.left = n10

	n100 := NewTreeNode(100)
	root.right = n100
	n75 := NewTreeNode(75)
	n100.left = n75

	n125 := NewTreeNode(125)
	n100.right = n125
	n110 := NewTreeNode(110)
	n125.left = n110

	traversals := NewTraversals(root)
	list := traversals.getPreOrder()
	for _, data := range list {
		fmt.Printf("%v\n", data)
	}
	fmt.Println("Level Order")
	levelOrderlist := traversals.getLevelOrder()
	for _, data := range levelOrderlist {
		fmt.Printf("%v\n", data)
	}

}
