---
layout: "post"
title: "QuickFind"
date: "2017-11-21 13:44"
---

### Quick-find [eager approach]
Data structure
* Integer array id[] of length N.
* Interpretation: p and q are connected [iff][bb2bd808] they have the same id.

    ![iff they have the same id](../images/2017/11/iff-they-have-the-same-id.png)

  [bb2bd808]: http://fanyi.baidu.com/?aldtype=85#en/zh/iff "if and only if"
---
  ### Quick-find [eager approach]
  ##### Data structure
  * Integer array id[] of length N.
  * Interpretation: p and q are connected [iff][bb2bd808] they have the same id.

  ![interpretation](../images/2017/11/interpretation.png)

  ##### Find. Check if p and q have the same id.
    id[6] = 0; id[1] = 1 <br/>
    6 and 1 are not connected

  ##### Union. To merge components containing p and q, change all <br/> entries whose id equals id[p] to id[q].

![after union of 6 and 1.png](../images/2017/11/after-union-of-6-and-1.png "after union of 6 and 1.png")

### Quick-find: Java implementation

```
public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        // set id of each object to itself(N array accesses)
        for (int i = 0; i < N; i ++)
            id[i] = i;
    }
    // check whether p and q are in the same component(2 array accesses)
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        // change all entries with id[p] to id[q](at most 2N+2 array accesses)
        for (int i = 0; i < id.length; i ++)
            if (id[i] == pid) id[i] = qid;
    }

}
```

---
### Quick-find is too slow
##### Cost model. Number of array accesses(for read or write).

algorithm  | initialize | union | find
-----------|------------|-------|-----
quick-find | N          | N     | 1
##### order of growth of number of array accesses

Union is to expensive. It takes [n<sup>2</sup>][b9431c11] array accesses to process a sequence of
**_N_** union commands on _**N**_ objects.

  [b9431c11]: http://dict.youdao.com/w/eng/quadratic "quadratic"

---
### Quadratic algorithms do not scale

##### Rough standard (for now).
* 10<sup>9</sup> operation per second.
* 10<sup>9</sup> words of main memory.
* Touch all words in [approximately](this "a truism roughly since 1950!") 1 second.

##### Ex. Huge problem for quick-find.
* 10<sup>9</sup> union commands on 10<sup>9</sup> objects.
* Quick-find takes more than 10<sup>18</sup> operations.
* 30+ years of computer time!

##### Quadratic algorithms don't scale with technology.
* New computer may be 10X as fast.
* But, has 10X as much money => <br/>
  want to solve a problem that is 10X as big.
* With quadratic algorithm, takes 10X as long!
![coordinate](../images/2017/12/coordinate.png)
