#DSA #Set

### What is Disjoint Sets?
**A pair of sets which does not have any common element** are called disjoint sets. For example, set A={2,3} and set B={4,5} are disjoint sets. But set C={3,4,5} and {3,6,7} are not disjoint as both the sets C and D are having 3 as a common element.

### Equivalence Relations
If a R b is true, then we say a is related to b, otherwise a is not related to b. A relation R is called an equivalence relation if it satisfies the following properties: 
-  **Reflexive**: For every element a ∈ S, a R a is true.
-  **Symmetric**: For any two elements a, b ∈ S, if a R b is true then b R a is true. 
-  **Transitive**: For any three elements a, b, c ∈ S, if a R b and b R c are true then a R c is true.

Similarly, rail connectivity is an equivalence relation. This relation is reflexive because any location is connected to itself. If there is connectivity from city a to city b, then city b also has connectivity to city a, so the relation is symmetric. Finally, if city a is connected to city b and city b is connected to city c, then city a is also connected to city c.

### Equivalence Classes

The **equivalence class** of an element *a ∈ S* is a subset of S that contains all the elements that are related to a. Equivalence classes create a partition of S. Every member of S appears in exactly one equivalence class. To decide if a R b, we just need to check whether a and b are in the same equivalence class (group) or not. In the above example, two cities will be in same equivalence class if they have rail connectivity. If they do not have connectivity then they will be part of different equivalence classes.

Since the intersection of any two equivalence classes is empty (ϕ), *the equivalence classes are sometimes called **disjoint sets**.*

### When to use Disjoint Set?
Whenever we have been given a problem that contains **n** elements represented as separate sets initially and we need to the perform following operations:

-   *Combine two sets.*
-   *Find the connectivity of two given elements i.e. whether they belong to the same set or not.*

Then it is advisable to use Disjoint-Set data structure to pose an efficient solution. Disjoint Set Union is sometimes also referred to as Union-Find.

## Applications of Disjoint Set
-   It is used to find Cycle in a graph as in Kruskal's algorithm, DSUs are used.
-   Checking for connected components in a graph.
-   Searching for connected components in an image.

https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/
