package main;

import constants.HeroInputConstants;
import hero.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    private Scanner input;
    private PrintWriter output;
    private ArrayList<Hero> heroes = new ArrayList<>();
    private ArrayList<ArrayList<Move>> moves = new ArrayList<>();
    private int numRounds;

    public int getNumRounds() {
        return numRounds;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public ArrayList<ArrayList<Move>> getMoves() {
        return moves;
    }

    public FileIO(String in, String out) {
        try {
            input = new Scanner(new File(in));
            output = new PrintWriter(new File(out));
        } catch (Exception e) {
        }
    }

    public void ReadInput() {
        int n, m;
        n = input.nextInt();
        m = input.nextInt();
        input.nextLine();
        ArrayList<String> inputMap = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputMap.add(input.nextLine());
        }
        TerrainMap map = TerrainMap.getInstance();
        map.setTerrain(inputMap);

        int numHeroes = Integer.parseInt(input.nextLine());
        HeroFactory heroFactory = HeroFactory.getInstance();
        for (int i = 0; i < numHeroes; i++) {
            char type = input.next().charAt(0);
            int x = input.nextInt();
            int y = input.nextInt();
            input.nextLine();
            heroes.add(heroFactory.get(type, x, y));
        }

        numRounds = Integer.parseInt(input.nextLine());
        for(int i = 0; i < numRounds; i++) {
            String inputMoves = input.nextLine();
            ArrayList<Move> roundMoves = new ArrayList<>();
            for(int j = 0; j < inputMoves.length(); j++) {
                Move cur = null;
                switch (inputMoves.charAt(j)) {
                    case 'U':
                        cur = new Move(-1, 0);
                        break;
                    case 'D':
                        cur = new Move(1, 0);
                        break;
                    case 'L':
                        cur = new Move(0, -1);
                        break;
                    case 'R':
                        cur = new Move(0, 1);
                        break;
                }
                roundMoves.add(cur);
            }
            moves.add(roundMoves);
        }
    }
}
