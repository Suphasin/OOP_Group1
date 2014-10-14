package oopproject;

import java.awt.*;
import javax.swing.JPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mostheblu
 */
public class Forest extends JPanel {

    public int tree[][];
    private int numberTree;
    private int sizeTree;

    public Forest() {
        this.tree = tree;
        this.numberTree = numberTree;
        this.sizeTree = sizeTree;
        numberTree = 30;
        sizeTree = 10;
        setSize(350, 350);
        repaint();

    }

   

    public void paintComponent(Graphics g) {

        for (int i = 0; i < getNumberTree(); i++) {
            for (int j = 0; j < getNumberTree(); j++) {
                g.setColor(Color.yellow);
                int x = (i + 1) * getSizeTree(); 
                int y = (j + 1) * getSizeTree(); 
                g.fillRect(x + 2, y + 2, getSizeTree() - 2, getSizeTree() - 2);
            }
        }
        

               
    }

    public int[][] getTree() {
        return tree;
    }

    public int getNumberTree() {
        return numberTree;
    }

    public int getSizeTree() {
        return sizeTree;
    }

    public void setTree(int[][] tree) {
        this.tree = tree;
    }

    public void setNumberTree(int numberTree) {
        this.numberTree = numberTree;
    }

    public void setSizeTree(int size) {
        this.sizeTree = sizeTree;
        repaint();
    }

}
