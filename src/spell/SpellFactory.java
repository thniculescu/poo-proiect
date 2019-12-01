package spell;

import hero.Hero;

public class SpellFactory {
    private static SpellFactory instance = null;

    private SpellFactory() {
    }

    public static SpellFactory getInstance() {
        if(instance == null) {
            instance = new SpellFactory();
        }
        return instance;
    }

    public Spell get(SpellTypes type, Hero hero) {

        return new Spell() {
            @Override
            public void CastedOn(Hero hero) {

            }
        };
    }

}
