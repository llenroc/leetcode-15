import java.util.ArrayList;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    
    private List<Interval> intervals, other;
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.intervals = new ArrayList<Interval>();
        this.other = new ArrayList<Interval>();
    }
    
    public void addNum(int val) {
        Interval curr = new Interval(val, val);
        int where = 0;
        List<Interval> temp = this.other;
        
        for (Interval i : this.intervals) {
            if (i.end < curr.start - 1) {
                temp.add(i);
                ++where;
            } else if (i.start > curr.end + 1)
                temp.add(i);
            else {
                curr.start = Math.min(curr.start, i.start);
                curr.end = Math.max(curr.end, i.end);
            }
        }
        
        temp.add(where, curr);
        this.intervals.clear();
        this.other = this.intervals;
        this.intervals = temp;
    }
    
    public List<Interval> getIntervals() {
        return this.intervals;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
 