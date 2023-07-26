# Python3 program for the above approach

import random


def kthSmallest(arr, l, r, K, n):

    # If k is smaller than number of
    # elements in array
    if (K > 0 and K <= r - l + 1):

        # Partition the array around last
        # element and get position of pivot
        # element in sorted array
        pos = partition(arr, l, r)

        # If position is same as k
        if (pos - l == K - 1):
            return
        if (pos - l > K - 1):  # If position is more,
            # recur for left subarray
            return kthSmallest(arr, l, pos - 1, K, n)

        # Else recur for right subarray
        return kthSmallest(arr, pos + 1, r,
                           K - pos + l - 1, n)

    # If k is more than number of
    # elements in array
    print("Invalid value of K")


def KthLargest(arr, l, r, K, N):

    # This function arranges k Largest elements in last k positions
    # It means it arranges N-K-1 smallest elements from starting

    kthSmallest(arr, l, r, N - K - 1, N)


# Standard partition process of QuickSort().
# It considers the last element as pivot and
# moves all smaller element to left of it
# and greater elements to right


def partition(arr, l, r):

    x = arr[r]
    i = l
    for j in range(l, r):
        if (arr[j] <= x):
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
    arr[i], arr[r] = arr[r], arr[i]
    return i


# Driver code
a = [11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45]
n = len(a)

low = 0
high = n - 1

# assume k is 3
k = 3

# Function call

# For Smallest
kthSmallest(a, 0, n - 1, k, n)

# Print KSmallest no.
if (k >= 1 and k <= n):
    print(str(k) + " smallest elements are :", end=" ")
    for i in range(k):
        print(a[i], end=" ")
    print()


# For Largest
KthLargest(a, 0, n-1, k, n)
# Print KLargest no.
if (k >= 1 and k <= n):
    print(str(k) + " largest elements are :", end=" ")
    for i in range(n - 1, n-k-1, -1):
        print(a[i], end=" ")


# This code is contributed by shubhamm050402
