package main;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    private Scanner input;
    private PrintWriter output;

    public FileIO(String in, String out) {
        try {
            input = new Scanner(new File(in));
            output = new PrintWriter(new File(out));
        } catch (Exception e) {
            System.out.println("Nu pot deschide fisierele INTARE/IESIRE!");
        }
    }

    public void ReadInput() {
        int n, m;
        n = input.nextInt();
        m = input.nextInt();
        input.nextLine();
        ArrayList<String> inputMap = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            inputMap.add(input.nextLine());
        }
        TerrainMap map = TerrainMap.getInstance();
        map.setTerrain(inputMap);
    }
}
