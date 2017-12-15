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
 *
 * @author Arun
 */
public class QUITcommand extends Command {
    
    public QUITcommand(String firstWord, String secondWord, String thirdWord) {
        super(firstWord, secondWord, thirdWord);
    }
    
    public QUITcommand() {}

    @Override
    public boolean execute(Player player) {
        if(hasSecondWord()){
            Game.out.println(Game.messages.getString("quitWhat"));
            return false;
        }
        return true;
    }
    
}
