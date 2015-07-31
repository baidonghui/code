package cn.xiaobaidonghui.array;

/**
 * ������������ֻ���������������
 * 
 * <h3>��Ҫ����</h3>
 * <p>������������ �㷨���Ӷ�O(N) see {@link #normalSearch(int[], int)} </p>
 * <p>���ַ��������� �㷨���Ӷ�O(logN) see {@link #binarySearch(int[], int)} </p>
 * <p>�ݹ�Ķ��ַ��������� �㷨���Ӷ�O(logN) see {@link #binarySearch(int[], int, int, int)} </p>
 * @author baidonghui
 */
public class SeachX
{
    /**
     * ����������������� ȫ������ ���Ӷ�O(n)
     */
    public static int normalSearch(int[] array, int key)
    {
        int n = array.length;
        for(int i  = 0; i< n; i++)
        {
            if(array[i] == key)
            {
                return i;
            }
        }
        return -1;
    }
    
    
    /**
    * ��������Ķ��ֲ��Ҳ��� ÿ�γ���/2 ���Ӷ�O(logn)
    */
    public static int binarySearch(int[] array, int key)
    {
        int n = array.length;
        int lBound = 0;
        int hBound = n - 1;
        while(lBound <= hBound)
        {
            int mid = (lBound + hBound)/2;
            if(array[mid] == key)
            {
                return mid;
            }
            else if(array[mid] > key)
            {
                hBound = mid - 1;
            }
            else
            {
                lBound = mid +1;
            }
        }
        return -1;
    }
    
    /**
    * ��������ĵݹ鷨���ֲ��Ҳ��� ÿ�γ���/2 ���Ӷ�O(logn)���������ָ����Χ����keyֵ����������������ʱlBound == 1,hBound == array.length - 1
    */
    public static int binarySearch(int[] array, int lBound, int hBound, int key)
    {
        if(lBound > hBound)
            return -1;
        
        int mid = (lBound + hBound)/2;
        if(array[mid] == key)
        {
            return mid;
        }
        else if(array[mid] > key)
        {
            return binarySearch(array, lBound, mid - 1, key);
        }
        else
        {
            return binarySearch(array, mid + 1, hBound, key);
        }
    }
}

