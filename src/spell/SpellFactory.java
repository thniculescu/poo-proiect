package spell;

import hero.Hero;

public final class SpellFactory {
    private static SpellFactory instance = null;

    private SpellFactory() {
    }

    public static SpellFactory getInstance() {
        if (instance == null) {
            instance = new SpellFactory();
        }
        return instance;
    }

    public Spell get(final SpellTypes type, final Hero hero, final float amp) {

        switch (type) {
            case Slam:
                return new Slam(hero, amp);
            case Execute:
                return new Execute(hero, amp);
            case Drain:
                return new Drain(hero, amp);
            case Ignite:
                return new Ignite(hero, amp);
            case Deflect:
                return new Deflect(hero, amp);
            case Backstab:
                return new Backstab(hero, amp);
            case Fireblast:
                return new Fireblast(hero, amp);
            case Paralysis:
                return new Paralysis(hero, amp);
            default:
                return null;
        }
    }
}
