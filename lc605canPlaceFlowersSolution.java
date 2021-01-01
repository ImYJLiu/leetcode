605. 种花问题
假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

示例 1:

输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
示例 2:

输入: flowerbed = [1,0,0,0,1], n = 2
输出: False

----------------------------------------
answer:
防御式编程思想：在 flowerbed 数组两端各增加一个 0， 这样处理的好处在于不用考虑边界条件，任意位置处只要连续出现三个 0 就可以栽上一棵花。

public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 任意位置出现连续的3个0就可以种一朵花
        int[] ints = new int[flowerbed.length + 2];
        ints[0] = 0; int intsID = 1;
        for (int f : flowerbed) {
            ints[intsID] = f;
            intsID++;
        }
        for (int i = 1; i < ints.length - 1; i++) {
            if (ints[i] == 0 && ints[i-1] == 0 && ints[i+1] == 0){
                n--;
                ints[i] = 1;
            }
        }
        return n <= 0;

    }
