package org.elnino.tree;

import java.util.HashMap;

/**
 * A trie, also called digital tree or prefix tree
 *
 * @see <a href="https://en.wikipedia.org/wiki/Trie">wikipedia</a>
 */
@SuppressWarnings({"unused"})
public class Trie {
    private static class Node {
        /**
         * Whether a string represented by the path from root to this node exists in the set.
         */
        private boolean existed = false;

        private final HashMap<Character, Node> children = new HashMap<>();

        private Node getChild(char c) {
            return children.get(c);
        }

        /**
         * Create a child node representing character {@code c}
         * if this node does not exist.
         *
         * @return the child node
         */
        private Node setChild(char c) {
            Node node = children.get(c);

            if (node == null) {
                node = new Node();
                children.put(c, node);
            }
            return node;
        }

    }

    private final Node root = new Node();

    /**
     * @see java.util.Set#add(Object)
     */
    public boolean add(String s) {
        boolean ans;
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            cur = cur.setChild(s.charAt(i));
        }
        ans = !cur.existed;
        cur.existed = true;

        return ans;
    }

    /**
     * @see java.util.Set#contains(Object)
     */
    public boolean contains(String s) {
        if (s == null) return false;

        Node cur = root;
        int i, n = s.length();

        for (i = 0; i < n && cur != null; i++) {
            cur = cur.getChild(s.charAt(i));
        }

        return i == n && cur.existed;
    }

}
