package Diffusion_Project;

import processing.core.PApplet;

import java.util.ArrayList;

/**
 * @author nikla_000
 */
public class Animate extends PApplet
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

        drawGrid ();

        drawXCoordAndYCoord ();

        animateOneParticle (particle1);
        animateOneParticle (particle2);

        // Increment time. (Tilsvarer tidssteg).
        time++;
        //System.out.println ("Time = " + time + " Steps");
    }

    /**
     * Animates one particle in 2D
     */
    void animateOneParticle (Particle p)
    {
        fill (255, 0, 0);
        ellipse (p.getXCoord (), p.getYCoord (), p.getWidth (), p.getHeight ());
        p.move2D (random (2) - 1, random (2) - 1);
    }

    /**
     * Animates multiple particles in 2D
     */
    void animatePluralParticles (ArrayList<Particle> p, int amountOfParticles)
    {
        p.ensureCapacity (amountOfParticles);
        for(Particle particle : p)
        {
            animateOneParticle (particle);
        }
    }

    void drawGrid()
    {
        float xCoord = 1;
        float yCoord = 1;

        for (float y = 1; y < width; y++)
        {
            stroke (255);
            line (0, yCoord, width, yCoord);
            line (xCoord, 0, xCoord, height);

            xCoord += 40;
            yCoord += 40;
        }
    }

    void drawXCoordAndYCoord()
    {
        stroke (0, 255,0);
        line (width / 2, 0, width / 2, height);
        line (0, height / 2, width, height / 2);
    }

}
