package dk.atomit.Jheme.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristian on 6/10/2016.
 */
public class Tokenizer {

    private enum State {INITIAL, STANDARD, STRING}

    private State state;


    public Tokenizer(){
        state = State.INITIAL;
    }

    public String[] tokenize(String string_in){

        char[] input = string_in.toCharArray();

        List<String> output = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();

        char prev = ' ';


        for(char c : input){

            if(state == state.INITIAL){

                if(c == ')' || c == ']'){
                    output.add(")");
                } else if (c == '(' || c == '[') {
                    output.add("(");
                }

                else if(!(c == ' ')){
                    currentToken = new StringBuilder();
                    currentToken.append(c);
                    if(StartNewString(c)){
                        state = State.STRING;
                    } else{
                        state = State.STANDARD;
                    }

                }

                prev = c;
                continue;
            }

            else if(state == State.STANDARD){

                if(c == ')' || c == ']'){
                    output.add(currentToken.toString());
                    output.add(")");
                    state = State.INITIAL;
                } else if (c == '(' || c == '[') {
                    output.add(currentToken.toString());
                    output.add("(");
                    state = State.INITIAL;
                }

                else if(!(c == ' ')){
                    currentToken.append(c);
                } else {
                    //end of this token
                    output.add(currentToken.toString());
                    state = State.INITIAL;
                }

                prev = c;
                continue;
            }

            else if(state == State.STRING){

                currentToken.append(c);

                if(EndString(prev, c)){
                    output.add(currentToken.toString());
                    state = State.INITIAL;
                }

                prev = c;
                continue;
            }



        }

        if(!(state == State.INITIAL)){
            output.add(currentToken.toString());
        }

        return output.toArray(new String[output.size()]);

    }

    private boolean StartNewString(char c){
        return c == '"';
    }

    private boolean EndString(char prev, char c){
        return (!(prev == '\\')) && (c == '"');
    }
}
