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
    protected int fights;
    protected boolean paralyzed = false;
    protected ArrayList<SpellTypes> heroSpells = new ArrayList<>();

    public Hero(final int x, final int y) {
        this.x = x;
        this.y = y;
        level = 0;
        xp = 0;
        igniteDamage = 0;
        igniteRounds = 0;
        paralysisDamage = 0;
        paralysisRounds = 0;
        fights = 0;
    }

    public Hero(final Hero hero) {
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
        this.fights = hero.fights;
    }

    public final int getFights() {
        return fights;
    }

    public final void increaseFights() {
        fights++;
    }

    public final int getHp() {
        return hp;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final int getLevel() {
        return level;
    }

    public final int getMaxHp() {
        return maxHp;
    }

    public final void applyStatus() {
        if (igniteRounds > 0) {
            hp -= igniteDamage;
            igniteRounds--;
        }

        if (paralysisRounds > 0) {
            paralyzed = true;
            hp -= paralysisDamage;
            paralysisRounds--;
        } else {
            paralyzed = false;
        }
    }

    public final boolean alive() {
        return hp > 0;
    }

    /** **/
    @Override
    public String toString() {
        if (hp > 0) {
            return level + " " + xp + " " + hp + " " + x + " " + y;
        } else {
            return "dead";
        }
    }

    public abstract Hero isAffectedBy(ArrayList<Spell> spells);

    /** **/
    public ArrayList<Spell> getSpells(final float amp) {
        ArrayList<Spell> spellsToCast = new ArrayList<>();
        for (SpellTypes type : heroSpells) {
            Spell spell = SpellFactory.getInstance().get(type, this, amp);
            spellsToCast.add(spell);
        }
        return spellsToCast;
    }

    public final void move(final Move move) {
        if (move == null || this.paralyzed) {
            return;
        }
        x += move.getX();
        y += move.getY();
    }

    public final void gainXp(final int addedXp) {
        xp += addedXp;
        while (xp >= XpConstants.BASEXP + level * XpConstants.LVLUPEXP) {
            level++;
            maxHp += hpPerLevel;
            hp = maxHp;
        }
    }

    public final void paralyze(final float damage, final int duration) {
        this.paralysisDamage = Math.round(damage);
        this.paralysisRounds = duration;
    }

    public final void ignite(final float damage, final int duration) {
        this.igniteDamage = Math.round(damage);
        this.igniteRounds = duration;
    }

    public final void takeDamage(final float damage) {
        hp -= Math.round(damage);
    }
}
