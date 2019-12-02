package spell;

import constants.SpellConstants;
import hero.*;

public class Slam extends Spell {

    public Slam(Hero hero, float amp) {
        super(hero, amp);
        damage = SpellConstants.SLAMBASE + hero.getLevel() * SpellConstants.SLAMLVL;
        damage *= terrainAmp;
    }

    @Override
    public Knight CastedOn(Knight hero) {
        hero.takeDamage(damage * SpellConstants.SLAMKNIGHT);
        hero.Paralyze(0, SpellConstants.SLAMROUNDS);
        return hero;
    }

    @Override
    public Pyromancer CastedOn(Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.SLAMPYROMANCER);
        hero.Paralyze(0, SpellConstants.SLAMROUNDS);
        return hero;
    }

    @Override
    public Wizard CastedOn(Wizard hero) {
        hero.takeDamage(damage * SpellConstants.SLAMWIZARD);
        hero.Paralyze(0, SpellConstants.SLAMROUNDS);
        return hero;
    }

    @Override
    public Rogue CastedOn(Rogue hero) {
        hero.takeDamage(damage * SpellConstants.SLAMROGUE);
        hero.Paralyze(0, SpellConstants.SLAMROUNDS);
        return hero;
    }
}
