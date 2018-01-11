// 1 use one map
class TwoSum {
    private Map<Integer, Integer> map; // number, times
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    // add 的时候就把元素都加到 map， O（1）
    public void add(int number) {
        //map.getOrDefault(number, map.put(number, 1) + 1);
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }
    
    // 这里只看是否 contain， O（n）
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cur = entry.getKey();
            int target = value - cur;
            // if cur = target = value - cur => value = cur * 2
            if (cur == target) {
                if (entry.getValue() > 1) return true; // 等于一半：出现两次即 true
            } else {
                if (map.containsKey(target)) return true;
            }
        }
        return false;
    }
}

// 2 find O(1)
public class TwoSum {
    Set<Integer> sum;
    Set<Integer> num;
    
    TwoSum(){
        sum = new HashSet<Integer>();
        num = new HashSet<Integer>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        if(num.contains(number)){
            sum.add(number * 2);
        }else{
            Iterator<Integer> iter = num.iterator();
            while(iter.hasNext()){
                sum.add(iter.next() + number);
            }
            num.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        return sum.contains(value);
    }
}