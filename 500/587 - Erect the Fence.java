import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public List<Point> outerTrees(Point[] points) {
        Point base, curr;
        List<Point> stack = new ArrayList<Point>(), pts = new ArrayList<Point>();
        int x, i;
        
        if (points.length <= 3)
            return Arrays.asList(points);
        base = points[0];
        
        for (Point p : points) {
            if (p.y < base.y || (p.y == base.y && p.x < base.x))
                base = p;
        }

        Arrays.sort(points, new PointComparator(base));
        
        x = points.length - 1;
        while (x > 0 && ccw(base, points[x], points[x - 1]) == 0)
            --x;
        for (i = 0; i < x; ++i)
            pts.add(points[i]);
        for (i = points.length - 1; i >= x; --i)
            pts.add(points[i]);
        
        stack.add(pts.get(0));
        stack.add(pts.get(1));
        
        for (i = 2; i < points.length; ++i) {
            curr = pts.get(i);
            while (stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), curr) < 0)
                stack.remove(stack.size() - 1);
            stack.add(curr);
        }
        
        return stack;
    }

    public int ccw(Point p1, Point p2, Point p3) {
        return (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
    }
    
    private class PointComparator implements Comparator<Point> {
        Point b;
        
        public PointComparator(Point b) {
            this.b = b;
        }
        
        @Override
        public int compare(Point p1, Point p2) {
            int ccw = Solution.this.ccw(p2, p1, b);
            
            if (ccw == 0)
                return (int)Math.pow(p1.x - b.x, 2) + (int)Math.pow(p1.y - b.y, 2) - (int)Math.pow(p2.x - b.x, 2) - (int)Math.pow(p2.y - b.y, 2);
            else
                return ccw;
        }
    }
}
