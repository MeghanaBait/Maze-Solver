/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Meghana
 */
public class MazeSolver extends JFrame{
     private int[][] maze = 
        {{1,1,1,1,1,1,1,1,1,1,1,1,1},
         {1,0,1,0,1,0,1,0,0,0,0,0,1},
         {1,0,1,0,0,0,1,0,1,1,1,0,1},
         {1,0,1,1,1,1,1,0,0,0,0,0,1},
         {1,0,0,1,0,0,0,0,1,1,1,0,1},
         {1,0,1,0,1,1,1,0,1,0,0,0,1},
         {1,0,1,0,1,0,0,0,1,1,1,0,1},
         {1,0,1,0,1,1,1,0,1,0,1,0,1},
         {1,0,0,0,0,0,0,0,0,0,1,9,1},
         {1,1,1,1,1,1,1,1,1,1,1,1,1},
        };
     
     public List<Integer> path = new ArrayList<>();
     
     public MazeSolver(){
         setTitle("Maze Solver");
         setSize(500, 500);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         DFS.searchPath(maze, 1, 1, path);
         System.out.println(path);
         
     }
     @Override
     public void paint(Graphics g){
         
         g.translate(50, 100);
         for(int i = 0; i < maze.length; i++){
             for(int j = 0; j < maze[0].length; j++){
                 Color color;
                  g.setColor(Color.YELLOW);
                  g.fillRect(30*1, 30*1, 30, 30);
                 switch(maze [i][j]){
                     case 1: color = Color.BLACK;break;
                     case 9: color = Color.BLUE;break;
                     default: color = Color.white;break;
                 }
                 g.setColor(color);
                 g.fillRect(30*j,30*i,30,30);
                 g.setColor(Color.RED);
                 g.drawRect(30*j, 30*i, 30, 30);
             }
         }
         
         for(int i = 0; i < path.size(); i += 2){
             int pathx = path.get(i);
             int pathy = path.get(i+1);
             System.out.println("X Coordinate:" + pathx);
             System.out.println("Y Coordinate:" + pathy);
             
             g.setColor(Color.GREEN);
             g.fillRect(30*pathx, 30*pathy, 30, 30);
         }
     }
     
     
     public static void main(String[] args){
         MazeSolver view = new MazeSolver();
         view.setVisible(true);
     }
}
