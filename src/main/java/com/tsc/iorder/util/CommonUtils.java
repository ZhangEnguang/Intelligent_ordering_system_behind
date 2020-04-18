package com.tsc.iorder.util;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@Component
public class CommonUtils {
    /**
     * 把request转为map
     *
     * @param request
     * @return
     */
    public static Map<String, Object> getParameterMap(HttpServletRequest request)throws Exception{
        StringBuilder postData = new StringBuilder();
        BufferedReader bufferReaderBody = null;
        try {
            bufferReaderBody = new BufferedReader(request.getReader());
            String contentLine = "";
            while ((contentLine = bufferReaderBody.readLine()) != null) {
                postData.append(contentLine);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (bufferReaderBody != null) {
                bufferReaderBody.close();
            }
        }
        Map<String, Object> map = (Map<String, Object>) JSONUtils.parse(postData.toString());
        return map;
    }
}
