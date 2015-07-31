package cn.xiaobaidonghui.array;

/**
 * 这里包含了三种基本的搜索方法。
 * 
 * <h3>主要操作</h3>
 * <p>常规搜索操作 算法复杂度O(N) see {@link #normalSearch(int[], int)} </p>
 * <p>二分法搜索操作 算法复杂度O(logN) see {@link #binarySearch(int[], int)} </p>
 * <p>递归的二分法搜索操作 算法复杂度O(logN) see {@link #binarySearch(int[], int, int, int)} </p>
 * @author baidonghui
 */
public class SeachX
{
    /**
     * 正常数组的搜索操作 全部遍历 复杂度O(n)
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
    * 有序数组的二分查找操作 每次长度/2 复杂度O(logn)
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
    * 有序数组的递归法二分查找操作 每次长度/2 复杂度O(logn)，从数组的指定范围搜索key值，从整个数组搜索时lBound == 1,hBound == array.length - 1
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

