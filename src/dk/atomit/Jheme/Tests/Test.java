package dk.atomit.Jheme.Tests;

import dk.atomit.Jheme.Interpreter.Interpreter;
import dk.atomit.Jheme.Parser.Parser;
import dk.atomit.Jheme.SchemeTypes.SchemeObject;

import java.util.List;

/**
 * Created by Kristian on 6/7/2016.
 */
public class Test {

    public static void main(String[] args) {
        Parser p = new Parser();

        //p.prettyprintParsed("hello werld ;comment\n'(list)");
        //p.printParsed();
        List<SchemeObject> x = p.parse("(define x (lambda (b) (+ 1 b))) (+ x 2)");

        System.out.println(x);
        System.out.println(x.get(0).getStringValue());
        System.out.println(x.get(1).getStringValue());

        Interpreter i = new Interpreter();
        i.repl();
    }

}
