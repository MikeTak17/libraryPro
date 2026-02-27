package com.library.common.util;

import org.apache.commons.codec.binary.Hex;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * 文件处理工具类
 *
 * @author: xyh
 * @create: 2023-03-21
 **/
public class FileUtils {

    public static final String BASE64PREFIX = "data:image/jpg";

    public static final String BASE64SUFFIX = ";base64,";

    public static final Base64.Encoder encoder = Base64.getEncoder();
    public static final Base64.Decoder decoder = Base64.getDecoder();



    /**
     * base64编码
     * 格式：data:image/jpg;base64, + 编码
     *
     * @param bytes
     * @return
     */
    public static String getBase64String(byte[] bytes) {
        String encodedText = FileUtils.BASE64PREFIX + FileUtils.BASE64SUFFIX
                + FileUtils.encoder.encodeToString(bytes);
        return encodedText;
    }

    /**
     * base64解码
     *
     * @param base64String
     * @return
     */
    public static byte[] getBase64(String base64String) {
        byte[] decode = FileUtils.decoder.decode(base64String);
        return decode;
    }

    /**
     * 获取文件扩展名，不带后缀的.
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * 获取不带扩展名的文件名
     */
    public static String getFileName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    /**
     * 获取文件md5值
     *
     * @param inputStream 文件输入流
     * @return {@link String} 文件md5值
     */
    public static String getMd5(InputStream inputStream) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] buffer = new byte[8192];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                md5.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(md5.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
