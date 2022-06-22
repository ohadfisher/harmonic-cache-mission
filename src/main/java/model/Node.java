package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Node {

    private Integer id;
    private Node prev;
    private Node next;
    private int value;

    public Node(NodeData nodeData) {
        this.id = nodeData.getId();
        this.value = nodeData.getValue();
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
