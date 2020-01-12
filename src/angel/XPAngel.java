package angel;

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

    }

    @Override
    public void affect(Knight hero) {

    }

    @Override
    public void affect(Rogue hero) {

    }

    @Override
    public void affect(Wizard hero) {

    }
}
