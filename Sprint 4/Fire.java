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

    public static final float PROBCACHE = 0.00f;
    private Forest forest;
    private float probCatch;
    private float probBurn;
    private float probTree;
    static Tree[][] tree;
    static float minX = 0.00f;
    static float maxX = 1.00f;
    private int numberTree;
    private boolean[][] cell;
    public  int cnt =0;
    

    public Fire(Forest forest, int numberTree) {
        this.forest = forest;
        this.numberTree = numberTree;
        cell = new boolean[numberTree][numberTree];
        tree = new Tree[numberTree][numberTree];
        initGrid();
        setprobCatch(PROBCACHE);
        forest.update(tree);
        

    }

    public void Simulate() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    runFire();
                } catch (Exception e) {

                }
            }
        });
        t.start();

    }

    public void runFire() {
       
        while (!isFinish()) {
            run();
            
        
       
    }
    }

    public void run() {
        //int step = 1;
        try {
       
            search();
           
            forest.update(tree);
           // step++;
            cnt++ ;
            reset();
            Thread.sleep(100);
            
        } catch (Exception e) {
        }

        
    }

    public  void reset() {
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[0].length; j++) {
                cell[i][j] = false;
            }
        }
    }

    private void north(int x, int y) {
        if (tree[x][y - 1].getposition() == 1 && isBurn() == true) {
            tree[x][y - 1].setposition(2);
            cell[x][y - 1] = true;
            forest.update(tree);
        }       // north
    }

    private void south(int x, int y) {
        if (tree[x][y + 1].getposition() == 1 && isBurn() == true) {
            tree[x][y + 1].setposition(2);
            cell[x][y + 1] = true;
            forest.update(tree);
        }    // south
    }

    private void west(int x, int y) {
        if (tree[x - 1][y].getposition() == 1 && isBurn() == true) {
            tree[x - 1][y].setposition(2);
            cell[x - 1][y] = true;
            forest.update(tree);
        }       // west
    }

    private void east(int x, int y) {
        if (tree[x + 1][y].getposition() == 1 && isBurn() == true) {
            tree[x + 1][y].setposition(2);
            cell[x + 1][y] = true;
            forest.update(tree);
        }       // east  
    }

    public void search() {
        for (int i = 1; i < tree.length - 1; i++) {
            for (int j = 1; j < tree.length - 1; j++) {
                if (tree[i][j].getposition() == 2 && cell[i][j] == false) {
                    tree[i][j].setposition(0);
                    north(i, j);
                    south(i, j);
                    west(i, j);
                    east(i, j);
                }
            }

        }
        forest.update(tree); 
        //cnt++ ;
    }

    public void initGrid() {
        reset();
        for (int i = 0; i < tree.length ; i++) {
            for (int j = 0; j < tree.length ; j++) {
                tree[i][j] = new Tree(1);
                if (i == 0 || j == 0 || i == tree.length - 1 || j == tree.length - 1) {
                    tree[i][j].setposition(0);
                } else {
                    tree[i][j].setposition(1);
                }
            }
        }
        tree[tree.length / 2][tree.length / 2].setposition(2);
        forest.update(tree);
    }

    public boolean isFinish() {
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[0].length; j++) {
                if (tree[i][j].getposition() == 2) {
                    return false;
                }
            }
        }
        return true;
    }
    
     public void probTree(int[][] b){
       float Verocity = 0.00f;
 
       for(int i =1;i<tree.length-1;i++){
            for(int j=1 ; j<tree.length-1;j++){
               probTree= (float)(Math.random()*101);
               if(Verocity < probTree ) {
                   b[i][j] = 0;
               }
               else {
                   b[i][j] = 1;
               }
            }
        }
    }
    
    public void probBurn(int[][] b){
       float initBurn = 0.00f;
       
       for(int i =1;i<tree.length-1;i++){
            for(int j=1 ; j<tree.length-1;j++){
               probBurn = (float)(Math.random()*101);
               if(initBurn > probBurn ) {
                   b[i][j] = 2;
               }
               else {
                   b[i][j] = 1;
               }
            }
        }
    }
    
    public void setpropBurn(float a){
        probBurn = a;
    }
    
    public void setpropTree(float a){
        probTree = a;
    }
        

    public void setprobCatch(float a) {
        probCatch = a;
    }

    private boolean isBurn() {
        if (getRandomProb() < getProbCatch()) {
            return true;
        }

        return false;
    }

    public static float getRandomProb() {
        Random rand = new Random();

        float finalX = rand.nextFloat() * (maxX - minX) + minX;
        return finalX;
    }

    public float getProbCatch() {
        return probCatch;
    }

    public void setNumberTree(int numberTree) {
        this.numberTree = numberTree;
    }

    public int getNumberTree() {
        return numberTree;
    }
    
     public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getCnt() {
        return cnt;
    }
    

}
