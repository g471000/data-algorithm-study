package ch_04_tree_graph.q03_depth_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
        DepthList dl = new DepthList();

        dl.add(4);
        dl.add(2);
        dl.add(1);
        dl.add(3);
        dl.add(6);
        dl.add(5);
        dl.add(7);
        System.out.println(dl);
        ArrayList<LinkedList<DepthList.Node>> lists = dl.createLinkedList();
        System.out.println(dl.printLinkedList());
    }
}
