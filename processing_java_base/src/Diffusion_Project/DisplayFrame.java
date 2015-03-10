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
    private final JButton startButton;
    private final JButton stopButton;
    private final JButton button;
    private final JButton resetButton;
    private final JButton Dim1Button;
    private final JButton Dim2Button;

    public DisplayFrame() {
        // Set the size of the window
        this.setSize(1300, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Sets the window to appear in the center of the screen
        setLocationRelativeTo(null);
        
        // Initiate variables
        panelAnimate = new JPanel();
        panelAnimateCellAut = new JPanel();
        speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 60, 10);
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        button = new JButton("Add Particles");
        resetButton = new JButton("Reset");
        Dim1Button = new JButton("1 Dimension");
        Dim2Button = new JButton("2 Dimensions");
        animate = new Animate();
        animateCellAut = new AnimateCellAut();

        // Add components to the window.
        panelAnimate.add( animate );
        panelAnimateCellAut.add( animateCellAut );
        this.add(speedSlider);
        this.add(panelAnimate);
        this.add(panelAnimateCellAut);
        this.add(startButton);
        this.add(stopButton);
        this.add(button);
        this.add(resetButton);
        this.add(Dim1Button);
        this.add(Dim2Button);


        fixLayout();
        actionListeners();

        // Initiate the processing sketch
        animate.init();
        animateCellAut.init();

        this.setVisible( true );
    }
    
    private void fixLayout()
    {
        setLayout( null );

        // Set position and size of components
        panelAnimate.setBounds(20, 20, 441, 450);
        panelAnimateCellAut.setBounds(730, 20, 441, 450);
        startButton.setBounds(450, 20, 100, 30);
        stopButton.setBounds(570, 20, 100, 30);
        button.setBounds(450, 70, 150, 30);
        resetButton.setBounds(450, 250, 150, 30);
        speedSlider.setBounds(450, 120, 150, 30);
        Dim1Button.setBounds(450, 160, 120, 30);
        Dim2Button.setBounds(590, 160, 120, 30);
        
    }
    
    private void actionListeners()
    {
        // Set action listeners and commands to buttons
        startButton.addActionListener( animate );
        startButton.setActionCommand( "run" );
        
        stopButton.addActionListener( animate );
        stopButton.setActionCommand( "stop" );
        
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
