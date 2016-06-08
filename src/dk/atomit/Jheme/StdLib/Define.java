package dk.atomit.Jheme.StdLib;

import dk.atomit.Jheme.Environment.Environment;
import dk.atomit.Jheme.Interpreter.Interpreter;
import dk.atomit.Jheme.SchemeTypes.*;

/**
 * Created by Kristian on 6/7/2016.
 */
public class Define extends SchemeProcedure {

    @Override
    public SchemeObject call(SchemeObject[] args, Interpreter i, Environment e) {
        SchemeSymbol name = (SchemeSymbol) args[0];
        SchemeObject value = i.eval(args[1], e);
        e.put(name.getValue(), value);
        return new SchemeNoreturn();
    }

    @Override
    public SchemeObject execute(SchemeObject[] args, Interpreter i, Environment e) {
        return null;
    }
}
