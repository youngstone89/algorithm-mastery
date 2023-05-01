package main

import (
	"errors"
	"fmt"
)

type ArrayStack struct {
	array []any
}

func (as *ArrayStack) Push(data any) {
	as.array = append(as.array, data)
}

func (as *ArrayStack) Pop() error {
	// remove from the front of the array pointer
	if len(as.array) == 0 {
		return errors.New("array is empty")
	} else {
		var idx = len(as.array) - 1
		as.array[idx] = nil
	}
	return nil
}

func (as *ArrayStack) Print() {
	for _, v := range as.array {
		fmt.Printf("%v", v)
	}
}

func main() {
	as := new(ArrayStack)
	as.Push(0)
	as.Push(1)
	as.Push(2)
	as.Pop()
	as.Print()
}
