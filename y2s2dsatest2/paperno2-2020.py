def Fibonacci(num):
    if num <= 1:
        return num
    else:
        return Fibonacci(num - 1) + Fibonacci(num - 2)

while True:
    num = int(input("Enter the integer : "))
    if num == -1:
        print("Program Terminated!")
        break
    
    if(num > -1):
        print(Fibonacci(num))
    else:
        print("Enter a positive number!")





# Paper Number 2 (20 marks)
# The Fibonacci sequence is the series of numbers:
# 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
# The next number is found by adding up the two numbers before it as given by the
# following mathematical function.
# A recursive algorithm for the Fibonacci calculation is given below:
# a) Write a program in Python to read an integer from the keyboard.
# b) Develop a function in python named as Fibonacci and implement the above
# recursive algorithm.
# c) Pass the input number as parameter to the function developed and get the
# Fibonacci number as output.
# d) Use the loop to run the program and display the correct output until user inputs -1.
# Upload your answer using given template to the course web link “Paper Number 2”