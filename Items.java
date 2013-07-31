public class Items{
 public Items(int ident){
  if (ident==1){
   identity = ident;
   type = "quest";
   name = "torch";
   level = 0;
   maxlevel = 999;
   quest = 8;
   cost = 20;
   sell = 0;
   damage = 0;
   description = "Lights up dark places";
  } else if (ident==2){
   identity = ident;
   type = "item";
   name = "potion";
   level = 2;
   maxlevel = 999;
   quest = 0;
   cost = 15;
   sell = 5;
   damage = 0;
   description = "Heals for 6 health";
  } else if (ident==3){
   identity = ident;
   type = "weapon";
   name = "woodenclub";
   level = 3;
   maxlevel = 10;
   quest = 0;
   cost = 30;
   sell = 10;
   damage = 1;
   description = "Does 1 extra damage";
  } else if (ident==4){
   identity = ident;
   type = "weapon";
   name = "bronzedagger";
   level = 5;
   maxlevel = 12;
   quest = 0;
   cost = 50;
   sell = 16;
   damage = 2;
   description = "Does 2 extra damage";
  } else if (ident==5){
   identity = ident;
   type = "weapon";
   name = "ironsword";
   level = 8;
   maxlevel = 15;
   quest = 0;
   cost = 100;
   sell = 35;
   damage = 4;
   description = "Does 4 extra damage";
  } else if (ident==6){
   identity = ident;
   type = "weapon";
   name = "bonescythe";
   level = 10;
   maxlevel = 18;
   quest = 0;
   cost = 150;
   sell = 50;
   damage = 6;
   description = "Does 6 extra damage";
  } else if (ident==7){
   identity = ident;
   type = "weapon";
   name = "freewilly";
   level = 15;
   maxlevel = 25;
   quest = 0;
   cost = 300;
   sell = 100;
   damage = 15;
   description = "Does 15 extra damage";
  } else if (ident==8){
   identity = ident;
   type = "item";
   name = "unreachable";
   level = 997;
   maxlevel = 998;
   quest = 0;
   cost = 300;
   sell = 100;
   damage = 0;
   description = "You shouldn't be able to buy this";
  }
 }
 public int identity(){
  return identity;
 }
 public String type(){
  return type;
 }
 public String name(){
  return name;
 }
 public int level(){
  return level;
 }
 public int maxlevel(){
  return maxlevel;
 }
 public int quest(){
  return quest;
 }
 public int cost(){
  return cost;
 }
 public int sell(){
  return sell;
 }
 public int damage(){
  return damage;
 }
 public String description(){
  return description;
 }
 static int identity = 0;
 static String type = "";
 static String name = "";
 static int level = 0;
 static int maxlevel = 999;
 static int quest = 0;
 static int cost = 0;
 static int sell = 0;
 static int damage = 0;
 static String description = "";
 }