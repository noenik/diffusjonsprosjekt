package Diffusion_Project;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nikla_000
 */
public class Square {

    private final float xCoord;
    private final float yCoord;
    private final float xMax;
    private final float yMax;
    private final int col;
    private final int row;
    private final Random rand;

    private int particles;
    private int particlesMoved;
    private int layerNum;

    ArrayList<Square> neighbors = new ArrayList<>();

    public Square(int col, int row, float x, float y, int size, int particles, Random rand) {
        xCoord = x;//x;
        yCoord = y;//y;
        xMax = xCoord + size;
        yMax = yCoord + size;
        this.col = col;
        this.row = row;
        this.particles = particles;
        this.rand = rand;
    }

    float getXinit() {
        return xCoord;
    }

    float getYinit() {
        return yCoord;
    }

    float getXmax() {
        return xMax;
    }

    float getYmax() {
        return yMax;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    
    public int getLayerNum() {
        return layerNum;
    }
    
    public void setLayerNum(int layerNum) {
        this.layerNum = layerNum;
    }

    int getParticles() {
        return particles;
    }

    void setParticles(int val) {
        particles = val;
    }

    Square randomNeighbor() {
        int randNum = rand.nextInt(neighbors.size());
        return neighbors.get(randNum);
    }

    void findNeighbors(ArrayList<Square> rectangles) {
        for (Square r : rectangles) {
            int rcol = r.getCol();
            int rrow = r.getRow();

            for (int val1 = col - 1; val1 <= col + 1; val1++) {
                for (int val2 = row - 1; val2 <= row + 1; val2++) {
                    if (!(rcol == col && rrow == row) && rcol == val1 && rrow == val2) {
                        neighbors.add(r);
                    }
                }
            }

        }
    }

    public ArrayList<Square> getNeighbors() {
        return neighbors;
    }

    public boolean isNeighborOf(Square s) {
        return neighbors.contains(s);
    }

    void sum() {
        particles += particlesMoved;
        particlesMoved = 0;
    }

    void addP(int num) {
        particlesMoved += num;
    }

    void subP(int num) {
        particlesMoved -= num;
    }
}
