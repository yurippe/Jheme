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

        LambdaTests.test();

        System.out.println("PASSED ALL TESTS");

        Interpreter i = new Interpreter();
        System.out.println("Jheme v0.01 <by Kristian Gausel>\n");
        i.repl();
    }

}
