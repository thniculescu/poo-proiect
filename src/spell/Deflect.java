package spell;

import constants.SpellConstants;
import hero.*;
import sun.awt.X11.XSystemTrayPeer;

import java.util.ArrayList;

public class Deflect extends Spell {

    public Deflect(Hero hero, float amp) {
        super(hero, amp);
        damage = SpellConstants.DEFLECTBASE + hero.getLevel() * SpellConstants.DEFLECTLVL;
        damage = Math.min(damage, SpellConstants.DEFLECTMAX);
        damage *= terrainAmp;
    }

    @Override
    public Knight CastedOn(Knight hero) {
        ArrayList<Spell> spells = hero.getSpells(1f);
        float damageSum = 0;
        for(Spell spell : spells) {
            damageSum += spell.damage;
            damageSum = Math.round(damageSum);
        }
        damage *= damageSum;
        damage *= SpellConstants.DEFLECTKNIGHT;
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Pyromancer CastedOn(Pyromancer hero) {
        ArrayList<Spell> spells = hero.getSpells(1f);
        float damageSum = 0;
        for(Spell spell : spells) {
            damageSum += spell.damage;
            damageSum = Math.round(damageSum);
        }
        damage *= damageSum;
        damage *= SpellConstants.DEFLECTPYROMANCER;
        hero.takeDamage(damage);
        return hero;
    }

    @Override
    public Wizard CastedOn(Wizard hero) {
        return hero;
    }

    @Override
    public Rogue CastedOn(Rogue hero) {
        ArrayList<Spell> spells = hero.getSpells(1f);
        float damageSum = 0;
        for(Spell spell : spells) {
            damageSum += spell.damage;
            damageSum = Math.round(damageSum);
        }
        damage *= damageSum;
        damage *= SpellConstants.DEFLECTROGUE;
        hero.takeDamage(damage);
        return hero;
    }
}
