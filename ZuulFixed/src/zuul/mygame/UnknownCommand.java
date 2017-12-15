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
public class UnknownCommand extends Command {
    
    public UnknownCommand(String firstWord, String secondWord, String thirdWord) {
        super(firstWord, secondWord, thirdWord);
    }
    
    public UnknownCommand() {} 

    @Override
    public boolean execute(Player player) {
        Game.out.println(Game.messages.getString("unknown"));
        return false;
    }
    
    
}
