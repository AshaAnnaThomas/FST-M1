'''Rock beats scissors
Scissors beats paper
Paper beats rock'''

user1 = input("What is your Name ? ")
user2 = input("What is your Name ? ")

while True:
    user1_answer = input(user1 + " choose, rock, paper, scissors : ").lower()
    user2_answer = input(user2 + " choose, rock, paper, scissors : ").lower()


    if(user1_answer == user2_answer):
        print("Its a tie")
    elif(user1_answer =="rock"):
        if(user2_answer == "scissors"):
            print("Rock wins")
        else:
            print("Paper wins")
    elif(user1_answer == "scissors"):
        if (user2_answer == "rock"):
            print("Rock wins")
        else:
            print("scissors wins")
    elif (user1_answer == "paper"):
        if(user2_answer == "scissors"):
            print("scissors wins")
        else:
            print("paper wins")
    else:
        print("Invalid input")

    repeat = input("Do you want to play again? Yes/No: ").lower()

    if (repeat == "yes"):
        pass
    elif (repeat == "no"):
        raise SystemExit
    else:
        print("Invalid option")
        raise SystemExit
