package LeetCode;

// https://leetcode.com/problems/encode-and-decode-tinyurl/
class EncodeAndDecodeTinyURL {
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder(longUrl);
        sb.reverse();
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        StringBuilder sb = new StringBuilder(shortUrl);
        sb.reverse();
        return sb.toString();
    }
}