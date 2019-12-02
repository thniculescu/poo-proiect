package spell;

import constants.SpellConstants;
import hero.Hero;
import hero.Rogue;
import hero.Pyromancer;
import hero.Knight;
import hero.Wizard;
import main.TerrainMap;
import main.TerrainTypes;

public final class Paralysis extends Spell {

    private final int numRounds;

    public Paralysis(final Hero hero, final float amp) {
        super(hero, amp);
        int numRounds1;
        damage = SpellConstants.PARALYSISBASE + SpellConstants.PARALISTSLVL * hero.getLevel();
        damage *= terrainAmp;
        numRounds1 = SpellConstants.PARALISYSROUNDS;
        if (TerrainMap.getInstance().getTerrain(hero.getX(), hero.getY()) == TerrainTypes.Woods) {
            numRounds1 += SpellConstants.PARALISYSBONUSROUNDS;
        }
        numRounds = numRounds1;
    }

    @Override
    public Knight castedOn(final Knight hero) {
        hero.takeDamage(damage * SpellConstants.PARALYSISKNIGHT);
        hero.paralyze(damage * SpellConstants.PARALYSISKNIGHT, numRounds);
        return hero;
    }

    @Override
    public Pyromancer castedOn(final Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.PARALYSISPYROMANCER);
        hero.paralyze(damage * SpellConstants.PARALYSISPYROMANCER, numRounds);
        return hero;
    }

    @Override
    public Wizard castedOn(final Wizard hero) {
        hero.takeDamage(damage * SpellConstants.PARALYSISWIZARD);
        hero.paralyze(damage * SpellConstants.PARALYSISWIZARD, numRounds);
        return hero;
    }

    @Override
    public Rogue castedOn(final Rogue hero) {
        hero.takeDamage(damage * SpellConstants.PARALYSISROGUE);
        hero.paralyze(damage * SpellConstants.PARALYSISROGUE, numRounds);
        return hero;
    }
}
