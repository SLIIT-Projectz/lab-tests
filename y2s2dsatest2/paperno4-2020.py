def Power(base, exp):
    if exp == 0:
        return 1
    else:
        return base * Power(base, exp-1)


while True:
    x = int(input("Enter the value for X : "))
    if x == -1:
        print("Program Terminated!")
        break

    n = int(input("Enter the value for n : "))
    if n == -1:
        print("Program Terminated!")
        break

    if n > 0:
        print(Power(x, n))
    else:
        print("Enter a positive value for n!")





# Paper Number 4 (20 marks)
# The power function can be defined as pow( x, n) = x n . This can be evaluated using the
# multiplication as x n = x  x n −1 where x is any real number and n is a non-negative integer.
# [Hint: pow( x, n − 1) = x n −1 ]
# A recursive algorithm for the power calculation is given below:
# a) Write a program in Python to read an integers from the keyboard for x and n.
# b) Develop a function in python named as power and implement the above recursive
# algorithm.
# c) Pass the input numbers as parameter to the function developed and get the power
# of number as output.
# d) Use the loop to run the program and display the correct output until user inputs -1.
# Upload your answer using given template to the course web link “Paper Number 4”