package inori.blog.model;

import org.apache.commons.lang3.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class spreadsheet {
    private Map<String, String> map = new HashMap<>();

    /**
     * 正则验证字符串是否是数字
     */
    private static final Pattern NUM_PATTERN = Pattern.compile("^[0-9]*$");

    /**
     * 正则验证字符串是否有字符
     */
    private static final Pattern CHAR_PATTERN = Pattern.compile(".*[a-zA-Z]+.*");


    /**
     * 该函数的目的是获取在column列的值，内容为等式的话需要计算并返回其结果。举例，若在"A1"列存储的值为"=7+3"，sheet.get("A1")应返回"10"。
     *
     * @param column 列数
     * @return 该列存储的值，默认为空字符串
     */
    public String get(String column) {
        String result = map.get(column);
        if (result != null && !"".equals(result)) {
            if (isStr2Num(result)) {
                return result.trim();
            }
            if (result.charAt(0) == '=') {
                result = result.substring(1);
                if (column.equals(result)) {
                    return "#Circular";
                }
                do {
                    String str = result.replaceAll("[^a-zA-Z]", "");
                    if (StringUtils.isNotBlank(str)) {
                        for (char c : str.toCharArray()) {
                            String s = String.valueOf(c);
                            result = result.replaceAll(s, "(" + map.get(s) + ")");
                        }
                    }
                    result = result.replaceAll("=", "");
                } while (isStr2Char(result));

                try {
                    ScriptEngineManager manager = new ScriptEngineManager();
                    ScriptEngine script = manager.getEngineByName("JavaScript");
                    return script.eval(result).toString();
                } catch (Exception e) {
                    return "#Error";
                }
            }
            return result;
        } else {
            return "";
        }

    }

    /**
     * 判断字符串是否是数字
     */
    public boolean isStr2Num(String str) {
        if (StringUtils.isBlank(str.trim())) {
            return false;
        }
        Matcher matcher = NUM_PATTERN.matcher(str.trim());
        return matcher.matches();
    }

    /**
     * 判断字符串是否有字符
     */
    public boolean isStr2Char(String str) {
        Matcher matcher = CHAR_PATTERN.matcher(str);
        return matcher.matches();
    }

    /**
     * 判断字符是否是0-9的数字
     */
    private boolean isNumber(char num) {
        if (num >= '0' && num <= '9')
            return true;
        return false;
    }

    /**
     * 该函数的目的是获取在column列的字符串值，内容为等式的话不需要计算，直接返回字符串。举例，若在"A1"列存储的值为"=7+3"，sheet.getLiteral("A1")应返回"=7+3"。
     *
     * @param column 列数
     * @return 该列存储的字符串值，默认为空字符串
     */
    public String getLiteral(String column) {
        return map.get(column);
    }

    /**
     * 该函数的目的是在column列存储value的值。如果该列已经被占用，则替换为当前值。
     *
     * @param column 列数
     * @param value  在该列需要存储的值
     */
    public void put(String column, String value) {
        map.put(column, value);
    }
}
