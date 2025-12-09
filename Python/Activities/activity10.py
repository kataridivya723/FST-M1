#Asking user to enter input
user_input=input("Enter numbers sepearated by spaces:").split( )
#converting user entered input into tuple form
user_tuple=tuple(int(num) for num in user_input)
print("user entered tuple is:",user_tuple)
print("Elements divisible by 5 are: ")
#Using loop to check each elemt in the tuple
for num in user_tuple:
    if(int(num)%5==0):
        print(num)
   

