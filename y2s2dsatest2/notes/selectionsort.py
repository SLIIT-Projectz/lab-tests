def Selectionsort(arr):
    for i in range(len(arr) - 1):
        min = i
        for j in range(i, len(arr)):
            if arr[j] < arr[min]:
                min = j
                
        arr[i], arr[min] = arr[min], arr[i]


arr = [1, 4, 3, 9, 2, 7, 6, 5, 8, 0]

Selectionsort(arr)

print(arr)
