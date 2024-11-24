package Hw6_23001908_VuQuangNam.ex6.practice9;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        for (ArrayList<Integer> a : adj) {
            if (a.size() % 2 == 1) return false;
        }
        return true;
        // Code here
    }
}
