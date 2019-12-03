package spell;

import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public abstract class Spell {
    protected Hero castedBy; // cine a castat spellul, util pentru anumite spelluri
    protected float damage = 0;
    protected float terrainAmp; // amplificatorul de teren pentru momentul in care a fost castat spellul

    public Spell(final Hero hero, final float amp) {
        castedBy = hero;
        this.terrainAmp = amp;
    }

    public abstract Knight castedOn(Knight hero); // visitor pattern, abstract pentru ca trebuie sa fie Overrideuite de catre fiecare spell
    public abstract Wizard castedOn(Wizard hero); // aplica race amplifierul peste damageul de baza (care contine deja ampligier de teren)
    public abstract Rogue castedOn(Rogue hero);
    public abstract Pyromancer castedOn(Pyromancer hero);
}
