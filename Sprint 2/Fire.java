/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopg1;

import java.util.Random;

/**
 *
 * @author User
 */
public class Fire {

    public static final float PROBCACHE = 0.80f; 
    private Forest forest; 
    static float probCatch;
    static Tree[][] tree;
    static float minX = 0.00f;
    static float maxX = 1.00f;

    public Fire(Forest forest) {
        this.forest = forest;
        tree = new Tree[13][13];
        initGrid();
        setprobCatch(PROBCACHE);
        int step = 1;
        try{
        while (!isFinish()) {
            search();
            System.out.println("Step" + step);
            forest.update(tree);
            step++;
            Spread.reset();
            Thread.sleep(100);            
        }
        }catch(Exception e){}
        System.out.println("Total step = " + (step - 1));
        
    }

    private void north(int x, int y) {
        if (tree[x][y - 1].getposition() ==  1 && isBurn() == true) {
            tree[x][y - 1].setposition(2);
            Spread.cell[x][y - 1] = true;
            forest.update(tree);
        }       // north
    }

    private void south(int x, int y) {
        if (tree[x][y + 1].getposition() == 1 && isBurn() == true) {
            tree[x][y + 1].setposition(2);
            Spread.cell[x][y + 1] = true;forest.update(tree);
        }    // south
    }

    private void west(int x, int y) {
        if (tree[x - 1][y].getposition()==1 && isBurn() == true) {
            tree[x - 1][y].setposition(2);
            Spread.cell[x - 1][y] = true;forest.update(tree);
        }       // west
    }

    private void east(int x, int y) {
        if (tree[x + 1][y].getposition() == 1 && isBurn() == true) {
            tree[x + 1][y].setposition(2);
            Spread.cell[x + 1][y] = true;forest.update(tree);
        }       // east  
    }

    public void search() {
        for (int i = 1; i < tree.length - 1; i++) {
            for (int j = 1; j < tree.length - 1; j++) {
             if (tree[i][j].getposition() == 2 && Spread.cell[i][j] == false) {
                final int x = i;
                final int y = j;
                
                    tree[x][y].setposition(0);
                    north(x, y);
                    south(x, y);
                    west(x, y);
                    east(x, y);
            }
        }
    
    }
    }

    public static void initGrid() {
        Spread.reset();
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[0].length; j++) {
                tree[i][j] = new Tree(1);
                if (i == 0 || j == 0 || i == tree.length - 1 || j == tree.length - 1) {
                    tree[i][j].setposition(0);
                } else {
                    tree[i][j].setposition(1);
                }
            }
        }
        tree[tree.length / 2][tree.length / 2].setposition(2);
    }

    public static boolean isFinish() {
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[0].length; j++) {
                if (tree[i][j].getposition() == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void setprobCatch(float a) {
        probCatch = a;
    }

    private static boolean isBurn() {
        if (getRandomProb() < getProbCatch()) {
            return true;
        }

        return false;
    }

    /*public static void reDrawGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println();
    }*/

    public static float getRandomProb() {
        Random rand = new Random();

        float finalX = rand.nextFloat() * (maxX - minX) + minX;
        return finalX;
    }

    public static float getProbCatch() {
        return probCatch;
    }

}
