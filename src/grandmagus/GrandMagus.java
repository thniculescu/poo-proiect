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

    private GrandMagus() {
        information = new ArrayList<>();
    }

    public static GrandMagus getInstance() { // singleton pattern, nu sunt utile mai multe instante de GrandMagus
        if (instance == null) {
            instance = new GrandMagus();
        }
        return instance;
    }

    public final ArrayList<String> getInformation() {
        return information;
    }

    public final void clearInformation() {
        information = new ArrayList<>();
    }

    public final void update(final Angel angel) {
        information.add("Angel " + angel.getType()
                + " was spawned at " + angel.getX() + " " + angel.getY());
    }

    public final void update(final Angel angel, final Hero hero, final int id) {
        if(hero.alive()) {
            if(angel.getType() == AngelInputConstants.SPAWNER) {
                return;
            }
        } else {
            if(angel.getType() != AngelInputConstants.SPAWNER) {
                return;
            }
        }
        information.add("Angel " + angel.getType() + " "
                + angel.getFaction() + " " + hero.getType() + " " + id);
    }

    public final void update(final Hero hero, final int id) {
        String action;
        if(hero.alive()) {
            action = "brought to life";
        } else {
            action = "killed";
        }

        information.add("Player " + hero.getType() + " " + id + " was " + action + " by an angel");
    }

}
