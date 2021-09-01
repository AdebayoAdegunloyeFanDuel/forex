package http_management;

import config_management.ConfigManager;

public class FixerLatestRatesHttpMgr extends HttpManager {

    public FixerLatestRatesHttpMgr(){
        super(ConfigManager.fixerBaseUrl() + ConfigManager.LatestServiceEndPoint() + ConfigManager.accessQueryParamValue() + ConfigManager.accessKey());
    }
}
