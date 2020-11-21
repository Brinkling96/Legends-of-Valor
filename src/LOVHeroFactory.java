package src;

import java.util.ArrayList;
import java.util.Scanner;

public class LOVHeroFactory extends MAHHeroFactory {

    public LOVHeroFactory(Scanner in) {
        super(in);
    }

    @Override
    protected int promptHeroCount() {
        return 3;
    }
}
