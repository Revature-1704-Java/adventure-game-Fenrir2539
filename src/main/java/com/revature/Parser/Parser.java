package com.revature.Parser;

import com.revature.Commands.Command;
import com.revature.Commands.CommandWords;
import java.util.Scanner;

public class Parser {
    private CommandWords commandSet;
    private Scanner scanner;
    private Command command;

    public Parser() {
        commandSet = new CommandWords();
        scanner = new Scanner(System.in);
    }

    //Rewrite to return a command
    public Command parseInput() {
        String userInput = "";
        boolean inValidCommand = true;

        while(inValidCommand) {
            
            System.out.print("> ");
            userInput = scanner.nextLine().toLowerCase();
            if (commandSet.isCommand(userInput)) {
                break;
            }
            else {
                System.out.println("Garbage in, Garbage out");
            }  
        }
        //rewrite
        return command = new Command(userInput);
    }
}