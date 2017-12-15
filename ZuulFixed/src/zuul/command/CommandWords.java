package zuul.command;

import zuul.Game;

/**
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Arun
 */

public abstract class CommandWords 
{
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
    }

    /**
     * @return the validCommands
     */
    public abstract String[] getValidCommands();
    
    /**
     * Check whether a given String is a valid command word. 
     * @param aString the possible command 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)  {
        for(String command : getValidCommands()) {
            if (command.equals(Game.messages.getString(aString)))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
