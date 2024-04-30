

def binarySearch(arr, l, r, n):
    print("bs")
    # base case 1 when length is zero
    if len(arr) <= 0:
        return -1
    mid = l + (r - l)//2
    print("mid:{}".format(mid))
    if arr[mid] == n:
        return mid
    if arr[mid] < n:
        return binarySearch(arr, mid+1, r, n)
    else:
        return binarySearch(arr, l, mid - 1, n)


arr = [1, 2, 3, 4, 5]  # sorted array
x = 5
n = len(arr)
result = binarySearch(arr, 0, n - 1, x)

if result == -1:
    print("number {} doesn't exists in the array".format(x))
else:
    print("number {} is positioned at {}".format(x, result))
