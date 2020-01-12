package hero;

import angel.Angel;
import constants.HeroInputConstants;
import constants.HeroStatsConstants;
import constants.SpellConstants;
import main.TerrainMap;
import main.TerrainTypes;
import spell.Spell;
import spell.SpellTypes;

import java.util.ArrayList;

public class Pyromancer extends Hero {

    public Pyromancer(final Pyromancer pyromancer) {
        super(pyromancer);
    }

    @Override
    public final ArrayList<Spell> getSpells(final float amp) {
        float newamp = amp;
        if (TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Volcanic) {
            newamp += SpellConstants.PYROVOLCANICBONUS;
        }
        return super.getSpells(newamp);
    }

    @Override
    public String getType() {
        return "Pyromancer";
    }

    @Override
    public final Pyromancer isAffectedBy(final ArrayList<Spell> spells) {
        Pyromancer temp = new Pyromancer(this);
        for (Spell spell : spells) {
            temp = spell.castedOn(temp);
        }
        return temp;
    }

    @Override
    public void isAffectedBy(Angel angel) {
        angel.affect(this);
    }

    public Pyromancer(final int x, final int y) {
        super(x, y);
        heroSpells.add(SpellTypes.Fireblast);
        heroSpells.add(SpellTypes.Ignite);
        maxHp = HeroStatsConstants.PYROMANCERBASE;
        hpPerLevel = HeroStatsConstants.PYROMANCERLVL;
        hp = maxHp;
    }

    @Override
    public final String toString() {
        return HeroInputConstants.PYROMANCER + " " + super.toString();
    }
}
