package spell;

import constants.SpellConstants;
import hero.*;

public class Deflect extends Spell {

    public Deflect(Hero hero, float amp) {
        super(hero, amp);
        damage = SpellConstants.DEFLECTBASE + hero.getLevel() * SpellConstants.DEFLECTLVL;
        damage = Math.min(damage, SpellConstants.DEFLECTMAX);
        damage *= terrainAmp;
    }

    @Override
    public Knight CastedOn(Knight hero) {
        return super.CastedOn(hero);
    }

    @Override
    public Pyromancer CastedOn(Pyromancer hero) {
        return super.CastedOn(hero);
    }

    @Override
    public Wizard CastedOn(Wizard hero) {
        return hero;
    }

    @Override
    public Rogue CastedOn(Rogue hero) {
        return super.CastedOn(hero);
    }
}
