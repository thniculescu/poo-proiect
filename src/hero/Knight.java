package hero;

import constants.HeroInputConstants;
import constants.HeroStatsConstants;
import constants.MapConstants;
import constants.SpellConstants;
import main.TerrainMap;
import main.TerrainTypes;
import spell.Spell;
import spell.SpellTypes;

import java.util.ArrayList;

public class Knight extends Hero {
    @Override
    public ArrayList<Spell> getSpells(float amp) {
        if(TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Land) {
            amp += SpellConstants.KNIGHTLANDBONUS;
        }
        return super.getSpells(amp);
    }

    @Override
    public void isAffectedBy(ArrayList<Spell> spells) {
        for(Spell spell : spells) {
            spell.CastedOn(this);
        }
    }

    public Knight(int x, int y) {
        super(x, y);
        heroSpells.add(SpellTypes.Execute);
        heroSpells.add(SpellTypes.Slam);
        maxHp = HeroStatsConstants.KNIGHTBASE;
        hpPerLevel = HeroStatsConstants.KNIGHTLVL;
        hp = maxHp;
    }

    @Override
    public String toString() {
        return HeroInputConstants.KNIGHT + " " + super.toString();
    }
}
