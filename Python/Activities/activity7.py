# Ask user to enter input
user_input = input("Enter numbers separated by spaces: ").split( )

# Calculate sum
total=0
for number in user_input:
    total+=int(number)

print(f"The sum of the list is: {total}")