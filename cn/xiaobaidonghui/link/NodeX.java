package cn.xiaobaidonghui.link;

public class NodeX
{
    private int mKey;
    private NodeX mNext;
    
    public NodeX(int key)
    {
        mKey = key;
        mNext = null;
    }

    public int getKey()
    {
        return mKey;
    }

    public void setKey(int mKey)
    {
        this.mKey = mKey;
    }

    public NodeX getNext()
    {
        return mNext;
    }

    public void setNext(NodeX mNext)
    {
        this.mNext = mNext;
    }
    
    public void display()
    {
        System.out.print(this);
        System.out.println(" " + getKey() + ";");
    }
}
