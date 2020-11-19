package src;

import java.lang.reflect.Array;
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

    public ArrayList<LOVHero> createLOVParty(){
        ArrayList<Hero> heros = createParty();
        ArrayList<LOVHero> returnlist= new ArrayList<LOVHero>();
        int i = 0;
        for(Hero hero: heros){
            returnlist.add(new LOVHero(hero,new Marker(7,3*i,Integer.toString(i+1).charAt(0))));
        }
        return returnlist;
    }

}
