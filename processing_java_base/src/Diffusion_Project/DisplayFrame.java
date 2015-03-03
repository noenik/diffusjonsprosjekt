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
public class DisplayFrame extends JFrame implements ActionListener{

    private Animate s;

    private JPanel panel;
    private JButton startButton;
    private JButton stopButton;
    private JButton button;

    public DisplayFrame() {
        this.setSize(1200, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        button = new JButton("Add Particles");
        s = new Animate();

        panel.add(s);
        this.add(panel);
        this.add(startButton);
        this.add(stopButton);
        this.add(button);

        fixLayout();
        actionListeners();

        s.init();

        this.setVisible(true);
    }
    
    private void fixLayout(){
        setLayout(null);
        
        panel.setBounds(20, 20, 400, 400);
        startButton.setBounds(450, 20, 100, 30);
        stopButton.setBounds(570, 20, 100, 30);
        button.setBounds(450, 70, 100, 30);
        
    }
    
    private void actionListeners() {
        startButton.addActionListener(s);
        startButton.setActionCommand("run");
        
        stopButton.addActionListener(s);
        stopButton.setActionCommand("stop");
        
        button.addActionListener(s);
        button.setActionCommand("custom");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
