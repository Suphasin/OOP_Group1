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
public class Spread {

    static boolean[][] cell = new boolean[12][12];

    public Spread(boolean[][] cell) {
        Spread.cell = cell;
    }

    public Spread() {

    }

    public static void reset() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                cell[i][j] = false;
            }
        }
    }
}
