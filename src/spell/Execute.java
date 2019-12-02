package spell;

import constants.SpellConstants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

import static java.lang.Math.max;

public final class Execute extends Spell {

    public float getThreshhold() {
        return threshhold;
    }

    private float threshhold;

    public Execute(final Hero hero, final float amp) {
        super(hero, amp);
        damage = SpellConstants.EXECUTEBASE + hero.getLevel()
                * SpellConstants.EXECUTELVL;
        damage *= terrainAmp;
        threshhold = max(SpellConstants.EXECUTEPERCENTAGEBASE
                + hero.getLevel()
                * SpellConstants.EXECUTEPERCENTAGELVL,
                SpellConstants.EXECUTEMAX);
    }

    @Override
    public Knight castedOn(final Knight hero) {
        float damage;
        if (hero.getHp() <= Math.round((float) hero.getMaxHp() * threshhold)) {
            damage = hero.getHp();
        } else {
            damage = this.damage * SpellConstants.EXECUTEKNIGHT;
        }
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Pyromancer castedOn(final Pyromancer hero) {
        float damage;
        if (hero.getHp() <= Math.round((float) hero.getMaxHp() * threshhold)) {
            damage = hero.getHp();
        } else {
            damage = this.damage * SpellConstants.EXECUTEPYROMANCER;
        }
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Wizard castedOn(final Wizard hero) {
        float damage;
        if (hero.getHp() <= Math.round((float) hero.getMaxHp() * threshhold)) {
            damage = hero.getHp();
        } else {
            damage = this.damage * SpellConstants.EXECUTEWIZARD;
        }
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Rogue castedOn(final Rogue hero) {
        float damage;
        if (hero.getHp() <= Math.round((float) hero.getMaxHp() * threshhold)) {
            damage = hero.getHp();
        } else {
            damage = this.damage * SpellConstants.EXECUTEROGUE;
        }
        hero.takeDamage(damage);
        return hero;
    }
}
