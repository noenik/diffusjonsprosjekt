/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diffusion_Project;

import java.util.ArrayList;

/**
 * @author nikla_000
 */
public class Particle
{
    // Particle's coordinates
    private float xCoord;
    private float yCoord;

    // Particle's properties
    private float width;
    private float height;
    
    // Max and min coordinates so that the particle does not 
    // move outside the canvas.
    private static float X_MAX = 400;
    private static float X_MIN = 0;
    private static float Y_MAX = 400;
    private static float Y_MIN = 0;

   ArrayList<Integer> stepsMoved;

    /**
     * Constructs a new particle with xy coordinates and a given height and length
     *
     * @param x coordinates of the particle
     * @param y coordinates particle
     * @param w Width of the particle
     * @param h height of the particle
     */
    public Particle(float x, float y, float w, float h)
    {
        xCoord = x;
        yCoord = y;
        width = w;
        height = h;

        stepsMoved = new ArrayList<>();
    }
    public Particle()
    {
        this(200,200,1,1);
    }

    public ArrayList<Integer> getStepsMoved()
    {
        return stepsMoved;
    }

    /**
     * Gets the current x coordinates
     *
     * @return x coordinates to return
     */
    public float getXCoord()
    {
        return xCoord;
    }

    /**
     * Gets the current y coordinates
     *
     * @return y coordinates to return
     */
    public float getYCoord()
    {
        return yCoord;
    }

    /**
     * Get the width of the particle
     *
     * @return the width of the particle
     */
    public float getWidth()
    {
        return width;
    }

    /**
     * Gets the height of the particle
     *
     * @return the height of the particle
     */
    public float getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * Move the particle1 in 1D
     *
     * @param x direction
     */
    public void move1D(int x)
    {
        System.out.println(x);
        xCoord += x;
        stepsMoved.add( x );
    }


    /**
     * Move the particle1 in 2D
     *
     * @param x direction
     * @param y direction
     */
    public void move2D(int x, int y)
    {
        xCoord += x;
        yCoord += y;
        
        // If the coordinate is increased out of any boudaries it will 
        // "bounce" back.
        if(xCoord < X_MIN) {
            xCoord++;
        } else if(xCoord > X_MAX) {
            xCoord--;
        }
        
        if(yCoord < Y_MIN) {
            yCoord++;
        } else if(yCoord > Y_MAX) {
            yCoord--;
        }
    }
}