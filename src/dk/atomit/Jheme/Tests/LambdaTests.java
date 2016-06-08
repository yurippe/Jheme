package dk.atomit.Jheme.Tests;

import dk.atomit.Jheme.Interpreter.Interpreter;
import dk.atomit.Jheme.SchemeTypes.SchemeInteger;

/**
 * Created by Kristian on 6/8/2016.
 */
public class LambdaTests {

    public static void test(){
        Interpreter interpreter = new Interpreter();

        SchemeInteger a1 = (SchemeInteger) interpreter.eval("(((lambda (x) (lambda (x y z) (+ x y z))) 10) 1 2 3)").getSchemeObject();
        assert a1.getValue() == 6;
        SchemeInteger a2 = (SchemeInteger) interpreter.eval("(define x (lambda (x) (lambda (x) (+ x x)))) ((x 10) 20)").getSchemeObject();
        assert a2.getValue() == 40;
    }

}
