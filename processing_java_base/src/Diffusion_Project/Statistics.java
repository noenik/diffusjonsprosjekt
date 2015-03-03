package Diffusion_Project;

import java.util.ArrayList;

/**
 * Created by Ramin on 03.03.2015.
 */
public class Statistics
{
    private int numberOfStepIn1D;
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

    public Statistics()
    {
        animate = new Animate();
        particle = new Particle();
        this.time = animate.getTime();
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

    public double getVariance()
    {
        return variance;
    }

    public void setVariance(double variance)
    {
        this.variance = variance;
    }

    public double getStandardDeviation()
    {
        return standardDeviation = Math.sqrt( getVariance() );
    }

    public void setStandardDeviation(double standardDeviation)
    {
        this.standardDeviation = standardDeviation;
    }

    public double getSampleMean()
    {
        return Math.signum( getNumberOfStepIn1D() ) / time;
    }

    public void setSampleMean(double sampleMean)
    {
        this.sampleMean = sampleMean;
    }
}
