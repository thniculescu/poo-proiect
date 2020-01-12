package angel;

import constants.AngelConstants;
import constants.AngelInputConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class Spawner extends Angel {
    public Spawner(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.GOOD;
        type = AngelInputConstants.SPAWNER;
    }

    @Override
    public void affect(Pyromancer hero) {
        if(!hero.alive()) {
            hero.setHp((int)AngelConstants.SPWHPPYRO);
        }
    }

    @Override
    public void affect(Knight hero) {
        if(!hero.alive()) {
            hero.setHp((int)AngelConstants.SPWHPKNIGHT);
        }
    }

    @Override
    public void affect(Rogue hero) {
        if(!hero.alive()) {
            hero.setHp((int)AngelConstants.SPWHPROGUE);
        }
    }

    @Override
    public void affect(Wizard hero) {
        if(!hero.alive()) {
            hero.setHp((int)AngelConstants.SPWHPWIZARD);
        }
    }
}
