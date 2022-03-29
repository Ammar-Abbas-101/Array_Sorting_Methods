package com.ammarabbas;

import java.awt.*;

import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 800;
    final int PANEL_HEIGHT = 800;

    Timer bubbleTimer;
    Timer selectionTimer;
    Timer insertionTimer;

    int x = 80;
    int y = 0;

    public int[] myArray = {20,30,40,10,50,13,25};
    int indexOne;
    int indexTwo;
    int indexThree;
    int indexFour;
    int indexFive;
    int indexSix;
    int indexSeven;
    int j = 0;
    boolean flag = true;   // set flag to true to begin first pass
    int temp;   //holding variable
    int count = 0;

    MyPanel() {
        System.out.println(Arrays.toString(myArray));

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.pink);

        repaint();

        String[] buttonTitles = {"BubbleSort", "SelectionSort", "InsertionSort"};       // Making button titles

        int userChoice = JOptionPane.showOptionDialog(null, "What would you like to do?",
                "Welcome!", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                buttonTitles, buttonTitles[0]);     // creating input box

        if (userChoice == 0) {                  // if statements for each sorting method
            BubbleSort();
        } else if (userChoice == 1) {
            SelectionSort();
        }
        else {
            InsertionSort();
        }
        ;
    }

    public void paint(Graphics g) {

        super.paint(g); // paint background
        Graphics2D g2D = (Graphics2D) g;            // casting as graphisc2d object


        // Paints new rectangles every time
        Rectangle.Double bar1 = new Rectangle2D.Double((x * 0) + 80, 20, 50, indexOne * 12);
        Rectangle.Double bar2 = new Rectangle2D.Double((x * 1) + 80, 20, 50, indexTwo * 12);
        Rectangle.Double bar3 = new Rectangle2D.Double((x * 2) + 80, 20, 50, indexThree * 12);
        Rectangle.Double bar4 = new Rectangle2D.Double((x * 3) + 80, 20, 50, indexFour * 12);
        Rectangle.Double bar5 = new Rectangle2D.Double((x * 4) + 80, 20, 50, indexFive * 12);
        Rectangle.Double bar6 = new Rectangle2D.Double((x * 5) + 80, 20, 50, indexSix * 12);
        Rectangle.Double bar7 = new Rectangle2D.Double((x * 6) + 80, 20, 50, indexSeven * 12);

        // Setting color and filling in shapes
        g2D.setColor(Color.WHITE);
        g2D.fill(bar1);
        g2D.fill(bar2);
        g2D.fill(bar3);
        g2D.fill(bar4);
        g2D.fill(bar5);
        g2D.fill(bar6);
        g2D.fill(bar7);
    }


    public void SelectionSort(){

        int i,j,first,temp;

        for ( i = myArray.length - 1; i > 0; i -- )
        {
            first = 0;   //initialize to subscript of first element
            for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
            {
                if( myArray[ j ] < myArray[ first ] )
                    first = j;
            }
            temp = myArray[ first ];   //swap smallest found with element in position i.
            myArray[ first ] = myArray[ i ];
            myArray[ i ] = temp;
        }
        System.out.println(Arrays.toString(myArray));

    }

    public void InsertionSort(){
        int j;                     // the number of items sorted so far
        int key;                // the item to be inserted
        int i;

        for (j = 1; j < myArray.length; j++)    // Start with 1 (not 0)
        {
            key = myArray[j];
            for(i = j - 1; (i >= 0) && (myArray[ i ] < key); i--)   // Smaller values are moving up
            {
                myArray[i+1] = myArray[i];
            }
            myArray[i+1] = key;    // Put the key in its proper location
        }
        System.out.println(Arrays.toString(myArray));

    }

    public void BubbleSort(){

        bubbleTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                j=0;
                flag = false;

                // if statements to run each time

                if (bubbleChecking(j)){
                    flag = true;
                }

                else if(bubbleChecking(j+1)) {
                    flag = true;
                }

                else if(bubbleChecking(j+2)) {
                    flag = true;
                }

                else if(bubbleChecking(j+3)) {
                    flag = true;
                }

                else if(bubbleChecking(j+4)) {
                    flag = true;
                }

                else if(bubbleChecking(j+5)) {
                    flag = true;
                }

                else if(bubbleChecking(j+6)) {
                    flag = true;
                }

                if (!flag){
                    System.out.println(Arrays.toString(myArray));
                    bubbleTimer.stop();
                    System.out.println("Sorted.");
                    System.exit(0);
                }

            }
        });
        bubbleTimer.start();            // starting timer
    }
    public boolean bubbleChecking(int j){

        if (j+1 < myArray.length){
            if ( myArray[ j ] > myArray[j+1] )   // change to > for ascending sort
            {
                temp = myArray[ j ];                //swap elements
                myArray[ j ] = myArray[ j+1 ];
                myArray[ j+1 ] = temp;
                flag = true;              //shows a swap occurred

                // Updating array index
                indexOne = myArray[0];
                indexTwo = myArray[1];
                indexThree = myArray[2];
                indexFour = myArray[3];
                indexFive = myArray[4];
                indexSix = myArray[5];
                indexSeven = myArray[6];
                System.out.println(Arrays.toString(myArray));
                repaint();          // repaints the graphics with updated values
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }


    @Override
    public void actionPerformed(ActionEvent e) {}

}