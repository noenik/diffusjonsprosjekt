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
public class CellAutPanel extends JPanel {

    private final JButton startButtonCe;
    private final JButton stopButtonCe;
    private final JButton customizeButtonCe;
    private final JButton resetButtonCe;
    private final JButton togglePixEllipse;

    private final JToggleButton textToggle;
    private final JToggleButton probDistToggle;
    private final JCheckBox stopAtEdge;

    private final JPanel panelAnimateCellAut;

    private final JLabel runTime;

    private AnimateCellAut animateCellAut;

    public CellAutPanel() {

        panelAnimateCellAut = new JPanel();

        startButtonCe = new JButton("Start");
        stopButtonCe = new JButton("Stop");
        customizeButtonCe = new JButton("Customize");
        resetButtonCe = new JButton("Reset");
        togglePixEllipse = new JButton("Toggle size");

        textToggle = new JToggleButton("Toggle text");
        probDistToggle = new JToggleButton("Toggle Probability Distribution");
        stopAtEdge = new JCheckBox("Stop at edge");

        runTime = new JLabel("Time: 0s");
        
        animateCellAut = new AnimateCellAut();

        addComponents();

        fixLayout();
        actionListeners();

        // Initiate the processing sketch
        animateCellAut.init();

    }

    private void addComponents() {

        // Add components to the window.
//        panelAnimate.add( animate );
        panelAnimateCellAut.add(animateCellAut);
        add(panelAnimateCellAut);
        add(startButtonCe);
        add(stopButtonCe);
        add(customizeButtonCe);
        add(resetButtonCe);
        add(textToggle);
        add(probDistToggle);
        add(stopAtEdge);
        add(togglePixEllipse);
        add(runTime);

    }

    private void fixLayout() {
        setLayout(null);

        // Set position and size of components
        panelAnimateCellAut.setBounds(30, 30, 590, 555);
        startButtonCe.setBounds(630, 30, 100, 30);
        stopButtonCe.setBounds(740, 30, 100, 30);
        customizeButtonCe.setBounds(630, 70, 100, 30);
        resetButtonCe.setBounds(630, 120, 100, 30);
        togglePixEllipse.setBounds(740, 120, 100, 30);

        probDistToggle.setBounds(630, 555, 210, 30);
        textToggle.setBounds(740, 70, 100, 30);
        stopAtEdge.setBounds(630, 170, 100, 30);

        runTime.setBounds(630, 250, 100, 20);

    }

    private void actionListeners() {
        // Set action listeners and commands to buttons

        startButtonCe.addActionListener(animateCellAut);
        startButtonCe.setActionCommand("run");

        stopButtonCe.addActionListener(animateCellAut);
        stopButtonCe.setActionCommand("stop");

        customizeButtonCe.addActionListener(animateCellAut);
        customizeButtonCe.setActionCommand("customize");

        togglePixEllipse.addActionListener(animateCellAut);
        togglePixEllipse.setActionCommand("togglesize");

        resetButtonCe.addActionListener(animateCellAut);
        resetButtonCe.setActionCommand("reset");

        probDistToggle.addActionListener(animateCellAut);
        probDistToggle.setActionCommand("probDist");

        textToggle.addChangeListener(animateCellAut);
        stopAtEdge.addItemListener(animateCellAut);
    }

    public void keepTime() {
        while (true) {
            float time = animateCellAut.getTime();

            runTime.setText("Time: " + time + "s");
        }
    }

}
