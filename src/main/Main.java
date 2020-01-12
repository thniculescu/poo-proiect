package main;

import angel.Angel;
import constants.XpConstants;
import grandmagus.GrandMagus;
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
        GrandMagus grandMagus = GrandMagus.getInstance();
        int numRounds = fileIO.getNumRounds();

        for (int i = 0; i < numRounds; i++) {
            fileIO.getOutput().println("~~ Round " + (int)(i + 1) + " ~~");
            grandMagus.clearInformation();
            for (int j = 0; j < heroes.size(); j++) { // sunt aplicate statusurile si se misca eroii
                heroes.get(j).applyStatus();
                heroes.get(j).move(moves.get(i).get(j));
            }

            for (int j = 0; j < heroes.size(); j++) { // nu marchez eroii care s-au luptat pentru ca nu pot avea mai mult de un fight pe runda
                Hero first = heroes.get(j);
                for (int k = j + 1; k < heroes.size(); k++) {
                    Hero second = heroes.get(k);
                    if (first.getX() == second.getX()
                    && first.getY() == second.getY()
                    && first.alive() && second.alive()) { // conditia pentru a avea loc o batalie

                        ArrayList<Spell> firstSpells =
                                first.getSpells(1f); // sunt generate spellurile inainte ca eroii sa piarda viata
                        ArrayList<Spell> secondSpells =
                                second.getSpells(1f);

                        first = first.isAffectedBy(secondSpells); // eroii sunt afectati de spelurile ceiluilalt erou, nu conteaza ordinea
                        second = second.isAffectedBy(firstSpells);

                        int potentialXp1 = max(0, XpConstants.GAINXP // xpul pe care l-ar castiga first daca ar castiga lupta
                                - (first.getLevel() - second.getLevel())
                                * XpConstants.LVLDIFMULTIPLIER);
                        int potentialXp2 = max(0, XpConstants.GAINXP // analog pentru second
                                - (second.getLevel() - first.getLevel())
                                * XpConstants.LVLDIFMULTIPLIER);

                        if (first.alive() && !second.alive()) { // se acorda xp daca este cazul
                            first.gainXp(potentialXp1);
                        }
                        if (!first.alive() && second.alive()) {
                            second.gainXp(potentialXp2);
                        }
                        first.increaseFights();
                        second.increaseFights();
                        heroes.set(j, first); // se updateaza eroii in heroes, pentru rundele viitoare
                        heroes.set(k, second);
                    }
                }
            }

            ArrayList<Angel> roundAngels = fileIO.getRoundAngels();
            for(Angel angel : roundAngels) {
                grandMagus.update(angel);
                for(int j = 0; j < heroes.size(); j++) {
                    if(heroes.get(j).getX() == angel.getX()
                    && heroes.get(j).getY() == angel.getY()) {
                        boolean before = heroes.get(j).alive();
                        heroes.get(j).isAffectedBy(angel);
                        grandMagus.update(angel, heroes.get(j), j);
                        boolean after = heroes.get(j).alive();
                        if(before != after) {
                            grandMagus.update(heroes.get(j), j);
                        }
                    }
                }
            }

            for(String string : grandMagus.getInformation()) {
                fileIO.getOutput().println(string);
            }
            fileIO.getOutput().println("");
        }

        fileIO.printOutput();
    }
}
