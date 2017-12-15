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
 * Command to go somewhere
 * @author Arun
 */
public class GOcommand extends Command{
    
     public GOcommand(String firstWord, String secondWord, String thirdWord) {
        super(firstWord, secondWord, thirdWord);
    }
     
     public GOcommand() {}

    @Override
    public boolean execute(Player player) {
        if(!hasSecondWord()){
            Game.out.println(Game.messages.getString("goWhere"));
            return false;
        }
        String direction = getSecondWord();
        player.goRoom(direction);
        return false;
    }
    
}
