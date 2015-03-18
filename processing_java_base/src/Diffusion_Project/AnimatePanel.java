/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diffusion_Project;

import javax.swing.*;

/**
 *
 * @author nikla_000
 */
public class AnimatePanel extends JPanel {
    
    
    private final JPanel panelAnimate;
    
    private final JSlider speedSlider;
    private final JButton startButtonAg;
    private final JButton stopButtonAg;
    private final JButton button;
    private final JButton resetButton;
    private final JButton Dim1Button;
    private final JButton Dim2Button;
    
    private final Animate animate;
    
    public AnimatePanel() {
        
        
        
        panelAnimate = new JPanel();
        
        speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 60, 10);
        startButtonAg = new JButton("Start");
        stopButtonAg = new JButton("Stop");
        
        
        
        button = new JButton("Add Particles");
        resetButton = new JButton("Reset");
        Dim1Button = new JButton("1 Dimension");
        Dim2Button = new JButton("2 Dimensions");
        
        
        animate = new Animate();

        addComponents();

        fixLayout();
        actionListeners();

        // Initiate the processing sketch
        animate.init();
        
    }
    
    
    
    private void addComponents() {
        
        // Add components to the window.
        
        panelAnimate.add( animate );
        this.add(speedSlider);
        this.add(panelAnimate);
        this.add(startButtonAg);
        this.add(stopButtonAg);
        this.add(button);
        this.add(resetButton);
        this.add(Dim1Button);
        this.add(Dim2Button);
    }
    
    private void fixLayout()
    {
        setLayout( null );

        // Set position and size of components
        panelAnimate.setBounds(20, 30, 405, 407);
        startButtonAg.setBounds(435, 30, 100, 30);
        stopButtonAg.setBounds(545, 30, 100, 30);
        button.setBounds(435, 70, 150, 30);
        resetButton.setBounds(435, 110, 150, 30);
        speedSlider.setBounds(435, 160, 150, 30);
        Dim1Button.setBounds(435, 210, 120, 30);
        Dim2Button.setBounds(565, 210, 120, 30);
        
        
    }
    
    private void actionListeners()
    {
        // Set action listeners and commands to buttons
        startButtonAg.addActionListener( animate );
        startButtonAg.setActionCommand( "run" );
        
        stopButtonAg.addActionListener( animate );
        stopButtonAg.setActionCommand( "stop" );
        
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
    
//    private void keepTime() {
//        while(true) {
//            float time = animateCellAut.getTime();
//            
//            runTime.setText("Time: " + time + "s");
//        }
//    }
    
}
