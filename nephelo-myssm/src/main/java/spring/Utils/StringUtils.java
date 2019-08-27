package spring.Utils;

/**
 *  @Author nephelo
 *  判断字符串是否为空
 */
public class StringUtils {
    public static boolean isEmpty(String string) {
        if ((string == null) || "".equals(string)) {
            return true;
        }
        return false;
    }
}

