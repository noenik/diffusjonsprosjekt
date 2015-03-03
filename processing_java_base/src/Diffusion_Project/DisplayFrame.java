/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diffusion_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author nikla_000
 */

public class DisplayFrame extends JFrame
{


    private Animate animate;

    private JPanel panel;
    private JButton startButton;
    private JButton stopButton;
    private JButton button;

    public DisplayFrame() {
        this.setSize(1200, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        button = new JButton("Add Particles");
        animate = new Animate();

        panel.add( animate );
        this.add(panel);
        this.add(startButton);
        this.add(stopButton);
        this.add(button);


        fixLayout();
        actionListeners();

        animate.init();

        this.setVisible( true );
    }
    
    private void fixLayout()
    {
        setLayout( null );

        panel.setBounds(20, 20, 400, 400);
        startButton.setBounds(450, 20, 100, 30);
        stopButton.setBounds(570, 20, 100, 30);
        button.setBounds(450, 70, 150, 30);

        
    }
    
    private void actionListeners()
    {
        startButton.addActionListener( animate );
        startButton.setActionCommand( "run" );
        
        stopButton.addActionListener( animate );
        stopButton.setActionCommand( "stop" );

    }
}
