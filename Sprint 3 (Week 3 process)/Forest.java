/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopg1;

import java.awt.*;
import javax.swing.JFrame;
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

    public Tree tree[][];
    //private int numberTree;
    private int sizeTree;

    public Forest(int sizeTree) {
        this.sizeTree = sizeTree;
        setSize(800, 650);

    }

    public void update(Tree[][] tree) {
        this.tree = tree;
        repaint();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree.length ; j++) {

                int x = (i + 1) * getSizeTree();
                int y = (j + 1) * getSizeTree();

                if (tree[i][j].getposition() == Tree.empty) {
                    g.setColor(Color.yellow);
                } else if (tree[i][j].getposition() == Tree.tree) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.RED);
                }

                g.fillRect(x + 2, y + 2, getSizeTree() - 2, getSizeTree() - 2);
            }

        }
    }


    /*public int getNumberTree() {
        return numberTree;
    }*/

    public int getSizeTree() {
        return sizeTree;
    }

    /*ublic void setNumberTree(int numberTree) {
        this.numberTree = numberTree;
    }*/

    public void setSizeTree(int size) {
        this.sizeTree = size;
    }

}
