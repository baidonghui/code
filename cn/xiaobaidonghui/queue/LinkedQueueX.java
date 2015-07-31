package cn.xiaobaidonghui.queue;

import cn.xiaobaidonghui.link.FirstLastLinkX;
import cn.xiaobaidonghui.link.NodeX;

public class LinkedQueueX
{
    public FirstLastLinkX mLink;
    
    public LinkedQueueX()
    {
        mLink = new FirstLastLinkX();
    }
    
    public boolean isEmpty()
    {
        return mLink.isEmpty();
    }
    
    public void enque(int key)
    {
        mLink.insertLast(new NodeX(key));
    }
    
    public int deque()
    {
        NodeX first = mLink.removeFirst();
        if(first != null)
        {
            return first.getKey(); 
        }
        else
        {
            return Integer.MIN_VALUE;
        }
    }
    
}
