package Diffusion_Project;

import java.util.ArrayList;

/**
 * Created by Ramin on 03.03.2015.
 */
public class Statistics
{
    private int numberOfStepIn1D;
    private int dimension;
    private int diffusionCoeffisient;
    private int time;
    private int constant = 2;

    ArrayList<Particle> particleList;

    private Particle particle;

    public Statistics()
    {
        particle = new Particle();

    }

    public void setParticleList(ArrayList<Particle> particleList)
    {
        this.particleList = particleList;
    }

    public int getNumberOfStepIn1D()
    {
        int sum = 0;

        for(Integer i : particle.getStepsMoved())
        {
            sum += i.intValue();
        }
        return sum;
    }

    public void setParticle(Particle particle)
    {
        this.particle = particle;
    }
}
