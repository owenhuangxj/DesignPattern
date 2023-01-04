package com.owen.strategy.congqin;
/**
 * @Author：Owen
 * @Package：com.owen.strategy.congqin
 * @Project：PatternDesign
 * @name：ReceiptHandleStrategyFactory
 * @Date：2022/12/22 20:09
 * @Filename：ReceiptHandleStrategyFactory
 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 策略工厂类
 *
 * @author OwenHuang
 * @since 2022/12/22 20:09
 */
public class ReceiptHandleStrategyFactory {
    public ReceiptHandleStrategyFactory() {
    }

    private static Map<String, ReceiptHandleStrategy> strategyMap;

    public static void init() {
        strategyMap = new HashMap<>();
//        strategyMap.put("MT1101", new MT1101ReceiptHandleStrategy());
//        strategyMap.put("MT2101", new MT2101ReceiptHandleStrategy());
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read("E:\\projects\\DesignPattern\\src\\main\\resources\\config.xml");
            Element rootElement = document.getRootElement();
//            Iterator<Element> elementIterator = rootElement.elementIterator();
//            while (elementIterator.hasNext()) {
//                Element element = elementIterator.next();
//                String name = element.elementTextTrim("name");
//                String className = element.elementTextTrim("class");
//                Class<?> clazz = Class.forName(className);
//                ReceiptHandleStrategy strategy =
//                        (ReceiptHandleStrategy) clazz.newInstance();
//                strategyMap.put(name,strategy);
//            }
            List<Element> classes = rootElement.elements("class");
            for (Element clzElement : classes) {
                String name = clzElement.attributeValue("name");
                String className = clzElement.attributeValue("value");
                Class<?> clazz = Class.forName(className);
                ReceiptHandleStrategy strategy =
                        (ReceiptHandleStrategy) clazz.newInstance();
                strategyMap.put(name, strategy);
            }

        } catch (DocumentException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static ReceiptHandleStrategy getReceiptHandleStrategy(String strategyType) {
        return strategyMap.get(strategyType);
    }
}
