package cn.xiaobaidonghui.link;

public class FirstLastLinkX extends LinkX
{
    private NodeX mLast;
    
    @Override
    public void insertFirst(NodeX node)
    {
        super.insertFirst(node);
        if(mLast == null)
        {
            mLast = node;
        }
    }
    
    @Override
    public NodeX removeFirst()
    {   
        NodeX first = super.removeFirst();
        if(mFirst == null)
        {
            mLast = null;
        }
        return first;
    }
    
    public void insertLast(NodeX node)
    {
        if(isEmpty())
        {
            insertFirst(node);
        }
        else
        {
            mLast.setNext(node);
            mLast = node;
        }
    }
    
    @Override
    public NodeX find(int key)
    {
        return super.find(key);
    }
    
    @Override
    public NodeX insertAfter(int key, NodeX node)
    {
        if(!isEmpty() && find(key) == mLast)
        {
            mLast = node;
        }
        
        return super.insertAfter(key, node);
    }
    
    @Override
    public NodeX delete(int key)
    {
//        if(super.delete(key) == mLast)
//        {
//            //此时mLast指向前一个
//        }
        return null;
    }
}
