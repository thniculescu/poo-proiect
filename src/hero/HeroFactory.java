package hero;

import constants.HeroInputConstants;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() {
    }

    public static HeroFactory getInstance() { // singleton pattern, nu sunt utile mai multe instante de hero factory
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero get(final char type, final int x, final int y) { // instantiaza un nou erou la pozitia x, y de tipul type
        switch (type) {
            case HeroInputConstants.KNIGHT:
                return new Knight(x, y);
            case HeroInputConstants.WIZARD:
                return new Wizard(x, y);
            case HeroInputConstants.ROGUE:
                return new Rogue(x, y);
            case HeroInputConstants.PYROMANCER:
                return new Pyromancer(x, y);
            default:
                return null;
        }
    }
}
