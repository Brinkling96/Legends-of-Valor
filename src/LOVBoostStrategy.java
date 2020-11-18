package src;

public interface LOVBoostStrategy {
    void doBoostBehavior(Hero hero);

    default void resetBoost(Hero hero){
        hero.setCellStre(0);
        hero.setCellDex(0);
        hero.setCellAgi(0);
    }
}
