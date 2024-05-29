package com.provinitiAPI.testservices;

import com.provinitiAPI.common.ExtentTestManager;
import com.provinitiAPI.utils.RestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ProvinitiServices extends ServiceBase {

    @Value("${provinityservice.host}")
    public String host;
    @Autowired RestWrapper restWrapper;

    public String getproviniti(String endpointURL)
    {
     ExtentTestManager.logStep("Proviniti EndPoint is \": "+host+endpointURL);
      return restWrapper.getResponseWithPathParams(host,endpointURL);
    }
}
