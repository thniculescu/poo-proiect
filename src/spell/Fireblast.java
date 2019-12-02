package spell;

import constants.SpellConstants;
import hero.*;

public class Fireblast extends Spell {

    public Fireblast(Hero hero, float amp) {
        super(hero, amp);
        damage = SpellConstants.FIREBLASTBASE + hero.getLevel() * SpellConstants.FIREBLASTLVL;
        damage *= terrainAmp;
    }

    @Override
    public Knight CastedOn(Knight hero) {
        hero.takeDamage(damage * SpellConstants.FIREBLASTKNIGHT);
        return  hero;
    }

    @Override
    public Pyromancer CastedOn(Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.FIREBLASTPYROMANCER);
        return  hero;
    }

    @Override
    public Wizard CastedOn(Wizard hero) {
        hero.takeDamage(damage * SpellConstants.FIREBLASTWIZARD);
        return  hero;
    }

    @Override
    public Rogue CastedOn(Rogue hero) {
        hero.takeDamage(damage * SpellConstants.FIREBLASTROGUE);
        return hero;
    }
}
