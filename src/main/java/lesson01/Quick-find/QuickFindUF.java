
public class QuickFindUF {

    private int[] id;

    // set id of each object to itself(N array accesses)
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i ++) {
            id[i] = i;
        }
    }

    // check wheter p and q are in the same component(2 array accesses)
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // change all entries with id[p] to id[q](at most 2N + 2 array accesses)
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i ++ ) {
            /**
             * id[i] equals the entry of id[p],
             * set id[i] equals the entry of q namely qid.
             * add by rayhong
             */
            if (id[i] == pid) id[i] = qid;
        }
    }

    public static void main(String[] args) {
        QuickFindUF qfUF = new QuickFindUF(10);
        qfUF.union(0, 1);
    }

}
