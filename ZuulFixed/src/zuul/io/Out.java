package zuul.io;

import java.util.List;

/**
 *
 * @author Arun
 */
public class Out {
    
    public Out(){
    }
    
    public void print(List<String> msg){
        msg.stream()
                .forEach((str)-> { System.out.println(str); });
    }
    
     /**
     * Print a message
     * @param str the message to print
     */
    public void print(String str) {
        System.out.print(str);
    }

    /**
     * Print a message
     *
     * @param str the message to print
     */
    public void println(String str) {
        System.out.println(str);
    }
}
