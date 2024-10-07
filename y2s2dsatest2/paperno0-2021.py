def display(num):
    if num == 1:
        return 1
    else:
        return num + display(num - 1)

while True:
    num = int(input("Enter number : "))
    if num == -1:
        print("Output: Finished")
        break

    if num > 0:
        print("Output: ", display(num))
    else:
        print("Enter a number above 0")





# Paper Number 0 (20 marks)
# Consider the following recursive sequence of numbers:
# 1,3,6,10,15. . . .
# a) Design a recursive Python function to produce the above output when a user
# enters an integer from the keyboard.
# b) Use the loop to run the program and display the correct output until user input -1.
# c) Sample Output:
# Enter number:1
# Output:1
# Enter number:2
# Output:3
# Enter number:3
# Output:6
# Enter number: -1
# Output: Finished
# Note: 0 marks for non-recursive solutions
# Upload your answer using given in the course web link “Paper Number 0”