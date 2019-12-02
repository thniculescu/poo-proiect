package spell;

import constants.SpellConstants;
import hero.*;
import main.TerrainMap;
import main.TerrainTypes;

public class Backstab extends Spell {

    public Backstab(Hero hero, float amp) {
        super(hero, amp);
        damage = SpellConstants.BACKSTABBASE + hero.getLevel() * SpellConstants.BACKSTABLVL;
        damage *= terrainAmp;
        if(hero.getFights() % SpellConstants.BACKSTABROUNDS == 0) {
            if(TerrainMap.getInstance().getTerrain(hero.getX(), hero.getY()) == TerrainTypes.Woods) {
                damage *= SpellConstants.BACKSTABBONUS;
            }
        }
    }

    @Override
    public Knight CastedOn(Knight hero) {
        hero.takeDamage(damage * SpellConstants.BACKSTABKNIGHT);
        return hero;
    }

    @Override
    public Pyromancer CastedOn(Pyromancer hero) {
        hero.takeDamage(damage * SpellConstants.BACKSTABPYROMANCER);
        return hero;
    }

    @Override
    public Wizard CastedOn(Wizard hero) {
        hero.takeDamage(damage * SpellConstants.BACKSTABWIZARD);
        return hero;
    }

    @Override
    public Rogue CastedOn(Rogue hero) {
        hero.takeDamage(damage * SpellConstants.BACKSTABROGUE);
        castedBy.increaseFights();
        return hero;
    }
}
