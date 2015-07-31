package cn.xiaobaidonghui.array;

/**
 * 这里包含了三种最基本的排序方法。
 * <p>冒泡排序 {@link #bubbleSort(int[])} </p>
 * <p>选择排序 {@link #selectSort(int[])} </p>
 * <p>插入排序 {@link #insertSort(int[])} </p>
 * <p>这三种排序的复杂度都为O(N^2)。</p>
 * <p>选择排序与冒泡排序相比，将交换的次数由O(N^2)减小到O(N)；对于基本有序的数组而言，插入排序则会更加高效。</p>
 * @author baidonghui
 */
public class BaseSortX
{
    /**
     * 冒泡排序开始 （升序）
     * 两两比较选取较大值，当某次外循环结束后，处于数组右侧的元素都是绝对有序的(不变性)，因此下一次循环中无需参与比较。
     * @param array 设置要排序的数组
     */
    public static void bubbleSort(int[] array)
    {
        int n = array.length;
        for (int i = n - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (array[j] > array[j + 1])    //双层循环嵌套，此处比较复杂度O(n^2)
                {
                    swap(array, j, j + 1);  //双层循环嵌套，此处交换复杂度O(n^2)
                }
            }
        }
    }
    
    /**
     * 选择排序（升序）
     * 每次外循环选取出无序部分的最小值，与无序部分的第一个元素做交换
     * 因此当某次循环结束后，处于数组左侧的元素都是绝对有序的(不变性)，因此下一次中无需参与比较
     * 选择排序是不稳定的，可以观察{ 3,1,5,8,6,5,2}中两个5排序前后的顺序。
     * @param array 设置要排序的数组
     */
    public static void selectSort(int[] array)
    {   
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
        {
            int min = i; //min表示未排序数组中最小元素的下标
            for (int j = i + 1; j < n; j++)
            {
                if (array[j] < array[min])  //双层循环嵌套，此处比较复杂度O(n^2)
                {
                    min = j;
                }
            }
            swap(array, min, i);    //单层循环，此处比较复杂度O(n)
        }
    }

    /**
     * 插入排序（升序）
     * 数组的左边是局部有序的，即这部分是有序的，但绝对位置不是不变的。(不变性)
     * 每次外循环执行时，取出未排序部分的第一个元素，
     * 依次和局部有序的元素从右至左进行比较，直至找到合适的位置插入进去。
     * @param array 设置要排序的数组
     */
    public static void insertSort(int[] array)
    {
        int n = array.length;
        for(int i = 1;i<n;i++)
        {
           int temp = array[i];
           int j = i;
           while(j > 0 && array[j] > temp)
           {
               array[j]= array[j-1];    //双层循环嵌套，此处复制复杂度O(n^2)
               j--;
           }
           array[j] = temp; //单层循环，此处复制复杂度O(n)
        }
    }  
    
    /**
     * 数组内元素的交换
     * @param array 设置要交换数组的数组
     * @param i 第一个索引
     * @param j 第二个索引
     */
    private static void swap(int[] array, int i, int j)
    {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
