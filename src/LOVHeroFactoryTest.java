package src;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

class LOVHeroFactoryTest {
    @Test
    public void createParty(){
        LOVHeroFactory lovhf = new LOVHeroFactory(new Scanner(System.in));
        ArrayList<LOVHero> test = lovhf.createLOVParty();
    }
}