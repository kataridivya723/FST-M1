

#Taking players names as an input
player1 = input("Enter Player 1's name:")
player2 = input("Enter Player 2's name:")

#Taking Players choices
player1_choice = input(player1 + ", which one you want to choose rocks, scissors or paper:").lower()
player2_choice = input(player2 + ", which one you want to choose rocks, scissors or paper:").lower()

if player1_choice == player2_choice:
    print("It's a tie!")
elif player1_choice == 'rock':
    if player2_choice == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif player1_choice == 'scissors':
    if player2_choice == 'paper':
        print("Scissors Wins!")
    else:
        print("Rock Wins!")
elif player1_choice == 'paper':
    if player2_choice == 'rock':
        print("Paper Wins!")
    else:
        print("Scissors Wins!")
else:
    print("Invalid input ! You have not entered rock, paper or scissors, please try again")