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
    private final CellAutPanel cellAut;
    
    private final JTabbedPane tabbedPane;


    public DisplayFrame() {
        // Set the size of the window
        this.setSize(900, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Sets the window to appear in the center of the screen
        setLocationRelativeTo(null);
        
        // Initiate variables
        tabbedPane = new JTabbedPane();
        cellAut = new CellAutPanel();
        
        tabbedPane.addTab("Cellular Automaton", cellAut);
        tabbedPane.addTab("Agent based", new AnimatePanel());
        add(tabbedPane);

        this.setVisible( true );
        
        cellAut.keepTime();
    }
}
