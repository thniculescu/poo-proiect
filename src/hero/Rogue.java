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

    public Rogue(Rogue rogue) {
        super(rogue);
    }

    @Override
    public ArrayList<Spell> getSpells(float amp) {
        if(TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Woods) {
            amp += SpellConstants.ROGUEWOODSBONUS;
        }
        return super.getSpells(amp);
    }

    @Override
    public Rogue isAffectedBy(ArrayList<Spell> spells) {
        Rogue temp = new Rogue(this);
        for(Spell spell : spells) {
            temp = spell.CastedOn(temp);
        }
        return temp;
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
