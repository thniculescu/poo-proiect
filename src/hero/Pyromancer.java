package hero;

import constants.HeroInputConstants;
import constants.HeroStatsConstants;
import constants.SpellConstants;
import main.TerrainMap;
import main.TerrainTypes;
import spell.Spell;
import spell.SpellTypes;

import java.util.ArrayList;

public class Pyromancer extends Hero {

    public Pyromancer(Pyromancer pyromancer) {
        super(pyromancer);
    }

    @Override
    public ArrayList<Spell> getSpells(float amp) {
        if(TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Volcanic) {
            amp += SpellConstants.PYROVOLCANICBONUS;
        }
        return super.getSpells(amp);
    }

    @Override
    public Pyromancer isAffectedBy(ArrayList<Spell> spells) {
        Pyromancer temp = new Pyromancer(this);
        for(Spell spell : spells) {
            temp = spell.CastedOn(temp);
        }
        return temp;
    }

    public Pyromancer(int x, int y) {
        super(x, y);
        heroSpells.add(SpellTypes.Fireblast);
        heroSpells.add(SpellTypes.Ignite);
        maxHp = HeroStatsConstants.PYROMANCERBASE;
        hpPerLevel = HeroStatsConstants.PYROMANCERLVL;
        hp = maxHp;
    }

    @Override
    public String toString() {
        return HeroInputConstants.PYROMANCER + " " + super.toString();
    }
}
