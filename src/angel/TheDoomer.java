package angel;

import constants.AngelInputConstants;
import grandmagus.GrandMagus;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class TheDoomer extends Angel{

    public TheDoomer(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.BAD;
        type = AngelInputConstants.THEDOOMER;
    }

    @Override
    public void affect(Pyromancer hero) {
        hero.setHp(0);
    }

    @Override
    public void affect(Knight hero) {
        hero.setHp(0);
    }

    @Override
    public void affect(Rogue hero) {
        hero.setHp(0);
    }

    @Override
    public void affect(Wizard hero) {
        hero.setHp(0);
    }
}
