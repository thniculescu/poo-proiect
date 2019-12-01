package hero;

import constants.HeroInputConstants;
import constants.HeroStatsConstants;
import constants.SpellConstants;
import main.TerrainMap;
import main.TerrainTypes;
import spell.Spell;
import spell.SpellTypes;

import java.util.ArrayList;

public class Wizard extends Hero {
    @Override
    public ArrayList<Spell> getSpells(float amp) {
        if(TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Desert) {
            amp += SpellConstants.WIZARDDESERTBONUS;
        }
        return super.getSpells(amp);
    }

    @Override
    public void isAffectedBy(ArrayList<Spell> spells) {
        for(Spell spell : spells) {
            spell.CastedOn(this);
        }
    }

    public Wizard(int x, int y) {
        super(x, y);
        heroSpells.add(SpellTypes.Drain);
        heroSpells.add(SpellTypes.Deflect);
        maxHp = HeroStatsConstants.WIZARDBASE;
        hpPerLevel = HeroStatsConstants.WIZARDLVL;
        hp = maxHp;
    }

    @Override
    public String toString() {
        return HeroInputConstants.WIZARD + " " + super.toString();
    }
}
