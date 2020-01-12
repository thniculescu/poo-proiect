package grandmagus;

import angel.Angel;
import angel.Spawner;
import constants.AngelInputConstants;
import hero.Hero;
import hero.HeroFactory;

import java.util.ArrayList;

public class GrandMagus {
    private static GrandMagus instance = null;
    ArrayList<String> information;
    ArrayList<String> lvl_info;

    private GrandMagus() {
        information = new ArrayList<>();
    }

    public static GrandMagus getInstance() { // singleton pattern, nu sunt utile mai multe instante de GrandMagus
        if (instance == null) {
            instance = new GrandMagus();
        }
        return instance;
    }

    public final ArrayList<String> getAllInformation() {
        information.addAll(lvl_info);
        return information;
    }

    public final void clearInformation() {
        information = new ArrayList<>();
        lvl_info = new ArrayList<>();
    }

    public final void update(final Angel angel) {
        information.add("Angel " + angel.getType()
                + " was spawned at " + angel.getX() + " " + angel.getY());
    }

    public final void update(final Angel angel, final Hero hero) {
        if(hero.alive()) {
            if(angel.getType() == AngelInputConstants.SPAWNER) {
                return;
            }
        } else {
            if(angel.getType() != AngelInputConstants.SPAWNER) {
                return;
            }
        }
        information.add(angel.getType() + " "
                + angel.getFaction() + " " + hero.getType() + " " + hero.getId());
    }

    public final void update(final Hero hero) {
        String action;
        if(hero.alive()) {
            action = "brought to life";
        } else {
            action = "killed";
        }

        information.add("Player " + hero.getType() + " " + hero.getId() + " was " + action + " by an angel");
    }

    public final void update(final Hero waskilled, final Hero killer) {
        information.add("Player " + waskilled.getType() + " "
                + waskilled.getId() + " was killed by " + killer.getType() + " " + killer.getId());
    }

    public final void update(final Hero hero, final int level) {
        lvl_info.add(hero.getType() + " " + hero.getId() + " reached level " + level);
    }

}
