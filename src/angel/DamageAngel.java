package angel;

import constants.AngelConstants;
import constants.AngelInputConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class DamageAngel extends Angel {
    public DamageAngel(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.GOOD;
        type = AngelInputConstants.DAMAGEANGEL;
    }

    @Override
    public void affect(Pyromancer hero) {
        hero.addToBoost(AngelConstants.DMGPYRO);
    }

    @Override
    public void affect(Knight hero) {
        hero.addToBoost(AngelConstants.DMGKNIGHT);
    }

    @Override
    public void affect(Rogue hero) {
        hero.addToBoost(AngelConstants.DMGROGUE);
    }

    @Override
    public void affect(Wizard hero) {
        hero.addToBoost(AngelConstants.DMGWIWIZARD);
    }
}
