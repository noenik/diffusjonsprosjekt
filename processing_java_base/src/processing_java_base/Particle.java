/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package processing_java_base;

/**
 *
 * @author nikla_000
 */
public class Particle {
    private float xCoord;
    private float yCoord;
    private float width;
    private float height;
    
    public Particle(float x, float y, float w, float h) {
        xCoord = x;
        yCoord = y;
        width = w;
        height = h;
    }

    public float getxCoord() {
        return xCoord;
    }

    public float getyCoord() {
        return yCoord;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
    
    public void move(float x, float y) {
        xCoord += x;
        yCoord += y;
    }
}
