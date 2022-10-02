package com.notes;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private static class Node {
        public Node(char data) {
            this.data = data;
        }

        int we = 0;
        char data;
        int pc = 0;//prefixCount
        Node[] nodes = new Node[26];

        @Override
        public String toString() {
            return data + "";
        }
    }

    void insert(Node root, String word) {
        Node current = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            Node node = new Node(chars[i]);
            node.pc = 1;
            if (i == chars.length - 1) {
                node.we = 1;
            }
            if (current.nodes[index] == null) {
                current.nodes[index] = node;
                current = node;
            } else {
                if (current.nodes[index].data == chars[i]) {
                    current.nodes[index].pc += 1;
                    current = current.nodes[index];
                } else {
                    current.nodes[index] = node;
                    current = node;
                }
            }
        }
    }

    boolean search(Node root, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (root.nodes[index] == null) {
                return false;
            } else {
                if (root.nodes[index].data == chars[i]) {
                    if (root.nodes[index].we == 1 && i + 1 == chars.length) {
                        return true;
                    }
                    root = root.nodes[index];
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    boolean delete(Node root, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (root.nodes[index] == null) {
                return false;
            } else {
                if (root.nodes[index].data == chars[i]) {
                    if (root.nodes[index].we == 1 && i + 1 == chars.length) {
                        root.nodes[index].we = 0;
                        return true;
                    }
                    root = root.nodes[index];
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    int countPrefixWords(Node root, String prefix) {
        if (root == null) return -1;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (root.nodes[index] == null) {
                return -1;
            } else {
                if (root.nodes[index].data == chars[i] && (i + 1) == chars.length) {
                    return root.nodes[index].pc;
                } else {
                    root = root.nodes[index];
                }
            }
        }
        return -1;
    }
    List<String> autoCompleteWordSuggestion(Node root, String prefix){
        if(root == null) return null;
        List<String> list = new ArrayList<>();
        char chars[] = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if(root.nodes[index] == null)return null;
            else{
                if(root.nodes[index].data == chars[i]){
                    if(i+1 == chars.length){
                        return list;
                    }else {

                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        Node root = new Node('/');
        trie.insert(root, "abc");
        trie.insert(root, "abcd");
        trie.insert(root, "apple");
        trie.insert(root, "adding");

        System.out.println(root);
        System.out.println(trie.countPrefixWords(root, "ab"));
    }
}
