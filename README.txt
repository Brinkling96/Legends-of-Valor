Xinyi Zhao
email:zxy1307@bu.edu
id:U76496954

Sean Brady
email: sdbrady9@bu.edu



Execution instruction for Legends of Valor:

Setup:
Select 2 to run Legends of Valor

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
You need to choose the heros you want, then it will print all heroes that you 
can choose from, group by their types. Then you need to enter the number before the hero to choose
that hero. After choosing, it will print all your team members and their information.

You will then choose which lane to place each of your selected heros.

Then, it's time for the game!

Board:
It will show a board, V is the Monster Nexus, P is a plain cell, B is a bush cell, C is a cave cell, K is a Koulou cell, & is a inacessible cell. Inside each cell cand be a Hero, represented by 1 2 or 3, or a Monster represented by M. X are placed in & cells to indicate you cannot move there.

Hero Action:
Each round each hero is given a chance to do an action. Followed by the Monsters turn to act. Heros can move, use potions, equip items, Teleport to another lane, goback to that lanes nexus and fight to end thier turn. Heros can also shop while at a nexus and check they thier inventory and unequip items at the cost of no action. A user can quit the game at any time as well during this action selection menu.

Fight:
If you decide to fight, there will first show infotmation about enemy's troop in range. Then the hero enters a number to choose an enemy to fight in range. 
In the fight, he can use[A]Attack [C]Cast Spell Or [Q]Quit Game.
If hero/monster 's hp equal to 0, he defeated. If it is a monster, the monster is removed from the game and the hero collects xp and money.
If one team member dies in a round, he will be moved back to the hero nexus.

Market:
You can [B]buy [S]sell or [L]Leave market. if you choose buy, you can choose from [W]Weapon [A]Armor [P]Potion [S]Spell
or [B]Back to Market.
Once you left market, you can enter m to display map or else to continue moving.

The game will not end, unless you enter Q/q to quit the game or if a hero or monster reaches the opponent's Nexus. Your heroes can gain infinit hp and
mana, but their max level is 10, and after they get lv10, their hp and mana will multiple by 1.5
when they "level up".

For HeroFactory class, I typed in all heroes, and for MonsterFactory and Market class, I imported 
monsters and items from file, the address is "src/Legends_Monster_Hero/filename.txt"


class:

LOVBoard: the class represents the board of the game
LOVCell: the class represents the cells of board with row and column. The Cell is subtyped with each having unique behavior of temporarly boosting a heros stats.

Creature: the class represents creatures in the game which includes hero and monster

HeroAttack: interface represents that heroes can attack 
Hero: the class extends Creature class, implements HeroAttack interface, and represents all heroes.
Hero_Paladins: sub class of Hero class, which represent hero Paladins
Hero_Sorcerers: sub class of Hero class, which represent hero Sorcerers
Hero_Warriors: sub class of Hero class, which represent hero Warriors
LOVHeroFactory: the class initializes all heroes for LOV

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


Monster Game: abstract class for the game (MAH and LOV)
LegendsOfValor: the class represets the monster and heroes game which extends the Monster Game class
Patterns: the class print some patterns of output
