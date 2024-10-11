import random

def Quicksort(arr):
    if len(arr) <= 1:
        return arr

    pivot = random.choice(arr)

    left = []
    for i in arr:
        if i < pivot:
            left.append(i)

    right = []
    for i in arr:
        if i > pivot:
            right.append(i)

    middle = []
    for i in arr:
        if i == pivot:
            middle.append(i)

    return Quicksort(left) + middle + Quicksort(right)


arr = [1, 4, 3, 9, 2, 7, 6, 5, 8, 0]

print("\nunsorted array: ")
for i in arr:
    print(i, end='')

arr = Quicksort(arr)

print("\n\nsorted array: ")
for i in arr:
    print(i, end='')

print("\n\nEnd.")