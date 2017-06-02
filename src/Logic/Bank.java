package Logic;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Alexandr on 26.05.2017.
 */
public class Bank {
    public ArrayList<Integer> pk = new ArrayList<>();

    public void add(int k){
        pk.add(k);
    }

    public int getI(int I){
        return pk.get(I);
    }

    public void clear(){
        pk.clear();
    }
}
