import javax.swing.*;


public class Background{
 public static Adventurer player;
 public static GUIAdventure game;
 private static boolean go = false;
 private static int choice, choicex, validChoices;

 static boolean intro = false;
 static boolean introdeath = false;
 static boolean noflee = false;
 static boolean nopots = false;
 static boolean didpots = false;

 public static void main(String[] args){
  game = new GUIAdventure();
  while (true){
   storyLine();
  }
 }

 public static void storyLine(){
  addText("    Welcome to TextAdventure",true);
  //addText("\n        Created by Jimmy.",false);
  player = new Adventurer("",0,0,0,0,0,0,0,0,"chain",0);
  //name a new character or load a game here
  game.setButton(1,"New Game");
  game.setButton(2,"Load Game");
  String name="";
  game.update();
  while (true){
   wait(2);
   if (choice==1){
    name = JOptionPane.showInputDialog(null,"Character name: ","New Game",1);
   } else {
    String str = JOptionPane.showInputDialog(null,"Type file to load: ","Load Game",1);
    if (str!=null){
     game.load(str);
     name = player.name;
    } /*else {
     name = JOptionPane.showInputDialog(null,"Character name: ","New Game",1);
     player = new Adventurer(name,1,0,0,0,0,0,0,0,"chain",0);
    }*/
   }
   if (name!=null && !name.equals("")){
    break;
   }
  }
  if (choice==1){
   player = new Adventurer(name,1,0,0,0,0,0,0,0,"chain",0);
   addText("Don't forget to save often!",true);
  }
  game.update();
  TextAdventure.main();
 }

 public static void addText(String addition, boolean newline){
  if (newline){
   game.centerTA.append("\n\n   ");
  }
  game.centerTA.append(addition+" ");
  game.centerTA.setCaretPosition(game.centerTA.getDocument().getLength());
 }

 public static void wait(int x){
  choicex=choice;
  validChoices = x;
  while (true){
   if (go){
    go = false;
    break;
   }
  }
 }

 public static void spacer(){
  for (int i=2; i<7; i++){
   game.setButton(i, " ");
  }
  game.setButton(1, "Continue");
  wait(1);
  choice=choicex;
 } 

 public static void attack(int x){ //1=all three, 2=no pots, 3=nopotsnoflee, 4=noflee
  for (int i=2; i<7; i++){
   game.setButton(i, " ");
  }
  game.setButton(1,"Attack");
  if (x==1){
   game.setButton(2,"Potion");
   game.setButton(3,"Flee");
   wait(3);
  } else if (x==2){
   game.setButton(2,"Flee");
   wait(2);
  } else if (x==3){
   wait(1);
  } else if (x==4){
   game.setButton(2,"Potion");
   wait(2);
  }
 }

 public static boolean yesno(){
  game.setButton(1,"Yes");
  game.setButton(2,"No");
  wait(2);
  if (choice==1){
   return true;
  } else {
   return false;
  }
 }
 
 public static int choice(){
  return choice;
 }

