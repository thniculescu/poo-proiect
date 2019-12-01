package spell;

import constants.SpellConstants;
import hero.*;

public class Fireblast extends Spell {

    public Fireblast(Hero hero, float amp) {
        super(hero, amp);
        System.out.println(hero + " casted IGNITE");
        damage = SpellConstants.FIREBLASTBASE + hero.getLevel() * SpellConstants.FIREBLASTLVL;
    }

    @Override
    public void CastedOn(Knight hero) {

    }

    @Override
    public void CastedOn(Wizard hero) {

    }

    @Override
    public void CastedOn(Rogue hero) {

    }

    @Override
    public void CastedOn(Pyromancer hero) {

    }
}
