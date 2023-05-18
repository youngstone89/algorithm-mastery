import heapq
from typing import List


class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.minHeap, self.k = nums, k
        heapq.heapify(self.minHeap)
        while len(self.minHeap) > k:
            heapq.heappop(self.minHeap)

    def add(self, val: int):
        heapq.heappush(self.minHeap, val)
        if len(self.minHeap) > self.k:
            heapq.heappop(self.minHeap)
        return self.minHeap[0]


if __name__ == '__main__':
    kthLargest = KthLargest(3, [4, 5, 8, 2])
    print(kthLargest.add(3))
    print(kthLargest.add(5))  # return 5
    print(kthLargest.add(10))  # return 5
    print(kthLargest.add(9))  # return 8
    print(kthLargest.add(4))  # return 8
