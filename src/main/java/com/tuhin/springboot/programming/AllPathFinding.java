package com.tuhin.springboot.programming;
// JAVA program to print all
// paths from a source to
// destination.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// A directed graph using
// adjacency list representation
public class AllPathFinding {

    // No. of vertices in graph
    private int vertices;

    // adjacency list
    private ArrayList<Integer>[] adjList;

    //Constructor
    public AllPathFinding(int vertices) {

        //initialise vertex count
        this.vertices = vertices;

        // initialise adjacency list
        initAdjList();
    }

    // utility method to initialise
    // adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList() {
        adjList = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, int v) {
        // Add v to u's list.
        adjList[u].add(v);
    }

    // Prints all paths from
    // 's' to 'd'

    public void printAllEdges(int s) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            visited[u] = true;
            if (adjList[u].size() > 0) {
                System.err.print("From");
                printNodeValue(u);
                System.out.print("-->[");
                for (Integer i : adjList[u]) {
                    if (!visited[i]) {
                        queue.add(i);
                    }
                    printNodeValue(i);
                    System.err.print(",  ");
                }
                System.out.println("]");
            }


        }
    }


    public void printAllPaths(int s) {
        boolean[] isVisited = new boolean[vertices];
        ArrayList<Integer> pathList = new ArrayList<>();

        //add source to path[]
        pathList.add(s);

        //Call recursive utility
        printAllPathsUtil(s, isVisited, pathList);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Integer u,
                                   boolean[] isVisited,
                                   List<Integer> localPathList) {

        // Mark the current node
        isVisited[u] = true;

        if (adjList[u].size() == 0) {
            //System.out.println(localPathList);
            systemOutThePath(localPathList);
            System.out.println();
            // if match found then no need to traverse more till depth
            isVisited[u] = false;
            return;
        }

        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, isVisited, localPathList);

                // remove current node
                // in path[]
                localPathList.remove(i);
            } else {
                systemOutThePath(localPathList);
                System.out.println("->" + myMapSmallBig.get(i));
            }
        }

        // Mark the current node
        isVisited[u] = false;
    }

    private void printNodeValue(int node) {
        System.out.print("(" + myMapSmallBig.get(node) + ")" + descriptionMap.get(myMapSmallBig.get(node)) + "");
    }

    private void systemOutThePath(List<Integer> localPathList) {
        localPathList.forEach(node -> {
            //System.out.print("--" + myMapSmallBig.get(node) + "--");
            System.out.print("--(" + myMapSmallBig.get(node) + ")" + descriptionMap.get(myMapSmallBig.get(node)) + "--");
        });
    }

    static Map<Integer, Integer> myMapBigSmall;
    static Map<Integer, Integer> myMapSmallBig;
    static Map<Integer, String> descriptionMap;

    static String replaceNewLineWithEmpty(String str) {
        return str.replaceAll("\\r\\n|\\r|\\n", " ");
    }
    public static AllPathFinding csvReader() {
        String csvFile = "G:\\temp\\flow-state-transition.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            boolean skip = true;
            myMapBigSmall = new HashMap<>();
            myMapSmallBig = new HashMap<>();
            descriptionMap = new HashMap<>();
            while ((line = br.readLine()) != null) {
                if (skip) {
                    skip = false;
                    continue;
                }
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                int src = Integer.parseInt(data[3]);
                int dst = Integer.parseInt(data[4]);

                if (!myMapBigSmall.containsKey(src)) {
                    int sz = myMapBigSmall.size();
                    myMapBigSmall.put(src, sz);
                    myMapSmallBig.put(sz, src);
                    String description = data[5];
                    descriptionMap.put(src, description);
                }
                if (!myMapBigSmall.containsKey(dst)) {
                    int sz = myMapBigSmall.size();
                    myMapBigSmall.put(dst, sz);
                    myMapSmallBig.put(sz, dst);
                    String description = replaceNewLineWithEmpty(data[6]);
                    descriptionMap.put(dst, description);
                }
            }
            br.close();
            AllPathFinding g = new AllPathFinding(myMapBigSmall.size());
            br = new BufferedReader(new FileReader(csvFile));
            skip = true;
            while ((line = br.readLine()) != null) {
                if (skip) {
                    skip = false;
                    continue;
                }
                String[] data = line.split(cvsSplitBy);
                int src = Integer.parseInt(data[3]);
                int dst = Integer.parseInt(data[4]);
                //System.out.println(data[0]+"-"+data[3]);
                g.addEdge(myMapBigSmall.get(src), myMapBigSmall.get(dst));
            }
            return g;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    // Driver program
    public static void main(String[] args) {
        // Create a sample graph
        AllPathFinding g = csvReader();

        // arbitrary source
        int s = myMapBigSmall.get(7038);

        System.out.println("Following are all different paths from " + s);
        g.printAllPaths(s);
//        g.printAllEdges(s);

    }
}

// This code is contributed by Himanshu Shekhar.
