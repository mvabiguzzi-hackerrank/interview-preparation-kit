package com.mvabiguzzi.hackerrank.interview.preparation.kit.graphs;

import java.util.*;

public class BfsShortestReachInGraph {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        final Graph.Node node1 = Graph.getNode(1);
        final Graph.Node node2 = Graph.getNode(2);
        final Graph.Node node3 = Graph.getNode(3);
        final Graph.Node node4 = Graph.getNode(4);
        final Graph.Node node5 = Graph.getNode(5);

        node1.adjacent.add(node2);
        node1.adjacent.add(node3);
        node3.adjacent.add(node4);

//        final ArrayList<Integer> path = Graph.getPath(1, 5);
//        path.forEach(System.out::println);

        final ArrayList<Integer> path1 = Graph.getPath(1, 4);
        path1.forEach(System.out::println);
    }

    public static class Graph {
        private static HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

        public static class Node {
            private int id;
            LinkedList<Node> adjacent;

            private Node(final int id) {
                this.id = id;
                adjacent = new LinkedList<Node>();
            }
        }

        public static Node getNode(final int id) {
            final Node node = Optional.ofNullable(nodeLookup.get(id)).orElse(new Node(id));
            nodeLookup.putIfAbsent(node.id, node);
            return node;
        }

        private void addEdge(final int source, final int dest) {
            final Node sourceNode = getNode(source);
            final Node destNode = getNode(dest);

            sourceNode.adjacent.add(destNode);
        }

        public boolean hasPath(final Node source, final Node dest) {
            final LinkedList<Node> nextToVisit = new LinkedList<>();
            final HashSet<Integer> visited = new HashSet<>();

            nextToVisit.add(source);

            while (!nextToVisit.isEmpty()) {
                final Node node = nextToVisit.remove();

                if(node == dest) {
                    return true;
                }

                if (visited.contains(node.id)) continue;

                visited.add(node.id);

                nextToVisit.addAll(node.adjacent);
            }

            return false;
        }

        public static ArrayList<Integer> getPath(final int source, final int dest) {
            final Node sourceNode = getNode(source); final Node destNode = getNode(dest);

            final LinkedList<Node> nextToVisit = new LinkedList<>();
            nextToVisit.add(sourceNode);

            return getPath(destNode, nextToVisit, new HashSet<Integer>());
        }

        private static ArrayList<Integer> getPath(final Node destNode, final LinkedList<Node> nextToVisit,
                                  final HashSet<Integer> visited) {

            if(nextToVisit.isEmpty()) {
                return new ArrayList<>();
            } else {
                final Node node = nextToVisit.remove();

                if (visited.contains(node.id)) {
                    return getPath(destNode, nextToVisit, visited);
                } else {
                    visited.add(node.id);

                    if ( node == destNode) {
                        return new ArrayList<>(Collections.singletonList(node.id));
                    } else {
                        nextToVisit.addAll(node.adjacent);
                        final ArrayList<Integer> path = getPath(destNode, nextToVisit, visited);

                        if(!path.isEmpty()) path.add(0, node.id);

                        return path;
                    }
                }
            }
        }
    }
}
