package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final long SEED = 873123;
    private static final Random RANDOM = new Random(SEED);


    private static void drawRow(TETile[][] world, Position p, int s, TETile t, int Row) {
        for (int i = 0; i < s + 2 * Row; i += 1) {
            world[p.x - Row + i][p.y + 2 * s - Row - 1] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
            world[p.x - Row + i][p.y + Row] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }
    }
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }else {
            for (int y = 0; y < s; y += 1) {
                drawRow(world, p, s, t, y);
                }
            }
        }
    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.MOUNTAIN;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.TREE;
            case 3: return Tileset.GRASS;
            case 4: return Tileset.SAND;
            default: return Tileset.NOTHING;
        }
    }
    private static Position TopRightHexPosition(Position oldPosition, int size) {
        return new Position(oldPosition.x + 2 * size - 1, oldPosition.y + size);
    }
    private static Position BottomRightHexPosition(Position oldPosition, int size) {
        return new Position(oldPosition.x + 2 * size - 1, oldPosition.y - size);
    }
    public static void drawRandomVerticalHexes(TETile[][] world, Position p, int s, int num) {
        Position nowPosition = p;
        for (int i = 0; i < num; i += 1) {
            addHexagon(world, nowPosition, s, randomTile());
            nowPosition.y = nowPosition.y - 2 * s;
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        int s = 3;
        Position firstTop = new Position(20,20);
        Position secondTop = TopRightHexPosition(firstTop, s);
        Position thirdTop = TopRightHexPosition(secondTop, s);
        Position fourthTop = BottomRightHexPosition(thirdTop, s);
        Position fifthTop = BottomRightHexPosition(fourthTop, s);
        drawRandomVerticalHexes(world, firstTop, s, 3);
        drawRandomVerticalHexes(world, secondTop, s, 4);
        drawRandomVerticalHexes(world, thirdTop, s, 5);
        drawRandomVerticalHexes(world, fourthTop, s, 4);
        drawRandomVerticalHexes(world, fifthTop, s, 3);
        ter.renderFrame(world);
    }
}
