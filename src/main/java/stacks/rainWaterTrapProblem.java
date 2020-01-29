import java.util.Stack;

public class rainWaterTrapProblem {


  /*Complexity
  * space : 0(n)
  * time : o(n)
  * */

  private static int trapWaterSolutionOne(int[] height) {

    int n = height.length;
    if(n<=0)
    {return 0;}
    int[] lMax = new int[n];
    int[] rMax = new int[n];
    lMax[0] = 0;
    rMax[n - 1] = 0;
    int max = 0;
    for (int i = 1; i < n; i++) {
      lMax[i] = Math.max(lMax[i - 1], height[i - 1]);
    }

    for (int j = n - 2; j >= 0; j--) {
      rMax[j] = Math.max(rMax[j + 1], height[j + 1]);
    }

    int unitOfWaterTrapped = 0;
    for (int k = 0; k < n; k++) {
      int waterAtPosition = Math.min(rMax[k], lMax[k]) - height[k];
      if (waterAtPosition > 0) {
        unitOfWaterTrapped += waterAtPosition;
      }
    }

    return unitOfWaterTrapped;
  }


  static int trapWaterUsingStack(int[] height)
  {

    int unitOfWaterTrapped=0;

    Stack<Integer> stack =new Stack<>();
    int n=height.length;
    for(int i=0;i<n;i++)
    {

      while(!stack.isEmpty() && height[i]>height[stack.peek()])
      {
        int top=stack.pop();
        if(!stack.isEmpty())
        {
          int lMax= height[stack.peek()];
          int rMax=height[i];
          unitOfWaterTrapped+=(Math.min(lMax,rMax)-height[top])*(i-stack.peek()-1);
        }


      }
      stack.push(i);

    }
    return unitOfWaterTrapped;
  }

  public static void main(String[] args) {
    System.out.println(trapWaterSolutionOne(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    System.out.println(trapWaterUsingStack(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

  }
}
