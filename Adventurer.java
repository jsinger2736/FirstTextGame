import java.io.*;

public class Adventurer{
 public Adventurer(String namec, int levelc, int expc, int healthc, int damagec, int locationc, int questc, int moneyc, int numpots1c, String weaponc, int currweapdamc){
  //the c at the end stands for constructor, the variable names just couldn't be the same
  name = namec;
  level = levelc;
  exp = expc;
  health = healthc;
  location = locationc;
  quest = questc;
  money = moneyc;
  numpots1 = numpots1c;
  weapon = weaponc;
  currweapdam = currweapdamc;
  maxhealth=4*level+16;
  if (health==0){
   health=maxhealth;}
  if (damagec==0){
   damage=1*level+2;
  } else {
   damage = damagec;
  }
 }
 public String name(){
  return name;
 }
 public void damagetaken(int damagetaken){
  health=health-damagetaken;
  if (health<0){
   health=0;}
 }
 public int damagedoes(){
  return damage;
 }
 public void damageinc(int damageinc){
  damage = damage + damageinc;
  currweapdam = damageinc;
 }
 public int currweapdam(){
  return currweapdam;
 }
 public void damagedec(int damagedec){
  damage = damage - damagedec;
 }
 public int maxhealth(){
  return maxhealth;
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
 public void setlocation(int newplace){
  location = newplace;
 }
 public int getlocation(){
  return location;
 }
 public void setquest(int newquest){
  quest = newquest;
 }
 public int getquest(){
  return quest;
 }
 public int level(){
  return level;
 }
 public void addmoney(int newmoney){
  money = money + newmoney;
 }
 public int moneyamnt(){
  return money;
 }
 public boolean takemoney(int moneytaken){
  if (money>=moneytaken){
   money = money - moneytaken;
   Background.game.makeMessage("Item Bought","Transaction processed.");
   return true;
  } else if (money<moneytaken){
   Background.game.makeMessage("Lack Of Gold","You don't have enough gold.");
   return false;
  }
  System.out.println("Something went wrong in Adventurer.takemoney, sorry bout that.");
  return false;
 }
 public int numpots(){
  return numpots1;
 }
 public void addpots(int newpots){
  numpots1 = numpots1 + newpots;
  //System.out.println("You have a total of "+numpots1+" potions.");
 }
 public String weapon(){
  return weapon;
 }
 public void changeweapon(String newweapon){
  weapon = newweapon;
 }
 public String potion(int number, int strength){ //using potions to heal
  if (strength==1){
   if (number>numpots1){
    number=numpots1;}
   if (number==0){
    return "Sorry, you currently have no potions.";}
   health=health+number*6;
   numpots1=numpots1-number;
   if (health>=maxhealth){
    health=maxhealth;
    return "You're back to full health!";
   } else if (health<maxhealth){
    return "You gained "+number*6+" health!";}
  }
   return "Potions didn't work for some reason, fix it.";
 }
 public void rest(){ //heals to full health
  health = maxhealth;
 }
 public int expneeded(){
  return (15+10*level)-exp;
 }
 public void experience(int expgain){
  exp=exp+expgain;
  boolean levelcounter = true; //used to break while loop of leveling
  int explevel = 0; //used to calculate when adventurer goes up a level
  int levelup = level; //used to check to see if a new level was gained
  while (levelcounter){
   explevel = exp - (15+9*level);
   if (explevel>=0){
    level = level + 1;
    damage = damage + 1;
    maxhealth = maxhealth + 4;
    health = health + 4;
    exp = explevel; //subtracts experience used to level up
   } else if (explevel<0){
    levelcounter = false;}
  }
  if (levelup!=level){ //if adventurer levels up, this tells them their new level
   int levelgain = level - levelup;
   int healthgain = 4*levelgain;
   int damagegain = 1*levelgain;
   Background.addText("You are now level "+level+"! You gained "+healthgain+" health and do "+damagegain+" more damage!",true);
   int neededexp = -(exp-(15+9*level));
   int nextlevel = level + 1;
   //System.out.println("You need "+neededexp+" more experience to get to level "+nextlevel+".");
  }
 }

 /* Perhaps spells will go here one day */
 /*                                     */
 /*                                     */
 /*                                     */

 //here's my attempt at saving
 public void save(){
  String newline = System.getProperty("line.separator");
  FileWriter fWriter = null;
  BufferedWriter writer = null;
  try {
   fWriter = new FileWriter("SaveFiles/"+name+".txt", false);
   writer = new BufferedWriter(fWriter);
   //next line is writing each input to Adventurer() on a separate line
   writer.write(name+newline+level+newline+exp+newline+health+newline+damage+newline+location+newline+quest+newline+money+newline+numpots1+newline+weapon+newline+currweapdam);
   writer.close();
   Background.game.makeMessage("Save","Game saved.");
  } catch (Exception e) {
   Background.game.makeMessage("Error","Most likely the folder \"SaveFiles\" has been deleted. Saving will not work\nwithout that folder, so please create one in the same folder as this game.\nIf \"SaveFiles\" is there and you are still getting this message, let me know.\n -Jimmy");
  }
 }
 


 public int speed = 2;
 public double acc = .9;
 public double hitbox = .95;

 //default stuff for constructor
 public static String name = "";
 public static int level = 1;
 public static int exp = 0;
 public static int maxhealth = 0;
 public static int health = 0;
 public static int damage = 0;
 public static int location = 0;
 public static int quest = 0;
 public static int money = 0;
 public static int numpots1 = 0;
 public static String weapon = "chain";
 public static int currweapdam = 0;
}

