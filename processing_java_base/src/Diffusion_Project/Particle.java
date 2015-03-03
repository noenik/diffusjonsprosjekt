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
        xCoord += x;
        stepsMoved.add( x );
    }

    public Particle()
    {
        xCoord = 200;
        yCoord = 200;
        width = 1;
        height = 1;
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
    }
}