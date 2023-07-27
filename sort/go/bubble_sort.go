package main

import "fmt"

func main() {
	var nums = []int{1, 6, 0, 3, 5, 2, 8, 9}
	bubbleSort(nums)
}
func bubbleSort(nums []int) {
	for i := 0; i < len(nums)-1; i++ {
		for j := 0; j < len(nums)-(1+i); j++ {
			if nums[j] > nums[j+1] {
				// swap
				var temp = nums[j]
				nums[j] = nums[j+1]
				nums[j+1] = temp
			}
		}
	}

	fmt.Println(nums)
}
