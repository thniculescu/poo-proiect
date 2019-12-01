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

    @Override
    public ArrayList<Spell> getSpells(float amp) {
        System.out.println("WOHOO PYRO SPELLS");
        if(TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Volcanic) {
            amp += SpellConstants.PYROVOLCANICBONUS;
        }
        return super.getSpells(amp);
    }

    @Override
    public void isAffectedBy(ArrayList<Spell> spells) {
        for(Spell spell : spells) {
            spell.CastedOn(this);
        }
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
