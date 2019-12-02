package spell;

import constants.SpellConstants;
import hero.*;

import static java.lang.Math.max;

public class Execute extends Spell {

    float threshhold;

    public Execute(Hero hero, float amp) {
        super(hero, amp);
        damage = SpellConstants.EXECUTEBASE + hero.getLevel() * SpellConstants.EXECUTELVL;
        damage *= terrainAmp;
        threshhold = max(SpellConstants.EXECUTEPERCENTAGEBASE + hero.getLevel() * SpellConstants.EXECUTEPERCENTAGELVL, SpellConstants.EXECUTEMAX);
    }

    @Override
    public Knight CastedOn(Knight hero) {
        float damage;
        if(hero.getHp() < Math.round((float) hero.getMaxHp() * threshhold)) {
            damage = hero.getHp();
        } else{
            damage = this.damage * SpellConstants.EXECUTEKNIGHT;
        }
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Pyromancer CastedOn(Pyromancer hero) {
        float damage;
        if(hero.getHp() < Math.round((float) hero.getMaxHp() * threshhold)) {
            damage = hero.getHp();
        } else{
            damage = this.damage * SpellConstants.EXECUTEPYROMANCER;
        }
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Wizard CastedOn(Wizard hero) {
        float damage;
        if(hero.getHp() < Math.round((float) hero.getMaxHp() * threshhold)) {
            damage = hero.getHp();
        } else{
            damage = this.damage * SpellConstants.EXECUTEWIZARD;
        }
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Rogue CastedOn(Rogue hero) {
        float damage;
        if(hero.getHp() < Math.round((float) hero.getMaxHp() * threshhold)) {
            damage = hero.getHp();
        } else{
            damage = this.damage * SpellConstants.EXECUTEROGUE;
        }
        hero.takeDamage(damage);
        return hero;
    }
}
