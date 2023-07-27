package main

import "testing"

func Test_selectionSort(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			selectionSort(tt.args.nums)
		})
	}
}
func BenchmarkSelectionSort(b *testing.B) {
	for i := 0; i < b.N; i++ {
		selectionSort([]int{1, 6, 0, 3, 5, 2, 8, 9})
	}
}
