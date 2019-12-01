package hero;

import spell.Spell;
import spell.SpellFactory;
import spell.SpellTypes;
import spell.StatusEffect;

import java.util.ArrayList;

public abstract class Hero {
    int hp, xp, x, y, level;
    ArrayList<StatusEffect> heroStatus;
    ArrayList<SpellTypes> heroSpells;

    @Override
    public String toString() {
        return "Hero{" +
                "hp=" + hp +
                ", xp=" + xp +
                ", x=" + x +
                ", y=" + y +
                ", heroStatus=" + heroStatus +
                '}';
    }

    public void isAffectedBy(ArrayList<Spell> spells) {
        for(Spell spell : spells) {
            spell.CastedOn(this);
        }
    }

    public ArrayList<Spell> getSpells() {
        ArrayList<Spell> spellsToCast = new ArrayList<>();
        for(SpellTypes type : heroSpells) {
            spellsToCast.add(SpellFactory.getInstance().get(type, this));
        }
        return spellsToCast;
    }

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
        this.level = 0;
        this.xp = 0;
    }

    public void Move(Move move) {
        if(move == null) {
            return;
        }
        x += move.x;
        y += move.y;
    }
}
