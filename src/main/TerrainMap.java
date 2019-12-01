package main;

import constants.MapConstants;

import java.util.ArrayList;

public class TerrainMap {
    private static TerrainMap instance = null;
    private TerrainTypes[][] terrain;
    private int height;
    private int width;

    private TerrainMap() {
    }

    public TerrainTypes getTerrain(int x, int y) {
        return terrain[x][y];
    }

    public void setTerrain(ArrayList<String> input) {
        height = input.size();
        width = input.get(0).length();

        terrain = new TerrainTypes[height][width];

        for(int i = 0; i < height; i++) {
            String curLine = input.get(i);
            for(int j = 0; j < width; j++) {
                TerrainTypes cur = null;
                switch (curLine.charAt(j)) {
                    case MapConstants.LAND:
                        cur = TerrainTypes.Land;
                        break;
                    case MapConstants.WOODS:
                        cur = TerrainTypes.Woods;
                        break;
                    case MapConstants.VOLCANIC:
                        cur = TerrainTypes.Volcanic;
                        break;
                    case MapConstants.DESERT:
                        cur = TerrainTypes.Desert;
                        break;
                }
                terrain[i][j] = cur;
            }
        }
    }

    public static TerrainMap getInstance() {
        if(instance == null) {
            instance = new TerrainMap();
        }
        return instance;
    }
}
