package com.example.demo.exception;


import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {
   @Override
   public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
       // Get the actual exception
       Throwable error = getError(webRequest);
       // Build a custom JSON structure
       Map<String, Object> errorAttributes = new HashMap<>();
       errorAttributes.put("timestamp", Instant.now());
       errorAttributes.put("status", 500);
       errorAttributes.put("error", "Internal Server Error");
       if (error != null) {
           errorAttributes.put("details", error.getMessage());
       } else {
           errorAttributes.put("details", "Unknown error occurred");
       }
       // Get the request path
       String path = (String) webRequest.getAttribute("javax.servlet.error.request_uri", 0);
       errorAttributes.put("path", path);
       return errorAttributes;
   }
}
