
[11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

![](https://img-bed-1307643120.cos.ap-shanghai.myqcloud.com/img/202201131115046.png)

**证明：**

对于双指针 $i$ 和 $j$ ， 其中 $j > i$，两条线的区域面积为：

$$area = (j - i) * min(h[i], h[j])$$

当 $h[i] > h[j]$ 时，有 $min(max(h[i + 1], h[i + 2], ...,h[j -1]), h[j]) \le h[j]$ ,即 $[i + 1, j - 1]$ 中任意一条线与 $j$ 所围成的区域均小于 $i$ 和 $j$ 所围成的区域。故最大值只可能在 $i$ 和 $[i+1,j-1]$ 所围成的区域中产生。反之亦然。