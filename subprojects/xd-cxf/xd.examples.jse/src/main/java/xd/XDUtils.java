package xd;

public class XDUtils {
    public static String bytesToHex(byte[] bytes) {
        if (bytes == null) {
            bytes = new byte[0];
        }
        StringBuilder sb = new StringBuilder();
        boolean sep = false;
        for (byte b : bytes) {
            if (sep) {
                sb.append(" ");
            }
            sb.append(byteToHex(b));
            sep = true;
        }
        return sb.toString();
    }

    private static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF).toUpperCase();
        return (hex.length() == 1 ? "0" : "") + hex;
    }
}
