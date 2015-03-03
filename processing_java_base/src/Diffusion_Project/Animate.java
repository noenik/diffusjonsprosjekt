package Diffusion_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import processing.core.PApplet;

/**
 * @author nikla_000
 */
public class Animate extends PApplet implements ActionListener, ChangeListener {

    Particle particle1;

    ArrayList<Particle> particles;
    Random rand = new Random();

    int time = 0;

    JSlider sliderSource;
    
    @Override
    public void setup()
    {
        size( 400, 400 );
        if(frame != null)
        {
            frame.setResizable( true );
        }

        particle1 = new Particle( 200, 200, 1, 1 );

        particles = new ArrayList<Particle>();

        frameRate( 10 );
        noLoop();
    }

    @Override

    public void draw()
    {
        background( 255 );
        drawGrid();

        drawXCoordAndYCoord();

        // Bevegelse av en partikkel i 1D
        //animateOneParticleIn1D( particle1 );

        // Bevegelse av en partikkel i 2D
        animatePluralParticlesIn2D (particles);

        // Bevegelse av mange partikler i 2D
        //animatePluralParticlesIn2D( particles );

        // Increment time. (Tilsvarer tidssteg).
        time++;
        //System.out.println ("Time = " + time + " Steps");
    }

    /**
     * Animate one particle in 1D
     */
    void animateOneParticleIn1D (Particle p)
    {
        p.setWidth( 10 );
        p.setHeight( 10 );
        fill( 255, 0, 0 );
        ellipseMode( CENTER );
        ellipse( p.getXCoord(), p.getYCoord(), p.getWidth(), p.getHeight() );
        p.move1D( rand.nextInt( 3 ) - 1 );
    }

    /**
     * Animates one particle in 2D
     */
    void animateOneParticleIn2D(Particle p)
    {
        p.setWidth( 10 );
        p.setHeight( 10 );
        fill( 255, 0, 0 );
        ellipseMode( CENTER );
        ellipse( p.getXCoord(), p.getYCoord(), p.getWidth(), p.getHeight() );
        p.move2D(rand.nextInt(3) - 1, rand.nextInt(3) - 1);
    }

    /**
     * Animates multiple particles in 2D
     */
    void animatePluralParticlesIn2D(ArrayList<Particle> particles)
    {
        for(Particle p : particles)
        {
            noStroke();
            fill( 255, 0, 0 );
            ellipseMode( CENTER );
            ellipse( p.getXCoord(), p.getYCoord(), p.getWidth(), p.getHeight() );
            p.move2D(rand.nextInt(3) - 1, rand.nextInt(3) - 1);
        }
    }

    /**
     * Legg til x antall partikler i listen particles.
     *
     * @param amountOfParticles antall partikkler å legge til.
     */
    void addParticles(int amountOfParticles)
    {
        for(int i = 0; i <= amountOfParticles; i++)
        {
            particles.add( new Particle() );
        }
    }

    void drawGrid() {
        float xCoord = 1;
        float yCoord = 1;

        for(float y = 1; y < width; y++)
        {
            stroke( 0 );
            line( 0, yCoord, width, yCoord );
            line( xCoord, 0, xCoord, height );

            xCoord += 40;
            yCoord += 40;
        }
    }
    void drawXCoordAndYCoord()
    {
        stroke( 0, 255, 0 );
        line( width / 2, 0, width / 2, height );
        line( 0, height / 2, width, height / 2 );
    }



    private void custom() {
        JPanel panel = new JPanel();
        JTextField field = new JTextField(4) {
            public void addNotify() {
                super.addNotify();
                requestFocus();
            }
        };
        panel.add(new JLabel("Number of new particles:"));
        panel.add(field);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Please enter a number", JOptionPane.OK_CANCEL_OPTION);
        field.requestFocusInWindow();
        
        try {
            addParticles(Integer.parseInt(field.getText()));
        } catch(NumberFormatException ne) {
            System.out.println("Error: " + ne);
        }
    }
    
    private void reset() {
        particles.clear();
        sliderSource.setValue(10);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case "run":
                loop();
                break;
            case "stop":
                noLoop();
                break;
            case "custom":
                custom();
                break;
            case "reset":
                reset();
                break;
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        sliderSource = (JSlider) e.getSource();
        frameRate(sliderSource.getValue());        
    }
}
