class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.matches("^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])(\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}$")) {
            return "IPv4";
        } else if (queryIP.matches("^([0-9a-fA-F]{1,4})(:[0-9a-fA-F]{1,4}){7}$")) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}