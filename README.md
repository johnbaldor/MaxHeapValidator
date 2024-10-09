MaxHeapValidator Program
This program verifies the validity of add and remove operations in a binary tree that respects the max heap invariant. It checks if a tree is a valid max heap before and after adding or removing elements, ensuring that all max heap properties are maintained.

To run the program, run the command:

java MaxHeapValidator


Features
MaxHeapValidator: Validates that binary trees maintain the max heap property during add/remove operations.
BinaryTree: Represents a mutable binary tree structure with methods like addInt() and removeInt().
BTStrategy Interface: Allows for different strategies to manage binary tree operations.
Recursive Validation: Uses recursive methods to ensure that all subtrees respect max heap properties.
