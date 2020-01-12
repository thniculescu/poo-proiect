package angel;

import constants.AngelInputConstants;

public class AngelFactory {

    private static AngelFactory instance = null;

    private AngelFactory() {
    }

    public static AngelFactory getInstance() { // singleton pattern, nu sunt utile mai multe instante de angel factory
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    public Angel get(final String type, final int x, final int y) { // instantiaza un nou inger la pozitia x, y de tipul type
        switch (type) {
            case AngelInputConstants.DAMAGEANGEL:
                return new DamageAngel(x, y);
            case AngelInputConstants.DARKANGEL:
                return new DarkAngel(x, y);
            case AngelInputConstants.DRACULA:
                return new Dracula(x, y);
            case AngelInputConstants.GOODBOY:
                return new GoodBoy(x, y);
            case AngelInputConstants.LEVELUPANGEL:
                return new LevelUpAngel(x, y);
            case AngelInputConstants.LIFEGIVER:
                return new LifeGiver(x, y);
            case AngelInputConstants.SMALLANGEL:
                return new SmallAngel(x, y);
            case AngelInputConstants.SPAWNER:
                return new Spawner(x, y);
            case AngelInputConstants.XPANGEL:
                return new XPAngel(x, y);
            case AngelInputConstants.THEDOOMER:
                return new TheDoomer(x, y);
            default:
                return null;
        }
    }
}
