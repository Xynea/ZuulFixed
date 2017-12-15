/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul.command;

import java.util.MissingResourceException;
import java.util.Scanner;
import zuul.Game;
import zuul.mygame.UnknownCommand;

/**
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * @author Arun
 */
public class Parser {
    private final CommandWords commands;
    private final Scanner reader;
    private final String MYPACKAGE;
    
    /**
     * Create a parser to read from the terminal window.
     * @param pkg the package of command classes
     */
    public Parser(String pkg) {
        this.commands = Game.commands;
        reader = new Scanner(Game.in.in);
        MYPACKAGE = pkg + '.';
    }
    
    /**
     * @return The next command from the user.
     */
    public Command getCommand() {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;
        String word3 = null;

        Game.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        try ( // Find up to two words on the line.
                Scanner tokenizer = new Scanner(inputLine)) {
                if(tokenizer.hasNext()) {
                    word1 = tokenizer.next();      // get first word
                    if(tokenizer.hasNext()) {
                        word2 = tokenizer.next();      // get next word
                    }
                    if(tokenizer.hasNext()) {
                        word3 = tokenizer.next();      // get next word
                        
                    }
                }
        }

        // Check if word is known, if true create a command with the word
        // else create a "null command"
        try {
            word1 = Game.messages.getString(word1); // translate it
        }
        catch (MissingResourceException | NullPointerException e) {
            return new UnknownCommand(word1, word2, word3);
        }
        if(commands.isCommand(word1)) {
            String cmdString = MYPACKAGE + word1.toUpperCase() + "command";
            try {
                Command cmd = (Command) Class.forName(cmdString).newInstance();
                cmd.addWords(word1, word2, word3);
                //Could use the Constructor class but this is easier
                return cmd;
           }
            catch (ClassNotFoundException  
                   | InstantiationException 
                   | IllegalAccessException 
                   | SecurityException  
                   | IllegalArgumentException 
                   e ) 
            { 
                return new UnknownCommand(word1, word2, word3);
            } 
        }
        else {
            return new UnknownCommand(word1, word2, word3); 
        }
    }
}


