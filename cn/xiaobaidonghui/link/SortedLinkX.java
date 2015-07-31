package cn.xiaobaidonghui.link;

public class SortedLinkX
{
    NodeX mFirst;
    
    public SortedLinkX()
    {
        mFirst = null;
    }
    
    public void insert(NodeX node)
    {
        NodeX current = mFirst;
        NodeX parent = null;
        while(current != null && current.getKey() < node.getKey())
        {
            parent = current;
            current = current.getNext();
        }
        
        if(parent == null)
        {
            node.setNext(mFirst);
            mFirst=node;
        }
        else
        {
            parent.setNext(node);
            node.setNext(current);
        }
    }

    public NodeX remove()
    {
        NodeX first = mFirst;
        mFirst = mFirst.getNext();
        return first;
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
