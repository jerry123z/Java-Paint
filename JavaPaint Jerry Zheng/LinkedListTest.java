import java.util.Scanner;
 
class LinkedListTest {
    public static void main( String[] args ) {        
        String command;
        Scanner keyInput = new Scanner(System.in);
        LinkedList<String> myList = new LinkedList<String>();
         
        while (true) {
            System.out.printf( "\nList Empty? %b   List Size? %d   %s\n", myList.isEmpty(), myList.size(), myList );
            System.out.print("Command >");
            command = keyInput.nextLine().toLowerCase().trim();
            if (command.startsWith("add")) {
                myList.addFront(command.substring(4));
                System.out.println( "Added to front: " + myList.first() );
            }
            else if (command.startsWith("rem")) {
                System.out.println( "Removed from front: " + myList.removeFront() );
            }
            else if (command.startsWith("con")) {
                System.out.println( "Contains \"" + command.substring(4) +"\"? " + myList.contains(command.substring(4)) );
            }
            else if (command.startsWith("ins")) {
                myList.insert(command.substring(4));
                System.out.println( "Inserted in order: " + command.substring(4) );
            }
            else if (command.startsWith("kill")) {
                myList.makeEmpty();
                System.out.println( "Emptied List: " + myList );
            }
            else if (command.startsWith("quit")) {
                System.out.println( "Bye-Bye!");
                break;
            }
            else {
                System.out.println( "I don't understand \""+command+"\".  Please use: add X, rem, con X, ins X, del X, kill, or quit" );
            }
        }
    }
}