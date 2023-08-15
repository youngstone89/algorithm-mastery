import heapq


class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        N = len(points)
        adj = {i: [] for i in range(N)}  # i : list of [cost, node ]

        # bulding edges
        for i in range(N):
            x1, y1 = points[i]
            for j in range(i+1, N):
                x2, y2 = points[j]
                dist = abs(x1-x2) + abs(y1-y2)
                adj[i].append([dist, j])

        res = 0

        visit = set()
        minH = [[0, 0]]  # [cost,point]
        while len(visit) < N:
            cost, i = heapq.heappop(minH)
            if i in visit:
                continue
            res += cost
            visit.add(i)
            for nCost, nNode in adj[i]:
                if nNode not in visit:
                    heapq.heappush(minH, [nCost, nNode])
        return res
