def binarySearch(arr, l, h, x):
    if h >= 1:
        mid = (l + h)//2
        if arr[mid] == x :
            return mid
        elif x > arr[mid] :
            return binarySearch(arr, mid+1, h,x)
        else:
            return binarySearch(arr, l, mid-1, x)
    else:
        return -1


arr = [2, 3, 4, 10, 40]
x = 10
result = binarySearch(arr,0,len(arr)-1, x)
if result != -1:
    print("Element is present at index %d" % result)
else:
    print("Element is not present in the array")