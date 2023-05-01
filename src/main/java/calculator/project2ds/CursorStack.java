package calculator.project2ds;

public class CursorStack {
    private final Node[] CURSOR_SPACE;
    private int maxCapacity = 100;

    public CursorStack(){
        CURSOR_SPACE = new Node[maxCapacity];
        for (int i = 0; i < maxCapacity; i++)
            CURSOR_SPACE[i] = new Node(null,i+1);
        CURSOR_SPACE[maxCapacity - 1].next = 0;
    }

    public CursorStack(int newSize){
        maxCapacity = newSize;
        CURSOR_SPACE = new Node[maxCapacity];
        for (int i = 0; i < maxCapacity; i++)
            CURSOR_SPACE[i] = new Node(null,i+1);
        CURSOR_SPACE[maxCapacity - 1].next = 0;
    }

    public int createStack(){
        return allocate();
    }

    private int allocate(){
        int p = CURSOR_SPACE[0].next;
        CURSOR_SPACE[0].next = CURSOR_SPACE[p].next;
        if (p == 0) {
            System.out.println("Out Of Memory");
            System.exit(0);
        }
        CURSOR_SPACE[p].next = 0;
        return p;
    }

    public void push(int stackHead, Object data){
        int current =  CURSOR_SPACE[stackHead].next;
        int prev = stackHead;
        while (current != 0){
            prev = current;
            current = CURSOR_SPACE[current].next;
        }
        int pos = allocate();
        CURSOR_SPACE[pos].data = data;
        CURSOR_SPACE[pos].next = CURSOR_SPACE[prev].next;
        CURSOR_SPACE[prev].next = pos;
    }

    public Object pop(int stackHead){
        int current =  CURSOR_SPACE[stackHead].next;
        int prev = stackHead;
        while (CURSOR_SPACE[current].next != 0){
            prev = current;
            current = CURSOR_SPACE[current].next;
        }
        CURSOR_SPACE[prev].next = 0;
        Object data = CURSOR_SPACE[current].data;
        free(current);
        return data;
    }

    public Object peek(int stackHead) {
        int current =  CURSOR_SPACE[stackHead].next;
        while (CURSOR_SPACE[current].next != 0){
            current = CURSOR_SPACE[current].next;
        }
        return CURSOR_SPACE[current].data;
    }


    private void free(int p){
        CURSOR_SPACE[p].next = CURSOR_SPACE[0].next;
        CURSOR_SPACE[0].next = p;
    }

    public boolean isEmpty(int stackHead){
        return (CURSOR_SPACE[stackHead].next == 0);
    }

}
