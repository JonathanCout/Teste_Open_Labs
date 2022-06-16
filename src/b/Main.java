package b;

import java.util.*;

public class Main {

    static int[] coins = {25,10,5,1};
    static Set<List<Integer>> possibilities = new HashSet<>();
    static int counter = 0;

    public static void main(String[] args) {
        makeChange(19,0);
        for (List<Integer> possible : possibilities){
            System.out.println(possible.toString());
        }
    }

    public static int makeChange(int amount, int indexStart){
        int dummy = amount;
        int result;

        if(indexStart > 3){
            return 0;
        }
        List<Integer> currentWay = new ArrayList<>();
        while(currentWay.size() < 4) currentWay.add(0);
        for(int i = indexStart; i < coins.length; i++){
            result = dummy/coins[i] - counter;
            currentWay.set(i, result);
            dummy -= coins[i]* currentWay.get(i);

            if(result > 1 && i < 3){
                counter++;
                makeChange(amount,indexStart);
            }
            counter = 0;
        }

        possibilities.add(currentWay);
        indexStart++;
        makeChange(amount,indexStart);
        return 0;
    }




}