---
layout: "post"
title: "Quick-union"
date: "2017-12-08 14:29"
---

### Quick-union
##### Data structure.
* Integer array id[] of length N.
* Interpretation: id[i] is parent of i.
* [Root of i is id[id[id[...id[i]...]]].][00124f2b]

    i    | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
    -----|---|---|---|---|---|---|---|---|---|--
    id[] | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    [00124f2b]: this "keep going until it doesn't change(algorithm ensures no cycles)"

    ![root of 3 is 9](../images/2017/12/root-of-3-is-9.png)
---
### Data structure.
* Integer array id[] of length N.
* Interpretation: id[i] is parent of i.
* [Root of i is id[id[id{...id[i]...}]].][00124f2b]

    i    | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
    -----|---|---|---|---|---|---|---|---|---|---|
    id[] | 0 | 1 | 9 | 4 | 9 | 6 | 6 | 7 | 8 | 9 |

Find. check if p and q have the same root.

![Check if p and q have the same root](../images/2017/12/check-if-p-and-q-have-the-same-root.png)

Union. To merge components containing p and q,
    set the id of p's root to the id of q's root.

    i    | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
    -----|---|---|---|---|---|---|---|---|---|---|
    id[] | 0 | 1 | 9 | 4 | 9 | 6 | 6 | 7 | 8 | 6 **<- only one value changes** |


![set p's root to q's root](../images/2017/12/set-p-s-root-to-q-s-root.png)
