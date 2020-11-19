package src;

public interface LOVBoostStrategy {
    void doBoostBehavior(LOVHero hero);

    default void resetBoost(LOVHero hero){
        hero.setCellStre(0);
        hero.setCellDex(0);
        hero.setCellAgi(0);
    }
}
