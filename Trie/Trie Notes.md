#DSA  #Trie

### Introduction
In computer science, a trie, also called digital tree or prefix tree, is a type of k-ary search tree, a tree data structure used for locating specific keys from within a set. These keys are most often strings, with links between nodes defined not by the entire key, but by individual characters.

`Below implementation is for a dictionary where letters are in small (a-z)`

### Create Trie Node
```java
private static class Node {  
    public Node(char data) {  
        this.data = data;  
    }  
  
    int we = 0;  
    char data;  
    Node[] nodes = new Node[26];  
  
    @Override  
    public String toString() {  
        return data + "";  
    }  
}
```

### Insert a word
```java
void insert(Node root, String word) {  
    Node current = root;  
    char[] chars = word.toCharArray();  
    for (int i = 0; i < chars.length; i++) {  
        int index = chars[i] - 'a';  
        Node node = new Node(chars[i]);  
        if (i == chars.length - 1) {  
            node.we = 1;  
        }  
        if (current.nodes[index] == null) {  
            current.nodes[index] = node;  
            current = node;  
        } else {  
            if (current.nodes[index].data == chars[i]) {  
                current = current.nodes[index];  
            } else {  
                current.nodes[index] = node;  
                current = node;  
            }  
        }  
    }  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

### Search a word
```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

### Delete a word
```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

### Count the words starts with the prefix
```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)