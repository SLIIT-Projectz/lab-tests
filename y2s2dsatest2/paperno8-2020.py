def sum(num):
    if num == 0 or num == 1:
        return num
    else:
        return sum(num - 1) + num


while True:
    num = int(input("Enter the number: "))
    if(num == -1):
        print("Program Terminated!")
        break
    
    if num > -1:
        print(sum(num))
    else:
        print("Enter a positive number!")





# Paper Number 8 (20 marks)
# The function sum(n) is defined as the sum of integers from 1 to n.
# sum(n) = 1 + 2 + 3 + 4......... + n
# The recursive relation for sum(n) where n is a non-negative integer is given by
# sum(n) = sum(n − 1) + n
# [Hint: sum(n − 1) = 1 + 2 + 3 + 4......... + (n − 1) ]
# The sum of n is given here:
# A recursive algorithm for the sum of sum of n calculation is given below:
# a) Write a program in Python to read an integer from the keyboard for n.
# b) Develop a function in python named as sum and implement the above recursive
# algorithm.
# c) Pass the input numbers as parameter to the function developed and get the sum of
# number as output.
# d) Use the loop to run the program and display the correct output until user inputs -1.
# Upload your answer using given template to the course web link “Paper Number 8”