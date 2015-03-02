package processing_java_base;

import processing.core.*;

/**
 *
 * @author nikla_000
 */
public class SampleSketch extends PApplet {

    Particle x;
    Particle z;

    int time = 0;

    @Override
    public void setup() {
        size(400, 400);
        x = new Particle(200, 200, 20, 20);
        z = new Particle(200, 200, 20, 20);
        frameRate(10);
    }

    @Override
    public void draw() {
        background(0);
        stroke(255);

        float xCoord = 1;
        float yCoord = 1;
        for (float y = 1; y < width; y++) {
            line(0, yCoord, width, yCoord);
                line(xCoord, 0, xCoord, height);
                xCoord += 40;
                yCoord += 40;
        }

        line(width / 2, 0, width / 2, height);
        line(0, height / 2, width, height / 2);

        x.move(random(2) - 1, random(2) - 1);
        z.move(random(2) - 1, random(2) - 1);
//        posY += random(2) - 1;
        fill(255, 0, 0);
        ellipse(x.getxCoord(), x.getyCoord(), x.getWidth(), x.getHeight());
        ellipse(z.getxCoord(), z.getyCoord(), z.getWidth(), z.getHeight());

        // Increment time. (Tilsvarer tidssteg).
        time++;
    }

}
