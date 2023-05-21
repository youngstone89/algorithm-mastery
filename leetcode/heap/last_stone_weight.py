import heapq
from typing import List


class LastStoneWeight:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones = [-s for s in stones]
        heapq.heapify(stones)
        while (len(stones) > 1):
            first = heapq.heappop(stones)  # -8
            second = heapq.heappop(stones)  # -7
            if second > first:  # opposite of plus comparison
                heapq.heappush(stones, first-second)
        stones.append(0)
        return abs(stones[0])


if __name__ == '__main__':
    solution = LastStoneWeight()
    print(solution.lastStoneWeight([2, 7, 4, 1, 8, 1]))
