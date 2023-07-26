def bubbleSort(arr):
    # length
    n = len(arr)
    for i in range(n):
        swapped = False
        for j in range(n-1-i):
            if (arr[j] > arr[j+1]):
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = True
        if (swapped == False):
            break


if __name__ == "__main__":
    arr = [64, 34, 25, 12, 22, 11, 90]
    bubbleSort(arr)
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")

# Time Complexity O(n2)
# Space O(1)
