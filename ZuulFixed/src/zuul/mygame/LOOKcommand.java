/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul.mygame;

import zuul.Game;
import zuul.Player;
import zuul.command.Command;

/**
 * Command to look at the room
 * @author Arun
 */
public class LOOKcommand extends Command{
    
    public LOOKcommand(String firstWord, String secondWord, String thirdWord) {
        super(firstWord, secondWord, thirdWord);
    }
    
    public LOOKcommand() {}
    
    @Override
    public boolean execute(Player player) {
        if(hasSecondWord()){
            Game.out.println(Game.messages.getString("lookWhat"));
            return false;
        }
        player.look();
        return false;
    }
    
}