 public static int combat(int creaturetype, int level, boolean ambush){ //1 won, 2 died, 3 fled
  Creature monster = new Creature(creaturetype, level);
  double playeraccuracy = monster.hitbox()*player.acc();
  double monsteraccuracy = player.hitbox()*monster.acc();
  addText("A "+monster.name()+" with "+monster.health()+" health appears",true);

  //if the creature ambushes (attacks first without retaliation)
  if (ambush==true){
   addText("and attacks!",false);
   spacer();
   player.damagetaken(monster.damagedoes());
   addText("The "+monster.name()+" does "+monster.damagedoes()+" damage to you!",true);
   game.update();
   if (player.health()==0){ //if the ambush killed the player
    spacer();
    if (introdeath==true){
     return 2;}
    addText("Ouch, that surprise attack got you. You died.",true);
    return 2;}
  } else {
   addText("!",false);}
  spacer();

  // combat loop
  int repeat = 1;
  while (repeat>0){
   addText("What would you like to do?",true);
   attack(1);
   double hitchance = 0; //used to determine if an attack lands
   
   //if player chooses potion first
   if (choice==2){ //////////////////////////////////
    if (player.numpots()==0){
      nopots = true;
      addText("You don't have any potions.",true);
      attack(2);
    } else {
     addText("How many potions would you like to take? ",true);
     for (int i=1; i<7; i++){
      game.setButton(i,Integer.toString(i));
     }
     wait(6);
     int numpots = choice;
     choice = 0;
     addText(player.potion(numpots,1),true);
     game.update();
     didpots = true;
     spacer();
    }
   }

   //if player tries to flee but can't at the current time
   if (nopots==true){
    if (choice==2){
     choice=3;
    }
   }
   if (choice == 3){
    if (intro==true || monster.entrapment()==1.0){
     noflee = true;}
    if (intro==true){
     addText("You can't flee right now!",true);
     if (nopots==false){
      attack(4);
     } else {
      attack(3);
     }
    } else if (monster.entrapment()==1.0){
     addText("The "+monster.name()+" is keeping you from escaping!",true);
     if (nopots=false){
      attack(4);
     } else {
      attack(3);
     }
    }
   }     
   
   //if player chooses potion after trying to flee
   if (didpots==false){
    if (nopots==false){
     if (choice==2){
      if (player.numpots()==0){
       if (noflee==false){
        addText("You don't have any potions.",true);
        attack(2);
       } else {
        addText("You don't have any potions.",true);
        attack(3);
       }
      } else {
       if (didpots==false){
        addText("How many potions would you like to take? ",true);
        for (int i=1; i<7; i++){
         game.setButton(i,Integer.toString(i));
        }
        wait(6);
        int numpots = choice;
        choice = 0;
        addText(player.potion(numpots,1),true);
        game.update();
        spacer();
        didpots=true;
       }
      }
     }
    }
   }
   if (nopots==true){
    if (choice==2){
     choice=3;
    }
   }

   //if player is faster
   if (player.speed()>=monster.speed()){ 
    //if player attempts to flee   ///////////////////////////////
    if (choice==3){
     double runattempt = Math.random();
     if (runattempt>=monster.entrapment()){
      if (noflee==false){
       addText("You fled!",true);
       spacer();
       return 3;
      }
     } else {
      addText("The "+monster.name()+" stopped you from fleeing.",true);
     }
    }
    
    //if player attempts to attack
    if (choice==1){
     hitchance = Math.random();
     if (hitchance<=playeraccuracy){
      monster.damagetaken(player.damagedoes());
      addText("You do "+player.damagedoes()+" damage!",true);
     } else if (hitchance>playeraccuracy){
      addText("Your attack missed!",true);}
    }

    //check to see if monster died
    if (monster.health()==0){
     addText("\nYou defeated the "+monster.name()+"!",false);
     repeat = 0;
     spacer();
    } else if (monster.health()!=0){  // if monster is still alive
     //monster attempts to attack
     hitchance = Math.random();
     if (hitchance<=monsteraccuracy){
      player.damagetaken(monster.damagedoes());
      addText("The "+monster.name()+" does "+monster.damagedoes()+" damage to you!",false);
      game.update();
     } else if (hitchance>monsteraccuracy){
      addText("The "+monster.name()+" missed!",false);}
     spacer();
     if (player.health()!=0){
      addText("The "+monster.name()+" has "+monster.health()+" health left.",true);}
    }

      //check to see if player died
    if (player.health()==0){
     if (introdeath==true){
      return 2;}
     addText("\nThe "+monster.name()+" killed you.",false);
     spacer();
     return 2;}
    
   } else if (player.speed()<monster.speed()){ //if monster is faster
    
     //monster attempts to attack
     hitchance = Math.random();
     if (hitchance<=monsteraccuracy){
      player.damagetaken(monster.damagedoes());
      addText("The "+monster.name()+" does "+monster.damagedoes()+" damage to you!",true);
      game.update();
     } else if (hitchance>monsteraccuracy){
      addText("The "+monster.name()+" missed!",true);}

    //check to see if player died
    if (player.health()==0){
     addText("\nThe "+monster.name()+" killed you.",false);
     spacer();
     return 2;
    } 

    //if player attempts to flee
    if (choice==3){
     double runattempt = Math.random();
     if (runattempt>=monster.entrapment()){
      if (noflee==false){
       addText("You fled!",false);
       spacer();
       return 3;
      }
     } else {
      addText("The "+monster.name()+" stopped you from fleeing.",false);}
    }

    //if player attempts to attack
    if (choice==1){
     hitchance = Math.random();
     if (hitchance<=playeraccuracy){
      monster.damagetaken(player.damagedoes());
      addText("You do "+player.damagedoes()+" damage!",false);
     } else if (hitchance>playeraccuracy){
      addText("Your attack missed!",false);}
    }

    //check to see if monster died
    if (monster.health()==0){
     addText("\nYou defeated the "+monster.name()+"!",false);
     repeat = 0;
     spacer();
    } else if (monster.health()!=0){
     spacer();
     addText("The "+monster.name()+" has "+monster.health()+" health left.",true);
    }
   }//end of speed if statement
   nopots = false;
   noflee = false;
  }
  //drops from defeating the monster
  if (monster.dropchance()>Math.random()){
   int drop = monster.drop();
   if (drop==1){
    addText("The monster dropped "+monster.dropnum()+" potions.",true);
    player.addpots(monster.dropnum());}
    game.update();
  }
  //money and experience from defeating the monster
  player.addmoney(monster.moneydrop());
  addText("\nYou gained "+monster.moneydrop()+" gold and "+monster.exp()+" experience!",false);
  player.experience(monster.exp());
  game.update();
  spacer();
  return 1;
 } //end of combat method

 public static void buttonClicked(int x){
  if (x<=validChoices){
   choice = x;
   buttonPress();
  }
 }
 
 public static void buttonPress(){
  go = true;
 }

 public static void restart(){
  player = new Adventurer("newplayer",1,0,0,0,0,0,0,0,"chain",0);
  game.update();
 }

}