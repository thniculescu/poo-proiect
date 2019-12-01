package hero;

import constants.XpConstants;
import spell.Spell;
import spell.SpellFactory;
import spell.SpellTypes;

import java.util.ArrayList;

public abstract class Hero {
    protected int hp, xp, x, y, level, hpPerLevel, maxHp;
    protected int igniteDamage;
    protected int igniteRounds;
    protected int paralysisDamage;
    protected int paralysisRounds;
    protected ArrayList<SpellTypes> heroSpells = new ArrayList<>();

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
        level = 0;
        xp = 0;
        igniteDamage = 0;
        igniteRounds = 0;
        paralysisDamage = 0;
        paralysisRounds = 0;
    }

    public int getHp() {
        return hp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void applyStatus() {
        if(igniteRounds > 1) {
            hp -= igniteDamage;
            igniteRounds--;
        }

        if(paralysisRounds > 0) {
            hp -= paralysisDamage;
            paralysisRounds--;
        }
    }

    public boolean alive() {
        if(hp > 0) {
            return true;
        }
        return false;
    }

    public boolean stunned() {
        if(paralysisRounds > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (hp > 0) {
            return level + " " + xp + " " + hp + " " + x + " " + y;
        } else {
            return "dead";
        }
    }

    abstract public void isAffectedBy(ArrayList<Spell> spells);

    public ArrayList<Spell> getSpells(float amp) {
        ArrayList<Spell> spellsToCast = new ArrayList<>();
        for(SpellTypes type : heroSpells) {
            Spell spell = SpellFactory.getInstance().get(type, this, amp);
            spellsToCast.add(spell);
        }
        return spellsToCast;
    }

    public void Move(Move move) {
        if(move == null) {
            return;
        }
        x += move.x;
        y += move.y;
    }

    public void levelUp() {
        if(xp > XpConstants.BASEXP + level * XpConstants.LVLUPEXP) {
            level++;
            maxHp += hpPerLevel;
            hp = maxHp;
        }
    }
}
