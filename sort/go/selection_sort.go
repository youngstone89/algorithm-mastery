package main

// func main() {
// 	nums := []int{0, 9, 3, 5, 7, 9, 2, 3}
// 	selectionSort(nums)
// 	fmt.Println(nums)
// }

func selectionSort(nums []int) {
	// last idx : 2
	// i=0, j=1,
	// i=0, j=2

	// i=1, j=2
	for i := 0; i < len(nums)-1; i++ {
		minIdx := i
		for j := i + 1; j < len(nums); j++ {
			if nums[minIdx] > nums[j] {
				minIdx = j
			}

		}
		temp := nums[minIdx]
		nums[minIdx] = nums[i]
		nums[i] = temp
	}
}
