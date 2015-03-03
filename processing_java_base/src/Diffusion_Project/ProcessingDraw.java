package Diffusion_Project;

import processing.core.*;

/**
 * @author nikla_000
 */
public class ProcessingDraw extends PApplet
{

    Particle particle1;
    Particle particle2;

    int time = 0;

    @Override
    public void setup ()
    {
        size (400, 400);
        particle1 = new Particle (200, 200, 20, 20);
        particle2 = new Particle (200, 200, 20, 20);
        frameRate (10);
    }

    @Override
    public void draw ()
    {
        background (0);
        stroke (255);

        float xCoord = 1;
        float yCoord = 1;

        for (float y = 1; y < width; y++)
        {
            line (0, yCoord, width, yCoord);
            line (xCoord, 0, xCoord, height);
            xCoord += 40;
            yCoord += 40;
        }

        line (width / 2, 0, width / 2, height);
        line (0, height / 2, width, height / 2);

        particle1.move2D (random (2) - 1, random (2) - 1);
        particle2.move2D (random (2) - 1, random (2) - 1);

        fill (255, 0, 0);
        ellipse (particle1.getXCoord (), particle1.getYCoord (), particle1.getWidth (), particle1.getHeight ());
        ellipse (particle2.getXCoord (), particle2.getYCoord (), particle2.getWidth (), particle2.getHeight ());

        // Increment time. (Tilsvarer tidssteg).
        time++;
        //System.out.println ("Time = " + time + " Steps");
    }

}
