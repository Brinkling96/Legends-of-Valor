package src;

import java.util.ArrayList;
import java.util.Scanner;

public class LOVHeroFactory extends MAHHeroFactory {
	//the class initializes all Legand of Valor game heroes 
    private int hero_num;

    public LOVHeroFactory(Scanner in, int hero_num) {
        super(in);
        this.hero_num= hero_num;
    }

    @Override
    protected int promptHeroCount() {
        return hero_num;
    }
}
