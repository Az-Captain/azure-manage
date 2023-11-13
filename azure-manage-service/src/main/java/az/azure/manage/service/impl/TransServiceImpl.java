package az.azure.manage.service.impl;

import az.azure.manage.dto.TransDto;
import az.azure.manage.service.TransService;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author Az
 * @date 2022/10/11
 */
@Service("transService")
public class TransServiceImpl implements TransService {

    @Override
    public String translation(TransDto transDto) {
        JSONObject json1 = new JSONObject();
        json1.put("DTYPE", '0');
        json1.put("KEY", transDto.getKey());
        json1.put("sk", "6ed6b9a1994860b33e1aa8abfe00d015");
        Map<String, String> map = Maps.newHashMap();
        map.put("DATA", json1.toString());
        String url = "https://api.xcxbq.cn/api/translateapi/index";
        return httpPost(url, map);
    }

    public static String httpPost(String url, Map<String, String> params) {
        URL connect;
        StringBuffer data = new StringBuffer();
        try {
            connect = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) connect.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // post 不能使用缓存
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            OutputStreamWriter paramOut = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8);

            String paramStr = "";
            for (String param : params.keySet()) {
                paramStr += "&" + param + "=" + params.get(param);
            }
            paramOut.write(paramStr);
            paramOut.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
            paramOut.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}
