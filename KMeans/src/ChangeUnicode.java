import java.io.UnsupportedEncodingException;

/**
 * Created by yuminchen on 16/10/19.
 */
public class ChangeUnicode {

    public static final String UTF_8 = "UTF-8";
    /** 16 位 UCS 转换格式，Big Endian(最低地址存放高位字节）字节顺序     */
    public static final String UTF_16BE = "UTF-16BE";
    /** 16 位 UCS 转换格式，Litter Endian（最高地址存放地位字节）字节顺序     */
    public static final String UTF_16LE = "UTF-16LE";
    /** 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识     */
    public static final String UTF_16 = "UTF-16";
    /** 中文超大字符集     **/
    public static final String GBK = "GBK";

    /** 将字符编码转换成UTF-8     */
    public static String toUTF_8(String str) throws UnsupportedEncodingException {
        return changeCharset(str, UTF_8);
    }

    /** 将字符编码转换成UTF-16BE     */
    public String toUTF_16BE(String str) throws UnsupportedEncodingException{
        return this.changeCharset(str, UTF_16BE);
    }

    /** 将字符编码转换成UTF-16LE     */
    public String toUTF_16LE(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, UTF_16LE);
    }

    /** 将字符编码转换成UTF-16     */
    public String toUTF_16(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, UTF_16);
    }

    /** 将字符编码转换成GBK     */
    public String toGBK(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, GBK);
    }

    public static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
        if(str != null) {
            //用默认字符编码解码字符串。与系统相关，中文windows默认为GB2312
            byte[] bs = str.getBytes();
            return new String(bs, newCharset);    //用新的字符编码生成字符串
        }
        return null;
    }

    /**
     * 字符串编码转换的实现方法
     * @param str    待转换的字符串
     * @param oldCharset    源字符集
     * @param newCharset    目标字符集
     */
    public String changeCharset(String str, String oldCharset, String newCharset) throws UnsupportedEncodingException {
        if(str != null) {
            //用源字符编码解码字符串
            byte[] bs = str.getBytes(oldCharset);
            return new String(bs, newCharset);
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
