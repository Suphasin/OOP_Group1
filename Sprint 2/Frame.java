/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oopg1;

import java.awt.Dimension;
import java.awt.Toolkit;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Frame {
    public Frame() {
////        Forest f = new Forest();
////        Fire st = new Fire(f);
////        add(f);
////        f.setLocation(WIDTH, 130);
////        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
////        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
////        setResizable(false);
        
    }
    
    public static void main(String args[]){

        GUI gui = new GUI();
        gui.setSize(900,600);
        
    }
}
