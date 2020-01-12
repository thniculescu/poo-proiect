package angel;

import constants.AngelConstants;
import constants.AngelInputConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class XPAngel extends Angel {
    public XPAngel(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.GOOD;
        type = AngelInputConstants.XPANGEL;
    }

    @Override
    public void affect(Pyromancer hero) {
        hero.gainXp((int) AngelConstants.XPHPPYRO);
    }

    @Override
    public void affect(Knight hero) {
        hero.gainXp((int) AngelConstants.XPHPKNIGHT);
    }

    @Override
    public void affect(Rogue hero) {
        hero.gainXp((int) AngelConstants.XPHPROGUE);
    }

    @Override
    public void affect(Wizard hero) {
        hero.gainXp((int) AngelConstants.XPHPWIZARD);
    }
}
