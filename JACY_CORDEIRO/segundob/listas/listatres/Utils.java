package segundob.listas.listatres;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public Map<String, Object> srtoMAP(String strJson) {
       // Extrair os dados do JSON usando expressões regulares
       Pattern pattern = Pattern.compile("\"(\\w+)\"\\s*:\\s*(\"[^\"]*\"|\\d+|true|false|null)");
       Matcher matcher = pattern.matcher(strJson);
        // Mapa que irá armazenar a chave:valor do json
            Map<String, Object> jsonData = new HashMap<>();

            while (matcher.find()) {
                String Key = matcher.group(1);
                String value = matcher.group(2); 
                
                jsonData.put(Key, value.replace("\"", ""));

            }
               return jsonData;
        } 
        
        
    }
    

