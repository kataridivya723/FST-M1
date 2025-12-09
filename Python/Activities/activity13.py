#using function to calculate sum of list of elements
def calculateSum(num):
    sum=0
    for i in num:
      sum=sum+int(i)
    return sum

#Asking user to provide list of values
user_input=input("Enter a list by space separated:").split( )
#storing returned value into res
res=calculateSum(user_input)
#printing result 
print("Sum of all the entered list : ",res)