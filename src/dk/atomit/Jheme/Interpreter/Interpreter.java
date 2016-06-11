package dk.atomit.Jheme.Interpreter;

import dk.atomit.Jheme.Environment.Environment;
import dk.atomit.Jheme.SchemeTypes.*;
import dk.atomit.Jheme.Parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Kristian on 6/7/2016.
 */
public class Interpreter {

    private Parser parser = new Parser();
    private Environment environment = Environment.getStdEnvironment();

    public EvaluationResult eval(SchemeObject o, Environment e){
        if(o instanceof SchemeSymbol) {
            return new EvaluationResult(e.find(((SchemeSymbol) o).getValue()), e);

        }else if(o instanceof SchemeExpression){
            return ((SchemeExpression) o).evaluate(this, e);
        } else{
            return new EvaluationResult(o, e);
        }
    }

    public EvaluationResult eval(String expressions){
        EvaluationResult result = null;
        EvaluationResult finalResult = null;
        for(SchemeObject exp : parser.parse(expressions)){
            result = eval(exp, environment);
            if(finalResult == null || !(result.getSchemeObject() instanceof SchemeNoreturn)){
                finalResult = result;
            }
        }
        if(finalResult != null && finalResult.getSchemeObject() instanceof SchemeUninitialized){
            throw new RuntimeException("Attempt to reference undefined variable");
        }
        return finalResult;
    }

    public void repl(){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try {
                String line = buffer.readLine();
                EvaluationResult r = eval(line);
                if(!(r.getSchemeObject() instanceof SchemeNoreturn)) {
                    System.out.println(r.getSchemeObject().getStringValue());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public void assertArgCountEqual(SchemeObject assertedin, SchemeObject[] args, int assertcount){
        if(!(args.length == assertcount)){
            throw new RuntimeException("Illegal argument count");
        }
    }

    public void assertArgCountMin(SchemeObject assertedin, SchemeObject[] args, int assertcount){
        if(!(args.length >= assertcount)){
            throw new RuntimeException("Illegal argument count");
        }
    }

    public void assertIsType(SchemeObject assertedin, SchemeObject arg, Class type){
        if(!(arg.getClass() == type)){
            throw new RuntimeException("Expected argument to be of type: " + type.getClass().getName());
        }
    }

    public void assertListSize(SchemeObject assertedin, List<?> list, int assertcount){
        if(!(list.size() == assertcount)){
            throw new RuntimeException("Expected length to be " + assertcount);
        }
    }


}
