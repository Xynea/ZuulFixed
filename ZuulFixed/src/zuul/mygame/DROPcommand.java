package zuul.mygame;

import zuul.Game;
import zuul.Player;
import zuul.command.Command;

/**
 * Command to drop an item.
 * @author Arun
 */
public class DROPcommand extends Command {
    
    public DROPcommand(String firstWord, String secondWord, String thirdWord){
        super(firstWord, secondWord, thirdWord);
    }
    
    public DROPcommand() {}

    @Override
    public boolean execute(Player player) {
        if(!hasSecondWord()){
            Game.out.println(Game.messages.getString("dropWhat"));
            return false;
        }
        String desc = getSecondWord();
        player.drop(desc);
        return false;
    }
    
    
}
