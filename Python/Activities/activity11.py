#Fruits dictionary
fruits= {
"banana" :  "20",
"apple"  :  "30",
"kiwi"   :  "40"
}
user_input=input("Enter a fruit of your choise:").lower()

if(user_input in fruits):
    print(user_input," is available")
else:
    print(user_input,"is not avilable")

