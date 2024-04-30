class Node:
    def __init__(self, key) -> None:
        self.key = key
        self.left = None
        self.right = None


def insert(node, key) -> Node:
    if node is None:
        return Node(key)
    if key > node.key:
        node.right = insert(node.right, key)
    else:
        node.left = insert(node.left, key)
    # return pointer
    return node


def search(node, key) -> Node:
    print("finding {}".format(key))


if __name__ == '__main__':
    root = None
    root = insert(root, 50)
    print('key:{}, left:{}, right:{}'.format(root.key, root.left, root.right))
    insert(root, 30)
    print('key:{}, left:{}, right:{}'.format(
        root.key, root.left.key, root.right))

    insert(root, 20)
    print('key:{}, left:{}, right:{}'.format(
        root.left.key, root.left.left.key, root.right))
    insert(root, 40)
    print('key:{}, left:{}, right:{}'.format(
        root.left.key, root.left.left.key, root.left.right.key))
    insert(root, 70)
    print('key:{}, left:{}, right:{}'.format(
        root.key, root.left.key, root.right.key))
    # Key to be found
    key = 6

    # Searching in a BST
    if search(root, key) is None:
        print(key, "not found")
    else:
        print(key, "found")
