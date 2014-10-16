/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopg1;

/**
 *
 * @author User
 */
public class Tree {

    public static final int empty = 0;
    public static final int tree = 1;
    public static final int burn = 2;
    private int position;

    public Tree(int position) {
        position = tree;
    }

    public int getposition() {
        return this.position;
    }

    public void setposition(int position) {
        this.position = position;
    }
}
