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

    public Rogue(final Rogue rogue) {
        super(rogue);
    }

    @Override
    public final ArrayList<Spell> getSpells(final float amp) {
        float newamp = amp;
        if (TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Woods) {
            newamp += SpellConstants.ROGUEWOODSBONUS;
        }
        return super.getSpells(newamp);
    }

    @Override
    public final Rogue isAffectedBy(final ArrayList<Spell> spells) {
        Rogue temp = new Rogue(this);
        for (Spell spell : spells) {
            temp = spell.castedOn(temp);
        }
        return temp;
    }

    public Rogue(final int x, final int y) {
        super(x, y);
        heroSpells.add(SpellTypes.Backstab);
        heroSpells.add(SpellTypes.Paralysis);
        maxHp = HeroStatsConstants.ROGUEBASE;
        hpPerLevel = HeroStatsConstants.ROGUELVL;
        hp = maxHp;
    }

    @Override
    public final String toString() {
        return HeroInputConstants.ROGUE + " " + super.toString();
    }
}
