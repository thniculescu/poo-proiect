package hero;

import angel.Angel;
import constants.XpConstants;
import grandmagus.GrandMagus;
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
    protected String status;
    protected boolean paralyzed = false;
    protected ArrayList<SpellTypes> heroSpells = new ArrayList<>();
    protected float damageBoost = 0f;
    protected int id;

    public Hero(final int x, final int y) { // initializeaza un erou la o anumita pozitie
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

    public Hero(final Hero hero) { // copy constructor
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
        this.id = hero.id;
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

    public final void applyStatus() { // aplica statusurile de ignite si paralyze daca este cazul
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

    /** Face afisarea mai "clean" de codat. **/
    @Override
    public String toString() {
        if (hp > 0) {
            return level + " " + xp + " " + hp + " " + x + " " + y;
        } else {
            return "dead";
        }
    }

    public abstract Hero isAffectedBy(ArrayList<Spell> spells); // aplica spellurile pe erou
                                                                // nu exista erou de tip Hero => functia este abstract
    public abstract void isAffectedBy(Angel angel); // asemanator pentru ingeri

    /** Intoarce lista de spelluri, amp este amplificatorul de teren cu care sunt modificate spellurile. **/
    public ArrayList<Spell> getSpells(final float amp) {
        ArrayList<Spell> spellsToCast = new ArrayList<>();
        for (SpellTypes type : heroSpells) {
            Spell spell = SpellFactory.getInstance().get(type, this, amp);
            spellsToCast.add(spell);
        }
        return spellsToCast;
    }

    public final void move(final Move move) { // misca eroul daca se poate
        if (move == null || this.paralyzed) {
            return;
        }
        x += move.getX();
        y += move.getY();
    }

    public final void gainXp(final int addedXp) { // se ocupa de procesul de level up
        xp += addedXp;
        while (xp >= XpConstants.BASEXP + level * XpConstants.LVLUPEXP) {
            level++;
            GrandMagus.getInstance().update(this, level);
            maxHp += hpPerLevel;
            hp = maxHp;
        }
    }

    public final void levelUp() { // creste eroul cu un nivel
        xp = XpConstants.BASEXP + level * XpConstants.LVLUPEXP;
        level++;
        GrandMagus.getInstance().update(this, level);
        maxHp += hpPerLevel;
        hp = maxHp;
    }

    public final void paralyze(final float damage, final int duration) { // updateaza statusul de paralyzed
        this.paralysisDamage = Math.round(damage);
        this.paralysisRounds = duration;
    }

    public final void ignite(final float damage, final int duration) { // updateaza statusul de ignite
        this.igniteDamage = Math.round(damage);
        this.igniteRounds = duration;
    }

    public final void addToBoost(final float boost) {
        damageBoost += boost;
    }

    public final void takeDamage(final float damage) {
        hp -= Math.round(damage);
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }


    public final void heal(final float heal) {
        hp = Math.min((int)(hp + heal), maxHp);
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public abstract String getType();
}
