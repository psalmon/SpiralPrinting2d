/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spiralprinting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Paul
 */
public class SpiralPrinting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            
            String[] lineArray = line.split(";");
            if (lineArray.length > 0) {//ignore blank line inputs
                //Process line of input Here

                //Max ,minimum, and current indexes in our matrix.
                int maxX = Integer.parseInt(lineArray[0]) - 1;
                int maxY = Integer.parseInt(lineArray[1]) - 1;
                int minX = 0;
                int minY = 0;
                int x = 0;
                int y = 0;
                
                //Build our matrix
                String[] valueArray = lineArray[2].split("\\s");
                String[][] matrix = new String [Integer.parseInt(lineArray[0])][Integer.parseInt(lineArray[1])];
                int count = 0;
                
                for (int j = 0; j <= maxY; j++){
                    for (int i = 0; i <= maxX; i++){
                        matrix[i][j] = (valueArray[count]);
                        count++;
                    }
                }     
                StringBuilder printString = new StringBuilder();
                //Traverse and print our matrix in a spiral!
                int total = 0;
                while (maxX >=minX && maxY >= minY){

                    if (x != maxX){
                        while (x < maxX){
                            printString.append(matrix[x][y]).append(" ");
                            x++;
                            total++;
                        }maxX--;
                    }
                    if (y != maxY){
                        while (y < maxY){
                            printString.append(matrix[x][y]).append(" ");
                            y++;
                            total++;
                        }maxY--;
                    }
                    if (x != minX){
                        while (x > minX){
                            printString.append(matrix[x][y]).append(" ");
                            x--;
                           total++;
                        }minX++;
                    }
                    if (y != minY){
                        while (y > minY){
                            printString.append(matrix[x][y]).append(" ");
                            y--;
                           total++;
                        }minY++;
                    }
                    if (y==maxY){
                        //printString.append(matrix[x][y]);
                        minY++;
                    }
                    if(x==maxX){
                        //printString.append(matrix[x][y]);
                        minX++;
                    }
                    
                    //One border done (4 passes). Next iteration of while-loop begins.
                    x = minX;
                    y = minY;
                }//end of our traversal loop
                //Print it !
                if (total < valueArray.length){
                    printString.append(matrix[(maxX/2)+1][(maxY/2)+1]);
                }
                System.out.println(printString.toString().trim());
            }
        }//end of input line analysis
    }
}//end of class
