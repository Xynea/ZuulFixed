/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul.mygame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import zuul.Game;
import zuul.Room;
import zuul.Character;
import zuul.Player;
/**
 *
 * @author Arun
 */
public class MyGame extends Game{
    
    public MyGame(String language, String country) {
	super(language, country, new zuul.mygame.CommandWords());
    }

    @Override
    protected void createRooms() {
        Room outside, theatre, pub, lab, office;
        allRooms = new ArrayList<>();
        
        // creating rooms
        outside = new Room(messages.getString("outside")); // outside the main entrance of the university
        allRooms.add(outside);
        theatre = new Room(messages.getString("lecture")); // in a lecture theatre
        allRooms.add(theatre);
        pub = new Room(messages.getString("pub")); // in the campus pub
        allRooms.add(pub);
        lab = new Room(messages.getString("lab")); // in a computing lab
        allRooms.add(lab);
        office = new Room(messages.getString("admin")); // in the computing admin office
        allRooms.add(office);
        
        // initialising room exits
        outside.setExits(null, theatre, lab, pub);
        outside.addItem(messages.getString("notebook"), 2);
        theatre.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);
        
        // add a character/non playable character
        lab.addCharacter(new Character(messages.getString("Andy"), lab){
            @Override
            public void execute(){
                randomMove();
            }
        });
        
        setAllRooms(allRooms);
        setPlayer(new Player(messages.getString("me"),outside));
    }

    @Override
    protected List<String> getWelcomeStrings() {
        List<String> welcomeDesc = new LinkedList<>();
        welcomeDesc.add("");
        welcomeDesc.add(messages.getString("welcome"));
        welcomeDesc.add(messages.getString("zuul"));
        welcomeDesc.add(messages.getString("getHelp"));
        welcomeDesc.add("");
        welcomeDesc.addAll(getPlayer().getDetails());
        return welcomeDesc;        
    }
    
}
