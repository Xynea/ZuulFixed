/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul;

import java.util.Random;

/**
 * Class for characters/NPC - Non Playable Character
 * @author Arun
 */
public class Character {
    private final String name;
    private Room currentRoom;
    
    /**
     * Place a new character in a room
     * @param n the name of the character
     * @param r the room in which to place them
     */
    public Character(String n, Room r) {
        name = n;
        currentRoom = r;
    }
    
    /**
     * @return the name
     */
    public String getName() { return name; }

    /**
     * @return the room the character is in
     */
    public Room getCurrentRoom() { return currentRoom; }

    /**
     * Place the character in a room
     * @param currentRoom the currentRoom to set
     */
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }
 
    /**
     * Move the character to a randomly chosen adjacent room
     */
    public void randomMove() {
        String[] exits =  currentRoom.getAllExits().toArray(new String[0]); 
        int numExits = exits.length;
        if (numExits == 0)
            return; 	
        int n = new Random().nextInt(numExits);
        Room nextRoom = currentRoom.getExit(exits[n]);
        currentRoom.removeCharacter(name);
        nextRoom.addCharacter(this);
        currentRoom = nextRoom;
    }
    
    
    /**
     * Game-specific action 
     */
    public void execute() {}
}

