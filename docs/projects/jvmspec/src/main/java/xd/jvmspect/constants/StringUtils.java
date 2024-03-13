package xd.jvmspect.constants;

public class StringUtils {
    public static String toXMLTextNodeContent(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            if (aByte >= ' ') {
                sb.append((char) aByte);
            } else {
                String hexString = "\\x" + Integer.toHexString(aByte & 0xFF);
                sb.append(hexString);
            }
        }
        return sb.toString();
    }
}
