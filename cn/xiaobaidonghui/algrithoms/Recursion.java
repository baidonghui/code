package cn.xiaobaidonghui.algrithoms;

/**
 * 
 * @author baidonghui
 *
 */
public class Recursion
{
    /**
     * 返回三角数字，要求num为正整数
     */
    public static int triangle(int num)
    {
        if(num == 1)
        {
            return 1;
        }
        else if(num > 1)
        {
            return triangle(num - 1) + num;
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * 返回num的阶乘，要求num是非负的整数
     */
    public static int factorial(int num)
    {
        if(num == 0)
        {
            return 1;
        }
        else if(num > 0)
        {
            return factorial(num - 1) * num;
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * 汉诺塔问题
     */
    public static void hanoi(int topN, char from, char inter, char to)
    {
        if(topN == 1)
        {
            System.out.print(topN + " " + from + "->" + to);
        }
        else
        {
            hanoi(topN-1, from, to ,inter);
            System.out.print(topN + " " + from + "->" + to);        
            hanoi(topN-1, inter, from ,to);
        }
    }
}
