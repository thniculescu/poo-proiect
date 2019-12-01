package hero;

import constants.HeroInputConstants;
import constants.HeroStatsConstants;
import constants.SpellConstants;
import main.TerrainMap;
import main.TerrainTypes;
import spell.Spell;
import spell.SpellTypes;

import java.util.ArrayList;

public class Rogue extends Hero {

    int backstabCounter = 0;

    @Override
    public ArrayList<Spell> getSpells(float amp) {
        if(TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Woods) {
            amp += SpellConstants.ROGUEWOODSBONUS;
        }
        return super.getSpells(amp);
    }

    @Override
    public void isAffectedBy(ArrayList<Spell> spells) {
        for(Spell spell : spells) {
            spell.CastedOn(this);
        }
    }

    public Rogue(int x, int y) {
        super(x, y);
        heroSpells.add(SpellTypes.Backstab);
        heroSpells.add(SpellTypes.Paralysis);
        maxHp = HeroStatsConstants.ROGUEBASE;
        hpPerLevel = HeroStatsConstants.ROGUELVL;
        hp = maxHp;
    }

    @Override
    public String toString() {
        return HeroInputConstants.ROGUE + " " + super.toString();
    }
}
