package cn.ssh.DeptActionImpl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.List;
public class listToJson {

    /** 
     * ��������һ�� object��������һ��ָ�������ַ��� 
     *  
     * @param object ������� 
     * @return String 
     */  
    public static String objectToJson(Object object) {  
        StringBuilder json = new StringBuilder();  
        if (object == null) {  
            json.append("\"\"");  
        } else if (object instanceof String || object instanceof Integer || object instanceof Double || object instanceof Long) {  
            json.append("\"").append(object.toString()).append("\"");  
        } else {  
            json.append(beanToJson(object));  
        }  
        return json.toString();  
    }  

    /** 
     * ��������һ�� Javabean��������һ��ָ�������ַ��� 
     *  
     * @param bean bean���� 
     * @return String "{}" 
     */  
    public static String beanToJson(Object bean) {  
        StringBuilder json = new StringBuilder();  
        json.append("{");  
        PropertyDescriptor[] props = null;  
        try {  
            props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        if (props != null) {  
            for (int i = 0; i < props.length; i++) {  
                try {  
                    if(!(props[i].getPropertyType()).isInterface()){  
                        String name = objectToJson(props[i].getName());  
                        String value = objectToJson(props[i].getReadMethod().invoke(bean));  
                        json.append(name);  
                        json.append(":");  
                        json.append(value);  
                        json.append(",");  
                    }  
                } catch (Exception e) {  
                }  
            }  
            json.setCharAt(json.length() - 1, '}');  
        } else {  
            json.append("}");  
        }  
        return json.toString();  
    }  

    /** 
     * ͨ������һ���б����,����ָ���������б��е���������һ��JSON���ָ���ַ��� 
     *  
     * @param list �б���� 
     * @return String "[{},{}]" 
     */  
    public static String listToJson(List<?> list) {  
        StringBuilder json = new StringBuilder();  
        json.append("[");  
        if (list != null && list.size() > 0) {  
            for (Object obj : list) {  
                json.append(objectToJson(obj));  
                json.append(",");  
            }  
            json.setCharAt(json.length() - 1, ']');  
        } else {  
            json.append("]");  
        }  
        return json.toString();  
    }  
   
}
