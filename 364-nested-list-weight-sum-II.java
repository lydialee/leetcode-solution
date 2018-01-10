// solution 1: iterate
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int LevelSum = 0, sum = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger n : nestedList) {
                if (n.isInteger())
                    LevelSum += n.getInteger();
                else
                    nextLevel.addAll(n.getList());
            }
            sum += LevelSum;
            nestedList = nextLevel;
        }
        return sum;
    }
}