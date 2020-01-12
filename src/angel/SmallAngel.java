package angel;

import constants.AngelConstants;
import constants.AngelInputConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class SmallAngel extends Angel {
    public SmallAngel(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.GOOD;
        type = AngelInputConstants.SMALLANGEL;
    }

    @Override
    public void affect(Pyromancer hero) {
        hero.heal(AngelConstants.SMADMGPYRO);
        hero.addToBoost(AngelConstants.SMAHPPYRO);
    }

    @Override
    public void affect(Knight hero) {
        hero.heal(AngelConstants.SMAHPKNIGHT);
        hero.addToBoost(AngelConstants.SMADMGKNIGHT);
    }

    @Override
    public void affect(Rogue hero) {
        hero.heal(AngelConstants.SMAHPROGUE);
        hero.addToBoost(AngelConstants.SMADMGROGUE);
    }

    @Override
    public void affect(Wizard hero) {
        hero.heal(AngelConstants.SMAHPWIZARD);
        hero.addToBoost(AngelConstants.SMADMGWIZARD);
    }
}
