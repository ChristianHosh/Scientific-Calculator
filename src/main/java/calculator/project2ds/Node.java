package calculator.project2ds;

public class Node {
    Object data;
    int next;

    public Node(Object d, int l)
    {
        data = d;
        next = l;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return this.data == o;
    }
}

