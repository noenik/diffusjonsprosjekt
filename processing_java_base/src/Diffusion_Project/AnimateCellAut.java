/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diffusion_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import processing.core.PApplet;

/**
 *
 * @author nikla_000
 */
public class AnimateCellAut extends PApplet implements ActionListener, ChangeListener, ItemListener {

    ArrayList<Square> list = new ArrayList<>();
    Random rand = new Random();
    Square init;
    float currentFrameRate = 10;
    int initParticles = 10000;

    int cellXCount = 11;
    int cellSize = 40;
    int gridWidth;
    float time = 0;
    int runStopTime = 0;
    int currentFrames = 0;

    boolean text = false;
    boolean stopAtEdge = false;
    boolean showAsDots = false;

    float diffusionFactor = (float) 0.5;
    ArrayList<Integer> pPerCol;
    ArrayList<Integer> pPerRow;

    @Override
    public void setup() {
        size(590, 550);
        frameRate(currentFrameRate);

        initiate();
        noLoop();
    }

    @Override
    public void draw() {
        time = currentFrames / currentFrameRate;
        currentFrames++;
        if (runStopTime > 0 && runStopTime < time) {
            noLoop();
        }

        background(238);
        int index = 0;

        for (Square r : list) {
            float xi = r.getXinit();
            float xe = r.getXmax();
            float yi = r.getYinit();
            float ye = r.getYmax();

            fill(255);
            stroke(0);
            rect(xi, yi, cellSize, cellSize);

            int particles = r.getParticles();

            if (text) {
                fill(0);
                text(particles, xi + 2, yi + (cellSize / 2));
            }

            for (int p = 0; p < particles; p++) {
                if (!text && !showAsDots) {
                    set((int) random(xi + 1, xe - 1), (int) random(yi + 1, ye - 1), color(255, 0, 0));
                } else if (!text && showAsDots) {
                    noStroke();
                    fill(255, 0, 0);
                    ellipse((int) random(xi + cellSize / 10, xe - cellSize / 10),
                            (int) random(yi + cellSize / 10, ye - cellSize / 10), cellSize / 10, cellSize / 10);
                }
                if ((frameCount % 10 == 0) && (random(1) <= 0.2)) {
                    moveParticle(index);
                }
            }
            int col = r.getCol();
            int row = r.getRow();

            if (stopAtEdge && (col == 0 || row == 0 || col == cellXCount || row == cellXCount) && particles > 0) {
                noLoop();
            }

            pPerCol.set(col, pPerCol.get(col) + particles);
            pPerRow.set(row, pPerRow.get(row) + particles);

            index++;

        }

        int aIndex = 0;
        for (int iNum = 0; iNum < (cellXCount * cellSize); iNum += cellSize) {

            double colFactor = (double) pPerCol.get(aIndex) / initParticles;
            double rowFactor = (double) pPerRow.get(aIndex) / initParticles;

            float xCoord = (float) (width - (200 * rowFactor));
            float yCoord = (float) (height - (200 * colFactor));

            fill(255, 0, 0);
            rect(iNum, yCoord, cellSize, (float) (200 * colFactor));
            rect(xCoord, iNum, (float) (200 * rowFactor), cellSize);

            pPerCol.set(aIndex, 0);
            pPerRow.set(aIndex, 0);

            aIndex++;
        }

        for (Square r : list) {
            r.sum();
        }
    }

    /**
     * Initiates all the cells as instances of Square and adds initial particles
     * to the middle one.
     */
    private void initiate() {
        pPerCol = new ArrayList<>();
        pPerRow = new ArrayList<>();

        gridWidth = cellXCount * cellSize;

        int rowCount = 0;
        for (int y = 0; y < gridWidth; y += cellSize) {
            int colCount = 0;
            for (int i = 0; i < gridWidth; i += cellSize) {
                if (rowCount == (cellXCount / 2) && colCount == (cellXCount / 2)) {
                    init = new Square(colCount, rowCount, i, y, cellSize, initParticles, rand);
                    list.add(init);
                } else {
                    list.add(new Square(colCount, rowCount, i, y, cellSize, 0, rand));
                }
                colCount++;
            }
            pPerCol.add(0);
            pPerRow.add(0);
            rowCount++;
        }
        for (Square r : list) {
            r.findNeighbors(list);
        }

//        for (int i = 0; i < cellXCount; i++) {
//            
//        }
        redraw();
    }

