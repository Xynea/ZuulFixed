/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 * @author Arun
 */
public class Room 
{
    /** Description of the room */
    final private String description;
    /** Exits from the room */
    final private Map<String, Room> exits;   
    /** Items in the room */
    final private Map<String,Item> items;   
    /** Characters in the room */
    final private Map<String,Character> characters;
    
    /**
     * Create a room described "description". 
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new HashMap<>();
        characters = new HashMap<>();
    }
    
    /**
     * Define 4 exits of this room.
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    //@SuppressWarnings("CallToPrintStackTrace")
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        try {
	    setExit(Game.messages.getString("north"), north);
	    setExit(Game.messages.getString("east"), east);
	    setExit(Game.messages.getString("south"), south);
	    setExit(Game.messages.getString("west"), west);
	} catch (BadExitException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
    }
    
    /**
     * Add an exit. Check that neither the direction nor the room is null
     * @param direction Direction to go
     * @param room the adjoining room
     */
    public void setExit(String direction, Room room) throws BadExitException {
    	if (room == null)
    	    return;
        if (direction == null)
            throw new BadExitException(direction, room);
        exits.put(direction, room);
    }
    
    /**
     * Get the room from an exit direction
     * @param direction the direction player wants to go
     * @return the room to go to
     */
    public Room getExit(String direction) { return exits.get(direction); }
    
    /**
     * @return The description of the room.
     */
    public String getDescription() { return description; }
    
    /**
     * @return The full detail of the room.
     */
    public List<String> getDetails() {
    	List<String> detail = new LinkedList<>();
        detail.add(Game.messages.getString("in") + " " + getDescription()); 
        
        String tmp = Game.messages.getString("exits") + ": ";
        tmp = exits.keySet().stream()
                .map((dir) -> dir + ' ')
                .reduce(tmp, String::concat);
        detail.add(tmp);
        
        tmp = Game.messages.getString("items") + ": ";
        tmp = items.keySet().stream()
                .map((desc) -> desc + '(' + items.get(desc).getWeight() + ')')
                .reduce(tmp, String::concat);
        detail.add(tmp);
        
        tmp = Game.messages.getString("characters") + ": ";
        tmp = characters.keySet().stream()
                .map((desc) -> desc + ' ')
                .reduce(tmp, String::concat);    
        detail.add(tmp);
        
        return detail;
    }
    
    /**
     * Add an item to the Room
     * @param description The description of the item
     * @param weight The item's weight
     */
    public void addItem(String description, int weight) {
        addItem(description, new Item(description, weight));               
    }
    
    void addItem(String desc, Item item) { items.put(desc, item); }
    
    /**
     * Check if room contains an item
     * @param description the item
     * @return the item's weight or 0 if none
     */
    public boolean containsItem(String description) { return items.containsKey(description); }
    
    /*
     * Get an item from the room if it is there
     */
    public Item getItem(String description) { return items.get(description); }
    
    /**
     * Remove an item from the Room
     * @param description the name of the item to remove
     * @return the Item removed or null if no item of that name 
     */
    public Item removeItem(String description) {
        if (items.containsKey(description)) {
            return items.remove(description);
        }
        else {
            Game.out.println(description + " " + Game.messages.getString("room")); // is not in the room
            return null;
        }
    }

    /**
     * Get a character in the room
     * @param name the name of the Character
     * @return the character or null if no character of that name
     */
    public Character getCharacter(String name) { return characters.get(name); }

    /**
     * Add a character to this room
     * @param character the character to set
     */
    public void addCharacter(Character character) { characters.put(character.getName(),character); }
    
    /** @return A set of all the exits from this room */
    public Set<String> getAllExits() { return exits.keySet(); }

    /**
     * Remove a character from this room
     * @param name the name of the character to remove
     */
    public void removeCharacter(String name) { characters.remove(name); }

    /**
     * Is a character in the room?
     * @param charac the name of the character
     * @return true if this character is in the room
     */
    public boolean hasCharacter(String charac) { return characters.containsKey(charac); }   
    
    public void process() {
        
        for (Character ch: characters.values()) {
            ch.execute();
        }
        for (Item it : items.values()) {
            it.execute();
        }
    }
}

