import java.util.Scanner;

public class Location{
 public Location(){
 }
 public int town(){//1
  int choice;
  Background.addText("You are in a town. Some townsfolk greet you, others don't.",true);
  Background.spacer();

  if (TextAdventure.getquest()==6){
   TextAdventure.setquest(7);
  }
  if (TextAdventure.getquest()==17){
   TextAdventure.setquest(18);
  }
  
  if (safearea(true,true,true,true)==-1){
   return -1;}

  //choose where to go
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Path");
  Background.game.setButton(2,"Stay");
  Background.wait(2);
  choice = Background.choice();
  if (choice==1){
   return 2;
  } else {
   return 1;
  }
 }// end of town()

 public int path(){//2
  int choice;
  Background.addText("You are walking along the path.",true);
  Background.spacer();
  
  //possible encounter
  encounterresult = encounter(4,(int)(.75*TextAdventure.level()+.5),.06,false);
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 1;
  } else if (encounterresult==0){
   if (TextAdventure.getquest()==0){
    if (!npcencounter(1,.3)){
     Background.addText("Nothing eventful happens.",true);
     Background.spacer();
    }
   }
  }
  if (TextAdventure.getquest()==0){
   Background.addText("Where would you like to go?",true);
   Background.game.setButton(1,"Town");
   Background.game.setButton(2,"Forest");
   Background.game.setButton(3,"Road");
   Background.game.setButton(4,"Stay");
   Background.wait(4);
  } else {
   Background.addText("Where would you like to go?",true);
   Background.game.setButton(1,"Town");
   Background.game.setButton(2,"Hut");
   Background.game.setButton(3,"Forest");
   Background.game.setButton(4,"Road");
   Background.game.setButton(5,"Stay");
   Background.wait(5);
  }
  choice = Background.choice();
  if (choice==1){
   return 1;
  } else if (TextAdventure.getquest()==0){
   if (choice==2){
    return 3;
   } else if (choice==3){
    return 4;
   } else if (choice==4){
    return 2;
   }
  } else {
   if (choice==2){
    return 17;
   } else if (choice==3){
    return 3;
   } else if (choice==4){
    return 4;
   } else if (choice==5){
    return 2;
   }
  }
  return 0;
 }// end of path()

 public int forest(){//3
  Background.addText("You're in the forest. You hear both small and large critters scurrying around.",true);
  Background.spacer();
  
  //alternating random encounters
  encounterresult = encounter(3,(int)(.8*TextAdventure.level()+.5),.4,false);
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==1){
  } else if (encounterresult==3){
   return 2;
  } else if (encounterresult==0){
   encounterresult = encounter(1,TextAdventure.level(),.6,true);
  } else if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 2;
  }
  encounterresult = encounter(2,(int)(.65*TextAdventure.level()+.5),.2,false);
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 2;
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Path");
  Background.game.setButton(2,"Clearing");
  Background.game.setButton(3,"Deepforest");
  Background.game.setButton(4,"Stay");
  Background.wait(4);
  choice = Background.choice();
  if (choice==1){
   return 2;
  } else if (choice==2){
   return 6;
  } else if (choice==3){
   return 5;
  } else {
   return 3;
  }
 }//end of forest()

 public int road(){ //4
  Background.addText("You're walking along a road.",true);
  Background.spacer();

  //possible encounter
  encounterresult = encounter(1,(int)(1.5+.6*TextAdventure.level()),.25,false);
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 2;
  } else if (encounterresult==0){
   Background.addText("There's no one else on the road.",true);
   Background.spacer();
  }

  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Path");
  Background.game.setButton(2,"Field");
  Background.game.setButton(3,"Castle Gates");
  Background.game.setButton(4,"Stay");
  Background.wait(4);
  choice = Background.choice();
  if (choice==1){
   return 2;
  } else if (choice==2){
   return 8;
  } else if (choice==3){
   return 7;
  } else {
   return 4;
  }
 }//end of road

 public int deepforest(){//5
  Background.addText("You're deep in the forest, where little sunlight makes it through to the ground. An eerie silence settles.",true);
  Background.spacer();
  if (TextAdventure.getquest()==1){
   encounterresult = encounter(2,1+(int)(.5*TextAdventure.level()),.75,false);
  } else {
   encounterresult = encounter(2,(int)(.75*TextAdventure.level()+.5),.35,true);
  }
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 6;
  } else if (encounterresult==1){
   if (TextAdventure.getquest()==1){
    Background.addText("The forest troll dropped something as you fought.",true);
    Background.addText("Pick it up?",true);
    yesno = Background.yesno();
    if (yesno){
     Background.addText("It's a paper with strange writing on it.",true);
     TextAdventure.setquest(2); 
     Background.spacer();
    }
   }
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Clearing");
  Background.game.setButton(2,"Forest");
  Background.game.setButton(3,"Cave");
  Background.game.setButton(4,"Stay");
  Background.wait(4);
  choice = Background.choice();
  if (choice==1){
   return 6;
  } else if (choice==2){
   return 3;
  } else if (choice==3){
   return 9;
  } else {
   return 5;
  }
 }//end of deepforest

 public int clearing(){//6  view stats, rest, and save
  Background.addText("You find an open clearing nestled within the forest. It's calm here.",true);
  Background.spacer();

  if (safearea(true,true,false,true)==-1){
   return -1;}

  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Forest");
  Background.game.setButton(2,"Deepforest");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 3;
  } else if (choice==2){
   return 5;
  } else {
   return 6;
  }
 }//end of clearing

 public int castlegates(){//7
  Background.addText("You are at the mighty gates of the castle.",true);
  Background.spacer();
  if (TextAdventure.getquest()==21){
   Background.addText("A few creatures appear to have been waiting for you.",true);
   Background.spacer();
   encounterresult = encounter(7,(int)(1.4+.7*TextAdventure.level()),1,false);
   if (encounterresult==2){
    return 0;
   } else if (encounterresult==3){
    return 4;
   }
   encounterresult = encounter(1,(int)(1.7+.8*TextAdventure.level()),1,false);
   if (encounterresult==2){
    return 0;
   } else if (encounterresult==3){
    return 4;
   }
   encounterresult = encounter(1,(int)(1.7+.95*TextAdventure.level()),1,false);
   if (encounterresult==2){
    return 0;
   } else if (encounterresult==3){
    return 4;
   }
   Background.addText("Drink the potion Scholar gave you now?",true);
   yesno = Background.yesno();
   if (yesno){
    TextAdventure.setquest(22);
   }
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Courtyard");
  Background.game.setButton(2,"Road");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   if (TextAdventure.getquest()<16){                           //put correct quest number here
    Background.addText("The gates are shut. You don't see a way to get in from here.",true);
    Background.spacer();
    if (TextAdventure.getquest()==3){
     TextAdventure.setquest(4);
    }
    return 7;
   }
   return 15;
  } else if (choice==2){
   return 4;
  } else {
   return 7;
  }
 }//end of castlegates
 
 public int field(){//8
  Background.addText("You're walking through a field. From here you can see the road and the castle, and even snow-capped mountains far in the distance.",true);
  Background.spacer();
  if (TextAdventure.getquest()>=4){
   Background.addText("There's something on the ground. It's a trapdoor. Would you like to enter?",true);
   yesno = Background.yesno();
   if (yesno){
    return 10;
   }
  }
  if (TextAdventure.getquest()<19){
   Background.addText("Where would you like to go?",true);
   Background.game.setButton(1,"Road");
   Background.game.setButton(2,"Stay");
   Background.wait(2);
   choice = Background.choice();
   if (choice==1){
    return 4;
   } else {
    return 8;
   }
  } else {
   Background.addText("Where would you like to go?",true);
   Background.game.setButton(1,"Foothills");
   Background.game.setButton(2,"Road");
   Background.game.setButton(3,"Stay");
   Background.wait(3);
   choice = Background.choice();
   if (choice==1){
    return 29;
   } else if (choice==2){
    return 4;
   } else {
    return 8;
   }
  }
 }//end of field

 public int deepforestcave(){//9
  Background.addText("You're standing at the entrance to the cave. Looking in you can see it quickly becomes pitch black.",true);
  Background.spacer();
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Deepforest");
  Background.game.setButton(2,"Underground");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 5;
  } else if (choice==2){
   if (TextAdventure.getquest()<9){
    Background.addText("It's too dark, you would get lost.",true);
    Background.spacer();
    return 9;
   } else {
    Background.addText("Your torch lights the way as you step in.",true);
    Background.spacer();
    return 19;
   }
  } else {
   return 9;
  }
 } // end of deepforestcave

 public int castletunnel(){//10
  Background.addText("You go down the steps and enter a tunnel. The walls and ceiling are close and stifling, and the floor has fresh dirt scattered on it.",true);
  Background.spacer();
  if (TextAdventure.getquest()==21 || TextAdventure.getquest()==22){
   encounterresult = encounter(1,3*TextAdventure.level(),1,false);
   if (encounterresult==2){
    return 0;
   } else if (encounterresult==3){
    return 8;
   }
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Stone Room");
  Background.game.setButton(2,"Field");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 11;
  } else if (choice==2){
   return 8;
  } else {
   return 10;
  }
 } // end of castletunnel

 public int stoneroom(){//11
  Background.addText("You're in a stone room that seems to carved from the bedrock.",true);
  if (TextAdventure.getquest()==4){
   Background.addText("There's a ladder going up on one of the walls.",true);}
  Background.spacer();

  if (safearea(true,true,false,true)==-1){
   return -1;}

  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Ladder");
  Background.game.setButton(2,"Tunnel");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 12;
  } else if (choice==2){
   return 10;
  } else {
   return 11;
  }
 } // end of stoneroom

 public int castledungeon(){//12
  if (TextAdventure.getquest()==4){
   Background.addText("The ladder opens up to a hallway that has rows of cells along each wall. This place has a familiar feel to it.",true);
  } else {
   Background.addText("You're in the dungeon of the castle. Rows of cells line the hallways.",true);
  }
  Background.spacer();
  if (TextAdventure.getquest()==14){
   encounterresult = encounter(1,(int)(3+.6*TextAdventure.level()),.75,false);
   if (encounterresult==2){
    return 0;
   } else if (encounterresult==3){
    return 11;
   }
  }
  if (TextAdventure.getquest()==15 || TextAdventure.getquest()==16){
   Background.addText("As you turn a corner, you find an Illithid to be already waiting for you.",true);
   Background.spacer();
   Background.addText("You aren't able to move as it approaches you. It's tentacles grasp onto you.",true);
   Background.spacer();
   Background.addText("It becomes harder to think, and you forget why you were there.",true);
   Background.spacer();
   Background.addText("Your vision goes black.",true);
   Background.spacer();
   return 0;
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Castle");
  Background.game.setButton(2,"Stone Room");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 13;
  } else if (choice==2) {
   return 11;
  } else {
   return 12;
  }
 } //end of castledungeon

 public int castleinterior(){//13
  if (TextAdventure.getquest()==4){
   Background.addText("You are in the interior of the castle. It's surpisingly empty.",true);
  } else {
   Background.addText("You're in the interior of the castle.",true);
  }
  Background.spacer();
  if (TextAdventure.getquest()==23){
   Background.addText("The Illithid's slaves still stand in the room, watching your every move.",true);
   Background.spacer();
  } else if (TextAdventure.getquest()==24){
   Background.addText("The slaves of the Illithid are nowhere to be seen.",true);
   Background.spacer();
  } else if (TextAdventure.getquest()>=25){
   Background.addText("A few people walk through the area to get from one part of the castle to another.",true);
   Background.spacer();
  }
  if (TextAdventure.getquest()==14){
   encounterresult = encounter(7,(int)(2.5+.5*TextAdventure.level()),.65,false);
   if (encounterresult==2){
    return 0;
   } else if (encounterresult==3){
    return 12;
   }
  }
  if (TextAdventure.getquest()==21 || TextAdventure.getquest()==22){
   Background.addText("The room is no longer as empty as it had been before.",true);
   Background.spacer();
   Background.addText("People with vacant looks on their faces are scattered around the place, and all have turned to stare at you.",true);
   Background.spacer();
   Background.addText("They begin to shuffle towards you.",true);
   Background.spacer();
   Background.addText("Run or stay?",true);
   Background.game.setButton(1,"Run");
   Background.game.setButton(2,"Stay");
   Background.wait(2);
   choice = Background.choice();
   if (choice==1){
    Background.addText("You turn towards the entrance, and find your escape blocked by more of them walking towards you.",true);
    Background.spacer();
   } else {
    Background.addText("You wait where you are as the people approach.",true);
    Background.spacer();
   }
   Background.addText("The people halt in a tight circle around you.",true);
   Background.spacer();
   Background.addText("Those in front of you part to reveal an Illithid striding towards you.",true);
   Background.spacer();
   if (TextAdventure.getquest()==21){
    Background.addText("As it approaches you find yourself unable to move.",true);
    Background.spacer();
    Background.addText("It continues to approach and the people behind it move to close the gap.",true);
    Background.spacer();
    Background.addText("The Illithid's tentacles lift, and wrap themselves around you. Your mind goes blank, your body goes limp, and your vision goes black.",true);
    Background.spacer();
    return 0;
   }
   Background.addText("The Illithid approaches you and then suddenly halts.",true);
   Background.spacer();
   Background.addText("\"What is thiss. There is ssomething different about you this time.\"",true);
   Background.spacer();
   Background.addText("\"You two\", it points to two of the people behind you, \"Hold him.\"",true);
   Background.spacer();
   encounterresult = encounter(9,(int)(2+.5*TextAdventure.level()),1,true);
   if (encounterresult==2){
    return 0;
   }
   encounterresult = encounter(9,(int)(1+.8*TextAdventure.level()),1,false);
   if (encounterresult==2){
    return 0;
   }
   Background.addText("\"It'ss my turn now\"",true);
   Background.spacer();
   encounterresult = encounter(10,(int)(2+.7*TextAdventure.level()),1,false);
   if (encounterresult==2){
    return 0;
   }
   TextAdventure.setquest(23);
   Background.addText("As the Illithid you defeated falls to the ground, some of the people around you seem to awaken, while the others continue staring at you.",true);
   Background.spacer();
   Background.addText("The awakened ones look around, seeming confused, and one by one look at you questioningly.",true);
   Background.spacer();
   Background.addText("One of them speaks up. \"Where are we?\"",true);
   Background.spacer();
   Background.addText("Rather than giving a lengthy explanation, you give them directions to Scholar's hut and tell them you will meet them there later.",true);
   Background.spacer();
   Background.addText("Those who are aware of themselves leave, and you are left with the vacant stares of those still under the Illithid's control.",true);
   Background.spacer();
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Courtyard");
  Background.game.setButton(2,"Stairs");
  Background.game.setButton(3,"Library");
  Background.game.setButton(4,"Dungeon");
  Background.game.setButton(5,"Stay");
  Background.wait(5);
  choice = Background.choice();
  if (choice==1){
   return 15;
  } else if (choice==2){ 
   return 18;
  } else if (choice==3){
   return 14;
  } else if (choice==4){
   return 12;
  } else {
   return 13;
  }
 } // end of castleinterior

 public int castlelibrary(){//14
  Background.addText("There are rows and rows of bookshelves, on all different topics.",true);
  Background.spacer();
  if (TextAdventure.getquest()>=25){
   Background.addText("There are people reading some of those books at tables between gaps in the shelves.",true);
   Background.spacer();
  }
  if (TextAdventure.getquest()==4){
   Background.addText("You search a bit and find books that seem to contain different languages. Some of them have writing that looks like that of the paper you found.",true);
   Background.spacer();
   Background.addText("Would you like to pick up several of the books?",true);
   yesno = Background.yesno();
   if (yesno){
    Background.addText("You pick out some that look the most promising to you.",true);
    TextAdventure.setquest(5);
    Background.spacer();
    Background.addText("Suddenly you hear a hiss behind you. You turn around and see a creature that looks vaguely humanoid, but has tiny pale green scales covering its skin and four tentacles arranged around the mouth on its bulbous head.",true);
    Background.spacer();
    Background.addText("It says in a sibilant voice \"Ah, it'ss you again\".",true);
    Background.spacer();
    Background.addText("Run or stay?",true);
    Background.game.setButton(1,"Run");
    Background.game.setButton(2,"Stay");
    Background.wait(2);
    choice = Background.choice();
    if (choice==1){
     Background.addText("You run as fast as you can from whatever that is.",true);
     Background.spacer();
     return 13;
    } else {
     Background.addText("The creature walks up to you, hissing as it does so.",true);
     Background.addText("\nYou find you can't move any part of your body.",false);
     Background.spacer();
     Background.addText("It reaches you and its tentacles wrap around your head.",true);
     Background.spacer();
     Background.addText("Your thoughts get fuzzy, you drop the books you were holding, and your vision goes black.",true);
     Background.spacer();
     return 0;
    }
   }
  }
  if (TextAdventure.getquest()==14){
   Background.addText("After a quick search you locate several books on underground creatures.",true);
   Background.spacer();
   Background.addText("Would you like to pick them up?",true);
   yesno = Background.yesno();
   if (yesno){
    TextAdventure.setquest(15);
    Background.addText("A hissing sound comes from the door to the library.",true);
    Background.spacer();
    Background.addText("Where would you like to go?",true);
    Background.game.setButton(1,"Library Door");
    Background.game.setButton(2,"Back Corner");
    Background.game.setButton(3,"Stay");
    Background.wait(3);
    choice = Background.choice();
    if (choice==1){
     Background.addText("As you come within view of the door, you see an Illithid waiting for you.",true);
     Background.spacer();
     Background.addText("It approaches you and you find yourself paralyzed, unable to run, or scream.",true);
     Background.spacer();
     Background.addText("It comes within an arm's length of you and stops. It says \"This time you will not esscape.\"",true);
     Background.spacer();
     Background.addText("As its last word trails off the Illithid's tentacles lift and curl themselves around you. Your arms go slack, and the books drop from your grasp.",true);
     Background.spacer();
     Background.addText("Your memories fade away and are replaced by a desire to serve.",true);
     Background.spacer();
     return 0;
    } else if (choice==2){
     Background.addText("You try to keep out of sight of the entrance to the library as you hurry to the back wall. A small wooden door catches your attention.",true);
     Background.spacer();
     Background.addText("Behind you you hear the hissing of an Illithid coming closer.",true);
     Background.spacer();
     Background.addText("You rush through the door and through a claustrophobic passageway that winds through the castle and opens back up into the main area.",true);
     Background.spacer();
     return 13;
    } else {
     Background.addText("You listen as the source of the hissing approaches.",true);
     Background.spacer();
     Background.addText("It seems to go to one side of the library, walking down the rows of bookcases. You run to the other end of the bookcases and book it (hehe) to the door.",true);
     Background.spacer();
     return 13;
    }
   }
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Castle");
  Background.game.setButton(2,"Stay");
  Background.wait(2);
  choice = Background.choice();
  if (choice==1){
   return 13;
  } else {
   return 14;
  }
 } // end of castlelibrary

 public int castlecourtyard(){ //15
  Background.addText("You're in the courtyard of the castle.",true);
  Background.spacer();
  if (TextAdventure.getquest()==14 || TextAdventure.getquest()==15){
   encounterresult = encounter(1,(int)(2.5+.5*TextAdventure.level()),.5,true);
   if (encounterresult==2){
    return 0;
   } else if (encounterresult==3){
    return 13;
   }
   encounterresult = encounter(7,(int)(2.5+.5*TextAdventure.level()),.75,false);
   if (encounterresult==2){
    return 0;
   } else if (encounterresult==3){
    return 27;
   }
   if (TextAdventure.getquest()==15){
    Background.addText("You notice there's a chain holding the gates' counterweight in place.",true);
    Background.spacer();
    Background.addText("Attempt to break it?",true);
    yesno = Background.yesno();
    if (yesno){
     Background.addText("You swing your weapon at the chain.",true);
     Background.spacer();
     Background.addText("After a few swings, the chain breaks, allowing the counterweight to fall heavily to the ground. The gates swing open.",true);
     TextAdventure.setquest(16);
     Background.spacer();
    }
   }
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Castle Gates");
  Background.game.setButton(2,"Castle");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   if (TextAdventure.getquest()<16){                            //put correct quest number here
    Background.addText("The gates are shut tight, and there's no way to open them from here.",true);
    Background.spacer();
    return 15;
   }
   return 7;
  } else if (choice==2){
   return 13;
  } else {
   return 15;
  }
 } // end of castlecourtyard

 public int castletower(){ //16
  Background.addText("You're in a large circular room with windows overlooking the surrounding lands.",true);
  Background.spacer();
  if (TextAdventure.getquest()==23){
   Background.addText("\"So i ssee you have found a way to fight uss.\" An Illithid turns from the window to face you.",true);
   Background.spacer();
   Background.addText("You make a move towards it, but before you get close it gestures for you to stop.",true);
   Background.spacer();
   Background.addText("\"Sstop, fool. You think killing me and my brother will save you? Thiss is only the beginning.\" With that the Illithid turned back towards the window and jumped.",true);
   Background.spacer();
   Background.addText("You run to the window, but when you look down you see no sign of the Illithid's landing. It must have somehow survived the fall and escaped.",true);
   TextAdventure.setquest(24);
   Background.spacer();
  }
  if (TextAdventure.getquest()>=25){
   npcencounter(1,.9);
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Window");
  Background.game.setButton(2,"Stairs");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   Background.addText("Are you sure?",true);
   yesno = Background.yesno();
   if (yesno){
    Background.addText("You jump out of the window.",true);
    Background.spacer();
    Background.addText("You hit the ground.",true);
    Background.player.damagetaken(Background.player.health);
    Background.spacer();
    return 0;
   } else {
    return 16;
   }
  } else if (choice==2){
   return 18;
  } else {
   return 16;
  }
 } // end of castletower

 public int scholarhut(){ //17
   Background.addText("You're in a hut with a low ceiling. There's sparse furniture and the roof has several small gaps in it.",true);
   Background.spacer();
  if (TextAdventure.getquest()<25){      //fix this later
   npcencounter(1,1);
  }                                      //add more later
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Path");
  Background.game.setButton(2,"Stay");
  Background.wait(2);
  choice = Background.choice();
  if (choice==1){
   return 2;
  } else {
   return 17;
  }
 } // end of scholarhut

 public int towerstairs(){ //18
  Background.addText("You are on a long, spiral staircase. There are periodic windows looking out over the rest of the castle.",true);
  Background.spacer();
  if (TextAdventure.getquest()>=25){
   encounterresult = encounter(5,1,1,true);
  }
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 13;
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Tower");
  Background.game.setButton(2,"Castle");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 16;
  } else if (choice==2){
   return 13;
  } else {
   return 18;
  }
 } // end of towerstairs

 public int deepforestcavefirstarea(){ //19
  Background.addText("You can see sunlight pouring in through the entrance to the cave, but very little of it reaches where you're standing.",true);
  Background.spacer();  
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Deeper");
  Background.game.setButton(2,"Cave Entrance");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 20;
  } else if (choice==2){
   return 9;
  } else {
   return 19;
  }
 } // end of deepforestcavefirstarea

 public int deepforestcavesecondarea(){ //20
  Background.addText("Twists and turns have blocked sight of the entrance, the only light here is that of the flickering torch on the rough rock surrounding you.",true);
  Background.spacer();  
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Deeper");
  Background.game.setButton(2,"Side Passage");
  Background.game.setButton(3,"Up");
  Background.game.setButton(4,"Stay");
  Background.wait(4);
  choice = Background.choice();
  if (choice==1){
   return 24;
  } else if (choice==2){
   return 21;
  } else if (choice==3){
   return 19;
  } else {
   return 20;
  }
 } // end of deepforestcavesecondarea

 public int deepforestcavesidepassage(){ //21
  Background.addText("The passage is narrow, and the floor is scattered with bat guano.",true);
  Background.spacer();  
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Side Cavern");
  Background.game.setButton(2,"Alcove");
  Background.game.setButton(3,"Main Passage");
  Background.game.setButton(4,"Stay");
  Background.wait(4);
  choice = Background.choice();
  if (choice==1){
   return 22;
  } else if (choice==2){
   return 23;
  } else if (choice==3){
   return 20;
  } else {
   return 21;
  }
 } // end of deepforestcavesidepassage

 public int deepforestcavesidecavern(){ //22
  Background.addText("The side passage opens up into a small cavern. The floor is covered in piles of bat guano. Looking up you see hundreds of small blue bats hanging from the ceiling.",true);
  Background.spacer();
  encounterresult = encounter(6,1,.5,false);
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 21;
  }
  encounterresult = encounter(6,1,.4,true);
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 21;
  }
  encounterresult = encounter(6,1,.5,false);
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 21;
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Side Passage");
  Background.game.setButton(2,"Stay");
  Background.wait(2);
  choice = Background.choice();
  if (choice==1){
   return 21;
  } else {
   return 22;
  }
 } // end of deepforestcavesidecavern

 public int deepforestcavealcove(){ //23
  Background.addText("You're in a small alcove that branches off from the side passage. It's empty and the rock here has been worn smooth.",true);
  Background.spacer();
  if (safearea(true,true,false,true)==-1){
   return -1;}
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Side Passage");
  Background.game.setButton(2,"Stay");
  Background.wait(2);
  choice = Background.choice();
  if (choice==1){
   return 21;
  } else {
   return 23;
  }
 } // end of deepforestcavealcove

 public int deepforestcavethirdarea(){ //24
  Background.addText("The floor of the cave where you are standing is starting to slope downwards quite steeply. You have to step carefully.",true);
  Background.spacer();
  double fall = Math.random();
  if (fall<.2){
   Background.addText("You slip and slide down through the cave.",true);
   Background.spacer();
   int falldamage = (int)(TextAdventure.maxhealth()/3);
   if (TextAdventure.damagetaken(falldamage)==0){
    Background.addText("As you fall you hit your head sharply on a protruding rock.",true);
    Background.spacer();
    return 0;
   } else {
    Background.addText("The fall caused you to take "+falldamage+" damage.",true);
    Background.spacer();
    Background.addText("Would you like to use a potion?",true);
    yesno = Background.yesno();
    if (yesno){
     if (Background.player.numpots()==0){
       Background.addText("You don't have any potions.",true);
     } else {
      Background.addText("How many potions would you like to take? ",true);
      for (int i=1; i<7; i++){
       Background.game.setButton(i,Integer.toString(i));
      }
      Background.wait(6);
      int numpots = Background.choice();
      Background.addText(Background.player.potion(numpots,1),true);
      Background.game.update();
      Background.spacer();
     }
    }
    return 25;
   }
  } else if (fall>.2 && fall<.35){
   Background.addText("Your feet start to slip, but you catch yourself before you fall.",true);
   Background.spacer();
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Deeper");
  Background.game.setButton(2,"Up");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 25;
  } else if (choice==2){
   return 20;
  } else {
   return 24;
  }
 } // end of deepforestcavethirdarea

 public int deepforestcavefourtharea(){ //25
  if (TextAdventure.getquest()<12){
   Background.addText("The cave opens up here into a larger chamber, which appears to be a dead end.",true);
  } else {
   Background.addText("The cave opens up here into a large chamber.",true);
  }
  Background.spacer();
  if (TextAdventure.getquest()==9){
   Background.addText("There's a torn slip of paper laying on the floor of the chamber.",true);
   Background.addText("\nPick it up?",false);
   yesno = Background.yesno();
   if (yesno){
    TextAdventure.setquest(10);
   }
  }
  if (TextAdventure.getquest()==11){
   double openchance = .65;
   if (openchance>=Math.random()){
    Background.addText("Suddenly you hear a scraping sound, and a portion of the back wall begins to swing out.",true);
    Background.spacer();
    Background.addText("A bent, lizard-like humanoid walks through the new opening.",true);
    Background.spacer();
    encounterresult = encounter(7,(int)(2.5+.6*TextAdventure.level()),1,false);
    if (encounterresult==2){
     return 0;
    } else if (encounterresult==3){
     return 24;
    }
    Background.addText("From seeing the kobold use the secret door, you now know how it's worked.",true);
    TextAdventure.setquest(12);
   }
  }
  if (TextAdventure.getquest()>11){
   Background.addText("Would you like to use the secret door?",true);
   yesno = Background.yesno();
   if (yesno){
    Background.addText("It opens up into a smooth-bored tunnel leading deeper into the ground.",true);
    Background.spacer();
    return 26;
   }
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Up");
  Background.game.setButton(2,"Stay");
  Background.wait(2);
  choice = Background.choice();
  if (choice==1){
   return 24;
  } else {
   return 25;
  }
 } // end of deepforestcavefourtharea

 public int secretcavepassage(){ //26
  Background.addText("There is a faint light coming from the lower end of the tunnel, and your torch is not as necessary here.",true);
  Background.spacer();
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Deeper");
  Background.game.setButton(2,"Cave");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 27;
  } else if (choice==2){
   return 25;
  } else {
   return 26;
  }
 } // end of secretcavepassage

 public int secretcavernentrance(){ //27
  Background.addText("You're at the entrance to an enormous cavern, the far side of which is lost in the darkness. Centered in the cavern is a city lit by innumerable torches, crawling with figures the likes of which you've only recently come to know.",true);
  Background.spacer();
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Cavern");
  Background.game.setButton(2,"Secret Tunnel");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 28;
  } else if (choice==2){
   return 26;
  } else {
   return 27;
  }
 }

 public int secretcavern(){ //28
  Background.addText("The underground city is close, the light it casts makes the use of your torch completely unnecessary.",true);
  Background.spacer();
  if (TextAdventure.getquest()<13){
   Background.addText("Creatures from the city are roaming much closer to you now. It's possible that some could see you from this distance, but you try to stay out of sight.",true);
   Background.spacer();
  }
  encounterresult = encounter(7,(int)(2.5+.5*TextAdventure.level()),.75,false);
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 27;
  }
  encounterresult = encounter(3,(int)(2+.6*TextAdventure.level()),.5,false);
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   return 27;
  }
  if (TextAdventure.getquest()<13){
   Background.addText("Where would you like to go?",true);
   Background.game.setButton(1,"City");
   Background.game.setButton(2,"Cavern Entrance");
   Background.game.setButton(3,"Stay");
   Background.wait(3);
   choice = Background.choice();
   if (choice==1){
    Background.addText("As you try to move closer to the city, you see that a group of the tentacled beings have noticed you and are now approaching your location.",true);
    Background.spacer();
    Background.addText("Run?",true);
    yesno = Background.yesno();
    if (yesno){
     Background.addText("You run.",true);
     Background.spacer();
     TextAdventure.setquest(13);
     return 27;
    } else {
     Background.addText("You stay where you are, allowing the things to come closer.",true);
     Background.spacer();
     Background.addText("As they approach, one breaks off from the group and moves faster.",true);
     Background.spacer();
     Background.addText("You find you can no longer move, none of your muscles respond to your will.",true);
     Background.spacer();
     Background.addText("The leading one stops within an armlength from you and pauses momentarily.",true);
     Background.spacer();
     Background.addText("Suddenly it hisses, and its tentacles wrap around you. Your thoughts fade, your body goes limp, and your vision goes black.",true);
     return 0;
    }
   } else if (choice==2){
    return 27;
   } else {
    return 28;
   }
  } else {
   Background.addText("The area between you and the city is crawling with various creatures, it'd be too dangerous to move any closer.",true);
   Background.spacer();
   Background.addText("Where would you like to go?",true);
   Background.game.setButton(1,"Cavern Entrance");
   Background.game.setButton(2,"Stay");
   Background.wait(2);
   choice = Background.choice();
   if (choice==1){
    return 27;
   } else {
    return 28;
   }
  }
 } // end of secretcavern

 public int foothills(){ //29  /////FINISH ME AND NEXT TWO
  Background.addText("You're walking through the foothills of the mountains. From here you can see a gap in the mountains where there is a pass through them.",true);
  Background.spacer();
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Mtn. Pass");
  Background.game.setButton(2,"Field");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 30;
  } else if (choice==2){
   return 8;
  } else {
   return 29;
  }
 } // end of foothills

 public int mountainpass(){ //30
  Background.addText("You're in the pass, with mountains towering to each of your sides.",true);
  Background.spacer();
  if (TextAdventure.getquest()==19){
   encounterresult = encounter(8,(int)(1.5+.6*TextAdventure.level()),1,false);
  } else {
   encounterresult = encounter(8,(int)(1.5+.6*TextAdventure.level()),.5,false);
  }
  if (encounterresult==2){
   return 0;
  } else if (encounterresult==3){
   if (TextAdventure.getquest()==19){
    return 29;
   } else {
    return 31;
   }
  }
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Valley");
  Background.game.setButton(2,"Foothills");
  Background.game.setButton(3,"Stay");
  Background.wait(3);
  choice = Background.choice();
  if (choice==1){
   return 31;
  } else if (choice==2){
   return 29;
  } else {
   return 30;
  }
 } // end of mountainpass

 public int valley(){ //31
  Background.addText("You are currently in a small valley, with fields of grass and flowers, surrounded by the steep sides of the mountains.",true);
  Background.spacer();
  if (TextAdventure.getquest()==19){
   Background.addText("Some of the flowers look like those described to you by Scholar.",true);
   Background.spacer();
   Background.addText("Would you like to pick them?",true);
   yesno = Background.yesno();
   if (yesno){
    Background.addText("You picked some of the lotuses.",true);
    TextAdventure.setquest(20);
    Background.spacer();
   }
  }  
  if (safearea(true,true,false,true)==-1){
   return -1;}
  Background.addText("Where would you like to go?",true);
  Background.game.setButton(1,"Mtn. Pass");
  Background.game.setButton(2,"Stay");
  Background.wait(2);
  choice = Background.choice();
  if (choice==1){
   return 30;
  } else {
   return 31;
  }
 } // end of valley

 public int encounter(int type, int level, double chance, boolean ambush){
  //returning 0=no encounter, 1=won, 2=death, 3=fled
  randomencounter = Math.random();
  if (randomencounter<=chance){
   int combatresult = Background.combat(type,level,ambush);
   if (combatresult==2){
    return 2;
   } else if (combatresult==1){
    return 1;
   } else if (combatresult==3){
    return 3;
   } else {
    return 0;
   }
  } else {
   return 0;
  }
 } //end of encounter

 public boolean npcencounter(int identity, double chance){//false no encounter, true an encounter occurred
  randomencounter = Math.random();
  if (randomencounter<=chance){
   Npc npc = new Npc(identity);
   if (TextAdventure.getquest()>=npc.minquest() && TextAdventure.getquest()<=npc.maxquest()){
    Background.addText("\n"+npc.description+" approaches you.",false);
    Background.spacer();
    Background.addText(npc.greeting(),true);
    Background.spacer();
    npc.action();
    return true;
   } else {
    return false;
   }
  } else {
   return false;
  }
 } // end of npcencounter

 public int safearea(boolean statsa, boolean resta, boolean storea, boolean savea){
  /*if (statsa){ //view stats
   System.out.print("Would you like to view your stats? (y/n): ");
   choice = input.next();
   System.out.println("");
   if (choice.equals("y")){
    //TextAdventure.stats();
   }
  }*/
  if (resta){ //rest to full health
   Background.addText("Would you like to rest?",true);
   yesno = Background.yesno();
   if (yesno){
    TextAdventure.rest();}
  }
  if (storea){ //chance to visit store
   Background.addText("Would you like to visit the store?",true);
   yesno = Background.yesno();
   if (yesno){
    TextAdventure.store();}
  }
  /*if (savea){ //choice of saving/exiting
   System.out.print("Would you like to save or exit your game? (save/exit/both/n): ");
   choice = input.next();
   System.out.println("");
   if (choice.equals("save")){
    TextAdventure.save();
   } else if (choice.equals("exit")){
    return -1;
   } else if (choice.equals("both")){
    TextAdventure.save();
    return -1;
   }
  }*/
  return 0;
 }

 static Scanner input = new Scanner(System.in);
 static String spacer = "";
 static int choice;
 static double randomencounter = 0;
 static int encounterresult = 0;
 static boolean yesno;

}