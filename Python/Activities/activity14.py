def fibonacci(num):
    s=0
    if num<=1:
        return num
    else:
        return (fibonacci(num-1)+fibonacci(num-2))


user_input=int(input("Enter the number of your choice to get fibonacci:"))
	
if user_input <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(user_input):
        print(fibonacci(i))
