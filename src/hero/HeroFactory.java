package hero;

import constants.HeroInputConstants;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() {
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero get(final char type, final int x, final int y) {
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
