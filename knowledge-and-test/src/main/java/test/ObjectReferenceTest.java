package test;

import model.GoodweInverter;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试引用类型存储到List中后，修改该引用，List中的该引用被修改
 * @author tilkai
 */
public class ObjectReferenceTest {
    /**
     * 输出结果：
     * asd
     * 123
     * asd
     * 345
     * @param args
     */
    public static void main(String []args) {

        List<String> strList = new ArrayList<String>();
        List<GoodweInverter> goodweInverters = new ArrayList<GoodweInverter>();

        String a = "asd";
        GoodweInverter goodweInverter = new GoodweInverter();
        goodweInverter.setCode1(123L);
        strList.add(a);
        goodweInverters.add(goodweInverter);

        System.out.println(strList.get(0));
        System.out.println(goodweInverters.get(0).getCode1());

        a = "zxc";
        goodweInverter.setCode1(345L);

        System.out.println(strList.get(0));
        System.out.println(goodweInverters.get(0).getCode1());
    }
}
