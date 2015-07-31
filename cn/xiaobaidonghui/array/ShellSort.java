package cn.xiaobaidonghui.array;

/**
 * ϣ�����򣨽�����Ӧ�õ���������Ȼ������С������
 * �Ƚ���n��������ʹ���Ϊn��������������������ÿ��Ԫ�ص��������С�ˣ����n=4����ÿ��Ԫ�ص�����������Ԫ��Ҳ�С��������򡱣���
 * Ȼ������С���������������n=1ʱ����Ϊ��������
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
