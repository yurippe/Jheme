package dk.atomit.Jheme.StdLib;

import dk.atomit.Jheme.Environment.Environment;
import dk.atomit.Jheme.Interpreter.EvaluationResult;
import dk.atomit.Jheme.Interpreter.Interpreter;
import dk.atomit.Jheme.SchemeTypes.SchemeNoreturn;
import dk.atomit.Jheme.SchemeTypes.SchemeObject;
import dk.atomit.Jheme.SchemeTypes.SchemeProcedure;

/**
 * Created by Kristian on 6/10/2016.
 */
public class PrintF extends SchemeProcedure {

    @Override
    public EvaluationResult execute(SchemeObject[] args, Interpreter interpreter, Environment e) {

        StringBuilder sb = new StringBuilder();
        for(SchemeObject arg : args){
            sb.append(arg.getStringValue() + "\t");
        }

        System.out.println(sb.toString());

        return new EvaluationResult(new SchemeNoreturn(), e);
    }
}
