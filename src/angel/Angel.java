package angel;

import grandmagus.GrandMagus;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public abstract class Angel {
    protected final int x;
    protected final int y;
    protected String faction; // GOOD => helps BAD => hits
    protected String type;
    static GrandMagus grandMagus = GrandMagus.getInstance();

    public Angel(final int x, final int y) { // initializeaza un inger la o anumita pozitie
        this.x = x;
        this.y = y;
    }

    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
    }
    public String getFaction() {
        return faction;
    }

    public abstract void affect(final Pyromancer hero);
    public abstract void affect(final Knight hero);
    public abstract void affect(final Rogue hero);
    public abstract void affect(final Wizard hero);

    public String getType() {
        return type;
    }
}
