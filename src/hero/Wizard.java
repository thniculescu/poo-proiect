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

public final class Wizard extends Hero {

    public Wizard(final Wizard wizard) {
        super(wizard);
    }

    @Override
    public ArrayList<Spell> getSpells(final float amp) {
        float newamp = amp;
        if (TerrainMap.getInstance().getTerrain(x, y) == TerrainTypes.Desert) {
            newamp += SpellConstants.WIZARDDESERTBONUS;
        }
        return super.getSpells(newamp);
    }

    @Override
    public String getType() {
        return "Wizard";
    }

    @Override
    public Wizard isAffectedBy(final ArrayList<Spell> spells) {
        Wizard temp = new Wizard(this);
        for (Spell spell : spells) {
            temp = spell.castedOn(temp);
        }
        return temp;
    }

    @Override
    public void isAffectedBy(Angel angel) {
        angel.affect(this);
    }

    public Wizard(final int x, final int y) {
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
