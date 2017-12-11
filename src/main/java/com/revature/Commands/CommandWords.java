package com.revature.Commands;

import java.util.Set;
import java.util.HashSet;


public class CommandWords {

    private Set<String> validCommands = new HashSet<String>();

    public CommandWords() {
        validCommands.add("north");
        validCommands.add("east");
        validCommands.add("south");
        validCommands.add("west");
        validCommands.add("quit");
        validCommands.add("cry");
        validCommands.add("stop");
    }   

    public boolean isCommand(String str) {
        if (validCommands.contains(str)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void showAll() {
        for(String command: validCommands) {
            System.out.print(command + ",  ");
        }
        System.out.println();
    }
}