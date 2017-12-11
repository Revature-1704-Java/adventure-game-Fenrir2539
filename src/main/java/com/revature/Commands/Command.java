package com.revature.Commands;

public class Command {
    private String command;

    public Command(String str) {
        this.command = str;
    }

    public String getString() {
        return command;
    }
}