package capers;
import java.io.File;

import static capers.Utils.*;

public class Test {
    static final File DOG_FOLDER = join(".capers","dogs") ;
    public static void main(String[] args) {
        for( String s: DOG_FOLDER.list()){
            System.out.println(s);
        }
    }
}
