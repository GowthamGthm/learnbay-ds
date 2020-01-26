public class SpiralMatrix {

    private void spiralMatrix(int[][] a)

    {

        int col=a[0].length;
        int rows=a.length;

        for(int i=0;i<rows/2;i++)
        {
            for(int j=0;j<col-i;j++)
            {
                System.out.println(a[i][j]);

            }
            for(int k=i+1;k<rows-i;k++)
            {
                System.out.println(a[k][j]);
            }
            for(int l=j-1;l>i;l--)
            {
                System.out.println(a[l][k]);
            }
            for(int m=j-1;j>i;m--)
            {
                System.out.println(a[k][m]);
            }
        }


    }
}
