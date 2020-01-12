package angel;

import constants.AngelConstants;
import constants.AngelInputConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class DarkAngel extends Angel {
    public DarkAngel(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.BAD;
        type = AngelInputConstants.DARKANGEL;
    }

    @Override
    public void affect(Pyromancer hero) {
        hero.takeDamage(AngelConstants.DRKPYRO);
    }

    @Override
    public void affect(Knight hero) {
        hero.takeDamage(AngelConstants.DRKKNIGHT);
    }

    @Override
    public void affect(Rogue hero) {
        hero.takeDamage(AngelConstants.DRKROGUE);
    }

    @Override
    public void affect(Wizard hero) {
        hero.takeDamage(AngelConstants.DRKWIZARD);
    }
}
