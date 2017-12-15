package zuul.mygame;

/**
 * This class holds an enumeration of all command words known to this particular game.
 * @author Arun
 */
public class CommandWords extends zuul.command.CommandWords{
    // an array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "look", "take", "drop", "give"
    };
    
    public CommandWords(){}
    
    /** @return the validCommands */
    @Override
    public  String[] getValidCommands() { return validCommands; }
}
