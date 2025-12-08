# Get the users names
player1 = input("Enter Player1's name: ")
player2 = input("Enter Player2's name:  ")


while True:
# Get the users choices
    player1_response = input(player1 + ",What do you Choose among [rock, paper or scissors]?").lower()
    player2_response = input(player2 + ",What do you Choose among [rock, paper or scissors]?").lower()

# Run the game to check who wins
    if player1_response == player2_response:
        print("It's a tie!")
    elif player1_response == 'rock':
        if player2_response == 'scissors':
            print(player1+" wins!")
        elif player2_response=='paper':
            print(player2+" wins!")
        else:
             print(f"Invalid input! {player2} have not entered rock, paper or scissors, try again.")   
    elif player1_response == 'scissors':
        if player2_response == 'paper':
           print(player1+" wins!")
        elif player2_response=='rock':
           print(player2+" wins!")
        else:
            print(f"Invalid input! {player2} have not entered rock, paper or scissors, try again.")  
    elif player1_response == 'paper':
        if player2_response == 'rock':
           print(player1+" wins!")
        elif player2_response=='scissors':
           print(player2+" wins!")
        else:
            print(f"Invalid input! {player2} have not entered rock, paper or scissors, try again.")  
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")

         # User response for repeating the game
    repeat = input("Do you want to play another round? Yes/No: ").lower()
    
    # yes, don't do anything
    if(repeat == "yes"):
        pass
    # no, exit the game
    elif(repeat == "no"):
        raise SystemExit
    # anything else other than yes or no, exit with an error message.
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit


       