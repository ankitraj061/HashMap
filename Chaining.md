# HashMap with Chaining

## Overview
Chaining is a collision resolution technique used in hash tables like `HashMap`. When two or more keys hash to the same index, the keys are stored in a linked list (or another collection) at that index. This allows multiple keys to occupy the same slot in the hash table without overwriting each other.

## How It Works

### Hash Function
A hash function computes the index for a given key. For example, if the hash function returns an index of 4, the key is placed in the 4th slot of the hash table.

### Collision Occurrence
If two keys hash to the same index, a collision occurs. For example, if both `key1` and `key2` hash to index 4, a collision is detected.

### Chaining
In chaining, when a collision occurs, the colliding keys are stored in a linked list at the same index.

- **Linked List at Index**: If `key1` and `key2` both hash to index 4:
  - `key1` is placed in a linked list at index 4.
  - When inserting `key2`, the algorithm detects the collision and appends `key2` to the linked list at index 4.
  - Now, both `key1` and `key2` are stored in the same slot but within a linked list.

### Example
- Suppose we have a hash table of size 10.
- If `key1` hashes to index 4 and `key2` also hashes to index 4:
  - `key1` is placed in a linked list at index 4.
  - When `key2` is inserted, it’s added to the linked list at index 4.
  - The table at index 4 now points to a linked list containing both `key1` and `key2`.

## Advantages
- **No Primary Clustering**: Unlike linear probing, chaining avoids the issue of primary clustering since each index in the hash table maintains its own separate chain (linked list) of elements.
- **Dynamic Size**: The linked list (or other collection) can grow dynamically as more keys collide at the same index.

## Disadvantages
- **Memory Overhead**: Chaining can result in more memory usage since each element in a chain typically requires additional pointers (e.g., for linked lists).
- **Potentially Slower Lookups**: If a hash table becomes highly loaded (i.e., many elements are hashed to the same index), the linked list at that index can become long, leading to slower lookups.

## Load Factor and Rehashing
- **Load Factor**: Similar to other hash table implementations, the load factor is the ratio of the number of entries to the total number of slots in the hash table.
- **Rehashing**: If the load factor becomes too high, rehashing may be necessary. Rehashing involves creating a new, larger hash table and reinserting all the existing keys into the new table.

## Summary
HashMap with chaining resolves collisions by storing multiple keys that hash to the same index in a linked list. This approach avoids the primary clustering issue seen with linear probing but may involve more memory overhead and slower lookups in cases of high collision rates.
