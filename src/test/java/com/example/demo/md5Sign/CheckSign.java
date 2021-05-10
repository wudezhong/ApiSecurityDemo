package com.example.demo.md5Sign;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author  jinkai
 * @since  2020-09-27
 */
public class CheckSign {

    /**
     *  md5 加密
     * @param text
     * @param appKey
     * @param input_charset
     * @return
     */
    public static String sign(String text, String appKey, String input_charset) {
        text = text + appKey;
        return DigestUtils.md5DigestAsHex(getContentBytes(text, input_charset));
    }
    /**
     * @param content
     * @param charset
     * @return
     * @throws RuntimeException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    /**
     * 构建签名字符串
     *
     * @param params      请求参数，自动移除sign和signType
     * @param charset     UTF8
     * @param emptyIgnore 忽略空值
     * @return 签名串，注意在进行MD5加密前还需要在签名串的后面拼接上appKey
     */
    public static String buildQuery(Map<String, Object> params, String charset, boolean emptyIgnore) {
        StringBuffer sb = new StringBuffer();
        Set<String> paramNames = new TreeSet(params.keySet());    //参数名进行排序

        Iterator i$ = ((Set) paramNames).iterator();
        while (i$.hasNext()) {
            String key = (String) i$.next();
            if(StringUtils.isEmpty(key) || "sign".equalsIgnoreCase(key) || "signType".equalsIgnoreCase(key)){
                continue;
            }
            try {
                String value = (String) params.get(key);
                if (!StringUtils.isEmpty(value) || !emptyIgnore) {    //过滤空值
                    sb.append(URLEncoder.encode(key, charset));  //参数名进行URLEncode
                    sb.append("=");
                    sb.append(URLEncoder.encode(value == null ? "" : value, charset));    //参数值进行URLEncode
                    sb.append("&");
                }
            } catch (UnsupportedEncodingException var8) {
                throw new RuntimeException(var8);
            }
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }
}
