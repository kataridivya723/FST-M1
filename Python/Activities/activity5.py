#Multiplication Table

number = int(input("Enter a number you wnat a multiplication table:"))

for multipler in range(1,11):
    print(f"{number} * {multipler} =", number*multipler)