    /**
     * Moves a particle from one cell to a random neighbor.
     *
     * @param index Index of the origin cell in the list of cells.
     */
    private void moveParticle(int index) {
        Square r = list.get(index);
        r.subP(1);

        Square receiver = r.randomNeighbor();
        receiver.addP(1);
    }

    /**
     * Opens a dialog with fields for setting initial conditions of the
     * simulation
     */
    private void custom() {
        JPanel panel = new JPanel();

        JTextField field = new JTextField(4);
        JTextField field2 = new JTextField(4);
        JTextField field3 = new JTextField(4);
        JTextField field4 = new JTextField(4);
        JTextField field5 = new JTextField(4);

        Box box = Box.createVerticalBox();
        Box box2 = Box.createHorizontalBox();
        Box box3 = Box.createHorizontalBox();
        panel.add(box);

        box.add(new JLabel("Number of initial particles:            "));
        box.add(field);
        box.add(Box.createVerticalStrut(10));
        box.add(new JLabel("Diffusion coefficient:            "));
        box.add(field2);
        box.add(Box.createVerticalStrut(20));
        box.add(box2);
        box2.add(new JLabel("Cell Size: "));
        box2.add(field3);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(new JLabel("Number of cells: "));
        box2.add(field4);
        box.add(Box.createVerticalStrut(20));
        box.add(box3);
        box3.add(new JLabel("Set running time (s): "));
        box3.add(field5);
        box3.add(Box.createHorizontalStrut(100));

        int result = JOptionPane.showConfirmDialog(null, panel, "Please fill the fields", JOptionPane.OK_CANCEL_OPTION);
        field.requestFocusInWindow();

        if (result == JOptionPane.OK_OPTION) {
            try {
                currentFrameRate = (float) (10 * Float.parseFloat(field2.getText()));
                frameRate(currentFrameRate);
            } catch (NumberFormatException ne) {
            }

            try {
                int num = Integer.parseInt(field.getText());

                initParticles = num;
                init.setParticles(num);
                redraw();
            } catch (NumberFormatException ne) {
            }

            try {
                int cSize = Integer.parseInt(field3.getText());
                cellSize = cSize;
                redraw();
            } catch (NumberFormatException ne) {
            }

            try {
                int cellNum = Integer.parseInt(field4.getText());
                cellXCount = cellNum;
            } catch (NumberFormatException ne) {
            }

            try {
                int runTime = Integer.parseInt(field5.getText());
                runStopTime = runTime;
            } catch (NumberFormatException ne) {
            }
        }
    }

    /**
     * Resets the simulation to it's start point.
     */
    private void reset() {
        noLoop();
        list.clear();
        initiate();
        currentFrames = 0;
    }

    /**
     * Opens a dialog to make sure the user wants to reset the simulation.
     *
     * @return A boolean value true if user wants to reset, false if not.
     */
    private boolean wantToReset() {
        if (frameCount > 3) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Performing this action will reset the current simulation"
                    + "and apply your settings. Do you still want to do it?", "Warning", dialogButton);
            return dialogResult == JOptionPane.YES_OPTION;
        } else {
            return true;
        }
    }

    public float getTime() {
        return time;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "run":
                loop();
                break;
            case "stop":
                noLoop();
                break;
            case "customize":
                noLoop();
                if (wantToReset()) {
                    custom();
                    reset();
                } else {
                    loop();
                }
                size(gridWidth + 100, gridWidth + 100);
                break;
            case "reset":
                reset();
                break;
            case "togglesize":
                showAsDots = !showAsDots;
                break;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        text = !text;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        stopAtEdge = !stopAtEdge;
    }
}
