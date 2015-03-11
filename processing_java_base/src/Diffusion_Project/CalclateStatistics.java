package Diffusion_Project;

import java.util.ArrayList;


/**
 * Created by Ramin on 03.03.2015.
 */
public class CalclateStatistics
{
    private int squaredDistance1D;
    private int numberOfStepsIn2D;
    private int dimension;
    private int diffusionCoefficient;
    private int time;
    private int constant = 2;

    private double standardDeviation;
    private double variance;
    private double sampleMean;

    private Animate animate;

    ArrayList<Particle> particleList;

    private Particle particle;

    public CalclateStatistics()
    {
        animate = new Animate();
        particle = new Particle();
        this.time = animate.getCurrentMillis();
    }

    public void setParticleList(ArrayList<Particle> particleList)
    {
        this.particleList = particleList;
    }

    public int getSquaredDistance1D()
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
