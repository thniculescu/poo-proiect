package main;

import constants.XpConstants;
import hero.Hero;
import hero.Move;
import spell.Spell;

import java.util.ArrayList;

import static java.lang.Math.max;

public final class Main {
    private Main() { }
    public static void main(final String[] args) {
        FileIO fileIO = new FileIO(args[0], args[1]);
        fileIO.readInput();

        ArrayList<Hero> heroes = fileIO.getHeroes();
        ArrayList<ArrayList<Move>> moves = fileIO.getMoves();
        int numRounds = fileIO.getNumRounds();

        for (int i = 0; i < numRounds; i++) {
            for (int j = 0; j < heroes.size(); j++) {
                heroes.get(j).applyStatus();
                heroes.get(j).move(moves.get(i).get(j));
            }

            for (int j = 0; j < heroes.size(); j++) {
                Hero first = heroes.get(j);
                for (int k = j + 1; k < heroes.size(); k++) {
                    Hero second = heroes.get(k);
                    if (first.getX() == second.getX()
                    && first.getY() == second.getY()
                    && first.alive() && second.alive()) {

                        ArrayList<Spell> firstSpells =
                                first.getSpells(1f);
                        ArrayList<Spell> secondSpells =
                                second.getSpells(1f);

                        first = first.isAffectedBy(secondSpells);
                        second = second.isAffectedBy(firstSpells);

                        int potentialXp1 = max(0, XpConstants.GAINXP
                                - (first.getLevel() - second.getLevel())
                                * XpConstants.LVLDIFMULTIPLIER);
                        int potentialXp2 = max(0, XpConstants.GAINXP
                                - (second.getLevel() - first.getLevel())
                                * XpConstants.LVLDIFMULTIPLIER);

                        if (first.alive() && !second.alive()) {
                            first.gainXp(potentialXp1);
                        }
                        if (!first.alive() && second.alive()) {
                            second.gainXp(potentialXp2);
                        }
                        first.increaseFights();
                        second.increaseFights();
                        heroes.set(j, first);
                        heroes.set(k, second);
                    }
                }
            }
        }

        fileIO.printOutput();
    }
}
