package spell;

import constants.SpellConstants;
import hero.*;

public class Ignite extends Spell {

    private float damageOverTime;
    private final int numRounds;

    public Ignite(Hero hero, float amp) {
        super(hero, amp);
        damage = SpellConstants.IGNITEBASE + SpellConstants.IGNITELVL * hero.getLevel();
        damage *= terrainAmp;
        damageOverTime = SpellConstants.IGNITEDOTBASE + SpellConstants.IGNITEDOTLVL * hero.getLevel();
        damageOverTime *= terrainAmp;
        numRounds = SpellConstants.IGNITEROUNDS;
    }

    @Override
    public Knight CastedOn(Knight hero) {
        hero.takeDamage(damage * SpellConstants.IGNITEKNIGHT);
        hero.Ignite(damageOverTime * SpellConstants.IGNITEKNIGHT, numRounds);
        return hero;
    }

    @Override
    public Pyromancer CastedOn(Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.IGNITEPYROMANCER);
        hero.Ignite(damageOverTime * SpellConstants.IGNITEPYROMANCER, numRounds);
        return hero;
    }

    @Override
    public Wizard CastedOn(Wizard hero) {
        hero.takeDamage(damage * SpellConstants.IGNITEWIZARD);
        hero.Ignite(damageOverTime * SpellConstants.IGNITEWIZARD, numRounds);
        return hero;
    }

    @Override
    public Rogue CastedOn(Rogue hero) {
        hero.takeDamage(damage * SpellConstants.IGNITEROGUE);
        hero.Ignite(damageOverTime * SpellConstants.IGNITEROGUE, numRounds);
        return hero;
    }
}
