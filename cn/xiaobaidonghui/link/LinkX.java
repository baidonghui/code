package cn.xiaobaidonghui.link;

/**
 * 单链表，在表头插入与删除节点复杂度为O(1)，查找复杂度O(N)。在其他位置插入和删除因为查找的原因复杂度O(N)。
 * 和数组相比，链表的大小是可变的，数组则是大小固定的。
 * @author baidonghui
 */
public class LinkX
{
    protected NodeX mFirst;

    public boolean isEmpty()
    {
        return (mFirst == null);
    }

    public void insertFirst(NodeX node)
    {
        node.setNext(mFirst);
        mFirst = node;
    }

    public NodeX removeFirst()
    {
        NodeX first = mFirst;
        if (!isEmpty())
        {
            mFirst = mFirst.getNext();
        }
        return first;
    }

    public NodeX find(int key)
    {
        NodeX current = mFirst;
        while (current != null)
        {
            if (current.getKey() == key)
            {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public NodeX insertAfter(int key, NodeX node)
    {
        NodeX current = find(key);
        if (current != null)
        {
            node.setNext(current.getNext());
            current.setNext(node);
            return node;
        }
        return null;
    }

    public NodeX delete(int key)
    {
        if (isEmpty())
        {
            return null;
        }

        NodeX current = mFirst;
        NodeX previous = mFirst;
        while (current != null)
        {
            if (current.getKey() == key)
            {
                break;
            }
            previous = current;
            current = current.getNext();
        }

        previous.setNext(current.getNext());
        return current;
    }

    public void display()
    {
        System.out.println("-------");
        NodeX current = mFirst;
        while (current != null)
        {
            current.display();
            current = current.getNext();
        }
        System.out.println("-------");
    }
}
