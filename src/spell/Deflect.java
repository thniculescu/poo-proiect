package spell;

import constants.SpellConstants;
import hero.Hero;
import hero.Wizard;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;

import java.util.ArrayList;

public final class Deflect extends Spell {

    public Deflect(final Hero hero, final float amp) {
        super(hero, amp);
        damage = SpellConstants.DEFLECTBASE + hero.getLevel() * SpellConstants.DEFLECTLVL;
        damage = Math.min(damage, SpellConstants.DEFLECTMAX);
        damage *= terrainAmp;
    }

    @Override
    public Knight castedOn(final Knight hero) {
        ArrayList<Spell> spells = hero.getSpells(1f);
        float damageSum = 0;
        for (Spell spell : spells) {
            damageSum += spell.damage;
            damageSum = Math.round(damageSum);
        }
        damage *= damageSum;
        damage *= SpellConstants.DEFLECTKNIGHT;
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Pyromancer castedOn(final Pyromancer hero) {
        ArrayList<Spell> spells = hero.getSpells(1f);
        float damageSum = 0;
        for (Spell spell : spells) {
            damageSum += spell.damage;
            damageSum = Math.round(damageSum);
        }
        damage *= damageSum;
        damage *= SpellConstants.DEFLECTPYROMANCER;
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Wizard castedOn(final Wizard hero) {
        return hero;
    }

    @Override
    public Rogue castedOn(final Rogue hero) {
        ArrayList<Spell> spells = hero.getSpells(1f);
        float damageSum = 0;
        for (Spell spell : spells) {
            damageSum += spell.damage;
            damageSum = Math.round(damageSum);
        }
        damage *= damageSum;
        damage *= SpellConstants.DEFLECTROGUE;
        hero.takeDamage(damage);
        return hero;
    }
}
