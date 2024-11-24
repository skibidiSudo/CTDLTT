package Hw6_23001908_VuQuangNam.ex6.practice13;

import java.util.*;
class Solution {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        if (!wordSet.contains(targetWord)) return 0;
        if (!wordSet.contains(startWord)) {
            wordSet.add(startWord);
        }
        Map<String, List<String>> adj = new HashMap<>();
        for (String word : wordSet) {
            adj.putIfAbsent(word, new ArrayList<>());
            for (String otherWord : wordSet) {
                if (check(word, otherWord)) {
                    adj.get(word).add(otherWord);
                }
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(startWord);
        Map<String, Integer> distance = new HashMap<>();
        distance.put(startWord, 1);
        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentDistance = distance.get(currentWord);
            if (currentWord.equals(targetWord)) {
                return currentDistance;
            }
            for (String neighbor : adj.getOrDefault(currentWord, new ArrayList<>())) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, currentDistance + 1);
                    queue.add(neighbor);
                }
            }
        }
        return 0;
    }

    private boolean check(String w1, String w2) {
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }

}
