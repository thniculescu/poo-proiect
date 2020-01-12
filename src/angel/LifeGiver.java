package angel;

import constants.AngelConstants;
import constants.AngelInputConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class LifeGiver extends Angel {
    public LifeGiver(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.GOOD;
        type = AngelInputConstants.LIFEGIVER;
    }

    @Override
    public void affect(Pyromancer hero) {
        hero.heal(AngelConstants.LIGHPPYRO);
    }

    @Override
    public void affect(Knight hero) {
        hero.heal(AngelConstants.LIGHPKNIGHT);
    }

    @Override
    public void affect(Rogue hero) {
        hero.heal(AngelConstants.LIGHPROGUE);
    }

    @Override
    public void affect(Wizard hero) {
        hero.heal(AngelConstants.LIGHPWIZARD);
    }
}
