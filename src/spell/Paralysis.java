package spell;

import constants.SpellConstants;
import hero.*;
import main.TerrainMap;
import main.TerrainTypes;

public class Paralysis extends Spell {

    private final int numRounds;

    public Paralysis(Hero hero, float amp) {
        super(hero, amp);
        int numRounds1;
        damage = SpellConstants.PARALYSISBASE + SpellConstants.PARALISTSLVL * hero.getLevel();
        damage *= terrainAmp;
        numRounds1 = SpellConstants.PARALISYSROUNDS;
        if(TerrainMap.getInstance().getTerrain(hero.getX(), hero.getY()) == TerrainTypes.Woods) {
            numRounds1 += SpellConstants.PARALISYSBONUSROUNDS;
        }
        numRounds = numRounds1;
    }

    @Override
    public Knight CastedOn(Knight hero) {
        hero.takeDamage(damage * SpellConstants.PARALYSISKNIGHT);
        hero.Paralyze(damage * SpellConstants.PARALYSISKNIGHT, numRounds);
        return hero;
    }

    @Override
    public Pyromancer CastedOn(Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.PARALYSISPYROMANCER);
        hero.Paralyze(damage * SpellConstants.PARALYSISPYROMANCER, numRounds);
        return hero;
    }

    @Override
    public Wizard CastedOn(Wizard hero) {
        hero.takeDamage(damage * SpellConstants.PARALYSISWIZARD);
        hero.Paralyze(damage * SpellConstants.PARALYSISWIZARD, numRounds);
        return hero;
    }

    @Override
    public Rogue CastedOn(Rogue hero) {
        hero.takeDamage(damage * SpellConstants.PARALYSISROGUE);
        hero.Paralyze(damage * SpellConstants.PARALYSISROGUE, numRounds);
        return hero;
    }
}
