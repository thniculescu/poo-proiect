package angel;

import constants.AngelConstants;
import constants.AngelInputConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.GOOD;
        type = AngelInputConstants.LEVELUPANGEL;
    }

    @Override
    public void affect(Pyromancer hero) {
        hero.addToBoost(AngelConstants.LVLDMGPYRO);
        hero.levelUp();
    }

    @Override
    public void affect(Knight hero) {
        hero.addToBoost(AngelConstants.LVLDMGKNIGHT);
        hero.levelUp();
    }

    @Override
    public void affect(Rogue hero) {
        hero.addToBoost(AngelConstants.LVLDMGROGUE);
        hero.levelUp();
    }

    @Override
    public void affect(Wizard hero) {
        hero.addToBoost(AngelConstants.LVLDMGWIZARD);
        hero.levelUp();
    }
}
