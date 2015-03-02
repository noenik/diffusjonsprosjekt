/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package processing_java_base;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author nikla_000
 */
public class DisplayFrame extends JFrame{
    private SampleSketch s;
    
    private JPanel panel;
//    private JLabel label;
    
    public DisplayFrame() {
        this.setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        panel = new JPanel();
//        label = new JLabel();
        s = new SampleSketch();
        
        panel.add(s);
        this.add(panel);
//        this.add(label);
        
        
//        setLayout(null);
//        label.setBounds(200, 550, 100, 30);
        
        s.init();
        
        this.setVisible(true);
    }
}
