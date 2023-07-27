package main

import "testing"
import "fmt"

func Test_bubbleSort(t *testing.T) {
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
			bubbleSort(tt.args.nums)
		})
	}
}

// GO111MODULE=off go test -bench=. -benchtime=10s -count 1 -run=^# -benchmem | tee old.txt
// go install golang.org/x/perf/cmd/benchstat@latest
func BenchmarkBubbleSort(b *testing.B) {
	var table = []struct {
		input []int
	}{
		{input: []int{1, 6, 0, 3, 5, 2, 8, 9}},
		{input: []int{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}},
		{input: []int{100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86}},
		{input: []int{10001, 10000, 9999, 8888, 3333, 2222, 1111, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}},
	}

	for _, v := range table {
		b.Run(fmt.Sprintf("input_size_%d", len(v.input)), func(b *testing.B) {
			for i := 0; i < b.N; i++ {
				bubbleSort(v.input)
			}
		})
	}
}
