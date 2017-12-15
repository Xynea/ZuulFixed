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
 * Command to get help
 * @author Arun
 */
public class HELPcommand extends Command {
    
    public HELPcommand(String firstWord, String secondWord, String thirdWord) {
        super(firstWord, secondWord, thirdWord);
    }
    
    public HELPcommand() {}
    
    @Override
    public boolean execute(Player player) {
        for(String str : getInstructions())
            Game.out.println(str);
        return false;
    }
    
    private String[] getInstructions(){
        String[] helpDesc = new String[4];
        helpDesc[0] = Game.messages.getString("lost");
        helpDesc[1] = "";
        helpDesc[2] = Game.messages.getString("commands");
        String tmp =  " ";
        for(String cmd : Game.commands.getValidCommands())
            tmp += cmd + ' ';
        helpDesc[3] = tmp;
        return helpDesc;
    }
    
}
