/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diffusion_Project;

import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;

/**
 *
 * @author nikla_000
 */
public class AnimateCellAut extends PApplet {

    ArrayList<Square> list = new ArrayList<>();
    Random rand = new Random();

    @Override
    public void setup() {
        size(440, 440);
//        frameRate(5);
        int rowCount = 0;
        for (int y = 0; y < height; y += 40) {
            int colCount = 0;
            for (int i = 0; i < width; i += 40) {
                if (rowCount == 5 && colCount == 5) {
                    list.add(new Square(colCount, rowCount, i, y, 10000, rand));
                } else {
                    list.add(new Square(colCount, rowCount, i, y, 0, rand));
                }
                colCount++;
            }
            rowCount++;
        }
        for (Square r : list) {
            r.findNeighbours(list);
        }
    }

    @Override
    public void draw() {
        background(255);

        int index = 0;
        for (Square r : list) {
            float xi = r.getXinit();
            float xe = r.getXmax();
            float yi = r.getYinit();
            float ye = r.getYmax();

//            Square target = list.get(60);
//            if (r == target) {
//                fill(255, 0, 0);
//            } else if (r.isNeighbourOf(target)) {
//                fill(0, 0, 255);
//            } else {
//                fill(255);
//            }
            fill(255);
            rect(xi, yi, xe, ye);
//            fill(0);
//            text(r.getCol() + ", " + r.getRow(), xi, yi + 20);

            for (int p = 0; p < r.getParticles(); p++) {
                set((int) random(xi + 1, xe - 1), (int) random(yi + 1, ye - 1), color(255, 0, 0));

                if (random(1) < 0.2) {
                    moveParticle(index);
                }
            }
            index++;
        }

//        fill(0, 0, 255);
//        for (Square s : list.get(35).getNeighbours()) {
//            rect(s.getXinit(), s.getYinit(), s.getXmax(), s.getYmax());
//            System.out.println(s.getXinit() + " " + s.getYinit() + " " + s.getXmax() + " " + s.getYmax());
//        }
    }

    void moveParticle(int index) {
        Square r = list.get(index);
        r.subP(1);

        Square receiver = r.randomNeighbour();
        receiver.addP(1);
    }
}
