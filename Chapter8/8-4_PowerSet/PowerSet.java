/**
 * Write a method to return all subsets of a set.
 */

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class PowerSet {
    private static List<Set<Integer>> powerSet(Set<Integer> set) {
        Integer[] array = set.stream().toArray(n -> new Integer[n]);
        List<Set<Integer>> toReturn = new ArrayList<>();
        boolean[] memo = new boolean[array.length];
        recursion(0, new HashSet<Integer>(), toReturn, array, );
        return toReturn;
    }

    private static void recursion(int start, Set<Integer> currSet, List<Set<Integer>> toReturn, Integer[] array, int level, boolean[] memo) {
        if (start >= array.length) {
            return;
        }

        // Start a new base
        if (currSet.size() > 0) {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(array[start]);
            toReturn.add(new HashSet<Integer>(newSet));
            recursion(start + 1, newSet, toReturn, array);
        }

        // Continue the current route
        currSet.add(array[start]);
        toReturn.add(new HashSet<Integer>(currSet));
        recursion(start + 1, currSet, toReturn, array);
    }

    public static void main(String[] args) {
        Set<Integer> case1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Case1: " + case1);
        System.out.println(powerSet(case1));
    }
}
