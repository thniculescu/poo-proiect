package hero;

import constants.HeroInputConstants;
import constants.HeroStatsConstants;
import constants.SpellConstants;
import main.TerrainMap;
import main.TerrainTypes;
import spell.Spell;
import spell.SpellTypes;

import java.util.ArrayList;

public class Knight extends Hero {
    @Override
    public final ArrayList<Spell> getSpells(final float amp) { // aplica amplificatorul de teren daca este cazul
        float newamp = amp;
        if (TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Land) {
            newamp += SpellConstants.KNIGHTLANDBONUS;
        }
        return super.getSpells(newamp);
    }

    @Override
    public final Knight isAffectedBy(final ArrayList<Spell> spells) {
        Knight temp = new Knight(this);
        for (Spell spell : spells) {
            temp = spell.castedOn(temp);
        }
        return temp;
    }

    public Knight(final int x, final int y) { // initializeaza statsurile de baza
        super(x, y);
        heroSpells.add(SpellTypes.Execute);
        heroSpells.add(SpellTypes.Slam);
        maxHp = HeroStatsConstants.KNIGHTBASE;
        hpPerLevel = HeroStatsConstants.KNIGHTLVL;
        hp = maxHp;
    }

    public Knight(final Knight knight) {
        super(knight);
    }

    @Override
    public final String toString() {
        return HeroInputConstants.KNIGHT + " " + super.toString();
    }
}
