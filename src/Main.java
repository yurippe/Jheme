import dk.atomit.Jheme.Interpreter.Interpreter;


/**
 * Created by Kristian on 6/25/2016.
 */
public class Main {

    public static void main(String[] args) {

        Interpreter i = new Interpreter();
        System.out.println("Jheme " + Interpreter.VERSION + " <by Kristian Gausel>\n");
        i.repl(">> ");


    }

}
