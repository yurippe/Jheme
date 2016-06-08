package dk.atomit.Jheme.SchemeTypes;

/**
 * Created by Kristian on 6/7/2016.
 */
public class SchemePair implements SchemeObject {


    public String getStringValue() {
        return "<PAIR>";
    }

    public static SchemePair fromArray(SchemeObject[] arr){
        return new SchemePair();
    }
}
