public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int badVersion;
        int n;

        n = 5;
        badVersion = 4;
        solution.setBadVersion(badVersion);
        System.out.println(solution.firstBadVersion(n));


    }
}
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl {

    int badVersion;

    public void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public boolean isBadVersion(int version) {
        return this.badVersion <= version;
    }
}

class Solution extends VersionControl {

    public int firstBadVersion(int n) {

        int l = 1, r = n;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        if (l <= n && isBadVersion(l)) {
            return l;
        }

        /* 题目并未给出错误版本号不在 [1,n] 时的缺省返回值 姑且用 -1 表示 */
        return -1;
    }
}