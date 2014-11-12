package com.sankar.SRM144DIV2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PowerOutage {

    public int estimateTimeOut(int[] from, int[] to, int[] times) {
        return new Nodes(from, to, times).bestLength();
    }

    public class Nodes {

        private Map<Integer, Node> nodes = new HashMap<Integer, Node>();

        public Nodes(int[] from, int[] to, int[] times) {
            for (int i = 0; i < from.length; i++) {
                Node f = get(from[i]);
                Node t = get(to[i]);
                f.connect(t, times[i]);
            }
        }

        public int bestLength() {
            Node node0 = nodes.get(0);
            node0.calculateLengths();
            return node0.bestLength();
        }

        private Node get(int index) {
            Node node = nodes.get(index);

            if (node == null) {
                node = new Node();
                nodes.put(index, node);
            }

            return node;
        }

    }

    public class Node {
        private Set<Edge> connections = new HashSet<Edge>();

        private Map<Edge, Integer> lengths = new HashMap<Edge, Integer>();

        private int totalLength = -1;

        public void connect(Node other, int length) {
            connections.add(new Edge(other, length));
        }

        public int calculateLengths() {
            if (totalLength >= 0)
                return totalLength;

            totalLength = 0;
            for (Edge e : connections) {
                int edgeLength = e.totalLength();
                totalLength += edgeLength;
                lengths.put(e, edgeLength);
            }

            return totalLength;
        }

        public int bestLength() {
            int bestLength = 0;

            int maxLength = -1;
            Set<Edge> worst = new HashSet<Edge>();

            for (Entry<Edge, Integer> entry : lengths.entrySet()) {
                Edge edge = entry.getKey();
                int length = entry.getValue();

                if (length > maxLength) {
                    maxLength = length;
                    for (Edge e : worst)
                        bestLength += lengths.get(e);
                    worst.clear();
                    worst.add(edge);
                }

                else if (length == maxLength) {
                    worst.add(edge);
                }

                else
                    bestLength += length;
            }

            int worstBestLength = -1;
            Edge lastEdgeToVisit = null;

            for (Edge edge : worst) {
                int len = edge.bestLength();
                if (len > worstBestLength) {
                    worstBestLength = len;
                    lastEdgeToVisit = edge;
                }
            }

            for (Edge edge : worst) {
                bestLength += (edge == lastEdgeToVisit ? worstBestLength : lengths.get(edge));
            }

            return bestLength;
        }
    }

    public class Edge {
        private Node node;
        private int length;

        public Edge(Node node, int length) {
            this.node = node;
            this.length = length;
        }

        public int totalLength() {
            return length * 2 + node.calculateLengths();
        }

        public int bestLength() {
            return length + node.bestLength();
        }
    }

}
