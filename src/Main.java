import dk.atomit.Jheme.Interpreter.Interpreter;


/**
 * Created by Kristian on 6/25/2016.
 */
public class Main {

    public static void main(String[] args) {

        Interpreter i = new Interpreter();
        System.out.println("   __  _                         \n"        +
                           "   \\ \\| |__   ___ _ __ ___   ___ \n"      +
                           "    \\ \\ '_ \\ / _ \\ '_ ` _ \\ / _ \\\n"  +
                           " /\\_/ / | | |  __/ | | | | |  __/\n"       +
                           " \\___/|_| |_|\\___|_| |_| |_|\\___|\n");


        System.out.println("Jheme v" + Interpreter.VERSION + " <by Kristian Gausel>\n");
        i.repl(">> ");


    }

}
