package main;

import constants.MapConstants;

import java.util.ArrayList;

public final class TerrainMap {
    private static TerrainMap instance = null;
    private TerrainTypes[][] terrain;

    private TerrainMap() {
    }

    public TerrainTypes getTerrain(final int x, final int y) {
        return terrain[x][y];
    }

    public void setTerrain(final ArrayList<String> input) {
        int height = input.size();
        int width = input.get(0).length();

        terrain = new TerrainTypes[height][width];

        for (int i = 0; i < height; i++) {
            String curLine = input.get(i);
            for (int j = 0; j < width; j++) {
                TerrainTypes cur;
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
                    default:
                        cur = null;
                }
                terrain[i][j] = cur;
            }
        }
    }

    public static TerrainMap getInstance() {
        if (instance == null) {
            instance = new TerrainMap();
        }
        return instance;
    }
}
