package main

import (
	"container/heap"
	"fmt"
	"math"
)

// An Item is something we manage in a priority queue.
type Item struct {
	value    int // The value of the item; arbitrary.
	priority int // The priority of the item in the queue.
	// The index is needed by update and is maintained by the heap.Interface methods.
	index int // The index of the item in the heap.
}

// A PriorityQueue implements heap.Interface and holds Items.
type PriorityQueue []*Item

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	// We want Pop to give us the highest, not lowest, priority so we use greater than here.
	return pq[i].priority > pq[j].priority
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
	pq[i].index = i
	pq[j].index = j
}

func (pq *PriorityQueue) Push(x any) {
	n := len(*pq)
	item := x.(*Item)
	item.index = n
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() any {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil  // avoid memory leak
	item.index = -1 // for safety
	*pq = old[0 : n-1]
	return item
}

// update modifies the priority and value of an Item in the queue.
func (pq *PriorityQueue) update(item *Item, value int, priority int) {
	item.value = value
	item.priority = priority
	heap.Fix(pq, item.index)
}

func DijkstrasShortestPathWithPrioirtyQueue(arr [][]int, src int) []int {
	dist := make([]int, len(arr))
	for i, _ := range dist {
		dist[i] = math.MaxInt
	}
	dist[src] = 0

	visited := make([]bool, len(arr))
	pq := make(PriorityQueue, len(arr))
	pq.Push(&Item{value: src, priority: 0, index: src})

	for pq.Len() > 0 {
		current := pq.Pop().(*Item)
		if visited[current.value] {
			continue
		}
		visited[current.value] = true
		neighbors := arr[current.value]
		for i, v := range neighbors {
			tempDist := dist[current.value] + arr[current.value][i]
			if tempDist < dist[i] {
				dist[i] = tempDist
				pq.Push(&Item{value: i, priority: v, index: i})
			}
		}
	}

	return dist
}

func main() {
	arr := [][]int{{0, 4, 0, 0, 0, 0, 0, 8, 0},
		{4, 0, 8, 0, 0, 0, 0, 11, 0},
		{0, 8, 0, 7, 0, 4, 0, 0, 2},
		{0, 0, 7, 0, 9, 14, 0, 0, 0},
		{0, 0, 0, 9, 0, 10, 0, 0, 0},
		{0, 0, 4, 14, 10, 0, 2, 0, 0},
		{0, 0, 0, 0, 0, 2, 0, 1, 6},
		{8, 11, 0, 0, 0, 0, 1, 0, 7},
		{0, 0, 2, 0, 0, 0, 6, 7, 0}}
	src := 0
	dist := DijkstrasShortestPathWithPrioirtyQueue(arr, src)
	fmt.Println(dist)
}
