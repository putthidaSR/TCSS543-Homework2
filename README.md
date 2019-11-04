# TCSS543 - Advanced Algorithms
# Fall 2019

## Homework2 - Problem #4

Assume 𝐴 and 𝐵 are two sequences (arrays) of integers.

(a) Implement (in Java) Myers’ 𝑂(𝑁𝐷) algorithm to compute the edit distance between 𝐴 and 𝐵. 
(b) Implement (in Java) the Wu-Manber-Myers-Miller 𝑂(𝑁𝑃) algorithm for the same problem. 
(c) Generate 8 pairs of random sequences 𝐴 and 𝐵, of lengths 𝑀 = 4000 and 𝑁 = 5000 elements respectively, with 𝐷 = 10, 50, 100, 200, 400, 600, 800, and 1000 randomly located deletions and 𝑁 − 𝑀 + 𝐷 insertions between them. Apply both algorithms above, then tally and report how many comparisons each algorithm performs between an element from 𝐴 and an element from 𝐵.


References:
- E. Myers, “An O(ND) difference algorithm and its variations”, Algorithmica vol. 1, pp. 251-266, Springer, 1986.
- S. Wu, U, Manber, E. Myers, W. Miller, “An O(NP) sequence comparison algorithm”, Information Processing Letters vol. 35, pp. 317-323, Springer, 1990.
