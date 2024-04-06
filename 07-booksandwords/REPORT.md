1. What is your hash function like for hash table solution (if you implemented hash table).
    1. Calculation method
>     Use "prime modulo" to calculate hash values. The calculation method is to loop through  each    character of a word, multiply the hash value by a prime number of "31", and then add the "ASCII"      value of the character.
    2.Resolve hash conflicts
        >Use linear detection to handle hash conflicts. After calculating the hash value, if the position in the hash table is already occupied, linear search will continue until a blank position is found to insert.

1. For binary search trees (if you implemented it), how does your implementation get the top-100 list?

    > 1.If the current node is null, immediately return the current index;
    > 1. Recursively traverse the left subtree and update the index with the returned value;
    > 1. Add the current node to the array and update the index;
    > 1. Recursively traverse the right subtree and update the index with the return value.

1. What can you say about the **correctness** of your implementation? Any issues, bugs or problems you couldn't solve? Any idea why the problem persists and what could perhaps be the solution?

    >  The code has been debugged and modified multiple times, and now there are no obvious bugs. But if you need to process a large number of files or contain a lot of words at the same time, there may be performance issues.

1. What can you say about the **time complexity** of your implementation? How efficient is the code in reading and managing the words and their counts? How efficient is your code in getting the top-100 list? Which sorting algorithm are you using? What is the time complexity of that algorithm?

   - Time complexity
     - BST 
       > The time complexity of the insertion operation depends on the balance of the tree, in the worst-case scenario it is' O (log n) ', where' n 'is the number of nodes. The time complexity of the traversal operation (traversing in order, calculating the number of word occurrences) is also 'O (n)', where 'n' is the number of nodes.
     - HASH: 
       > The average time complexity of insertion is O (1), but it can reach O (n) when conflicts occur. Using the 'heap sorting' algorithm, the time complexity is O (nlogn)`.

   - Efficiency in reading and managing word count and counting
     - BST
       > By utilizing the characteristics of binary search trees, words and counts can be effectively managed.
     - HASH
       > Due to the constant time complexity of hash table insertion under average conditions, words and their counts can be effectively managed.

   - Efficiency in obtaining the top 100 list
     - BST
       > Efficiency depends on the size and balance of the tree, and is generally quite effective.
     - HASH
       > The efficiency depends on the sorting algorithm used, and due to the use of heap sorting, its time complexity is O (nlogn), which is acceptable for medium-sized datasets.


   - Sorting algorithm and time complexity 
     > Both implementations use the 'heap sorting' algorithm for sorting, with a time complexity of 'O (nlogn)', where 'n' is the number of nodes.
     
1. What did you find the **most difficult things** to understand and implement in this programming task? Why?
    > One of the most challenging aspects is optimizing the performance of hash tables and effectively processing large amounts of data. This involves understanding hash functions, handling hash conflicts, and dynamically adjusting the size of hash tables. In addition, implementing and understanding heap sorting algorithms is also a challenge.

1. What did you learn doing this?
    > Through this learning experience, I have learned how to use hash tables to calculate the number of occurrences of words, and gained a deeper understanding of hash functions, hash conflict handling, sorting algorithms and their implementation, as well as calculating the maximum depth of binary trees. At the same time, I have deepened my understanding and experience in code optimization and performance tuning.
