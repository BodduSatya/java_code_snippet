import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExceptionExample {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("One");
        myList.add("Two");

        /*
        // Modifying Collection During Iteration:
        for (String item : myList) {
            if (item.equals("Two")) {
                myList.remove(item); // ConcurrentModificationException here
            }
        }*/

        //To avoid ConcurrentModificationException, consider the following strategies:

        /*
        //1. Use Iterator Explicitly:
        Iterator<String> iterator = myList.iterator();
        while(iterator.hasNext()){
            String item = (String) iterator.next();
            if (item.equals("Two")) {
                iterator.remove(); // ConcurrentModificationException here
            }
        }
        System.out.println("myList = " + myList);
        */


        /*//2. Copy the Collection:
        List<String> copyList = new ArrayList<>(myList);
        for (String item : copyList) {
            if (item.equals("Two")) {
                myList.remove(item);
            }
        }
        System.out.println("myList = " + myList);*/

        /*//3. Use Concurrent Collections:
        myList = new CopyOnWriteArrayList<>();
        myList.add("One");
        myList.add("Two");

        for (String item : myList) {
            if (item.equals("Two")) {
                myList.remove(item); // No ConcurrentModificationException here
            }
        }*/

 

    }
}
