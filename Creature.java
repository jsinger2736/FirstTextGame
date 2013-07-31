public class Creature{
 public Creature(int creaturetype, int level){
  /* List of Creatures:
    1: Goblin
    2: Forest Troll
    3: Imp
    4: Generic Tolkien Rip-Off
    5: Slinky
    6: Zubat
    7: Kobold
    8: Mountain Troll
    9: Illithid Slave
    10: Illithid
                            */
  if (creaturetype==1){ //goblin (medium speed, medium health, low damage)
   type = 1;
   maxhealth = 2*level + 3;
   health = maxhealth;
   damage = level + 1;
   exp = 1*level + 4;
   speed = 2;
   name = "goblin";
   acc = .75;
   hitbox = 1;
   entrapment = .3;
   drop = 1;
   dropnum = 1;
   dropchance = .25;
   money = 1 + level;
  } else if (creaturetype==2){ //forest troll (slow speed, high health, medium damage)
   type = 2;
   maxhealth = (int)(3.5*level) + 6;
   health = maxhealth;
   damage = (int)(.5+1.5*level) + 2;
   exp = (int)(2.5*level) + 6;
   speed = 1;
   name = "forest troll";
   acc = .5;
   hitbox = 1;
   entrapment = .15;
   drop = 1;
   dropnum = 1;
   dropchance = .63;
   money = 2 + (int)(2*level);
  } else if (creaturetype==3){ //imp (fast speed, low health, low damage, harder to hit)
   type = 3;
   maxhealth = (int)(1.5*level) + 1;
   health = maxhealth;
   damage = (int)(1.5*level) + 1;
   exp = (int)(1.5*level)+3;
   speed = 3;
   name = "imp";
   acc = .8;
   hitbox = .7;
   entrapment = .6;
   drop = 1;
   dropnum = 1;
   dropchance = .28;
   money = 2 + (int)(1.5*level);
  } else if (creaturetype==4){ //generic Tolkien rip-off (suggested by Max) appears on path
   type = 4;
   maxhealth = 2*level +6;
   health = maxhealth;
   damage = (int)(1.8*level) + 3;
   exp = (int)(1.5*level) + 6;
   speed = 2;
   name = "generic Tolkien rip-off";
   acc = .35;
   hitbox = .5;
   entrapment = .6;
   drop = 1;
   dropnum = 1;
   dropchance = .9;
   money = (int)(2.5*level) + 4;
  } else if (creaturetype==5){ //slinky (suggested by Zach) appears on towerstairs
   type = 5;
   maxhealth = 1;
   health = maxhealth;
   damage = 1;
   exp = 1;
   speed = 1;
   name = "slinky";
   acc = 1.1;
   hitbox = .4;
   entrapment = 1;
   drop = 1;
   dropnum = 1;
   dropchance = 0;
   money = 0;
  } else if (creaturetype==6){ //zubat (suggested by Kelly) appears in deepforestcavesidecavern
   type = 6;
   maxhealth = 5;
   health = maxhealth;
   damage = 2;
   exp = 2;
   speed = 3;
   name = "Zubat";
   acc = .75;
   hitbox = .6;
   entrapment = .6;
   drop = 1;
   dropnum = 1;
   dropchance = 0.1;
   money = 3;
  } else if (creaturetype==7){ //kobold
   type = 7;
   maxhealth = 3+3*level;
   health = maxhealth;
   damage = 2+level;
   exp = 2+2*level;
   speed = 2;
   name = "kobold";
   acc = .8;
   hitbox = .85;
   entrapment = .5;
   drop = 1;
   dropnum = 1;
   dropchance = 0.5;
   money = 4+(int)(1.5*level);
  } else if (creaturetype==8){ //mountain troll
   type = 8;
   maxhealth = (int)(5.5*level) + 6;
   health = maxhealth;
   damage = (int)(.5+1.9*level) + 3;
   exp = 3*level + 7;
   speed = 1;
   name = "Mountain troll";
   acc = .38;
   hitbox = 1;
   entrapment = .2;
   drop = 1;
   dropnum = 2;
   dropchance = .63;
   money = 4 + (int)(2.5*level);
  } else if (creaturetype==9){ //Illithid Slave
   type = 9;
   maxhealth = (int)(3.5*level) + 5;
   health = maxhealth;
   damage = (int)(.5+1.3*level) + 2;
   exp = (int)2.3*level + 4;
   speed = 1;
   name = "Illithid Slave";
   acc = .75;
   hitbox = .85;
   entrapment = .8;
   drop = 1;
   dropnum = 1;
   dropchance = .55;
   money = 0 + (int)(0*level);
  } else if (creaturetype==10){ //Illithid
   type = 10;
   maxhealth = (int)(3*level) + 10;
   health = maxhealth;
   damage = (int)(.4+1.6*level) + 2;
   exp = (int)2.5*level + 6;
   speed = 3;
   name = "Illithid";
   acc = .7;
   hitbox = .67;
   entrapment = 1;
   drop = 1;
   dropnum = 1;
   dropchance = .2;
   money = 5 + (int)(1.7*level);
  }
 }
 public void damagetaken(int damagetaken){
  health = health - damagetaken;
  if (health<0){
   health = 0;}
 }
 public int damagedoes(){
  return damage;
 }
 public String name(){
  return name;
 }
 public int health(){
  return health;
 }
 public int speed(){
  return speed;
 }
 public double acc(){
  return acc;
 }
 public double hitbox(){
  return hitbox;
 }
 public double entrapment(){
  return entrapment;
 }
 public int exp(){
  return exp;
 }
 public int drop(){
  return drop;
 }
 public int dropnum(){
  return dropnum;
 }
 public double dropchance(){
  return dropchance;
 }
 public int moneydrop(){
  return money;
 }
 //stat variables common to all creatures
 static int maxhealth = 0;
 static int health = 0;
 static int damage = 1;
 static int exp = 0;
 static int speed = 1;
 static String name = " ";
 static double acc = .5;
 static double hitbox = 0;
 static double entrapment = 0;
 static int drop = 0; //1 is potion
 static int dropnum = 0;
 static double dropchance = 0;
 static int type = 0;
 static int money = 0;
}














