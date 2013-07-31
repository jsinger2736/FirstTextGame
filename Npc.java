import java.util.Scanner;
import java.io.*;

public class Npc{
 public Npc(int identity){
  if (identity==1){
   name = "Scholar";
   if (TextAdventure.getquest()<1){
    description = "A slightly bent man with graying hair";
   } else if (TextAdventure.getquest()>=1){
    description = "Scholar";
   }
   if (TextAdventure.getquest()<1){
    greeting = "\"Hello, I don't believe we've met before. My name is "+name+". And yours is... Ah, pleasure to meet you "+TextAdventure.name()+".\"";
   } else if (TextAdventure.getquest()>=1){
    greeting = "\"Good day, "+TextAdventure.name()+".\"";
   }
   if (TextAdventure.getquest()<999){
    action = ""+TextAdventure.getquest()+"Scholar";
   }
   minquest = 0;
   maxquest = 999;
  }
 }
 public String name(){
  return name;
 }
 public String description(){
  return description;
 }
 public String greeting(){
  return greeting;
 }
 public void action(){
  if (action.equals("0Scholar")){
   Background.addText("\"Have you noticed all the creatures that have begun to appear around here?\"",true);
   Background.spacer();
   Background.addText("\"Of course you have. Everyone has. It's hard not to notice that kind of thing most of the time. Regardless, I have a theory as to what their origin is.\"",true);
   Background.spacer();
   Background.addText("\"According to what I've heard, the first people to encounter them were those who often journeyed into the forest. The areas deep in the forest have never been safe, but I've been told that it has become far more dangerous recently.\"",true);
   Background.spacer();
   Background.addText("\"Now, I would like to explore this rumor myself, but I am growing old and don't think I was ever built for such excursions. Would you do me the favor of going there and figuring out more about what is going on?\"",true);
   yesno = Background.yesno();
   if (yesno){
    TextAdventure.setquest(1);
    Background.addText("\"Thank you "+TextAdventure.name()+", I look forward to seeing you again. I'll be in the hut nearby.\"",true);
    Background.spacer();
   } else {
    Background.addText("\"Oh. Well, alright then. I suppose I will forever remain in wonder.\"",true);
    Background.spacer();
    Background.addText("\"As will you.\"",true);
    Background.spacer();
   }
  } else if (action.equals("1Scholar")){
   Background.addText("\"Have you found anything interesting in the deepforest yet?\"",true);
   Background.spacer();
   Background.addText("\"No? Well come back to me when you have.\"",true);
   Background.spacer();
  } else if (action.equals("2Scholar")){
   Background.addText("\"Have you found anything interesting?\"",true);
   Background.spacer();
   Background.addText("\"Oh, what's this? This dropped from a troll?\"",true);
   Background.spacer();
   Background.addText("\"I can't understand this writing, but I think I know of a way to translate it.\"",true);
   Background.spacer();
   Background.addText("\"There should be something that could help us in the castle. Go to the library there and bring me back some books on other languages, that will get us started at least.\"",true);
   Background.spacer();
   TextAdventure.setquest(3);
   Background.addText("\"Goodbye "+TextAdventure.name()+".\"",true);
   Background.spacer();
  } else if (action.equals("3Scholar")){
   Background.addText("\"Do you have the books yet?\"",true);
   Background.spacer();
   Background.addText("\"Why not? Just go to the castle and get them.\"",true);
   Background.spacer();
  } else if (action.equals("4Scholar")){
   Background.addText("\"Do you have the books yet?\"",true);
   Background.spacer();
   Background.addText("\"Well why not?\"",true);
   Background.spacer();
   Background.addText("\"The gates are shut? Find another way in then. We need those books to translate this writing.\"",true);
   Background.spacer();
  } else if (action.equals("5Scholar")){
   Background.addText("\"You have the books I need for the translation?\"",true);
   Background.spacer();
   Background.addText("\"Ah, good, these will be quite helpful. A few of these aren't necessary, but reading them will provide me with something to do while you are away.\"",true);
   Background.spacer();
   Background.addText("\"Anyways, translating the paper will take a little while for me to complete, so go to the town and have a quick rest while you wait.\"",true);
   TextAdventure.setquest(6);
   Background.spacer();
  } else if (action.equals("6Scholar")){
   Background.addText("\"I haven't completed the translation yet. Go to the town and take a break.\"",true);
   Background.spacer();
  } else if (action.equals("7Scholar")){
   Background.addText("\"While you were resting up I was able to begin a translation of the writing you brought back from the forest.\"",true);
   Background.spacer();
   Background.addText("\"So far it appears to be orders to go aboveground and set up camp in the surrounding area. I believe that must be referring to leaving the cave in the forest, as it is the only way underground near here.\"",true);
   Background.spacer();
   Background.addText("\"Go there and explore it, see if you can find anything interesting. Come let me know what you find. Oh, and you'll most likely need a torch from the shop, it will be dark in the cave.\"",true);
   Background.spacer();
   TextAdventure.setquest(8);
  } else if (action.equals("8Scholar") || action.equals("9Scholar")){
   Background.addText("\"You're back from the cave already? I expected it to take longer than that.\"",true);
   Background.spacer();
   Background.addText("\"Go explore the entire cave, and then come back to me.\"",true);
   Background.spacer();
  } else if (action.equals("10Scholar")){
   Background.addText("\"Have you investigated the cave?\"",true);
   Background.spacer();
   Background.addText("\"What's this? Another piece of paper with that writing on it..\"",true);
   Background.spacer();
   Background.addText("\"This seems similar to the other writing you brought me. In fact, I believe it may say the very same thing.\"",true);
   Background.spacer();
   Background.addText("\"If this truly came from the cave I think you should go back and explore it further. There must be more to the cave than what you have found so far.\"",true);
   Background.spacer();
   Background.addText("\"Go to the cave and make sure you didn't miss anything. I'll be waiting here to hear what you've found.\"",true);
   Background.spacer();
   TextAdventure.setquest(11);
  } else if (action.equals("11Scholar")){
   Background.addText("\"Have you discovered anything new in the cave?\"",true);
   Background.spacer();
   Background.addText("\"What are you waiting for? I can feel a discovery in my bones.\"",true);
   Background.spacer();
  } else if (action.equals("12SCholar")){
   Background.addText("\"Did you find anything in the cave?\"",true);
   Background.spacer();
   Background.addText("\"Hm, so there was a hidden door in the back of the cave.. That is quite interesting. Go explore it!\"",true);
   Background.spacer();
  } else if (action.equals("13Scholar")){
   Background.addText("\"What did you find through the hidden door?\"",true);
   Background.spacer();
   Background.addText("\"An entire city underground.. That boggles the mind. Quite interesting though. What lived there?\"",true);
   Background.spacer();
   Background.addText("\"Tentacled creatures? Describe them some more, one of the books you had acquired may have mentioned them.\"",true);
   Background.spacer();
   Background.addText("\"Hm. This is terrible news. What you are describing is called an \"Illithid\", and they are said to be incredibly powerful psychics. From what you say, I am surprised you made it out of there intact.",true);
   Background.spacer();
   Background.addText("\"According to this book, Illithids often delete the memories and destroy the minds of humans they capture, and then use them as slaves. Do you remember ever seeing one before?\"",true);
   Background.spacer();
   Background.addText("\"There was an Illithid in the castle? Perhaps now we now know what become of those in the castle. The fact that Illithids are behind this might also provide me with a modicum of self-discovery...\"",true);
   Background.spacer();
   Background.addText("\"We might be able to find a way to retake the castle. We will need to figure out how to fight these creatures first, however.\"",true);
   Background.spacer();
   Background.addText("\"If you could sneak back into the castle and find me some books on Illithids, I may be able to find a way to prevent their paralyzing effect.\"",true);
   Background.spacer();
   Background.addText("\"Be careful, "+TextAdventure.name()+", I would hate for you to lose what is left of your mind.\"",true);
   TextAdventure.setquest(14);
   Background.spacer();
  } else if (action.equals("14Scholar")){
   Background.addText("\"Go retrieve the books from the castle library for me. Be careful though.\"",true);
   Background.spacer();
  } else if (action.equals("15Scholar")){
   Background.addText("You shouldn't have been able to escape the castle without opening the castle gates... But I must've left a loophole somehow that you got through, so congrats. You now get the castle gates open for free. Talk to me again.",true);
   TextAdventure.setquest(16);
  } else if (action.equals("16Scholar")){
   Background.addText("\"You seem to have made it back safely. Do you have the books I need?\"",true);
   Background.spacer();
   Background.addText("\"I need some time to look these over. Perhaps you could have a rest in the town and come back to me after you've done so. That should be enough time.\"",true);
   Background.spacer();
   TextAdventure.setquest(17);
  } else if (action.equals("17Scholar")){
   Background.addText("\"I still need more time to look over these books you brought me. Go have a rest in the town and come back.\"",true);
   Background.spacer();
  } else if (action.equals("18Scholar")){
   Background.addText("\"I have read through the books about the Illithid that you've brought me.\"",true);
   Background.spacer();
   Background.addText("\"They contain very little mention of how to prevent the Illithids from being able to paralyze a person, but from what information there is I believe I can piece together something.\"",true);
   Background.spacer();
   Background.addText("\"I'm going to need a fairly rare flower. You'll be able to find it in a certain valley of the mountains beyond the field. It's a lotus, and it's said to make one immune to psychic paralyzation.\"",true);
   Background.spacer();
   Background.addText("\"Go pick a few and bring them to me, then we can see about taking back the castle from the Illithids.\"",true);
   TextAdventure.setquest(19);
   Background.spacer();
  } else if (action.equals("19Scholar")){
   Background.addText("\"I need you to get me some of the lotus flowers from the mountains. Then I'll be able to make you a potion for fighting the Illithids.\"",true);
   Background.spacer();
   Background.addText("\"Hurry before they're able to reinforce the castle.\"",true);
   Background.spacer();
  } else if (action.equals("20Scholar")){
   Background.addText("\"Aww, are those flowers for me?\"",true);
   Background.spacer();
   Background.addText("\"Ok, enough with the foolishness, hand me those so I can make the potion for you.\"",true);
   Background.spacer();
   Background.addText("\"Alright, let me just add these to what I've made so far and...\"",true);
   Background.spacer();
   Background.addText("\"Here you go, drink this when you get to the castle, and it should make you immune to the Illithid's paralyzation. However I don't know how long its effects will last, so work fast.\"",true);
   Background.spacer();
   Background.addText("\"Good luck "+TextAdventure.name()+".\"",true);
   TextAdventure.setquest(21);
   Background.spacer();
  } else if (action.equals("21Scholar")){
   Background.addText("\"I've given you the potion, now go to the castle and clear out the Illithid.\"",true);
   Background.spacer();
   Background.addText("\"Good luck "+TextAdventure.name()+".\"",true);
   Background.spacer();
  } else if (action.equals("22Scholar")){
   Background.addText("\"Have you already taken the potion?\"",true);
   Background.spacer();
   Background.addText("\"The potion will only keep you safe for a short time, you must hurry to the castle before its effect wears off.\"",true);
   Background.spacer();
  } else if (action.equals("23Scholar")){
   Background.addText("\"This is certainly a lot of people who you've sent me. And all of them seem to have lost their memories because of the Illithid.\"",true);
   Background.spacer();
   Background.addText("\"I did not expect the Illithid would have so many of them in the castle, perhaps they've begun to plan something larger.\"",true);
   Background.spacer();
   Background.addText("\"You must go back to the castle and make sure you have cleaned out the Illithid, perhaps then we ourselves can use the castle instead of this tiny hut. It's far too small for this many people.\"",true);
   Background.spacer();
   Background.addText("\"Now go do that while I take care of these clueless people.\"",true);
   Background.spacer();
  } else if (action.equals("24Scholar")){
   Background.addText("\"Have you cleared the Illithid out of the castle? Is it safe now? This place is too crowded with all these people in it.\"",true);
   Background.spacer();
   Background.addText("\"Ah, that is very good to hear. Now let us go there so that I can live in a proper place again. I do believe I'd like to live up in the tower.\"",true);
   Background.spacer();
   Background.addText("\"I will see you there "+TextAdventure.name()+".\"",true);
   TextAdventure.setquest(25);
   Background.spacer();
  } else if (action.equals("25Scholar")){
   Background.addText("\"This castle seems so familiar to me, almost as I've been here before. I don't recall living here though.\"",true);
   Background.spacer();
   Background.addText("\"In fact, I don't recall anywhere that I lived before the hut. That's quite strange.\"",true);
   Background.spacer();
   Background.addText("\"Oh well, that is not what is important. What is important, however, is...\"",true);
   Background.spacer();
   Background.addText("This is currently the end of the questline. This is as far as it goes for now. Have fun wandering around and leveling up if you'd like though.",true);
   Background.spacer();
  }
 }//end of action

 public int minquest(){
  return minquest;
 }
 public int maxquest(){
  return maxquest;
 }

 static boolean yesno;
 static String choice = "";
 static String spacer = "";
 static Scanner input = new Scanner(System.in);
 static String newline = System.getProperty("line.separator");
 static String name = "";
 static String description = "";
 static String greeting = "";
 static String action = "";
 static int minquest = 0;
 static int maxquest = 999;
}