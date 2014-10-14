/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oopproject;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mostheblu
 */
public class OOPProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Forest f = new Forest() ;
        
      
        JFrame jf = new JFrame () ;
        jf.setTitle("Spreade Fire") ; 
        jf.setSize(650,600);
        jf.setVisible(true);
        jf.add(f) ;
      
       
    }
    
}
