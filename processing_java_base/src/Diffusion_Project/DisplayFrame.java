/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diffusion_Project;

import javax.swing.*;

/**
 * @author nikla_000
 */

public class DisplayFrame extends JFrame
{
    // Declare components

    private final Animate animate;
    private final AnimateCellAut animateCellAut;

    private final JPanel panelAnimate;
    private final JPanel panelAnimateCellAut;
    
    private final JSlider speedSlider;
    private final JButton startButtonAg;
    private final JButton stopButtonAg;
    
    private final JButton startButtonCe;
    private final JButton stopButtonCe;
    private final JButton customizeButtonCe;
    private final JButton resetButtonCe;
    
    private final JButton button;
    private final JButton resetButton;
    private final JButton Dim1Button;
    private final JButton Dim2Button;
    
    private final JLabel animateLabel;
    private final JLabel animateCellAutLabel;

    public DisplayFrame() {
        // Set the size of the window
        this.setSize(1215, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Sets the window to appear in the center of the screen
        setLocationRelativeTo(null);
        
        // Initiate variables
        panelAnimate = new JPanel();
        panelAnimateCellAut = new JPanel();
        speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 60, 10);
        startButtonAg = new JButton("Start");
        stopButtonAg = new JButton("Stop");
        
        startButtonCe = new JButton("Start");
        stopButtonCe = new JButton("Stop");
        customizeButtonCe = new JButton("Customize");
        resetButtonCe = new JButton("Reset");
        
        button = new JButton("Add Particles");
        resetButton = new JButton("Reset");
        Dim1Button = new JButton("1 Dimension");
        Dim2Button = new JButton("2 Dimensions");
        
        animateLabel = new JLabel("2D agent based simulation:");
        animateCellAutLabel = new JLabel("2D cellular automaton based simulation:");
        
        animate = new Animate();
        animateCellAut = new AnimateCellAut();

        addComponents();

        fixLayout();
        actionListeners();

        // Initiate the processing sketch
        animate.init();
        animateCellAut.init();

        this.setVisible( true );
    }
    
    private void addComponents() {
        
        // Add components to the window.
        panelAnimate.add( animate );
        panelAnimateCellAut.add( animateCellAut );
        this.add(speedSlider);
        this.add(panelAnimate);
        this.add(panelAnimateCellAut);
        this.add(startButtonAg);
        this.add(stopButtonAg);
        this.add(startButtonCe);
        this.add(stopButtonCe);
        this.add(customizeButtonCe);
        this.add(resetButtonCe);
        this.add(button);
        this.add(resetButton);
        this.add(Dim1Button);
        this.add(Dim2Button);
        this.add(animateLabel);
        this.add(animateCellAutLabel);
    }
    
    private void fixLayout()
    {
        setLayout( null );

        // Set position and size of components
        panelAnimate.setBounds(20, 30, 405, 407);
        panelAnimateCellAut.setBounds(600, 30, 590, 555);
        startButtonAg.setBounds(22, 500, 100, 30);
        stopButtonAg.setBounds(132, 500, 100, 30);
        button.setBounds(22, 540, 150, 30);
        resetButton.setBounds(22, 650, 150, 30);
        speedSlider.setBounds(20, 580, 150, 30);
        Dim1Button.setBounds(252, 580, 120, 30);
        Dim2Button.setBounds(252, 620, 120, 30);
        
        startButtonCe.setBounds(730, 600, 100, 30);
        stopButtonCe.setBounds(840, 600, 100, 30);
        customizeButtonCe.setBounds(730, 640, 100, 30);
        resetButtonCe.setBounds(730, 690, 100, 30);
        
        animateLabel.setBounds(22, 10, 500, 20);
        animateCellAutLabel.setBounds(730, 10, 500, 20);
        
    }
    
    private void actionListeners()
    {
        // Set action listeners and commands to buttons
        startButtonAg.addActionListener( animate );
        startButtonAg.setActionCommand( "run" );
        
        stopButtonAg.addActionListener( animateCellAut );
        stopButtonAg.setActionCommand( "stop" );
        
        startButtonCe.addActionListener( animateCellAut );
        startButtonCe.setActionCommand( "run" );
        
        stopButtonCe.addActionListener( animateCellAut );
        stopButtonCe.setActionCommand( "stop" );
        
        customizeButtonCe.addActionListener( animateCellAut );
        customizeButtonCe.setActionCommand( "customize" );
        
        resetButtonCe.addActionListener( animateCellAut );
        resetButtonCe.setActionCommand( "reset" );
        
        button.addActionListener( animate );
        button.setActionCommand( "custom" );
        
        resetButton.addActionListener( animate );
        resetButton.setActionCommand( "reset" );
        
        Dim1Button.addActionListener( animate );
        Dim1Button.setActionCommand( "1d" );
        
        Dim2Button.addActionListener( animate );
        Dim2Button.setActionCommand( "2d" );

        speedSlider.addChangeListener(animate);
    }
}
