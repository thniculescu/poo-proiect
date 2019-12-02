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
    protected boolean paralyzed = false;
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

    public Hero(Hero hero) {
        this.hp = hero.hp;
        this.xp = hero.xp;
        this.x = hero.x;
        this.y = hero.y;
        this.level = hero.level;
        this.hpPerLevel = hero.hpPerLevel;
        this.maxHp = hero.maxHp;
        this.igniteDamage = hero.igniteDamage;
        this.igniteRounds = hero.igniteRounds;
        this.paralysisDamage = hero.paralysisDamage;
        this.paralysisRounds = hero.paralysisRounds;
        this.heroSpells = new ArrayList<>(hero.heroSpells);
        this.paralyzed = hero.paralyzed;
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
            paralyzed = true;
            hp -= paralysisDamage;
            paralysisRounds--;
        } else {
            paralyzed = false;
        }
    }

    public boolean alive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        if (hp > 0) {
            return level + " " + xp + " " + hp + " " + x + " " + y;
        } else {
            return "dead";
        }
    }

    abstract public Hero isAffectedBy(ArrayList<Spell> spells);

    public ArrayList<Spell> getSpells(float amp) {
        ArrayList<Spell> spellsToCast = new ArrayList<>();
        for(SpellTypes type : heroSpells) {
            Spell spell = SpellFactory.getInstance().get(type, this, amp);
            spellsToCast.add(spell);
        }
        return spellsToCast;
    }

    public void Move(Move move) {
        if(move == null || this.paralyzed) {
            return;
        }
        x += move.x;
        y += move.y;
    }

    public void gainXp(int addedXp) {
        xp += addedXp;
        if(xp > XpConstants.BASEXP + level * XpConstants.LVLUPEXP) {
            level++;
            maxHp += hpPerLevel;
            hp = maxHp;
        }
    }

    public void Paralyze(float paralysisDamage, int paralysisRounds) {
        this.paralysisDamage = Math.round(paralysisDamage);
        this.paralysisRounds = paralysisRounds;
    }

    public void Ignite(float igniteDamage, int igniteRounds) {
        this.igniteDamage = Math.round(igniteDamage);
        this.igniteRounds = igniteRounds;
    }

    public void takeDamage(float damage) {
        hp -= Math.round(damage);
    }
}
