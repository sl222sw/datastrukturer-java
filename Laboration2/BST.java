package Laboration2;

import java.util.ArrayList;
import java.util.Iterator;

public class BST<E extends Comparable<E>> extends Mayagudar implements Iterable<E>{
    protected TreeNode<E> root;
    protected int size = 0;

    public void add(E e) {
        if (root == null) {
            root = new TreeNode<>(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;

            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return;
                }
            }

            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(e);
            } else {
                parent.right = new TreeNode<>(e);
            }
        }
        size++;
    }

    public void remove(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = parent.right;
            } else {
                break;
            }
        }

        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            TreeNode<E> parentOfRight = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRight = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;
            if (parentOfRight.right == rightMost) {
                parentOfRight.right=rightMost.left;
            } else {
                parentOfRight.left = rightMost.left;
            }
        size--;
        }

    }

    public boolean find(E e) {
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public E min() {
        TreeNode<E> current = root;

        if(current == null){
            throw new IndexOutOfBoundsException();
        }
        while (current.left != null) {
            current = current.left;
        }
        return current.element;
    }

    public E max() {
        TreeNode<E> current = root;

        if(current == null){
            throw new IndexOutOfBoundsException();
        }
        while (current.right != null) {
            current = current.right;
        }
        return current.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements Iterator<E> {
        private ArrayList<E> list = new ArrayList<>();

        private int current = 0;

        public InorderIterator() {
            inorder();
        }

        public void inorder() {
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            if(current < list.size()) {
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            return list.get(current++);
        }
    }
}
