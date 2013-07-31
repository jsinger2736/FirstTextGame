import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class GUIAdventure extends JFrame{
 private JPanel north, east, eastgrid, west, south, center, centertop, centertop2, centerbot;
 private JMenuBar menubar;
 private JMenu file, info, extra;
 private JMenuItem restart, save, load, exit, gameinfo, hint, iteminfo;
 public JTextArea centerTA;
 private JScrollPane centerSP;
 private JLabel name, level, experience, health, mana, damage, weapon, money, potions;
 private JButton[] buttons;
 private southButtonHandler southHandler;
 private menuItemHandler menuHandler;
 //private static Adventurer player;

 public GUIAdventure(){
  Container container = getContentPane();
  container.setLayout(new BorderLayout());

  centerTA = new JTextArea(/*"Hello and welcome to GUIAdventure.",*/ 6, 30);
  centerTA.setEditable(false);
  centerTA.setLineWrap(true);
  centerTA.setWrapStyleWord(true);
  centerSP = new JScrollPane(centerTA,
   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
   JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  name = new JLabel("Bob the Builder and Destroyer");
  name.setPreferredSize(new Dimension(250,20));
  centertop = new JPanel();
  centertop.setLayout(new BoxLayout(centertop, BoxLayout.LINE_AXIS));
  north = new JPanel();
  north.add(new JLabel("      Name: ", SwingConstants.RIGHT));
  north.add(name);
  container.add(north, BorderLayout.NORTH);
  centertop2 = new JPanel();
  centertop2.setLayout(new BorderLayout());
  centertop2.add(centertop, BorderLayout.CENTER);
  center = new JPanel();
  center.setLayout(new BorderLayout());
  center.add(centertop2, BorderLayout.NORTH);
  center.add(centerSP, BorderLayout.CENTER);
  container.add(center, BorderLayout.CENTER);

  level = new JLabel("");
  experience = new JLabel("");
  health = new JLabel("");
  mana = new JLabel("");
  damage = new JLabel("");
  weapon = new JLabel("");
  money = new JLabel("");
  potions = new JLabel("");
  eastgrid = new JPanel();
  eastgrid.setLayout(new GridLayout(7,2,10,5));
  eastgrid.add(new JLabel("Level: ", SwingConstants.RIGHT));
  eastgrid.add(level);
  eastgrid.add(new JLabel("Experience: ", SwingConstants.RIGHT));
  eastgrid.add(experience);
  eastgrid.add(new JLabel("Health: ", SwingConstants.RIGHT));
  eastgrid.add(health);
  //eastgrid.add(new JLabel("Mana: ", SwingConstants.RIGHT));
  //eastgrid.add(mana);
  eastgrid.add(new JLabel("Damage: ", SwingConstants.RIGHT));
  eastgrid.add(damage);
  eastgrid.add(new JLabel("Weapon: ",SwingConstants.RIGHT));
  eastgrid.add(weapon);
  eastgrid.add(new JLabel("Money: ", SwingConstants.RIGHT));
  eastgrid.add(money);
  eastgrid.add(new JLabel("Potions: ", SwingConstants.RIGHT));
  eastgrid.add(potions);
  east = new JPanel();
  east.add(eastgrid);
  container.add(east, BorderLayout.EAST);

  container.add(new JLabel("   "), BorderLayout.WEST);

  southHandler = new southButtonHandler();
  south = new JPanel();
  south.setLayout(new GridLayout(2,3,10,10));
  buttons = new JButton[6];
  for (int i=0; i<6; i++){
   buttons[i] = new JButton(" ");
   buttons[i].addActionListener(southHandler);
   south.add(buttons[i]);
  }
  south.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
  center.add(south, BorderLayout.SOUTH);

  container.add(new JLabel(" "), BorderLayout.SOUTH);

  menuHandler = new menuItemHandler();
  menubar = new JMenuBar();
  file = new JMenu("File");
  restart = new JMenuItem("New Game");
  restart.addActionListener(menuHandler);
  save = new JMenuItem("Save Game");
  save.addActionListener(menuHandler);
  load = new JMenuItem("Load Game");
  load.addActionListener(menuHandler);
  exit = new JMenuItem("Exit");
  exit.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e){
    System.exit(0);
   }
  });
  file.add(restart);
  file.add(save);
  file.add(load);
  file.add(exit);
  info = new JMenu("Info");
  gameinfo = new JMenuItem("Game Info");
  gameinfo.addActionListener(menuHandler);
  iteminfo = new JMenuItem("Item Info");
  iteminfo.addActionListener(menuHandler);
  info.add(gameinfo);
  info.add(iteminfo);
  extra = new JMenu("Extra");
  hint = new JMenuItem("Hint");
  hint.addActionListener(menuHandler);
  extra.add(hint);
  menubar.add(file);
  menubar.add(info);
  menubar.add(extra);
  setJMenuBar(menubar);

  setTitle("TextAdventure");
  update();
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  pack();
  setLocationRelativeTo(null);
  setVisible(true);
 } 

 public void setButton(int numbah, String newbutton){
  for (int i=0; i<6; i++){
   if (numbah==i+1){
    buttons[i].setText(newbutton);
   }
  }
 }

 private class southButtonHandler implements ActionListener{
  public void actionPerformed(ActionEvent e){
   Object source = e.getSource();
   for (int i=0; i<6; i++){
    if (source == buttons[i]){
     //System.out.println(i+1);
     //Background.addText(Integer.toString(i+1),true);
     Background.buttonClicked(i+1);
    }
   }
   update();
  }
 }

 private class menuItemHandler implements ActionListener{
  public void actionPerformed(ActionEvent e){
   Object source = e.getSource();
   if (source == restart){
    //System.out.println("restart");
    makeMessage("Restart Game","The ability to start a new game while the program is running is currently unavailable.\nIn order to start a new game you must restart the program. Sorry for the inconvenience.");
    //Background.restart();
   } else if (source == save){
    //System.out.println("save");
    Background.player.save();
    //Background.addText("Game saved.",true);
   } else if (source == load){
    //System.out.println("load");
    makeMessage("Load Game","While I will improve the loading eventually, I have not done so yet.\nIn order to load a game, you must restart the program.\nSorry for the inconvenience.");
    /*String str = JOptionPane.showInputDialog(null,"Type file to load: ","Load Game",1);
    if (str!=null){
     load(str);
     System.out.println("Loaded.");
    }*/
   } else if (source == gameinfo){
    makeMessage("Information about TextAdventure","TextAdventure started out as a game on the command prompt in early 2013,\nbut two months later was transferred into this gui. Hopefully you enjoy the game.\nTextAdventure was created and coded by Jimmy.\nThis version was finished April 18, 2013.\nIt's still rough around the edges.");
   } else if (source == hint){
    TextAdventure.hint(Background.player.quest);
   } else if (source == iteminfo){
    String message = "";
    if (Background.player.level<2){
     makeMessage("Item Info", "There are currently no items in the store.");
    } else {
     for (int i=1; i<Background.player.level+1; i++){
      Items item = new Items(i);
      if (item.type.equals("quest")){
       if (item.quest==Background.player.quest){
        message = message+item.name+" costs: "+item.cost+"    Description: "+item.description+"\n";
       }
      } else if (Background.player.level>=item.level && Background.player.level<item.maxlevel){
       message = message+item.name+" costs: "+item.cost+"    Description: "+item.description+"\n"; 
      }
     }
     makeMessage("Item Info",message);
    }
   }
   update();
  }
 }

 public void makeMessage(String title, String message){
  JOptionPane.showMessageDialog(null, message, title, 1);
 }

 public void update(){
  name.setText(Background.player.name);
  level.setText(Integer.toString(Background.player.level));
  experience.setText(Integer.toString(Background.player.exp)+"/"+Integer.toString(15+9*Background.player.level));
  health.setText(Integer.toString(Background.player.health)+"/"+Integer.toString(Background.player.maxhealth));
  //mana.setText("0/0");
  damage.setText(Integer.toString(Background.player.damage));
  weapon.setText(Background.player.weapon);
  money.setText(Integer.toString(Background.player.money));
  potions.setText(Integer.toString(Background.player.numpots1));
 }

 public String itemlist(){
  ArrayList<String> choicesal = new ArrayList<String>();
  if (Background.player.level>1){
   int counter = 0;
   while (true){
    counter++;
    Items item = new Items(counter);
    if (Background.player.level>=item.level && Background.player.level<item.maxlevel){
     if (item.type().equals("quest")){
      if (Background.player.quest!=item.quest()){
       continue;
      }
     }
     choicesal.add(item.name);
    } else if (Background.player.level<item.level){
     break;
    } /*else{
     break;
    }*/
   }
   String[] choices = new String[choicesal.size()+1];
   for (int i=0; i<choices.length-1; i++){
    choices[i] = choicesal.get(i);
   }
   choices[choicesal.size()]="exit";
   String input = (String)JOptionPane.showInputDialog(null,
    "Welcome to the store!\n Select an item from the list",
    "Store", JOptionPane.PLAIN_MESSAGE, null, choices, choices[choicesal.size()]);
   return input;
  } else {
   makeMessage("Store","There are currently no items in the shop.");
   return "exit";
  }
 }

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
   Background.player = new Adventurer(name, level, exp, health, damage, location, quest, money, numpots1, weapon, currweapdam);
  } catch(Exception e){
   System.err.println("Error: "+e.getMessage());
   Background.game.makeMessage("Error","Save file was not found.\nThe save file as you typed it either does not exist or has been moved.");
   //System.exit(0);
  }
 }

 public static void main(String[] args){
  
  //player = new Adventurer("playername",1,0,0,0,1,0,0,0,"chain",0);
  GUIAdventure game = new GUIAdventure();
 }

}