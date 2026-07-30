# Overview
This is a simulation of using the martingale strategy on the game Roulette. You can read more about martingale here: https://en.wikipedia.org/wiki/Martingale_(betting_system). The martingale strategy basically says to double your bet after each round you lose. Once you win a round, return to your initial bet. This may seem like an infinite money glitch, however, casinos usually limit this play by enforcing table limits. This simulation will show that no matter how many rounds you win, the odds are against you, and you will eventually lose.

# How to Play
To begin, there are a few terms you should know:
**Bankroll** - The total amount of money for placing bets
**Bet** - The total amount of money wagered
**Table Limit** - The max amount of money you can wager in a single round

When you begin, you will be prompted for you bankroll amount, the table limit, your base bet, and if you want to bet on black or red. Once you enter this info, the simulation will begin. You can change the speed of the simulation my editing the timeDelay field in the Wheel class. Each round will show you the round number, your current bet, the value of your bankroll prior to the round, and the result of the round. Once you run out of money, or you can no longer increase your bet size, the game will end. You will be able to see the highest amount your bankroll was, and how many rounds were played.
