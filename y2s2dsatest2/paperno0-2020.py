def Multiply(M, n):
    if(n == 1):
        return M
    else:
        return (M + Multiply(M, n-1))

while True:
    M = int(input("Enter the number for M : "))
    if M == -1:
        print("Program Terminated!")
        break
    n = int(input("Enter the number for n : "))
    if n == -1:
        print("Program Terminated!")
        break

    if(n > 0):
        print(Multiply (M, n))
    else:
        print("Please enter a value greater than or equal to 1 for n ...")





# Paper Number 0 (20 marks)
# A recursive algorithm for the calculation for the multiplication of two numbers M and n
# is given below:
# Multiply (M,n)
# if (n = 1)
# return
# M;
# else
# return (M + Multiply(M, n-1))
# a) Write a program in Python to read an integers from the keyboard for M and n.
# b) Develop a function in python named as multiply and implement the above
# recursive algorithm.
# c) Pass the input number as parameter to the function developed and get the
# multiplication of numbers as output.
# d) Use the loop to run the program and display the correct output until user input -1.
# Upload your answer using given template to the course web link “Paper Number 0”