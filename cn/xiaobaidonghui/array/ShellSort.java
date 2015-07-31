package cn.xiaobaidonghui.array;

/**
 * 希尔排序（将增量应用到插入排序，然后逐渐缩小增量）
 * 先进行n增量排序，使间隔为n的数据项有序（优势在于每个元素的最大误差减小了，如果n=4，则每个元素的误差不到两个单元，也叫“基本有序”），
 * 然后逐步缩小间隔（增量），当n=1时，即为插入排序。
 * @author baidonghui
 */
public class ShellSort
{
    public static void sort(int[] array)
    {
        int n = array.length;
        int h = 1;
        while (h <= n)
        {
            h = 3 * h + 1;
        }

        while (h >= 1)
        {
            sort(array, h);
            h = (h - 1) / 3;
        }

    }

    private static void sort(int[] array, int h)
    {
        int n = array.length;
        for (int i = h; i < n; i++)
        {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - h] > temp)
            {
                array[j] = array[j - h];
                j = j - h;
            }
            array[j] = temp;
        }
    }
}
