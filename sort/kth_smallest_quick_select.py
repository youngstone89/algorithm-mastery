# Python3 program of Quick Select

# Standard partition process of QuickSort().
# It considers the last element as pivot
# and moves all smaller element to left of
# it and greater elements to right
def partition(arr, l, r):

    # pick right most element as pivot
    x = arr[r]
    # set pointer index to leftmost
    i = l

    # loop from left to right
    # range is not inclusive of the right index
    # so not include pivot
    for j in range(l, r):

        # check if array element is less than equal to the pivot
        if arr[j] <= x:
            # if true, swap
            arr[i], arr[j] = arr[j], arr[i]
            # increment pointer index to set the next value
            i += 1

    # swap the pivot and last pointer to finish partition
    arr[i], arr[r] = arr[r], arr[i]

    # return pivot index
    return i

# finds the kth position (of the sorted array)
# in a given unsorted array i.e this function
# can be used to find both kth largest and
# kth smallest element in the array.
# ASSUMPTION: all elements in arr[] are distinct


def kthSmallest(arr, l, r, k):

    # if k is smaller than number of
    # elements in array
    # index bound validation
    if (k > 0 and k <= r - l + 1):

        # Partition the array around last
        # element and get position of pivot
        # element in sorted array
        index = partition(arr, l, r)

        # if position is same as k
        if (index - l == k - 1):
            return arr[index]

        # If position is more, recur
        # for left subarray
        if (index - l > k - 1):
            return kthSmallest(arr, l, index - 1, k)

        # Else recur for right subarray
        return kthSmallest(arr, index + 1, r,
                           k - index + l - 1)
    print("Index out of bound")


# Driver Code
arr = [10, 4, 5, 8, 6, 11, 26]
n = len(arr)
k = 3
print("K-th smallest element is ", end="")

# pass an input array and leftmost index and right most index and k
# rightmost index is equal to length -1
print(kthSmallest(arr, 0, n - 1, k))
