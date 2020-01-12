package angel;

import constants.AngelConstants;
import constants.AngelInputConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public class Dracula extends Angel {
    public Dracula(int x, int y) {
        super(x, y);
        faction = AngelInputConstants.BAD;
        type = AngelInputConstants.DRACULA;
    }

    @Override
    public void affect(Pyromancer hero) {
        hero.takeDamage(AngelConstants.DRAHPPYRO);
        hero.addToBoost(AngelConstants.DRADMGPYRO);
    }

    @Override
    public void affect(Knight hero) {
        hero.takeDamage(AngelConstants.DRAHPKNIGHT);
        hero.addToBoost(AngelConstants.DRADMGKNIGHT);
    }

    @Override
    public void affect(Rogue hero) {
        hero.takeDamage(AngelConstants.DRAHPROGUE);
        hero.addToBoost(AngelConstants.DRADMGROGUE);
    }

    @Override
    public void affect(Wizard hero) {
        hero.takeDamage(AngelConstants.DRAHPWIZARD);
        hero.addToBoost(AngelConstants.DRADMGWIZARD);
    }
}
