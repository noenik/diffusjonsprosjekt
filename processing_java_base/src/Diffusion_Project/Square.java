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

    int particles;

    ArrayList<Square> neighbours = new ArrayList<>();

    public Square(int col, int row, float x, float y, int particles, Random rand) {
        xCoord = col * 40;//x;
        yCoord = row * 40;//y;
        xMax = xCoord + 40;
        yMax = yCoord + 40;
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

    int getParticles() {
        return particles;
    }

    Square randomNeighbour() {
        int randNum = rand.nextInt(neighbours.size() - 1);
        System.out.println(randNum);
        return neighbours.get(randNum);
    }

    void findNeighbours(ArrayList<Square> rectangles) {
        for (Square r : rectangles) {
            int rcol = r.getCol();
            int rrow = r.getRow();

            for(int val1 = col - 1; val1 <= col +1 ; val1++) {
                for(int val2 = row - 1; val2 <= row + 1; val2++) {
                    if(!(rcol == col && rrow == row) && rcol == val1 && rrow == val2) {
                        neighbours.add(r);
                    }
                }
            }
            
            
//            if (rcol == col -1 && rrow == row - 1) {
//                neighbours.add(r);
//                System.out.println("Checked");
//                System.out.println("Col: " + col + " Row: " + row);
//                System.out.println("Against ");
//                System.out.println("Col: " + rcol + " Row: " + rrow);
//            }
        }
//        System.out.println(neighbours.size());
    }
    
    public ArrayList<Square> getNeighbours() {
        return neighbours;
    }
    
    public boolean isNeighbourOf(Square s) {
        return neighbours.contains(s);
    }

    void addP(int num) {
        particles += num;
    }

    void subP(int num) {
        particles -= num;
    }
}
