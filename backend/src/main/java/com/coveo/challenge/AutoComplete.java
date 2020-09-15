package com.coveo.challenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AutoComplete {
    // dict: abc, acd, bcd, def, a, aba

    // prefix a -> abc, acd, a, aba
    // prefix b -> bcd

    // given cities[0]
    // for every word that starts with letter a, go down this branch
    //            o
    //        a/    \b
    //        0      0
    //      b/ \c
    //       O
    //     a/ c\
    //     0   0

    // we want to find which words are that start with this prefix
    // go until prefix and do DFS on the words that are children from this part
    // worst case scenario traverse all possible subtrees

    // This class stores the entire string up to the point of traversal
    // so the value can be returned for consumption
    private class TrieNode {
        String prefix;

        // to store all of the children
        HashMap<Character, TrieNode> children; // has all child nodes
        boolean isWord; // whenever it is the terminal point of a word.

        private TrieNode(String prefix) {
            this.prefix = prefix;
            this.children = new HashMap<Character, TrieNode>();
        }
    }

    // root of the Tree
    private TrieNode trie;

        public AutoComplete(String[] dict) {

            trie = new TrieNode(""); // the empty string initially

            for (String s : dict) {
                insertWord(s);
            }
        }

    private void insertWord(String s) {
        // loop through the characters, see if a node is already existing for this character
        // otherwise insert the node
        TrieNode current = trie; // starts at first

        for (int i = 0; i < s.length(); i++) {
            if (!current.children.containsKey(s.charAt(i))) {
                current.children.put(s.charAt(i),
                    new TrieNode(s.substring(0, i + 1))); // substring to get the prefix
            }

            // now we want to move to the next, increment current
            // we need to mark it when we are at the end of a word
            current = current.children.get(s.charAt(i));

            // it means that we got the word, same size
            if (i == s.length() - 1) {
                current.isWord = true;
            }
        }
    }

    public List<String> getWordsForPrefix(String pre) {
        // iterate through prefix and see all options that are children of that node
        List<String> results = new LinkedList<String>();

        TrieNode current = trie;
        for (char c : pre.toCharArray()) {
            if (current.children.containsKey(c)) {
               current = current.children.get(c);
            } else {
                // not found, return the last accumulated results
                return results;
            }
        }
        // go recursively and find all the words, results are accumulated..
        findAllChildWords(current, results);
        return results;
    }

    private void findAllChildWords(TrieNode node, List<String> results) {
        // check if current is end of the word
        if (node.isWord) {
            // the value of the prefix is a valid word
            results.add(node.prefix);
        }

        // go with recursion through all of the children
        for (Character c : node.children.keySet()) {
            findAllChildWords(node.children.get(c), results);
        }
    }
}


