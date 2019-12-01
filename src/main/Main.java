package main;

import hero.Hero;
import hero.Move;
import spell.Spell;

import java.util.ArrayList;

public class Main {
    public static void main (String args[]) {
        FileIO fileIO = new FileIO(args[0], args[1]);
        fileIO.ReadInput();

        ArrayList<Hero> heroes = fileIO.getHeroes();
        ArrayList<ArrayList<Move>> moves = fileIO.getMoves();
        int numRounds = fileIO.getNumRounds();

        for(int i = 0; i < numRounds; i++) {
            for(int j = 0; j < heroes.size(); j++) {
                heroes.get(j).Move(moves.get(i).get(j));
                heroes.get(j).applyStatus();
            }

            for(int j = 0; j < heroes.size(); j++) {
                Hero first = heroes.get(j);
                for(int k = j + 1; k < heroes.size(); k++) {
                    Hero second = heroes.get(k);
                    if(first.getX() == second.getX()
                    && first.getY() == second.getY()
                    && first.alive() && second.alive()) {
                        ArrayList<Spell> firstSpells = first.getSpells(1);
                        ArrayList<Spell> secondSpells = second.getSpells(1);
                        first.isAffectedBy(secondSpells);
                        second.isAffectedBy(firstSpells);
                    }
                }
            }
        }

        for(int i = 0; i < heroes.size(); i++) {
            System.out.println(heroes.get(i));
        }
    }
}
