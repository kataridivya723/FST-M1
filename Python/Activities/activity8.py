
#Asking user for input
number=input("enter number with space:").split( )
print("list of number:",number)
#comparing both first value and last value in the list is same
if number[0]==number[-1]:
    print(True)
else:
    print(False)
