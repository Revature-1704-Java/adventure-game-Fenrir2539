package com.revature;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import com.revature.Commands.Command;
import com.revature.Commands.CommandWords;
import com.revature.FileIO.FileIO;
import com.revature.Parser.Parser;
import com.revature.Player.Player;
import com.revature.Rooms.Room;
import com.revature.Rooms.EventRoom;
import com.revature.Rooms.DeathRoom;
import com.revature.Rooms.VictoryRoom;
import java.util.HashSet;
import java.util.Locale;

public class App 
{
    private Parser parser;
    private boolean isDead;
    private boolean isQuit;
    private boolean isWinRar;
    private Set<Room> visitedRooms;
    private Player player;
    private Room roomOne, roomFive;
    private EventRoom roomTwo, roomThree, roomFour, roomSeven, roomEight;
    private DeathRoom roomSix;
    private VictoryRoom roomNine;
    private static ResourceBundle messages;
    private CommandWords commandWords;
    private Scanner nameScanner;

    
    public static void main(String[] args)
    {  
        //Localization logic
        String language = new String("en");
        String country = new String("US");
        Locale currentLocale;
        currentLocale = new Locale(language, country);
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        //end localization

        //Setup player

        //Play Game
        App game  = new App();
        game.play();  

    } //Main

    public App() {
        initRooms();
        parser = new Parser();
    }

    public void initRooms() {
        
          // create the rooms
        roomOne = new Room(messages.getString("roomOne"));
        roomTwo = new EventRoom(messages.getString("roomTwo"));
        roomThree = new EventRoom(messages.getString("roomThree"));
        roomFour = new EventRoom(messages.getString("roomFour"));
        roomFive = new Room(messages.getString("roomFive"));
        roomSix = new DeathRoom(messages.getString("roomSix"));
        roomSeven = new EventRoom(messages.getString("roomSeven"));
        roomEight = new EventRoom(messages.getString("roomEight"));
        roomNine = new VictoryRoom(messages.getString("roomNine"));

        // initialise room exits
        roomOne.setExits("east", roomTwo);
        roomOne.setExits("south", roomFour);
        roomOne.setType("normal");

        roomTwo.setExits("east", roomThree);
        roomTwo.setExits("south", roomFive);
        roomTwo.setExits("west", roomOne);
        roomTwo.setType("event");

        roomThree.setExits("west", roomTwo);
        roomThree.setExits("south", roomSix);
        roomThree.setType("event");
        roomThree.setIsLoseHP(false);

        roomFour.setExits("north", roomOne);
        roomFour.setExits("east", roomFive);
        roomFour.setExits("south", roomSeven);
        roomFour.setType("event");

        roomFive.setExits("north", roomTwo);
        roomFive.setExits("east", roomSix);
        roomFive.setExits("south", roomEight);
        roomFive.setExits("west", roomFour);
        roomFive.setType("normal");

        roomSix.setExits("north", roomThree);
        roomSix.setExits("south", roomNine);
        roomSix.setExits("west", roomFive);
        roomSix.setType("death");

        roomSeven.setExits("north", roomFour);
        roomSeven.setExits("east", roomEight);
        roomSeven.setType("event");
        roomSeven.setIsLoseHP(false);

        roomEight.setExits("north", roomFive);
        roomEight.setExits("east", roomNine);
        roomEight.setExits("west", roomSeven);
        roomEight.setType("event");

        roomNine.setExits("north", roomSix);
        roomNine.setExits("west", roomEight);
        roomNine.setType("victory");

        player = new Player();
        System.out.print("Enter Name: ");
        nameScanner = new Scanner(System.in);
        String userInput = nameScanner.nextLine();
        player.setName(userInput);

      }

      public void play() {

        visitedRooms = new HashSet<Room>();
        player.setCurrentRoom(roomOne);
        visitedRooms.add(player.getCurrentRoom());
        commandWords = new CommandWords();
        System.out.println(messages.getString("startGame"));
        System.out.println(messages.getString("roomOne"));
		
		boolean finished = false;
		while(!finished) {
            Command command = parser.parseInput();
            finished = processCommand(command);
            if (player.getHealth() <= 0) {
                isDead =true;
            }
            if(player.getCurrentRoom().getType().equals("death")) {
                isDead = true;
            }
			if (isDead) {break;}
            if (isQuit) {break;}
            if (isWinRar) {break;}
			if(visitedRooms.size() == 6) {
                System.out.println("Victory Room unlocked");
                roomNine.setIsLocked(false);
			}
		}
		if (isDead) {
			System.out.println("How did you die it is so easy!!!");
		}
		else if (isQuit) {
            System.out.println("Quitter!");
		}
		else {
			System.out.println("Good job, you did it");
        }
        
        //Write, Read and Display Scores
        FileIO fileIO= new FileIO();
        fileIO.writeScore(player.getName(), player.getScore());        
        fileIO.readScores();
        nameScanner.close();
    }
    
    public boolean processCommand (Command command) {
        boolean wantToQuit = false; 
        if(!commandWords.isCommand(command.getString())) {
            System.out.println("Garbage In, Garbage Out");
            return false;
        }

        if (command.getString().equals("help")) {
            printHelp();
        }
        else if (command.getString().equals("stop")) {
            System.out.println("You skin crawls, you feel if you stop something terrible will happen");
        }
        else if (command.getString().equals("quit")) {
            isQuit = true;
        }
        else if (command.getString().equals("cry")) {
            System.out.println("Boo-Hoo");
        }
        else if (command.getString().equals("north") | command.getString().equals("east")
        | command.getString().equals("south") | command.getString().equals("west")) {
            move(command);
        }

        // else command not recognized.
        return wantToQuit;
    }
	
    public void move(Command command) { 

        String direction = command.getString();
        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExits(direction);


        if (nextRoom == null) {
            System.out.println("Brick WALL!");
        }
        else {
            //Logic for event rooms
            if(nextRoom.getType().equals("event")) {
                EventRoom specialRoom = (EventRoom) nextRoom;
                if (specialRoom.getIsLoseHP()){
                    player.setHealth((short) (player.getHealth() - 20));
                }
                else {
                    player.setHealth((short) (player.getHealth() + 5));
                }
            }
            //Logic for Victory Room
            if(nextRoom.getType().equals("victory")) {
                VictoryRoom specialRoom = (VictoryRoom) nextRoom;
                if (specialRoom.getIsLocked()){
                    System.out.println("As you enter you are thrown back into the previous room");
                    nextRoom = player.getCurrentRoom();
                }
                else {
                    isWinRar = true;
                }
            }

            visitedRooms.add(player.getCurrentRoom());
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getDesc());
            if (visitedRooms.contains(player.getCurrentRoom())) {
            	System.out.println("This room seems familiar");	
            }
            else {
                player.setScore((short)(player.getScore() + 10));
            }
        }
        
    }
    
    public void printHelp() {
        System.out.println("This ain't free you know... Tip line is $9.99/min");
        System.out.println();
        commandWords.showAll();
    }
}
