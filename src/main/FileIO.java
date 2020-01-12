package main;

import angel.Angel;
import angel.AngelFactory;
import hero.Hero;
import hero.HeroFactory;
import hero.Move;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public final class FileIO {

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

    public FileIO(final String in, final String out) {
        try {
            input = new Scanner(new File(in));
            output = new PrintWriter(new File(out));
        } catch (Exception ignored) {
        }
    }

    public void readInput() {
        int n;
        n = input.nextInt();
        input.nextLine();
        ArrayList<String> inputMap = new ArrayList<>();
        for (int i = 0; i < n; i++) { // citeste harta linie cu linie
            inputMap.add(input.nextLine());
        }
        TerrainMap map = TerrainMap.getInstance();
        map.setTerrain(inputMap); // harta este transformata in casute tip terraintype

        int numHeroes = Integer.parseInt(input.nextLine());
        HeroFactory heroFactory = HeroFactory.getInstance();
        for (int i = 0; i < numHeroes; i++) { // sunt cititi si initializati eroii
            char type = input.next().charAt(0);
            int x = input.nextInt();
            int y = input.nextInt();
            input.nextLine();
            heroes.add(heroFactory.get(type, x, y));
        }

        numRounds = Integer.parseInt(input.nextLine());
        for (int i = 0; i < numRounds; i++) { // se citesc si se parseaza miscarile fiecarui erou, lnie cu linie
            String inputMoves = input.nextLine();
            ArrayList<Move> roundMoves = new ArrayList<>();
            for (int j = 0; j < inputMoves.length(); j++) {
                Move cur;
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
                    default:
                        cur = null;
                }
                roundMoves.add(cur);
            }
            moves.add(roundMoves);
        }
    }

    ArrayList<Angel> getRoundAngels() {
        String angelsString = input.nextLine();
        ArrayList<Angel> roundAngels = new ArrayList<>();

        String[] angelArray = angelsString.split(" ");
        int numAngels = Integer.parseInt(angelArray[0]);
        for(int i = 0; i < numAngels; i++) {
            String[] angelParams = angelArray[i + 1].split(",");
            roundAngels.add(AngelFactory.getInstance().get(angelParams[0],
                    Integer.valueOf(angelParams[1]),
                    Integer.valueOf(angelParams[2])));
        }
        return roundAngels;
    }

    public PrintWriter getOutput() {
        return output;
    }

    public void printOutput() {
        for (Hero hero : heroes) { // afiseaza in output starea eroilor
            output.println(hero);
        }
        output.flush();
    }
}
