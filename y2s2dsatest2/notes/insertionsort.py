def Insertionsort(arr):
    for i in range(1, len(arr)):
        current = arr[i]
        j = i-1

        while j >= 0 and current < arr[j]:
            arr[j+1] = arr[j]
            j-=1
        arr[j+1] = current

arr = [1, 4, 3, 9, 2, 7, 6, 5, 8, 0]

print("unsorted array: \n", arr)

Insertionsort(arr)

print("sorted array: \n", arr)
