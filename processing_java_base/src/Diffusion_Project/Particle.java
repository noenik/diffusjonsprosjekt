/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diffusion_Project;

/**
 * @author nikla_000
 */
public class Particle
{
    private float xCoord;
    private float yCoord;
    private float width;
    private float height;

    public Particle (float x, float y, float w, float h)
    {
        xCoord = x;
        yCoord = y;
        width = w;
        height = h;
    }

    public float getxCoord ()
    {
        return xCoord;
    }

    public float getyCoord ()
    {
        return yCoord;
    }

    public float getWidth ()
    {
        return width;
    }

    public float getHeight ()
    {
        return height;
    }

    /**
     * Move the particle1 in 1D
     * @param x direction
     */
    public void move1D (float x)
    {
        xCoord += x;
    }

    /**
     * Move the particle1 in 2D
     * @param x direction
     * @param y direction
     */
    public void move2D (float x, float y)
    {
        xCoord += x;
        yCoord += y;
    }
}
