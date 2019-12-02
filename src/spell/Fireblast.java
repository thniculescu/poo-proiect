package spell;

import constants.SpellConstants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Fireblast extends Spell {

    public Fireblast(final Hero hero, final float amp) {
        super(hero, amp);
        damage = SpellConstants.FIREBLASTBASE + hero.getLevel() * SpellConstants.FIREBLASTLVL;
        damage *= terrainAmp;
    }

    @Override
    public Knight castedOn(final Knight hero) {
        hero.takeDamage(damage * SpellConstants.FIREBLASTKNIGHT);
        return  hero;
    }

    @Override
    public Pyromancer castedOn(final Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.FIREBLASTPYROMANCER);
        return  hero;
    }

    @Override
    public Wizard castedOn(final Wizard hero) {
        hero.takeDamage(damage * SpellConstants.FIREBLASTWIZARD);
        return  hero;
    }

    @Override
    public Rogue castedOn(final Rogue hero) {
        hero.takeDamage(damage * SpellConstants.FIREBLASTROGUE);
        return hero;
    }
}
