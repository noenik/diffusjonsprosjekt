package Diffusion_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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

    CalclateStatistics statistics;

    ArrayList<Particle> particles;
    Random rand = new Random();

    int time = 0;
    int dimensions = 2;

    JSlider sliderSource;
    
    @Override
    public void setup()
    {
        size( 402, 402 );
        if(frame != null)
        {
            frame.setResizable( true );
        }

        particle1 = new Particle( 200, 200, 1, 1 );

        particles = new ArrayList<Particle>();

        statistics = new CalclateStatistics();

        frameRate( 10 );
        noLoop();

    }

    @Override
    public void draw()
    {
        background( 255 );
        drawGrid();

        drawXCoordAndYCoord();

        try {
        // Runs the animation, takes number of dimensions as parameter.
        animate(dimensions);
        }catch(ConcurrentModificationException c) {
            
        }
        
        // Increment time. (Tilsvarer tidssteg).
        time++;
        //System.out.println ("Time = " + time + " Steps");
        statistics.setParticle( particle1 );

        System.out.println( statistics.getNumberOfStepIn1D() );
    }

    public int getTime()
    {
        return time;
    }
    
    public void animate(int dimensions) {
        for(Particle p : particles)
        {
            noStroke();
            fill( 255, 0, 0 );
            ellipseMode( CENTER );
            ellipse( p.getXCoord(), p.getYCoord(), p.getWidth(), p.getHeight() );
            
            if(dimensions == 2) {
                p.move2D(rand.nextInt( 3 ) - 1, rand.nextInt( 3 ) - 1);
            } else {
                p.move1D( rand.nextInt( 3 ) - 1 );
            }
        }
    }

    /**
     * Legg til x antall partikler i listen particles.
     *
     * @param amountOfParticles antall partikkler å legge til.
     */
    void addParticles(int amountOfParticles)
    {
        for(int i = 0; i < amountOfParticles; i++)
        {
            particles.add( new Particle() );
        }
    }

    void drawGrid() {

        for(float y = 1; y < width; y += 40)
        {
            stroke( 0 );
            line( 0, y, width, y );
            line( y, 0, y, height );
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
        noLoop();
        particles.clear();
        if(sliderSource != null)
            sliderSource.setValue(10);
        redraw();
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
            case "1d":
                dimensions = 1;
                break;
            case "2d":
                dimensions = 2;
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        sliderSource = (JSlider) e.getSource();
        frameRate(sliderSource.getValue());        
    }
}
