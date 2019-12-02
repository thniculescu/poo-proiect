package spell;

import constants.SpellConstants;
import hero.*;

public class Drain extends Spell {

    public Drain(Hero hero, float amp) {
        super(hero, amp);
        damage = SpellConstants.DRAINBASE + hero.getLevel() * SpellConstants.DRAINLVL;
        damage *= terrainAmp;
    }

    @Override
    public Knight CastedOn(Knight hero) {
        damage *= Math.min(SpellConstants.DRAINHPPERCENT * hero.getMaxHp(), hero.getHp());
        hero.takeDamage(damage * SpellConstants.DRAINKNIGHT);
        return hero;
    }

    @Override
    public Pyromancer CastedOn(Pyromancer hero) {
        damage *= Math.min(SpellConstants.DRAINHPPERCENT * hero.getMaxHp(), hero.getHp());
        hero.takeDamage(damage * SpellConstants.DRAINPYROMANCER);
        return hero;
    }

    @Override
    public Wizard CastedOn(Wizard hero) {
        damage *= Math.min(SpellConstants.DRAINHPPERCENT * hero.getMaxHp(), hero.getHp());
        hero.takeDamage(damage * SpellConstants.DRAINWIZARD);
        return hero;
    }

    @Override
    public Rogue CastedOn(Rogue hero) {
        damage *= Math.min(SpellConstants.DRAINHPPERCENT * hero.getMaxHp(), hero.getHp());
        hero.takeDamage(damage * SpellConstants.DRAINROGUE);
        return hero;
    }
}
