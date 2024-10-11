def Bubblesort(arr):
    for i in range(len(arr)):
        for j in range(len(arr) - 1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

arr = [1, 4, 3, 9, 2, 7, 6, 5, 8, 0]

print("unsorted array: ", arr)

Bubblesort(arr)

print("sorted array: ", arr)
