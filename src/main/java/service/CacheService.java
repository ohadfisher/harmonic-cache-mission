package service;

import model.Node;
import model.NodeData;

import java.util.HashMap;

public class CacheService {
    private final int MAX_SIZE = 3;
    private HashMap<Integer, Node> nodes = new HashMap<>();
    private Integer headId = null;
    private Integer tailId = null;


    public void add(NodeData insertNodeData) {
        if (!insertNodeData.getId().equals(headId)) {
            if (nodes.isEmpty()) {
                insertFirstElement(insertNodeData);
            } else {
                maintenanceCache(insertNodeData);
            }
        }
    }

    private void insertFirstElement(NodeData insertNodeData) {
        int insertNodeId = insertNodeData.getId();
        nodes.put(insertNodeId, new Node(insertNodeData));
        headId = insertNodeId;
        tailId = headId;
    }

    private void maintenanceCache(NodeData insertNodeData) {
        int insertNodeId = insertNodeData.getId();
        if (nodes.containsKey(insertNodeId)) {
            connectNeighbors(nodes.get(insertNodeId));
        } else if (nodes.size() == MAX_SIZE) {
            removeLastElement();
        }
        //comment Action To All Scenarios
        connectToHeadOfCache(insertNodeData);
    }


    private void connectNeighbors(Node insertNode) {
        //connect Neighbors
        insertNode.getPrev().setNext(insertNode.getNext());
        //if not last element, we will connect the next
        if (insertNode.getNext() != null) {
            insertNode.getNext().setPrev(insertNode.getPrev());
        }

        //the "future" head not have prev
        insertNode.setPrev(null);
    }

    private void removeLastElement() {
        Node temporaryLastElement = nodes.get(tailId);
        tailId = temporaryLastElement.getPrev().getId();
        temporaryLastElement.getPrev().setNext(null);
        nodes.remove(temporaryLastElement.getId());
    }


    private void connectToHeadOfCache(NodeData insertNodeData) {
        int insertNodeId = insertNodeData.getId();


        Node insertNode;
        if (nodes.containsKey(insertNodeId)) {
            insertNode = nodes.get(insertNodeId);
        } else {
            insertNode = new Node(insertNodeData);
            nodes.put(insertNodeId, insertNode);
        }

        Node temporaryHead = nodes.get(headId);
        //connect new head to previous head
        insertNode.setNext(temporaryHead);
        temporaryHead.setPrev(insertNode);

        headId = insertNodeId;


    }

    public void printCache(String expectingOrder) {
        Node node = nodes.get(headId);
        System.out.println(expectingOrder + "-------Start---------");
        while (node != null) {
            System.out.println(node);
            node = node.getNext();
        }
        System.out.println("-------End---------\n");

    }


}
