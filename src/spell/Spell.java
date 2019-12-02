package spell;

import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public abstract class Spell {
    protected Hero castedBy;
    protected float damage = 0;
    protected float terrainAmp;

    public Spell(final Hero hero, final float amp) {
        castedBy = hero;
        this.terrainAmp = amp;
    }

    public abstract Knight castedOn(Knight hero);
    public abstract Wizard castedOn(Wizard hero);
    public abstract Rogue castedOn(Rogue hero);
    public abstract Pyromancer castedOn(Pyromancer hero);
}
