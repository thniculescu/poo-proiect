package spell;

import hero.*;

public class Ignite extends Spell {

    public Ignite(Hero hero, float amp) {
        super(hero, amp);
        System.out.println(hero + " casted IGNITE");
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
