package utils;

import java.nio.charset.Charset;

/**
 * byte[]与其他类型之间的转换工具
 * @author tilkai
 */
public class ByteConvertUtils {

    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    /**
     * byte[]转Byte[]
     * @param array byte[]
     * @return Byte[]
     */
    public static Byte[] toObject(final byte[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        final Byte[] result = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Byte.valueOf(array[i]);
        }
        return result;
    }

    /**
     * Byte[]转byte[]
     * @param array Byte[]
     * @param valueForNull Byte[]中null值的替换字符
     * @return byte[]
     */
    public static byte[] toPrimitive(final Byte[] array, final byte valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        final byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            final Byte b = array[i];
            result[i] = (b == null ? valueForNull : b.byteValue());
        }
        return result;
    }

    /**
     * short转byte[]
     * @param data short
     * @return byte[]
     */
    public static byte[] getBytes(short data)
    {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) ((data & 0xff00) >> 8);
        return bytes;
    }

    /**
     * char转byte[]
     * @param data
     * @return byte[]
     */
    public static byte[] getBytes(char data)
    {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (data);
        bytes[1] = (byte) (data >> 8);
        return bytes;
    }

    /**
     * int转byte[]
     * @param data int
     * @return byte[]
     */
    public static byte[] getBytes(int data)
    {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) ((data & 0xff00) >> 8);
        bytes[2] = (byte) ((data & 0xff0000) >> 16);
        bytes[3] = (byte) ((data & 0xff000000) >> 24);
        return bytes;
    }

    /**
     * long转byte[]
     * @param data long
     * @return byte[]
     */
    public static byte[] getBytes(long data)
    {
        byte[] bytes = new byte[8];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) ((data >> 8) & 0xff);
        bytes[2] = (byte) ((data >> 16) & 0xff);
        bytes[3] = (byte) ((data >> 24) & 0xff);
        bytes[4] = (byte) ((data >> 32) & 0xff);
        bytes[5] = (byte) ((data >> 40) & 0xff);
        bytes[6] = (byte) ((data >> 48) & 0xff);
        bytes[7] = (byte) ((data >> 56) & 0xff);
        return bytes;
    }

    /**
     * float转byte[]
     * @param data float
     * @return byte[]
     */
    public static byte[] getBytes(float data)
    {
        int intBits = Float.floatToIntBits(data);
        return getBytes(intBits);
    }

    /**
     * double转byte[]
     * @param data double
     * @return byte[]
     */
    public static byte[] getBytes(double data)
    {
        long intBits = Double.doubleToLongBits(data);
        return getBytes(intBits);
    }

    /**
     * String转byte[]
     * @param data String
     * @param charsetName 编码格式，如 "UTF-8"
     * @return byte[]
     */
    public static byte[] getBytes(String data, String charsetName)
    {
        Charset charset = Charset.forName(charsetName);
        return data.getBytes(charset);
    }

    /**
     * 指定GBK编码格式的String转byte[]
     * @param data String
     * @return byte[]
     */
    public static byte[] getBytes(String data)
    {
        return getBytes(data, "GBK");
    }


    /**
     * byte[]转short
     * @param bytes byte[]
     * @return short
     */
    public static short getShort(byte[] bytes)
    {
        return (short) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
    }

    /**
     * byte[]转char
     * @param bytes byte[]
     * @return char
     */
    public static char getChar(byte[] bytes)
    {
        return (char) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
    }

    /**
     * byte[]转int
     * @param bytes byte[]
     * @return int
     */
    public static int getInt(byte[] bytes)
    {
        return (0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)) | (0xff0000 & (bytes[2] << 16)) | (0xff000000 & (bytes[3] << 24));
    }

    /**
     * byte[]转long
     * @param bytes byte[]
     * @return long
     */
    public static long getLong(byte[] bytes)
    {
        return(0xffL & (long)bytes[0]) | (0xff00L & ((long)bytes[1] << 8)) | (0xff0000L & ((long)bytes[2] << 16)) | (0xff000000L & ((long)bytes[3] << 24))
                | (0xff00000000L & ((long)bytes[4] << 32)) | (0xff0000000000L & ((long)bytes[5] << 40)) | (0xff000000000000L & ((long)bytes[6] << 48)) | (0xff00000000000000L & ((long)bytes[7] << 56));
    }

    /**
     * byte[]转float
     * @param bytes byte[]
     * @return float
     */
    public static float getFloat(byte[] bytes)
    {
        return Float.intBitsToFloat(getInt(bytes));
    }

    /**
     * byte[]转double
     * @param bytes byte[]
     * @return double
     */
    public static double getDouble(byte[] bytes)
    {
        long l = getLong(bytes);
        System.out.println(l);
        return Double.longBitsToDouble(l);
    }

    /**
     * byte[]转String
     * @param bytes byte[]
     * @param charsetName 编码格式(如"UTF-8")
     * @return String
     */
    public static String getString(byte[] bytes, String charsetName)
    {
        return new String(bytes, Charset.forName(charsetName));
    }

    /**
     * byte[]转GBK编码格式的String
     * @param bytes byte[]
     * @return String
     */
    public static String getString(byte[] bytes)
    {
        return getString(bytes, "GBK");
    }



    public static void main(String[] args)
    {
        short s = 122;
        int i = 123;
        long l = 1234567;
        char c = 'a';
        float f = 122.22354566f;
        double d = 122.22;
        String string = "这是个String";

        System.out.println("*******************\n");

        System.out.println("short : " + s);
        System.out.println("short to byte[] : " + getBytes(s));
        System.out.println("byte[] to short : " + getShort(getBytes(s)));

        System.out.println("*******************\n");

        System.out.println("int : " + i);
        System.out.println("byte[] to int : " + getInt(getBytes(i)));

        System.out.println("*******************\n");

        System.out.println("long : " + l);
        System.out.println("byte[] to long : " + getLong(getBytes(l)));

        System.out.println("*******************\n");

        System.out.println("char : " + c);
        System.out.println("byte[] to char : " + getChar(getBytes(c)));

        System.out.println("*******************\n");

        System.out.println("float : " + f);
        System.out.println("byte[] to float : " + getFloat(getBytes(f)));

        System.out.println("*******************\n");

        System.out.println("double : " + d);
        System.out.println("byte[] to double : " + getDouble(getBytes(d)));

        System.out.println("*******************\n");

        System.out.println("String : " + string);
        System.out.println("byte[] to String : " + getString(getBytes(string)));

        System.out.println("*******************\n");

    }
}
