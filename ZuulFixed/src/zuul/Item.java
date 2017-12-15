package zuul;

/**
 * Item class - items in the game
 * @author Arun
 */
public class Item {
    private final String description;
    private final int weight;
    
    /**
     * Constructor for an Item
     * @param desc The item's description
     * @param w the item's weight
     */
    public Item (String desc, int w) {
        description = desc;
        weight = w;
    }
    
     /**
     * Return description of an item
     * @return the description
     */
    public String getDescription() { return description; }

    /**
     * Return weight of an item
     * @return the weight
     */
    public int getWeight() { return weight; }
    
    /**
     *  Make the item change state in some way.
     *  Default: do nothing
     */
    public void execute() {}
}

