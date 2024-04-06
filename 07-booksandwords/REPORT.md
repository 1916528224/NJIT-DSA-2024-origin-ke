1. What is your hash function like for hash table solution (if you implemented hash table).
    1. 计算方法 
        >使用`素数取模`来计算哈希值。计算方法为循环单词的每个字符，将哈希值乘以一个素数`31`，然后再加上字符的`ASCII`值。
    1. 解决哈希冲突
        >使用`线性探测法`来处理哈希冲突。计算出哈希值后，如果哈希表中的位置已被占用，会继续执行线性查找，直到找到一个空白位置来插入。

1. For binary search trees (if you implemented it), how does your implementation get the top-100 list?

    > 1. 如果当前节点为 null，则立即返回当前索引；
    > 1. 递归遍历左侧子树，并使用返回的值更新索引；
    > 1. 将当前节点添加到数组并更新索引；
    > 1. 递归遍历右子树并使用返回值更新索引。

1. What can you say about the **correctness** of your implementation? Any issues, bugs or problems you couldn't solve? Any idea why the problem persists and what could perhaps be the solution?

    > 代码经过多次调试并修改，现在已经没有明显的Bug。但是如果需要同时处理大量的文件或包含的单词非常多的时候，可能存在性能问题。

1. What can you say about the **time complexity** of your implementation? How efficient is the code in reading and managing the words and their counts? How efficient is your code in getting the top-100 list? Which sorting algorithm are you using? What is the time complexity of that algorithm?

   - 时间复杂度
     - BST 
       > 插入操作的时间复杂度取决于树的平衡，在最坏的情况下为`O(log n)`，其中`n`是节点数。遍历操作(按顺序遍历、计算单词出现次数)的时间复杂度也为`O(n)`，其中`n`是节点数。
     - HASH: 
       > 插入的平均情况时间复杂度为`O(1)`，但在发生冲突时可以达到`O(n)`。使用`堆排序`算法，所以时间复杂度为`O(nlogn)`。

   - 读取和管理字数和计数的效率
     - BST
       > 利用二叉搜索树的特性，可以有效的管理单词和计数。
     - HASH
       > 由于在平均情况下哈希表插入的时间复杂度是恒定的，因此可以有效的管理单词及其计数。

   - 得前 100 名列表方面的效率
     - BST
       > 效率取决于树的大小和平衡，一般情况下都是相当有效的。
     - HASH
       > 效率取决于所使用的排序算法，由于使用堆排序，其时间复杂度为 `O(nlogn)`，因此对于中等大小的数据集来说是可以接受的。

   - 使用的排序算法和时间复杂度
     > 两个实现都使用了`堆排序`算法进行排序，时间复杂度为 `O(nlogn)`，其中`n`是节点数。
     
1. What did you find the **most difficult things** to understand and implement in this programming task? Why?
    > 最具挑战性的方面之一是优化哈希表的性能并有效地处理大批量的数据。这涉及理解哈希函数、处理哈希冲突、动态调整哈希表大小等。 此外，实现和理解堆排序算法也是一个挑战。

1. What did you learn doing this?
    > 通过这次学习，我学会了如何使用哈希表来计算单词出现次数，并且深入了解了哈希函数、哈希冲突处理、排序算法及其实现，还有计算二叉树的最大深度。同时我还加深了对代码优化和性能调优的理解和经验。

