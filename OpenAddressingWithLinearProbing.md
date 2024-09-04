# Open Addressing with Linear Probing

## Overview
Open Addressing with Linear Probing is a collision resolution technique used in hash tables. When two keys hash to the same index, instead of placing the second key in the same spot (which would cause a collision), the algorithm finds the next available spot in the table to place the key.

## How It Works

### Hash Function
A hash function computes the index for a given key. For example, if the hash function returns an index of 3, the key is placed in the 3rd slot of the hash table.

### Collision Occurrence
If two keys hash to the same index, a collision occurs. For example, if both `key1` and `key2` hash to index 3, we have a collision.

### Linear Probing
In linear probing, when a collision occurs, the algorithm searches for the next available slot by incrementing the index sequentially until an empty slot is found.

- If the hash table size is `m`, and the current index is `i`, then linear probing checks the indices `(i+1) % m`, `(i+2) % m`, and so on until an empty slot is found.

#### Example:
- Suppose we have a hash table of size 10.
- If `key1` hashes to index 3 and `key2` also hashes to index 3:
  - `key1` is placed at index 3.
  - When inserting `key2`, index 3 is already occupied, so linear probing moves to index 4.
  - If index 4 is free, `key2` is placed there.

## Advantages
- **Simplicity**: Linear probing is easy to implement and understand.
- **Cache Performance**: Linear probing tends to be more cache-friendly because it often accesses consecutive memory locations.

## Disadvantages
- **Primary Clustering**: One of the main issues with linear probing is primary clustering, where a group of consecutive filled slots forms, leading to longer probe sequences and increased search time. This occurs because once a collision starts, subsequent elements are more likely to also collide, forming a "cluster" of occupied slots.
- **Degraded Performance at High Load Factors**: As the load factor (the ratio of occupied slots to the total number of slots) increases, the probability of collisions increases, leading to longer probe sequences and slower operations.

## Load Factor
The load factor is the ratio of the number of occupied slots to the total number of slots in the hash table.

- Linear probing performs well with load factors up to around 0.75. Beyond this, the chances of collisions increase significantly, leading to performance degradation.

## Rehashing
When the hash table becomes too full (high load factor), rehashing is performed. This involves creating a new, larger hash table and reinserting all the existing keys into the new table. Rehashing helps reduce the load factor and improve performance.

## Summary
In open addressing with linear probing, collisions are resolved by searching for the next available slot in a linear manner. While this approach is straightforward and efficient in low-load situations, it can suffer from clustering and performance issues as the table becomes more crowded. Rehashing and careful management of the load factor can help mitigate these issues.
