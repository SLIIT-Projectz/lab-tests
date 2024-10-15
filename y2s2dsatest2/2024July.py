def Selection(marks):
    for i in range(len(marks)):
        min = i

        for j in range(i, len(marks)):
            if marks[j] < marks[min]:
                min = j
        
        marks[i], marks[min] = marks[min], marks[i]

marks = []
count = 0
total = 0

# range, median, mean
while True:
    print("Enter the mark ", count+1, end="")
    num = int(input(": "))

    if num >= 0 and num <= 100:
        marks.append(num)
        count += 1
        total += num
    else:
        print("Enter a valid marks!")
    
    if count == 10:
        break

print("Unsorted: ", marks)
Selection(marks)
print("sorted: ", marks)

#range
range = marks[-1] - marks[0]

#median
if len(marks) % 2 == 0:
    median = (marks[(len(marks) // 2)] + marks[(len(marks) // 2) - 1]) / 2
else:
    median = marks[len(marks) // 2]

#mean
mean = total/ len(marks)

print("Range: ", range)
print("Median: ", median)
print("Mean: ", mean)