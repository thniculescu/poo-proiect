package spell;

import constants.SpellConstants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Slam extends Spell {

    public Slam(final Hero hero, final float amp) {
        super(hero, amp);
        damage = SpellConstants.SLAMBASE + hero.getLevel() * SpellConstants.SLAMLVL;
        damage *= terrainAmp;
    }

    @Override
    public Knight castedOn(final Knight hero) {
        hero.takeDamage(damage * SpellConstants.SLAMKNIGHT);
        hero.paralyze(0, SpellConstants.SLAMROUNDS);
        return hero;
    }

    @Override
    public Pyromancer castedOn(final Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.SLAMPYROMANCER);
        hero.paralyze(0, SpellConstants.SLAMROUNDS);
        return hero;
    }

    @Override
    public Wizard castedOn(final Wizard hero) {
        hero.takeDamage(damage * SpellConstants.SLAMWIZARD);
        hero.paralyze(0, SpellConstants.SLAMROUNDS);
        return hero;
    }

    @Override
    public Rogue castedOn(final Rogue hero) {
        hero.takeDamage(damage * SpellConstants.SLAMROGUE);
        hero.paralyze(0, SpellConstants.SLAMROUNDS);
        return hero;
    }
}
