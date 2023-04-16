fruit_shop = {
    "kiwi" : 25,
    "peach" : 89,
    "dragon fruit" : 27,
    "water melon" : 79,
    "apple" : 56,
    "orange" : 90
}

while True:

    user_input = input("Which fruit you want to check : ").lower()

    if (user_input in fruit_shop):
        print("Yes, available")
    else:
        print("No, not available")

    repeat = input("Do you want to play again? Yes/No: ").lower()

    if (repeat == "yes"):
        pass
    elif (repeat == "no"):
        raise SystemExit
    else:
        print("Invalid option")
        raise SystemExit