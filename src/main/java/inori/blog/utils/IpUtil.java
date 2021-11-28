package inori.blog.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Inori
 */
public class IpUtil {
    private static Pattern pattern = Pattern
            .compile("([1-9]\\d?|1\\d{2}|2[01]\\d|22[0-3])\\."
                    + "(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\."
                    + "(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\."
                    + "(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})");

    /**
     * 根据IP白名单设置获取可用的IP列表
     */
    private static Set<String> getAvaliIpList(List<String> ipList) {
        Set<String> result = new HashSet<>();
        for (String ip : ipList) {
            if (ip.contains("*")) {
                String[] ips = ip.split("\\.");
                String[] from = new String[]{"0", "0", "0", "0"};
                String[] end = new String[]{"255", "255", "255", "255"};
                List<String> tem = new ArrayList<>();
                for (int i = 0; i < ips.length; i++) {
                    if (ips[i].contains("*")) {
                        from[i] = "[*]";
                        end[i] = "[*]";
                        tem.add("0;255");
                    } else {
                        from[i] = ips[i];
                        end[i] = ips[i];
                    }
                }

                StringBuilder fromIp = new StringBuilder();
                StringBuilder endIp = new StringBuilder();
                for (int i = 0; i < ips.length; i++) {
                    fromIp.append(from[i]).append(".");
                    endIp.append(end[i]).append(".");
                }
                fromIp.deleteCharAt(fromIp.length() - 1);
                endIp.deleteCharAt(endIp.length() - 1);

                for (String s : tem) {
                    String startIp = fromIp.toString().replace("[*]", s.split(";")[0]);
                    String finishIp = endIp.toString().replace("[*]", s.split(";")[1]);
                    String ipAddress = startIp + "-" + finishIp;
                    if (validate(ipAddress)) {
                        result.add(ipAddress);
                    }
                }
            } else {
                if (validate(ip)) {
                    result.add(ip);
                }
            }
        }
        return result;
    }

    /**
     * 在添加至白名单时进行格式校验
     */
    private static boolean validate(String ip) {
        for (String s : ip.split("-")) {
            if (!pattern.matcher(s).matches()) {
                return false;
            }
        }
        return true;
    }

    /**
     * checkLoginIP:(根据IP,及可用Ip列表来判断ip是否包含在白名单之中).
     */
    private static boolean checkLoginIp(String ip, Set<String> ipList) {
        if (ipList.isEmpty() || ipList.contains(ip)) {
            return true;
        } else {
            for (String allow : ipList) {
                if (allow.contains("-")) {
                    String[] from = allow.split("-")[0].split("\\.");
                    String[] end = allow.split("-")[1].split("\\.");
                    String[] tag = ip.split("\\.");

                    // 对IP从左到右进行逐段匹配
                    boolean check = true;
                    for (int i = 0; i < tag.length; i++) {
                        int start = Integer.parseInt(from[i]);
                        int t = Integer.parseInt(tag[i]);
                        int finish = Integer.parseInt(end[i]);
                        if (!(start <= t && t <= finish)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 根据IP地址，及IP白名单设置规则判断IP是否包含在白名单
     */
    public static boolean checkLoginIp(String ip, List<String> ipWhiteConfig) {
        Set<String> ipList = getAvaliIpList(ipWhiteConfig);
        return checkLoginIp(ip, ipList);
    }


    public static String getIpAddress(HttpServletRequest request) {
        String unknown = "unknown";
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

}