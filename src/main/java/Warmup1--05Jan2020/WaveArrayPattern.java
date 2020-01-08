

public class WaveArrayPattern {

    public static void main(String[] arg)
    {
        int[] a={3,2,4,5,6,1,8,7,9};
        int n=a.length;
        createWavePatternInArray(a,n);
        for(int value:a )
        {
            System.out.println(value);
        }
    }

    private static void createWavePatternInArray(int[] a, int n) {
        for(int i=0;i<n;i=i+2)
        {
            // check if previous element is greater then swap
            if(i>0&&a[i]<a[i-1])
            {
                swap(a,i,i-1);
            }
            // check if next element is greater then swap
            if(i<n-1&&a[i]<a[i+1])
            {
                swap(a,i,i+1);
            }
        }
    }

    private static void swap(int[] a,int x, int y) {
        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;

    }
}
