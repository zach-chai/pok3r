# Poker Hand Ranking Game

Simple Poker Hand Ranking Game for COMP 4004 Course

## Installation
* Install maven ```http://maven.apache.org/```
* Clone the repo ```git clone git@github.com:zach-chai/poker-ranking-game.git poker```
* Enter directory ```cd poker```
* Run tests ```mvn test```
* Build a runnable jar ```mvn assembly:single```
* Execute ```java -jar target/poker_ranking-1.0.0-jar-with-dependencies.jar```

### Alternatively
* If you would like to just run the game there is a built jar under releases
* You can run it with the same command ```java -jar poker_ranking-1.0.0-jar-with-dependencies.jar```

## Playing Instructions
* First input the number of players
* Next you need to enter the hands for each player id followed by cards. Example ```0 AceHearts NineClubs FiveClubs JackDiamonds EightSpades```
* Once you entered a hand for each player it will calculate the ranks and output them


