## Blackjack Project

### Overview
This is a Blackjack simulator, simple in scope but quite effective for its purposes.

The game starts off with two cards dealt to both the player and the computer dealer. Before that can happen, however, the cards are generated using the criteria for cards found in both the suit and card-rank enums, taking advantage of nested for-each loops to iterate through each rank of each suit and add them to the "Deck" list. Once the deck is populated, it is shuffled using the "Collections.shuffle(cards)" method on the deck list, and from there cards are removed and added to the ArrayLists that hold both the player and dealer hands.

Now the game can begin! The first step the program takes is to check and see if either participant managed to get a 21, or "Blackjack," right away, as this wins the game immediately. Of course, if both manage a 21 then that round is a push.

If neither participant has managed a Blackjack, then it is on to the while loop containing the gameplay methods. The game sets up some variables (integers, booleans, and a number of lists and objects to hold on to decks and hands) inside of the "run()" method in order to interact with the methods based in other classes. The human gameplay was based around "while" loops, with the conditions being a mix of turn-ending and game-ending booleans. This helped jump out of the "hit" and "hold" logic cycles inside of the BlackJackModifiers class - wherein the human-facing code lives alongside win conditions, the initial BlackJack test, and various functions relating to the game itself - so that the rules of the game would be followed closely and logically.

The biggest issue to solve, for a whole cascading series of reasons, was making it so that Aces could be considered to be worth both 11 and 1. This was an issue that reared its ugly head early on, as the game was approaching minimum viability and would return a resounding "bust" when an Ace was dealt above a hand value of 11. I solved this in part a couple of times, but did not have an all-encompassing solution until quite late in the project. The solution ended up being solved in the "Deck" class using a method to determine the total number of Aces. Then, using this method inside of the hand-value calculating method, the total value of the player's or computer's hand would loop through the number of Aces, subtracting 10 from the total each time the score remained over 21. This meant, ultimately, that Aces could be valued at either 11 or 1 despite their technical immutability and the resulting score would be as close to 21 on the lower side as possible.

Once gameplay on the human side is finished, the computer takes a much simpler route to 21. If the human did not bust, the computer (or "dealer" in the game) checks to see if its score is lower than 17, and if so, it will take a card and keep repeating this action until it has between 17 and 21, inclusive, or has busted. The win-condition method then takes these two scores as its arguments and pops out the scores, the two hands, and a message declaring the winner.

There are a couple of things that I will be adding in the future releases, chief among which is a gambling system. After all, what is Blackjack without risk? To do so I would make a new class and call in arguments for the different behaviors, then keep them current throughout the "run()" block of the main class. After debugging and troubleshooting, however, this was not happening on this release. There are also a number of rules and strategies in Blackjack that I would like to add, such as splits and doubling down, but in those cases I find myself a bit flummoxed as to what they look like in practice.

With that, take a spin and best of luck to you!

### Topics
#### Object-oriented design
This project would have been absolutely massive and difficult to track if it had been entirely contained in the main method. The benefits of a class structure are found all over this program, but the most subtly powerful (in my mind) are the card and deck objects which can now be copied over and used in any other card-based game program.

Also useful were the classes that dictated how the rules of the game were to be implemented and the class which pulled information about player and dealer hands. This allowed for the issue of rogue Aces to be solved, for the rules of the game to be kept separate from the pieces that made up the game, and for the sanity of a main method which could have seen even more significant size creep.

#### Enums
The new (to me) concept of enumerated types greatly helped while generating the card deck, then even more so when information needed to be called about specific cards within hands. Being able to use immutable characteristics for cards made keeping track of specific items much easier, for everything from scorekeeping to not repeating cards.

#### Inheritance and Abstraction
I did not use as much inheritance or abstraction as could be used if this game were to get larger. What it essentially came down to was the "Card" class having both a suit and rank, then above that, a "Deck" had a series of "Cards," as also did the player's and computer's "Hand."

#### Java Collections
Ah, collections! The most direct use of this library came while shuffling the List that contained the deck of cards. Had I not this useful feature, I would have spent much more time trying to figure out a way to randomly select an element from the List, then changing the random value based on the size of the list, then at last making sure that the it never pointed to a null value. Thank you, Collections, for having such a useful feature that is indifferent to the changing size of Lists of all types. 
