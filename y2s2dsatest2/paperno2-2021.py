def Sequence(num):
    if num == 1:
        return num + 1
    else:
        return Sequence(num - 1) / 2


while True:
    num = int(input("Enter number : "))

    if num == -1:
        print("Output: Finished")
        break

    if num > 0:
        print("Output: ", Sequence(num))
    else:
        print("Enter a positive integer!")





# Paper Number 2 (20 marks)
# Consider the following recursive sequence of numbers:
# 2,1,0.5,0.25,0.125. . . .
# a) Design a recursive Python function to produce the above output when a user
# enters an integer from the keyboard.
# b) Use the loop to run the program and display the correct output until user input -1.
# c) Sample Output:
# Enter number:1
# Output:2
# Enter number:2
# Output:1
# Enter number:3
# Output:0.5
# Enter number: -1
# Output: Finished
# Note: 0 marks for non-recursive solutions
# Upload your answer using given in the course web link “Paper Number 2”