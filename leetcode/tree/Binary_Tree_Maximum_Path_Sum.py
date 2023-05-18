import sys
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.maxSum = -sys.maxsize
        self.dfs(root)
        return self.maxSum

    def dfs(self, root: TreeNode):
        if not root:
            return 0
        leftSum = self.dfs(root.left)
        rightSum = self.dfs(root.right)

        if leftSum < 0:
            leftSum = 0
        if rightSum < 0:
            rightSum = 0

        self.maxSum = max(self.maxSum, root.val + leftSum + rightSum)
        return max(root.val + leftSum + rightSum, root.val + rightSum)


if __name__ == '__main__':
    # test case 1
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    s = Solution()
    print(s.maxPathSum(root))

    # test case 2
    root = TreeNode(-10)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)
    print(s.maxPathSum(root))
