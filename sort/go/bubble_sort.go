package main

func main() {
	var nums = []int{1, 6, 0, 3, 5, 2, 8, 9}
	bubbleSort(nums)
}
func bubbleSort(nums []int) {
	isSwapped := true
	for isSwapped {
		isSwapped = false
		for i := 1; i < len(nums); i++ {
			if nums[i-1] > nums[i] {
				temp := nums[i-1]
				nums[i-1] = nums[i]
				nums[i] = temp
				isSwapped = true
			}
		}
	}

}
