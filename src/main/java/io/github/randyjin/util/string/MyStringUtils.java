package io.github.randyjin.util.string;

import org.apache.commons.lang.StringUtils;

/**
 * MyStringUtils
 *
 * @author 奕超
 * @date 2017/3/30
 */
public class MyStringUtils {

    public static String repeat(String source, int count) {
        if(source == null) {
            return null;
        }
        return StringUtils.repeat(source, count);
    }

    public static String replaceMiddle(String source, int startCount, int endCount, String replaceStr) {
        if(StringUtils.isEmpty(source)) {
            return source;
        }
        int sourceLength = source.length();
        if(sourceLength <= startCount + endCount) {
            return source;
        }
        int needReplaceCount = sourceLength - startCount - endCount;
        String prefix = source.substring(0, startCount);
        String suffix = source.substring(sourceLength - endCount,sourceLength);
        return prefix + repeat(replaceStr, needReplaceCount) + suffix;
    }
}
