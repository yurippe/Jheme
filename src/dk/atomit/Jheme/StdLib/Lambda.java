package dk.atomit.Jheme.StdLib;

import dk.atomit.Jheme.Environment.Environment;
import dk.atomit.Jheme.Interpreter.Interpreter;
import dk.atomit.Jheme.SchemeTypes.*;

import java.util.List;

/**
 * Created by Kristian on 6/7/2016.
 */
public class Lambda extends SchemeProcedure{


    @Override
    public SchemeObject call(SchemeObject[] args, Interpreter i, Environment e) {

        if(args[0] instanceof SchemeExpression){
            //type 1 (args is a list of specific args):
            final SchemeExpression lambda_args = (SchemeExpression) args[0];
            final SchemeExpression lambda_exp = (SchemeExpression) args[1];

            for(SchemeObject o : lambda_args.list()){
                if(!(o instanceof SchemeSymbol)){
                    throw new RuntimeException("Lambda arguments must be symbols");
                }
            }

            return new SchemeProcedure() {

                @Override
                public SchemeObject execute(SchemeObject[] args, Interpreter i, Environment e) {
                    Environment nenv = new Environment(e);

                    List<SchemeObject> anames = lambda_args.list();

                    if(args.length != anames.size()){
                        throw new RuntimeException("Wrong number of arguments");
                    }

                    for(int ai=0; ai < anames.size(); ai++){
                        String key = ((SchemeSymbol) anames.get(ai)).getValue();
                        System.out.println(key);
                        System.out.println("==>");
                        System.out.println( args[ai]);
                        nenv.put(key, args[ai]);
                    }

                    System.out.println(nenv);
                    return i.eval(lambda_exp, nenv);
                }
            };






        } else if (args[0] instanceof SchemeSymbol){
            //type 2 (args is 1 symbol which gets passed a list of args):
            final SchemeSymbol lambda_args = (SchemeSymbol) args[0];
            final SchemeExpression lambda_exp = (SchemeExpression) args[1];

            return new SchemeProcedure() {

                @Override
                public SchemeObject execute(SchemeObject[] args, Interpreter i, Environment e) {
                    Environment nenv = new Environment(e);
                    nenv.put(lambda_args.getValue(), SchemePair.fromArray(args));
                    return i.eval(lambda_exp, nenv);
                }
            };






        } else {
            throw new RuntimeException("Expected list of arguments or symbol");
        }

    }

    @Override
    public SchemeObject execute(SchemeObject[] args, Interpreter i, Environment e) {
        return null;
    }


}
