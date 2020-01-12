package angel;

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
