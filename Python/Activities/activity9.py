list1=input("Enter numbers separated by spaces for List1:").split( )
list2=input("Enter numbers separated by spaces for List2:").split( )
#print(list1, list2)

#ThirdEmpty List
list3=[]

#Checking Odd numbers from List1 
for num in list1:
    if(int(num) % 2 != 0):
        list3.append(num)
 
 #Checking Even numbers from List1 
for num in list2:
    if(int(num)%2 == 0):
       list3.append(num)
    
print("Odd numbers first List1 and Even numbers from List2 :", list3)