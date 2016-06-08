package dk.atomit.Jheme.Interpreter;

import dk.atomit.Jheme.Environment.Environment;
import dk.atomit.Jheme.SchemeTypes.SchemeExpression;
import dk.atomit.Jheme.SchemeTypes.SchemeNoreturn;
import dk.atomit.Jheme.SchemeTypes.SchemeObject;
import dk.atomit.Jheme.SchemeTypes.SchemeSymbol;
import dk.atomit.Jheme.Parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kristian on 6/7/2016.
 */
public class Interpreter {

    private Parser parser = new Parser();
    private Environment environment = Environment.getStdEnvironment();

    public SchemeObject eval(SchemeObject o, Environment e){
        if(o instanceof SchemeSymbol) {
            return e.find(((SchemeSymbol) o).getValue());

        }else if(o instanceof SchemeExpression){
            return ((SchemeExpression) o).evaluate(this, e);
        } else{
            return o;
        }
    }

    public SchemeObject eval(String expressions){
        SchemeObject result = null;
        for(SchemeObject exp : parser.parse(expressions)){
            result = eval(exp, environment);
            if(!(result instanceof SchemeNoreturn)){
                System.out.println(result.getStringValue());
            }
        }
        return result;
    }

    public void repl(){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try {
                String line = buffer.readLine();
                eval(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
