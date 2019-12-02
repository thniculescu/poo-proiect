package spell;

import hero.*;

public abstract class Spell {
    protected final Hero castedBy;
    protected float damage = 0;
    protected float terrainAmp;

    public Spell(Hero hero, float amp) {
        castedBy = hero;
        this.terrainAmp = amp;
    }

    public Knight CastedOn(Knight hero) {
        return hero;
    }
    public Wizard CastedOn(Wizard hero) {
        return hero;
    }
    public Rogue CastedOn(Rogue hero) {
        return hero;
    }
    public Pyromancer CastedOn(Pyromancer hero) {
        return hero;
    }
}
