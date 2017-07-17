import java.math.BigInteger;
import java.util.HashMap;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int i, j, ret = 0, local, val, a, b, c, d, same;
        Point p1, p2;
        HashMap<Key, Integer> hm;
        Key key;
        
        if (points == null)
            return 0;
        
        for (i = 0; i < points.length; ++i) {
            p1 = points[i];
            same = 0;
            local = 1;
            hm = new HashMap<Key, Integer>();
            
            for (j = i + 1; j < points.length; ++j) {
                p2 = points[j];
                
                if (p1.x == p2.x && p1.y == p2.y) {
                    ++same;
                    continue;
                }
                
                a = p2.y - p1.y;
                b = p1.x - p2.x;
                c = p2.x * p1.y - p1.x * p2.y;
                d = findGreatestCommonDivisor(a, b, c);
                
                key = new Key(a / d, b / d, c / d);
                if (! hm.containsKey(key))
                    val = 2;
                else
                    val = hm.get(key) + 1;
                hm.put(key, val);
                
                local = Math.max(local, val);
            }
            
            ret = Math.max(local + same, ret);
        }
        
        return ret;
    }
    
    private int findGreatestCommonDivisor(int a, int b, int c) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b).gcd(BigInteger.valueOf(c))).intValue();
    }
    
    private class Key {
        private final int a;
        private final int b;
        private final int c;
        // ax + by + c = 0
        
        public Key(int a, int b, int c) {
            if (a < 0) {
                a = -a;
                b = -b;
                c = -c;
            } else if (a == 0 && b < 0) {
                b = -b;
                c = -c;
            }

            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (! (o instanceof Key))
                return false;
            Key key = (Key) o;
            return a == key.a && b == key.b && c == key.c;
        }
        
        @Override
        public int hashCode() {
            return a * 251 + b * 31 + c;
        }
    }
}
