package zuul.mygame;

import zuul.Game;
import zuul.Player;
import zuul.command.Command;

/**
 * Command to give something to someone.
 * @author Arun
 */
public class GIVEcommand extends Command{
     public GIVEcommand(String firstWord, String secondWord, String thirdWord) {
        super(firstWord, secondWord, thirdWord);
    }

    public GIVEcommand() {}
     
    @Override
    public boolean execute(Player player) {
        if(!hasSecondWord()){
            Game.out.println(Game.messages.getString("giveWhat"));
            return false;
        }
        if(!hasThirdWord()){
            Game.out.println(Game.messages.getString("giveWho"));
            return false;
        }
        String desc = getSecondWord();
        String whom = getThirdWord();
        player.give(desc, whom);
        return false;
    }
}
