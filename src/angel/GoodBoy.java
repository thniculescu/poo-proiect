package angel;

import constants.AngelConstants;
import constants.AngelInputConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class GoodBoy extends Angel {
    public GoodBoy(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.GOOD;
        type = AngelInputConstants.GOODBOY;
    }

    @Override
    public void affect(Pyromancer hero) {
        hero.heal(AngelConstants.GBYDMGPYRO);
        hero.addToBoost(AngelConstants.GBYHPPYRO);
    }

    @Override
    public void affect(Knight hero) {
        hero.heal(AngelConstants.GBYHPKNIGHT);
        hero.addToBoost(AngelConstants.GBYDMGKNIGHT);
    }

    @Override
    public void affect(Rogue hero) {
        hero.heal(AngelConstants.GBYHPROGUE);
        hero.addToBoost(AngelConstants.GBYDMGROGUE);
    }

    @Override
    public void affect(Wizard hero) {
        hero.heal(AngelConstants.GBYHPWIZARD);
        hero.addToBoost(AngelConstants.GBYDMGWIZARD);
    }
}
