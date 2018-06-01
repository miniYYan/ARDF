package com.lfp.ardf.util;

import android.text.TextUtils;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by LiFuPing on 2018/5/17.
 */
public class ArrayUtil {
    public static String join(Object[] tokens, CharSequence delimiter) {
        return TextUtils.join(delimiter, tokens);
    }

    public static String join(Iterable  tokens, CharSequence delimiter) {
        return TextUtils.join(delimiter, tokens);
    }

    /**
     * 返回包含分隔符连接的字符串
     *
     * @param tokens          数据源
     * @param delimiter_key   两个key数据之间的分隔符
     * @param delimiter_value key与value之间的分隔符
     * @return 拼接之后的字符串
     */
    public static <K extends Object, V extends Object> String join(Map<K, V> tokens, CharSequence delimiter_key, CharSequence delimiter_value) {
        StringBuilder sb = new StringBuilder();
        Iterator<K> keys = tokens.keySet().iterator();
        boolean firstTime = true;
        while (keys.hasNext()) {
            K key = keys.next();
            V value = tokens.get(key);
            if (firstTime) {
                firstTime = false;
            } else sb.append(delimiter_key);
            sb.append(key);
            sb.append(delimiter_value);
            sb.append(value);
        }
        return sb.toString();
    }


}
