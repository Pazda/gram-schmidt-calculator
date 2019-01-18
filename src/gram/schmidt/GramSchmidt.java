package gram.schmidt;

import java.util.Scanner;

/**
 * 4/26/2018: Initial Creation
 * @author Tim Swyzen
 */
public class GramSchmidt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declarations 
        Scanner scan = new Scanner( System.in ); 
        int sizeEach;
        double dotProduct = 0.0;
        double lengthOf2 = 0.0;
        
        // Get matrix sizes
        System.out.print( "Dimension of vector: " );
        sizeEach = scan.nextInt();
        
        // Create the matrices
        double matrix1[] = new double[sizeEach];
        double matrix2[] = new double[sizeEach];
        double finalMatrix[] = new double[sizeEach];
        double backupMatrix2[] = new double[sizeEach];
        
        // Fill matrices
        for ( int i = 0; i < sizeEach; i++ )
        {
            System.out.println( "Enter value #" + (i+1) + " for the first matrix.");
            matrix1[i] = scan.nextDouble();
            finalMatrix[i] = matrix1[i];
        }
        for ( int i = 0; i < sizeEach; i++ )
        {
            System.out.println( "Enter value #" + (i+1) + " for the second matrix to orthonormalize with respect to the first.");
            matrix2[i] = scan.nextDouble();
            backupMatrix2[i] = matrix2[i];
        }
        
        
        // Calculate dot product of the vectors & length of vector 2
        for ( int i = 0; i < sizeEach; i++ )
        {
            dotProduct += ( matrix1[i] * matrix2[i] );
            lengthOf2 += ( matrix1[i] * matrix1[i] );
        }
        
        // Calculate projection of matrix 1 onto matrix 2
        for ( int i = 0; i < sizeEach; i++ )
        {
            finalMatrix[i] = finalMatrix[i] * dotProduct / lengthOf2;
            finalMatrix[i] = backupMatrix2[i] - finalMatrix[i];
        }
        
        // Display hopefully correct data!
        System.out.println( "First matrix: " );
        for ( int i = 0; i < sizeEach; i++ )
        {
            System.out.println( matrix1[i] );
        }
        
        System.out.println( "\n\nSecond matrix: " );
        for ( int i = 0; i < sizeEach; i++ )
        {
            System.out.println( finalMatrix[i] );
        }
    }
    
}
