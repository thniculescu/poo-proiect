package spell;

import hero.*;

import java.util.ArrayList;

public abstract class Spell {
    protected final Hero castedBy;
    protected float damage = 0;
    protected float amp;

    public Spell(Hero hero, float amp) {
        castedBy = hero;
        this.amp = amp;
    }

    public void CastedOn(Knight hero) {}
    public void CastedOn(Wizard hero) {}
    public void CastedOn(Rogue hero) {}
    public void CastedOn(Pyromancer hero) {}
}
