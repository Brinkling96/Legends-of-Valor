Xinyi Zhao
email:zxy1307@bu.edu
id:U76496954

Execution instruction:
Run in the terminal, first you can see the welcome message and introduction of the game, and also 
some small patterns. The type YES/yes to know some basic information, or anything else to start 
the game.
W - move forward
A - move left
S - move backwards
D - move right
Q - quit game
I - show information
If you choose to see that information, the you need to enter start/START to begin game.
You need to enter 1-3 to choose how many heroes you want, then it will print all heroes that you 
can choose from, group by their types. Then you need to enter the number before the hero to choose
that hero. After choosing, it will print all your team members and their information.
Then, it's time for moving!
It will show a board, M is market, & is nonaccessable place, and X is your team's location.
If you went to a empty space, there's 75% to meet enemy, and else is safe place, that you can check 
your team's status and just continue moving. If you choose C/c for checking status, you can check 
your team status, equip armor or weapon, check inventory, use Potion or quit the game.

If you meet enemies, there will first show infotmation about enemy's troop, and information about
your team. Then round 1, first member in your team to enter a number to choose an enemy to fight, 
In the fight, he can use[A]Attack [C]Cast Spell [U]Use Potion [E]Equip Armor/Weapon Or [Q]Quit Game.
If hero/monster 's hp equal to 0, he defeated. Then second member in your team to choose enemy, 
and fight. And then third... 
If one team member dies in a round, he cannot fight any more, and need to wait to until the whole 
fight ending. If no one in your team can fight, you defeated. If your team still have heroes and 
all monsters are defeated, you win the fight, and live heroes got money and experience. After that,
defeated heroes recovered by half of hp, and can continue moving.

If you meet a market, you can enter I/i to check inventory(every heroes has what weapon/armor/spell/
potion) and their money and level. or anything else to enter market.
Then you need to enter a number to choose which hero to visit the market. You can [B]buy [S]sell 
or [L]Leave market. if you choose buy, you can choose from [W]Weapon [A]Armor [P]Potion [S]Spell
or [B]Back to Market.
Once you left market, you can enter m to display map or else to continue moving.

The game will not end, unless you enter Q/q to quit the game. Your heroes can gain infinit hp and
mana, but their max level is 10, and after they get lv10, their hp and mana will multiple by 1.5
when they "level up".

For HeroFactory class, I typed in all heroes, and for MonsterFactory and Market class, I imported 
monsters and items from file, the address is "src/Legends_Monster_Hero/filename.txt"


class:

Board: the class represents the board of the game
Cell: the class represents the cells of board with row and column, and the type of the cell which 
is M/&/X and empty.

Creature: the class represents creatures in the game which includes hero and monster

HeroAttack: interface represents that heroes can attack 
Hero: the class extends Creature class, implements HeroAttack interface, and represents all heroes.
Hero_Paladins: sub class of Hero class, which represent hero Paladins
Hero_Sorcerers: sub class of Hero class, which represent hero Sorcerers
Hero_Warriors: sub class of Hero class, which represent hero Warriors
HeroFactory: the class initializes all heroes

MonsterAttack: interface represents that monsters can attack
Monster: the class extends Creature class, implements MonsterAttack interface, and represents 
all monsters.
Monster_Dragons: sub class of monster class, which represents monster Dragons
Monster_Exoskeletons: sub class of monster class, which represents monster Exoskeletons
Monster_Spirits: sub class of monster class, which represents monster Spirits
MonsterFactory: the class initializes all monsters

canBuyAndSell: interface for items which can buy and be sold
Item: the class represents all items sold in market, and implements canBuyAndSell interface
Item_Armor: sub class of Item class, and represents item armor
Item_Weapon: sub class of Item class, and represents item weapon
Item_Potion: sub class of Item class, and represents item potion
Item_Spell:sub class of Item class, and represents item spell
Market: the class initializes all items.

Team:the class represents the team of heroes chosen by player
Game: abstract class for the game
MonsterAndHeroes: the class represets the monster and heroes game which extends the Game class
Patterns: the class print some patterns of output