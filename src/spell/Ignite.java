package spell;

import constants.SpellConstants;
import hero.Hero;
import hero.Rogue;
import hero.Pyromancer;
import hero.Knight;
import hero.Wizard;

public final class Ignite extends Spell {

    private float damageOverTime;
    private final int numRounds;

    public Ignite(final Hero hero, final float amp) {
        super(hero, amp);
        damage = SpellConstants.IGNITEBASE + SpellConstants.IGNITELVL * hero.getLevel();
        damage *= terrainAmp;
        damageOverTime = SpellConstants.IGNITEDOTBASE
                + SpellConstants.IGNITEDOTLVL * hero.getLevel();
        damageOverTime *= terrainAmp;
        numRounds = SpellConstants.IGNITEROUNDS;
    }

    @Override
    public Knight castedOn(final Knight hero) {
        hero.takeDamage(damage * SpellConstants.IGNITEKNIGHT);
        hero.ignite(damageOverTime * SpellConstants.IGNITEKNIGHT, numRounds);
        return hero;
    }

    @Override
    public Pyromancer castedOn(final Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.IGNITEPYROMANCER);
        hero.ignite(damageOverTime * SpellConstants.IGNITEPYROMANCER, numRounds);
        return hero;
    }

    @Override
    public Wizard castedOn(final Wizard hero) {
        hero.takeDamage(damage * SpellConstants.IGNITEWIZARD);
        hero.ignite(damageOverTime * SpellConstants.IGNITEWIZARD, numRounds);
        return hero;
    }

    @Override
    public Rogue castedOn(final Rogue hero) {
        hero.takeDamage(damage * SpellConstants.IGNITEROGUE);
        hero.ignite(damageOverTime * SpellConstants.IGNITEROGUE, numRounds);
        return hero;
    }
}
