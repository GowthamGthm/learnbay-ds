import java.util.*;


/*
* Maximum Frequency Stack
* push- (1)
* pop-(1)
 */
class FreqStack {
     HashMap<Integer, Stack<Integer>> frequencyMap ;
     HashMap<Integer, Integer> valueMap ;

     int maxFrequency ;

    public FreqStack() {

        this.maxFrequency=0;
        frequencyMap = new HashMap<>();
        valueMap = new HashMap<>();

    }

    public void push(int x) {
        int freq= valueMap.getOrDefault(x,0);
        valueMap.put(x,++freq);
        if(maxFrequency<freq)
        {
            maxFrequency=freq;
        }
        frequencyMap.computeIfAbsent(freq,z->new Stack<>()).push(x);
    }

    public int pop() {

        int element=frequencyMap.get(maxFrequency).pop();
        valueMap.put(element,maxFrequency-1);
       if(frequencyMap.get(maxFrequency).isEmpty())
        {
            --maxFrequency;
        }

        return element;

    }



}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */