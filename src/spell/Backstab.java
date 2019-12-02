package spell;

import constants.SpellConstants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;
import main.TerrainMap;
import main.TerrainTypes;

public final class Backstab extends Spell {

    public Backstab(final Hero hero, final float amp) {
        super(hero, amp);
        damage = SpellConstants.BACKSTABBASE + hero.getLevel() * SpellConstants.BACKSTABLVL;
        damage *= terrainAmp;
        if (hero.getFights() % SpellConstants.BACKSTABROUNDS == 0) {
            if (TerrainMap.getInstance()
                    .getTerrain(hero.getX(), hero.getY())
                    == TerrainTypes.Woods) {
                damage *= SpellConstants.BACKSTABBONUS;
            }
        }
    }

    @Override
    public Knight castedOn(final Knight hero) {
        hero.takeDamage(damage * SpellConstants.BACKSTABKNIGHT);
        return hero;
    }

    @Override
    public Pyromancer castedOn(final Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.BACKSTABPYROMANCER);
        return hero;
    }

    @Override
    public Wizard castedOn(final Wizard hero) {
        hero.takeDamage(damage * SpellConstants.BACKSTABWIZARD);
        return hero;
    }

    @Override
    public Rogue castedOn(final Rogue hero) {
        hero.takeDamage(damage * SpellConstants.BACKSTABROGUE);
        castedBy.increaseFights();
        return hero;
    }
}
