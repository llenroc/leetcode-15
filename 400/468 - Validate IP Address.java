public class Solution {
    public String validIPAddress(String IP) {
        if (validateIPv4(IP))
            return "IPv4";
        
        if (validateIPv6(IP))
            return "IPv6";
        
        return "Neither";
    }
    
    private boolean validateIPv4(String s) {
        String[] nums = s.split("\\.");
        
        if (nums.length != 4)
            return false;
        
        if (s.charAt(s.length() - 1) == '.')
            return false;
        
        for (String num : nums) {
            if (num.length() == 0 || num.length() > 3)
                return false;
            
            if (num.length() > 1 && num.charAt(0) == '0')
                return false;
            
            for (char c : num.toCharArray()) {
                if (c < '0' || c > '9')
                    return false;
            }
            
            if (Integer.valueOf(num) > 255)
                return false;
        }
        
        return true;
    }
    
    private boolean validateIPv6(String s) {
        String[] nums = s.split(":");
        
        if (nums.length != 8)
            return false;
        
        if (s.charAt(s.length() - 1) == ':')
            return false;
        
        for (String num : nums) {
            if (num.length() == 0 || num.length() > 4)
                return false;
            
            for (char c : num.toCharArray()) {
                if (! ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')))
                    return false;
            }
        }
        
        return true;
    }
}
