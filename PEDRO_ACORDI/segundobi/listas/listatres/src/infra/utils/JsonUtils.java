package infra.utils;


import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils {
    public static Map<String, Object> srtToMap(String strJson) {
        Map<String, Object> jsonData = new HashMap<>();

        // Remover chaves externas se existirem
        strJson = strJson.trim();
        if (strJson.startsWith("{") && strJson.endsWith("}")) {
            strJson = strJson.substring(1, strJson.length() - 1).trim();
        }

        int index = 0;
        while (index < strJson.length()) {
            // Procurar chave
            Matcher keyMatcher = Pattern.compile("\"(\\w+)\"\\s*:").matcher(strJson.substring(index));
            if (keyMatcher.find()) {
                String key = keyMatcher.group(1);
                index += keyMatcher.end();

                // Pular espaços em branco
                while (index < strJson.length() && Character.isWhitespace(strJson.charAt(index))) {
                    index++;
                }

                // Verificar valor
                if (index < strJson.length()) {
                    char c = strJson.charAt(index);
                    if (c == '"') {
                        // Valor é uma string
                        int valueStart = index + 1;
                        int valueEnd = strJson.indexOf('"', valueStart);
                        while (valueEnd != -1 && strJson.charAt(valueEnd - 1) == '\\') {
                            valueEnd = strJson.indexOf('"', valueEnd + 1);
                        }
                        if (valueEnd == -1) {
                            throw new RuntimeException("String não terminada");
                        }
                        String value = strJson.substring(valueStart, valueEnd);
                        jsonData.put(key, value);
                        index = valueEnd + 1;
                    } else if (c == '{') {
                        // Valor é um objeto aninhado
                        int braceCount = 1;
                        int valueStart = index;
                        index++;
                        while (index < strJson.length() && braceCount > 0) {
                            char ch = strJson.charAt(index);
                            if (ch == '{') braceCount++;
                            else if (ch == '}') braceCount--;
                            index++;
                        }
                        if (braceCount != 0) {
                            throw new RuntimeException("Objeto JSON não terminado");
                        }
                        String nestedJson = strJson.substring(valueStart, index);
                        Map<String, Object> nestedMap = srtToMap(nestedJson);
                        jsonData.put(key, nestedMap);
                    } else if (c == '[') {
                        // Valor é um array
                        int bracketCount = 1;
                        int valueStart = index;
                        index++;
                        while (index < strJson.length() && bracketCount > 0) {
                            char ch = strJson.charAt(index);
                            if (ch == '[') bracketCount++;
                            else if (ch == ']') bracketCount--;
                            index++;
                        }
                        if (bracketCount != 0) {
                            throw new RuntimeException("Array JSON não terminado");
                        }
                        String arrayContent = strJson.substring(valueStart, index);
                        List<Map<String, Object>> array = arrayToMap(arrayContent, key);
                        jsonData.put(key, array);
                    } else {
                        // Valor é um literal (número, booleano ou null)
                        Matcher valueMatcher = Pattern.compile("^(true|false|null|[-+]?\\d*\\.?\\d+([eE][-+]?\\d+)?)").matcher(strJson.substring(index));
                        if (valueMatcher.find()) {
                            String valueStr = valueMatcher.group(1);
                            Object value = parseLiteral(valueStr);
                            jsonData.put(key, value);
                            index += valueMatcher.end();
                        } else {
                            throw new RuntimeException("Valor inesperado na posição " + index);
                        }
                    }
                }

                // Pular espaços e vírgulas
                while (index < strJson.length() && (Character.isWhitespace(strJson.charAt(index)) || strJson.charAt(index) == ',')) {
                    index++;
                }
            } else {
                break;
            }
        }

        return jsonData;
    }

    public static List<Map<String, Object>> arrayToMap(String json, String attribute) {
        List<Map<String, Object>> list = new ArrayList<>();

        String regex = "\"" + attribute + "\"\\s*:\\s*\\[(.*?)\\]";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(json);

        if (matcher.find()) {
            String arrayContent = matcher.group(1).trim();

            List<String> jsonObjects = splitJsonArray(arrayContent);

            for (String element : jsonObjects) {
                Map<String, Object> map = srtToMap(element);
                list.add(map);
            }
        }

        return list;
    }

    private static List<String> splitJsonArray(String arrayContent) {
        List<String> jsonObjects = new ArrayList<>();
        int braceCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrayContent.length(); i++) {
            char c = arrayContent.charAt(i);

            if (c == '{') {
                braceCount++;
            }
            if (c == '}') {
                braceCount--;
            }

            sb.append(c);

            if (braceCount == 0 && c == '}') {
                jsonObjects.add(sb.toString().trim());
                sb.setLength(0);
            }
        }

        return jsonObjects;
    }

    public static String toJson(Object obj) throws IllegalAccessException {
        return toJson(obj, new HashSet<>());
    }

    private static String toJson(Object obj, Set<Object> visited) throws IllegalAccessException {
        if (obj == null) {
            return "null";
        }
        if (visited.contains(obj)) {
            return "\"<circular reference>\"";
        }

        visited.add(obj);
        Class<?> clazz = obj.getClass();
        if (obj instanceof String) {
            return "\"" + escapeString(obj.toString()) + "\"";
        } else if (obj instanceof Number || obj instanceof Boolean) {
            return obj.toString();
        } else {
            // Objeto personalizado
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            Field[] fields = obj.getClass().getDeclaredFields();
            boolean firstField = true;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (!firstField) {
                    sb.append(",");
                }
                sb.append("\"").append(escapeString(field.getName())).append("\":");
                sb.append(toJson(value, visited));
                firstField = false;
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private static String escapeString(String str) {
        return str.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    private static Object parseLiteral(String valueStr) {
        valueStr = valueStr.trim();
        if (valueStr.equals("null")) {
            return null;
        } else if (valueStr.equals("true")) {
            return true;
        } else if (valueStr.equals("false")) {
            return false;
        } else {
            try {
                if (valueStr.contains(".") || valueStr.contains("e") || valueStr.contains("E")) {
                    return Double.parseDouble(valueStr);
                } else {
                    return Long.parseLong(valueStr);
                }
            } catch (NumberFormatException e) {
                return valueStr;
            }
        }
    }
}
