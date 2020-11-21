public class Main {
    public static void main(String[] args) {
        int[] persons;
        int[] times;

        persons = new int[]{0, 1, 1, 0, 0, 1, 0};
        times = new int[]{0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate tvc = new TopVotedCandidate(persons, times);
        for (int t : new int[]{3, 12, 25, 15, 24, 8}) {
            System.out.println(tvc.q(t));
        }
    }
}

class TopVotedCandidate {
    private int[] winning;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.winning = new int[persons.length];
        int[] candidates = new int[5000];
        int winningVoteCount = 0;
        for (int i = 0; i < times.length; i++) {
            int p = persons[i];
            candidates[p]++;
            if (winningVoteCount <= candidates[p]) {
                winningVoteCount = candidates[p];
                winning[i] = p;
            } else winning[i] = winning[i - 1];
        }
    }

    public int q(int t) {
        int l = 0, r = winning.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (times[m] == t) {
                return winning[m];
            }
            if (times[m] < t) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return winning[l - 1];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */