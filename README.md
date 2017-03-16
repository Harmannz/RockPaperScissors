# RockPaperScissors

This is a simple exercise in creating a rock paper scissor bot that would play rock paper scissors with other bots.


## Running a test game
Run *Game.java* class, in main, to play the tournament. 

You can use two basic bots for testing:
1. RandomBot simply picks random move.
2. RPSBot which iterates over rock, paper, scissors

### Harman Bot
This bot uses a simple markov chain to keep track of the opponents move and determines what move the opponent is likely to throw based on their previous move. 
This bot only looks at the previous move, it could be made more robust by looking at more past moves.
> I made this relatively quickly (1 hours) so its very basic. A more advanced model would definitely do better


### Creating A Bot
Creating a bot requires an implementation of the *Bot.java* interface
1. newGame: is called once per game and should be used for resetting your bot
2. nextMove: is called every move to determine the next move of your bot
3. lastResult: gets called at the end of each result and describes the result of the last match and what the opponent threw

