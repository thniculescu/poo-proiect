package main;

import hero.Hero;
import hero.Move;

import java.util.ArrayList;

public class Main {
    public static void main (String args[]) {
        FileIO fileIO = new FileIO(args[0], args[1]);
        fileIO.ReadInput();

        ArrayList<Hero> heroes = fileIO.getHeroes();
        ArrayList<ArrayList<Move>> moves = fileIO.getMoves();
        int numRounds = fileIO.getNumRounds();

        System.out.println(heroes);

        System.out.println(moves);
    }
}
