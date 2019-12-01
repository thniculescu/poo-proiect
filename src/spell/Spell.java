package spell;

import hero.Hero;

import java.util.ArrayList;

public interface Spell {
    ArrayList<StatusEffect> statusesApplied = null;
    Hero castedBy = null;
    float damage = 0;
    public void CastedOn(Hero hero);
}
