public class LinkedList<E> {
    /**
     * 节点内部类
     */
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
    //虚拟头结点
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize(){
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //向链表头添加新的元素e
    public void addFirst(E e){
        add(0,e);
    }

    //在链表中间添加新的元素e
    public void add(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("add failed.Illegal index");
        }
        //访问当前节点的前一个节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e,prev.next);

        size++;
    }

    //向链表末尾添加新元素
    public void addLast(E e){
        add(size,e);
    }

    //获得链表的第index元素的操作
    public E get(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("GET failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast(){
        return get(size-1);
    }

    //修改链表第index的元素为e
    public void set(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Set failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e == e){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除链表中第index个结点,返回删除的元素
    public E remove(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Delete failed.Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    //删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
