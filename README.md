# fair-teams
#### Create fair teams given players with a certain skill level ####

The players added at the moment are hard coded with their skill level. The set team sizes are 4 players per team with 12 total players making 3 teams.
Each time the program is executed, it will create 3 random fair teams considering each player's skill level. There is a small "delta" enabling the user flexability if it is unable to make fair teams.

With the list of given players, the program will create all the possible teams with the recommended team score (the sum of player's skills divided by the amount of teams).
The program then takes the first team from the list and creates team one. However, we do not want the same player to play for two different teams. So, the program then removes all teams with the players from team one. Then takes the first team from the list and creates team two, removing all teams with the players from team 2. Then it takes the first team from the list and creates team 3.

Future improvments to the program include:
- Flexability of the amount of teams and players
- Flexability of the amount of players per team
- User interface to add players with their skills and the flexability of team score


