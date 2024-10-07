def sumcube(num):
    if num == 1:
        return 1
    else:
        return sumcube(num - 1) + (num * num * num)


while True:
    num = int(input("Enter the number : "))

    if num == -1:
        print("Program Terminated!")
        break

    if num > 0:
        print(sumcube(num))
    else:
        print("Enter a positive number!")





# ________________________________________________________________________
# Paper Number 6 (20 marks)
# The sum of the n cubes numbers are given by the following formula:
# A recursive algorithm for the sum of first n cube calculation is given below:
# a) Write a program in Python to read an integer from the keyboard for n.
# b) Develop a function in python named as sumcube and implement the above
# recursive algorithm.
# c) Pass the input numbers as parameter to the function developed and get the sum of
# cubes of number as output.
# d) Use the loop to run the program and display the correct output until user inputs -1
# Upload your answer using given template to the course web link “Paper Number 6”