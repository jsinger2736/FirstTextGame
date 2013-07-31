import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class TextAdventure{ //begun 1/23/13
//Main method, includes intro, loading, and game over
 public static void main(){
  boolean choice;
  Background.addText("Hello "+Background.player.name+"!",true);

  //Option to opt out of the intro
  //Background.restart();
  Background.spacer();
  if (Background.player.getlocation()==0){
   Background.addText("Would you like to do the intro?",true);
   choice=Background.yesno();
   if (!choice){
    Background.addText("Fine then.",true);
   }
  } else {
   choice = false;
  }
  if (choice){
   
   //intro
   intro = true;
   Background.intro=true;
   while (intro==true){
    Background.addText("Hello "+Background.player.name+", and good luck on your wondrous adventure!",true);
    Background.spacer();
    Background.addText("It's still morning, and you've only just left the castle. Today you're going to investigate the complaints of some of the townspeople about so-called \"monsters\" that have been sighted nearby.",true);
    Background.spacer();
    Background.addText("As you are walking down the path, you see a creature scramble towards you from the forest. You've never seen anything quite like it before, and you aren't given very much time to gawk.",true);
    Background.spacer();
    if (Background.combat(1,1,true)==2){
     Background.addText("Would you like to try again?",true);
     choice = Background.yesno();
     if (choice){
      continue;
     } else {
      Background.addText("Game Over "+Background.player.name()+".",true);
      return;
     }
    }
    Background.addText("Maybe that was one of the monsters the townspeople had complained about. Hopefully there aren't too many of those things around, this might end up being more dangerous than you thought.",true);
    Background.spacer();
    Background.addText("Suddenly something zips through the air in front of you.",true);
    Background.spacer();
    if (Background.combat(3,1,false)==2){
     Background.addText("Would you like to try again?",true);
     choice = Background.yesno();
     if (choice){
      continue;
     } else {
      Background.addText("Game Over "+Background.player.name()+".",true);
      return;
     }
    }
    Background.addText("You wonder what exactly those things were, and start to hurry faster to the town. You're beginning to be able to see buildings off in the distance, but then you hear heavy footsteps coming from your right.",true);
    Background.spacer();
    Background.addText("The footsteps get faster and closer, and suddenly something large comes barreling out from between the trees, knocking the smaller ones to its side.",true);
    if (Background.combat(2,1,true)==2){
     Background.addText("Would you like to try again?",true);
     choice = Background.yesno();
     if (choice){
      continue;
     } else {
      Background.addText("Game Over "+Background.player.name()+".",true);
      return;
     }
    }
    Background.addText("That thing was big, it's definitely time to get to the town. You start running.",true);
    Background.spacer();
    Background.addText("You're almost to the edge of the town, when some townsfolk come from around a house yelling and pointing behind you. Without stopping, you turn around to look back.",true);
    Background.spacer();
    Background.introdeath = true;
    int sectrollcombat = Background.combat(2,1,true);
    Background.introdeath = false;
    if (sectrollcombat==2){
     Background.addText("The forest troll knocks you to the ground, and you have difficulty getting up. Your eyes force themselves closed and you drift off into nothingness.",true);
     Background.spacer();
    } else if (sectrollcombat==1){
     Background.addText("You survive, but you feel extremely tired from your exertions.",true);
     Background.spacer();
     Background.addText("You faint.",true);
     Background.spacer();}
    //wake up in the town
    Background.addText("You open your eyes to find yourself in a bed. A pretty comfortable bed actually. The townsfolk you saw must have saved you and gotten you into the bed.",true);
    Background.spacer();
    Background.player.rest();
    boolean repeat = true;
    while (repeat==true){
     Background.addText("Would you like to get up?",true);
     choice = Background.yesno();
     if (choice){
      Background.addText("You get up slowly, but you're still a bit shaky.",true);
      break;}
     Background.addText("You make yourself comfortable again and fall back asleep.",true);
     Background.spacer();
    }
    Background.spacer();
    Background.addText("A woman see's you up out of the bed and rushes over, steadying you.",true);
    Background.spacer();
    Background.addText("\"You need a bit more rest.\" she says, but you insist and she allows you to lean on her as you walk to the door. You try walking on your own and find it's not that difficult once you get your balance. You leave the building.",true);
    Background.spacer();
    intro = false;
    Background.intro=false;
   }
  }

  //begin the real part of the game
  if (Background.player.getlocation()==0){
   Background.player.setlocation(1);
  }
  int newplace = Background.player.getlocation();
  while (newplace!=0 && newplace!=-1){
   newplace = transition(newplace);
   if (newplace==0){
    Background.addText("Game Over "+Background.player.name()+".",true);
    Background.spacer();
   } else if (newplace==-1){
    Background.addText("Hope you enjoyed TextAdventure, "+Background.player.name()+".",true);
    Background.addText("\nPlay again soon!",false);
    Background.spacer();
   }
  }
 }

//transition between locations in Location.java
 public static int transition(int newplace){
  /*
    0   exit
    1   town
    2   path
    3   forest
    4   road
    5   deepforest
    6   clearing
    7   castlegates
    8   field
    9   deepforestcave
    10  castletunnel
    11  stoneroom
    12  castledungeon
    13  castleinterior
    14  castlelibrary
    15  castlecourtyard
    16  castletower
    17  scholarhut
    18  towerstairs
    19  deepforestcavefirstarea
    20  deepforestcavesecondarea
    21  deepforestcavesidepassage
    22  deepforestcavesidecavern
    23  deepforestcavealcove
    24  deepforestcavethirdarea
    25  deepforestcavefourtharea
    26  secretcavepassage
    27  secretcavernentrance
    28  secretcavern
    29  foothills
    30  mountainpass
    31  valley
                        */
  int nextplace = 0;
  if (newplace==1){
   nextplace = location.town();
  } else if (newplace==2){
   nextplace = location.path();
  } else if (newplace==3){
   nextplace = location.forest();
  } else if (newplace==4){
   nextplace = location.road();
  } else if (newplace==5){
   nextplace = location.deepforest();
  } else if (newplace==6){
   nextplace = location.clearing();
  } else if (newplace==7){
   nextplace = location.castlegates();
  } else if (newplace==8){
   nextplace = location.field();
  } else if (newplace==9){
   nextplace = location.deepforestcave();
  } else if (newplace==10){
   nextplace = location.castletunnel();
  } else if (newplace==11){
   nextplace = location.stoneroom();
  } else if (newplace==12){
   nextplace = location.castledungeon();
  } else if (newplace==13){
   nextplace = location.castleinterior();
  } else if (newplace==14){
   nextplace = location.castlelibrary();
  } else if (newplace==15){
   nextplace = location.castlecourtyard();
  } else if (newplace==16){
   nextplace = location.castletower();
  } else if (newplace==17){
   nextplace = location.scholarhut();
  } else if (newplace==18){
   nextplace = location.towerstairs();
  } else if (newplace==19){
   nextplace = location.deepforestcavefirstarea();
  } else if (newplace==20){
   nextplace = location.deepforestcavesecondarea();
  } else if (newplace==21){
   nextplace = location.deepforestcavesidepassage();
  } else if (newplace==22){
   nextplace = location.deepforestcavesidecavern();
  } else if (newplace==23){
   nextplace = location.deepforestcavealcove();
  } else if (newplace==24){
   nextplace = location.deepforestcavethirdarea();
  } else if (newplace==25){
   nextplace = location.deepforestcavefourtharea();
  } else if (newplace==26){
   nextplace = location.secretcavepassage();
  } else if (newplace==27){
   nextplace = location.secretcavernentrance();
  } else if (newplace==28){
   nextplace = location.secretcavern();
  } else if (newplace==29){
   nextplace = location.foothills();
  } else if (newplace==30){
   nextplace = location.mountainpass();
  } else if (newplace==31){
   nextplace = location.valley();
  }
  Background.player.setlocation(nextplace);
  return nextplace;


 }

 public static void rest(){
  Background.player.rest();
  Background.addText("You are now back to full health.",true);
  Background.spacer();
 }

 public static void save(){
  Background.player.save();
  Background.addText("You saved your adventure.",true);
  Background.spacer();
 }
/*
//combat between the player and whatever monster they're facing
 public static int combat(int creaturetype, int level, boolean ambush){ //1 won, 2 died, 3 fled
  Creature monster = new Creature(creaturetype, level);
  double playeraccuracy = monster.hitbox()*player.acc();
  double monsteraccuracy = player.hitbox()*monster.acc();
  System.out.print("A "+monster.name()+" with "+monster.health()+" health appears");

  //if the creature ambushes (attacks first without retaliation)
  if (ambush==true){
   System.out.println(" and attacks!");
   player.damagetaken(monster.damagedoes());
   System.out.println("The "+monster.name()+" does "+monster.damagedoes()+" damage to you!");
   if (player.health()<=0){ //if the ambush killed the player
    spacer = input.next();
    if (introdeath==true){
     return 2;}
    System.out.println("Ouch, that surprise attack got you. You died.");
    return 2;}
  } else {
   System.out.println("!");}
  spacer = input.next();

  // combat loop
  int repeat = 1;
  while (repeat>0){
   System.out.println("You currently have "+player.health()+" health.");
   System.out.print("What would you like to do? ((a)ttack/(p)otion/(f)lee): ");
   String attack=input.next();
   System.out.println("");
   double hitchance = 0; //used to determine if an attack lands
   
   //if player chooses potion first
   if (attack.equals("potion") || attack.equals("p")){
    if (player.numpots()==0){
      nopots = true;
      System.out.print("You don't have any potions. ((a)ttack/(f)lee): ");
      attack = input.next();
      System.out.println("");
    } else {
     System.out.println("You currently have "+player.numpots()+" potions.");
     System.out.print("How many would you like to take? ");
     int numpots = input.nextInt();
     System.out.println(" ");
     System.out.println(player.potion(numpots,1));
     didpots = true;
     spacer = input.next();
    }
   }

   //if player tries to flee but can't at the current time
   if (attack.equals("flee") || attack.equals("f")){
    if (intro==true || monster.entrapment()==1.0){
     noflee = true;}
    if (intro==true){
     System.out.print("You can't flee right now! ((a)ttack");
     if (nopots==false){
      System.out.print("/(p)otion): ");
     } else {
      System.out.print("): ");
     }
     attack = input.next();
     System.out.println("");
    } else if (monster.entrapment()==1.0){
     System.out.print("The "+monster.name()+" is keeping you from escaping! ((a)ttack");
     if (nopots=false){
      System.out.print("/(p)otion): ");
     } else {
      System.out.print("): ");
     }
     attack = input.next();
     System.out.println("");
    }
   }     
   
   //if player chooses potion after trying to flee
   if (didpots==false){
    if (attack.equals("potion") || attack.equals("p")){
     if (nopots==false){
      if (player.numpots()==0){
       if (noflee==false){
        System.out.print("You don't have any potions. ((a)ttack/(f)lee): ");
       } else {
        System.out.print("You don't have any potions. ((a)ttack): ");
       }
       attack = input.next();
       System.out.println("");
      } else {
       if (didpots==false){
        System.out.println("You currently have "+player.numpots()+" potions.");
        System.out.print("How many would you like to take? ");
        int numpots = input.nextInt();
        System.out.println(" ");
        System.out.println(player.potion(numpots,1));
        spacer = input.next();
       }
      }
     }
    }
   }

   //if player is faster
   if (player.speed()>=monster.speed()){ 
    //if player attempts to flee
    if (attack.equals("flee") || attack.equals("f")){
     double runattempt = Math.random();
     if (runattempt>=monster.entrapment()){
      if (noflee==false){
       System.out.println("You fled!");
       spacer = input.next();
       return 3;
      }
     } else {
      System.out.println("The "+monster.name()+" stopped you from fleeing.");
     }
    }
    
    //if player attempts to attack
    if (attack.equals("attack") || attack.equals("a")){
     hitchance = Math.random();
     if (hitchance<=playeraccuracy){
      monster.damagetaken(player.damagedoes());
      System.out.println("You do "+player.damagedoes()+" damage!");
     } else if (hitchance>playeraccuracy){
      System.out.println("Your attack missed!");}
    }

    //check to see if monster died
    if (monster.health()==0){
     System.out.println("You defeated the "+monster.name()+"!");
     System.out.println("You still have "+player.health()+" health left.");
     repeat = 0;
     spacer = input.next();
    } else if (monster.health()!=0){  // if monster is still alive
     //monster attempts to attack
     hitchance = Math.random();
     if (hitchance<=monsteraccuracy){
      player.damagetaken(monster.damagedoes());
      System.out.println("The "+monster.name()+" does "+monster.damagedoes()+" damage to you!");
     } else if (hitchance>monsteraccuracy){
      System.out.println("The "+monster.name()+" missed!");}
     if (attack.equals("attack") || attack.equals("a") || attack.equals("flee") || attack.equals("f") || attack.equals("potion") || attack.equals("p")){
      spacer = input.next();}
     if (player.health()!=0){
      System.out.println("The "+monster.name()+" has "+monster.health()+" health left.");}
    }

      //check to see if player died
    if (player.health()==0){
     if (introdeath==true){
      return 2;}
     System.out.println("The "+monster.name()+" killed you.");
     spacer = input.next();
     return 2;}
    
   } else if (player.speed()<monster.speed()){ //if monster is faster
    
     //monster attempts to attack
     hitchance = Math.random();
     if (hitchance<=monsteraccuracy){
      player.damagetaken(monster.damagedoes());
      System.out.println("The "+monster.name()+" does "+monster.damagedoes()+" damage to you!");
     } else if (hitchance>monsteraccuracy){
      System.out.println("The "+monster.name()+" missed!");}

    //check to see if player died
    if (player.health()==0){
     System.out.println("The "+monster.name()+" killed you.");
     spacer = input.next();
     return 2;
    } 

    //if player attempts to flee
    if (attack.equals("flee") || attack.equals("f")){
     double runattempt = Math.random();
     if (runattempt>=monster.entrapment()){
      if (noflee==false){
       System.out.println("You fled!");
       spacer = input.next();
       return 3;
      }
     } else {
      System.out.println("The "+monster.name()+" stopped you from fleeing.");}
    }

    //if player attempts to attack
    if (attack.equals("a") || attack.equals("attack")){
     hitchance = Math.random();
     if (hitchance<=playeraccuracy){
      monster.damagetaken(player.damagedoes());
      System.out.println("You do "+player.damagedoes()+" damage!");
     } else if (hitchance>playeraccuracy){
      System.out.println("Your attack missed!");}
    }

    //check to see if monster died
    if (monster.health()==0){
     System.out.println("You defeated the "+monster.name()+"!");
     System.out.println("You still have "+player.health()+" health left.");
     repeat = 0;
     spacer = input.next();
    } else if (monster.health()!=0){
     if (attack.equals("a") || attack.equals("attack") || attack.equals("flee") || attack.equals("f") || attack.equals("potion") || attack.equals("p")){
      spacer = input.next();}
     System.out.println("The "+monster.name()+" has "+monster.health()+" health left.");
    }
   }//end of speed if statement
   nopots = false;
   noflee = false;
  }
  //drops from defeating the monster
  if (monster.dropchance()>Math.random()){
   int drop = monster.drop();
   if (drop==1){
    System.out.println("The monster dropped "+monster.dropnum()+" potions.");
    player.addpots(monster.dropnum());}
  }
  //money and experience from defeating the monster
  player.addmoney(monster.moneydrop());
  System.out.println("You gained "+monster.moneydrop()+" gold and "+monster.exp()+" experience! Now you have "+player.moneyamnt()+" gold.");
  player.experience(monster.exp());
  spacer = input.next();
  return 1;
 } //end of combat method
*/

 public static void store(){
  //Background.game.makeMessage("Store","Sorry, the store is currently unavailable.");
  //if (Background.player.level()<5){
  // System.out.println("Welcome to the store! Unfortunately we currently have very little selection.");
  //} else {
  // System.out.println("Welcome to the store!");}
  boolean repeat = true;
  while (repeat==true){
   try{
    choice = Background.game.itemlist();
    if (choice==null){
     choice="exit";
    }
   } catch (NullPointerException e){
    choice = "exit";
   }
   if (choice.equals("exit")){
    Background.addText("You exit the store.",true);
    Background.spacer();
    break;}
   int counter = 0;
   while (repeat==true){
    counter = counter + 1;
    Items item = new Items(counter);
    if (choice.equals(item.name())){
     if (Background.player.level()<item.level()){
      System.out.println("We don't have "+choice+" here.");
      break;
     } else if (item.type().equals("item")){
      int num = Integer.parseInt(JOptionPane.showInputDialog(null,"How many? ","Potions",1));
      if (buy(item.identity(),num)){
       Background.player.addpots(num);
       Background.game.update();
       break;
      } else {
       break;
      }
     } else  if (item.type().equals("weapon")){
      if (item.name().equals(Background.player.weapon())){
       Background.game.makeMessage("Hey. Sup.","You already have that.");
       break;
      } else {
       Background.addText("Are you sure you want to buy a "+item.name+"?",true);
       yesno = Background.yesno();
       if (yesno){
        if (buy(item.identity(),1)){
         Background.player.damagedec(Background.player.currweapdam());
         Background.player.damageinc(item.damage());
         Background.player.changeweapon(item.name());
         Background.game.update();
         break;
        } else {
         break;
        }
       } else {
        System.out.println("Fine then.");
        break;
       }
      }
     } else if (item.type().equals("quest")){
      if (getquest()==item.quest()){
       Background.addText("Are you sure you want to buy a "+item.name+"?",true);
       yesno = Background.yesno();
       if (yesno){
        if (buy(item.identity(),1)){
         TextAdventure.setquest(9);
         Background.game.update();
         break;
        } else {
         break;
        }
       } else {
        System.out.println("Fine then.");
        break;
       }
      } else {
       System.out.println("We don't have "+choice+" here.");
       break;
      }
     }
    } else if (Background.player.level()<item.level()){
     System.out.println("We don't have "+choice+" here.");
     break;
    }
   }
   Background.game.update();
  }
 }

 /*public static void itemlist(){
  System.out.println("  Item:          Cost:          Description:");
  if (player.level()==1){
   System.out.println("");
   System.out.println("  There are no items in the shop at this time.");
  } else {
   boolean repeat = true;
   int counter = 0;
   while (repeat==true){
    counter = counter + 1;
    Items item = new Items(counter);
    if (player.level()>=item.level() && player.level()<item.maxlevel()){
     if (item.type().equals("quest")){
      if (getquest()!=item.quest()){
       continue;
      }
     }
     int itemnamenumspaces = 15 - item.name().length(); //15-itemnamelength spaces till cost
     int itemcostnumspaces = 15 - Integer.toString(item.cost()).length(); //15-itemcostlength spaces till description
     String itemnamespaces = "";
     String itemcostspaces = "";
     for (int x=0; x<itemnamenumspaces; x=x+1){
      itemnamespaces = itemnamespaces + " ";
     }
     for (int x=0; x<itemcostnumspaces; x=x+1){
      itemcostspaces = itemcostspaces + " ";
     }
     System.out.println("   "+item.name()+itemnamespaces+item.cost()+itemcostspaces+item.description());
    } else if (player.level()<item.level()){
     repeat = false;
    } else {
     repeat = false;
    }
   }
  }
 }*/

 public static boolean buy(int itemtype, int num){ //used in the store ^
  Items item = new Items(itemtype);
  int itemcost = item.cost();
  int cost = num*itemcost;
  return Background.player.takemoney(cost);
 }
 
 public static void setquest(int newquest){
  Background.player.setquest(newquest);
 }
 public static int getquest(){
  return Background.player.getquest();
 }
 public static String name(){
  return Background.player.name();
 }
 public static int level(){
  return Background.player.level();
 }
 public static int health(){
  return Background.player.health();
 }
 public static int maxhealth(){
  return Background.player.maxhealth();
 }
 public static int damagetaken(int damage){
  Background.player.damagetaken(damage);
  if (health()==0){
   return 0;}
  return 1;
 }
 public static void potion(int number, int strength){
  Background.addText(Background.player.potion(number, strength),true);
 }

 public static void hint(int qnum){
  if (qnum==0){
   Background.game.makeMessage("Hint","Supposedly there's an old guy who wanders around on the path outside of\ntown. Maybe you should try and bump into him.");
  } else if (qnum==1){
   Background.game.makeMessage("Hint","Scholar said to go to the deep forest, so go there and see what you find.");
  } else if (qnum==2){
   Background.game.makeMessage("Hint","You found a piece of paper you can't understand. Maybe Scholar will\nknow what it says.");
  } else if (qnum==3){
   Background.game.makeMessage("Hint","Scholar needs books from the library in the castle. It's a little ways down\nthe road from the town.");
  } else if (qnum==4){
   Background.game.makeMessage("Hint","There may or may not be a secret entrance to the castle from the field,\nbut you didn't hear it from me.");
  } else if (qnum==5){
   Background.game.makeMessage("Hint","Gcholar needs the books you grabbed from the library to translate the\npiece of paper..");
  } else if (qnum==6){
   Background.game.makeMessage("Hint","Go to the town and rest for a bit while Scholar works on the translations.");
  } else if (qnum==7){
   Background.game.makeMessage("Hint","Scholar's had some time to work on the translation, go to him and see\nwhat's up.");
  } else if (qnum==8){
   Background.game.makeMessage("Hint","You can't enter the cave until you have a torch to light it, you can find\nthose at the town's store.");
  } else if (qnum==9){
   Background.game.makeMessage("Hint","Go explore the cave, toward the back you should find another slip of\npaper with the strange writing on it.");
  } else if (qnum==10){
   Background.game.makeMessage("Hint","Return to Scholar with the paper you found in the cave.");
  } else if (qnum==11){
   Background.game.makeMessage("Hint","Scholar thinks there's more to the cave than you've found so far. Maybe\ngo check out the room that you found the last slip of paper in.");
  } else if (qnum==12){
   Background.game.makeMessage("Hint","There's a secret door in the cave, what are you waiting for! Go exploring\nand see what's through it.");
  } else if (qnum==13){
   Background.game.makeMessage("Hint","There's an underground city full of monsters.. Scholar might want to\nknow about something like that.");
  } else if (qnum==14){
   Background.game.makeMessage("Hint","Scholar needs some more books from the castle library, this time on how\nto help you with the Illithids.");
  } else if (qnum==15){
   Background.game.makeMessage("Hint","If the tunnel isn't a good way to exit the castle, maybe you should try\nbreaking through the gates of the castle.");
  } else if (qnum==16){
   Background.game.makeMessage("Hint","Return to Scholar with the books on potions that you retrieved from the library.");
  } else if (qnum==17){
   Background.game.makeMessage("Hint","Scholar is a slow reader, go rest in the town while he reads through the\nbooks you brought back on Illithids.");
  } else if (qnum==18){
   Background.game.makeMessage("Hint","You've given Scholar plenty of time to read the books on the Illithid,\nhe should be done by now.");
  } else if (qnum==19){
   Background.game.makeMessage("Hint","Supposedly flowers from a valley in the mountains will help keep you safe\nfrom the Illithid. I'm pretty sure some mountains were visible from the field.");
  } else if (qnum==20){
   Background.game.makeMessage("Hint","You got the flowers! Now bring them back to Scholar so he can make the potion for you.");
  } else if (qnum==21){
   Background.game.makeMessage("Hint","Scholar's made you a potion to protect you from the Illithid's paralyzation,\nand told you to drink it just before you enter the castle. Go clear out the castle!");
  } else if (qnum==22){
   Background.game.makeMessage("Hint","Now that you've taken the potion, take advantage of your immunity to the\nIllithid's paralyzation and go clear them out of the castle.");
  } else if (qnum==23){
   Background.game.makeMessage("Hint","You've taken out one of the Illithid, but there may be more around the castle.\nMaybe one's taken a liking to looking out of high windows...");
  } else if (qnum==24){
   Background.game.makeMessage("Hint","The second Illithid has fled the castle, and there seems to be no more of them\nthere. Scholar would sure like to know the castle is safe to inhabit once more.");
  } else if (qnum==25){
   Background.game.makeMessage("Hint","So far that is the end of the game. Hope you've enjoyed it so far, let me know\nwhat you think of it, and if you'd be interested in continuing the game were I to add to it.");
  }
 }

 //stats shows player their statistics when in a safe area
 /*public static void stats(){
  System.out.println(" Name:           "+player.name());
  System.out.println(" Level:          "+player.level());
  System.out.println(" Exp needed:     "+player.expneeded());
  System.out.println(" Current health: "+player.health());
  System.out.println(" Max health:     "+player.maxhealth());
  System.out.println(" Damage:         "+player.damagedoes());
  System.out.println(" Speed:          "+player.speed());
  System.out.println(" Weapon:         "+player.weapon());
  System.out.println("");
  spacer = input.next();
  System.out.println("");
 }*/

 //gonna try to load an adventurer
 public static void load(String name){
  //lets try to read a file!
  try{
   FileInputStream fstream = new FileInputStream("SaveFiles/"+name+".txt");
   DataInputStream in = new DataInputStream(fstream);
   BufferedReader br = new BufferedReader(new InputStreamReader(in));
   name = br.readLine();
   int level = Integer.parseInt(br.readLine());
   int exp = Integer.parseInt(br.readLine());
   int health = Integer.parseInt(br.readLine());
   int damage = Integer.parseInt(br.readLine());
   int location = Integer.parseInt(br.readLine());
   int quest = Integer.parseInt(br.readLine());
   int money = Integer.parseInt(br.readLine());
   int numpots1 = Integer.parseInt(br.readLine());
   String weapon = br.readLine();
   int currweapdam = Integer.parseInt(br.readLine());
   in.close();
   Adventurer player = new Adventurer(name, level, exp, health, damage, location, quest, money, numpots1, weapon, currweapdam);
   } catch(Exception e){
   System.err.println("Error: "+e.getMessage());
   Background.game.makeMessage("Error","Save file was not found. Close and try again.");
  }
 }
 
 static boolean yesno;
 static String choice = "";
 boolean alive = true; /* modified in combat method and used in transition method to break the loop and */
                       /* give a game over                                                              */
 //static Adventurer player = new Adventurer("",1,0,0,0,1,0,0,0,"chain",0);
 static Location location = new Location();
 static Items item = new Items(2);
 static Scanner input = new Scanner(System.in);
 static String spacer = "";
 static String overwrite = ""; //used for overwriting a saved file
 static boolean intro = false;
 static boolean introdeath = false;
 static boolean noflee = false;
 static boolean nopots = false;
 static boolean didpots = false;
}