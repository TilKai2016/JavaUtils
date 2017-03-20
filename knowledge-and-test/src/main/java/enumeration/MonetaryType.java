package enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 示例：货币类型枚举类
 *
 * 保存与展示都为字符串的枚举类
 *
 * @author tilkai
 */
public enum MonetaryType {

    CNY("CNY"),
    USD("USD");

    private String value;

    MonetaryType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {return String.valueOf(value);}

    /**
     * 使用@JsonCreator指定构造器或静态方法创建实例
     * @param text
     * @return
     */
    @JsonCreator
    public static MonetaryType fromValue(String text) {
        for (MonetaryType m : MonetaryType.values()) {
            if (String.valueOf(m.value).equals(text)) {
                return m;
            }
        }
        return null;
    }
}
