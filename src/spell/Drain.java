package spell;

import constants.SpellConstants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Drain extends Spell {

    public Drain(final Hero hero, final float amp) {
        super(hero, amp);
        damage = SpellConstants.DRAINBASE + hero.getLevel() * SpellConstants.DRAINLVL;
        damage *= terrainAmp;
    }

    @Override
    public Knight castedOn(final Knight hero) {
        damage *= Math.min(SpellConstants.DRAINHPPERCENT * hero.getMaxHp(), hero.getHp());
        hero.takeDamage(damage * SpellConstants.DRAINKNIGHT);
        return hero;
    }

    @Override
    public Pyromancer castedOn(final Pyromancer hero) {
        damage *= Math.min(SpellConstants.DRAINHPPERCENT * hero.getMaxHp(), hero.getHp());
        hero.takeDamage(damage * SpellConstants.DRAINPYROMANCER);
        return hero;
    }

    @Override
    public Wizard castedOn(final Wizard hero) {
        damage *= Math.min(SpellConstants.DRAINHPPERCENT * hero.getMaxHp(), hero.getHp());
        hero.takeDamage(damage * SpellConstants.DRAINWIZARD);
        return hero;
    }

    @Override
    public Rogue castedOn(final Rogue hero) {
        damage *= Math.min(SpellConstants.DRAINHPPERCENT * hero.getMaxHp(), hero.getHp());
        hero.takeDamage(damage * SpellConstants.DRAINROGUE);
        return hero;
    }
}
