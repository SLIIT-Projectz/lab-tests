def Mergesort(arr):
    if len(arr) <= 1:
        return arr

    middle = len(arr)//2
    left = arr[:middle]
    right = arr[middle:]

    Mergesort(left)
    Mergesort(right)

    lp = 0
    rp = 0
    fp = 0

    while lp < len(left) and rp < len(right):
        if left[lp] < right[rp]:
            arr[fp] = left[lp]
            lp += 1
        else:
            arr[fp] = right[rp]
            rp +=1

        fp += 1

    while lp < len(left):
        arr[fp] = left[lp]
        lp += 1
        fp += 1

    while rp < len(right):
        arr[fp] = right[rp]
        rp += 1
        fp += 1



arr = [1, 4, 3, 9, 2, 7, 6, 5, 8, 0]

print("\nunsorted array: ")
print(arr)

Mergesort(arr)

print("\n\nsorted array: ")
print(arr)