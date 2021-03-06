package utils;

import commons.DomainAppConstants;

/**
 * User: Ronald Butron
 * Date: 12/8/15
 */
public class CredentialManager {

    private static CredentialManager instance = null;
    private String envId;
    private String adminURL;
    private String tabletURL;
    private String roomManagerService;
    private String userNameAdmin;
    private String passwordAdmin;
    private String userExchange;
    private String passwordExchange;
    private String adminLoggedUrl;
    private String hometabletURL;
    private String adminHomeURL;
    private String ip;
    private String domainEmail;
    private JSONReader envReader;
    private String dbPort;

    protected CredentialManager(){
        init();
    }

    public static CredentialManager getInstance(){
        if (instance == null){
            instance = new CredentialManager();
        }
        return instance;
    }

    private void init() {
        String environmentId = System.getProperty("envId");
        if (environmentId == null || environmentId.isEmpty()){
            envId = DomainAppConstants.DEFECT_ID;
        } else {
            envId = environmentId;
        }
        envReader = new JSONReader(".\\configEnv.json");

        //Environment URLs
        adminURL = envReader.getKeyValue("Environment", "id", envId, "adminURL");
        tabletURL = envReader.getKeyValue("Environment", "id", envId, "tabletURL");
        roomManagerService = envReader.getKeyValue("Environment", "id", envId, "roomManagerService");
        adminHomeURL = envReader.getKeyValue("Environment", "id", envId, "adminHomeURL");
        ip = envReader.getKeyValue("Environment", "id", envId, "ip");
        hometabletURL = envReader.getKeyValue("Environment", "id", envId, "homeTabletURL");
        domainEmail = envReader.getKeyValue("Environment", "id", envId, "domainEmail");
        dbPort = envReader.getKeyValue("Environment", "id", envId, "dbPort");

        //Environment users information
        userNameAdmin = envReader.getKeyValue("Environment", "id", envId, "userAdmin", "userName");
        passwordAdmin = envReader.getKeyValue("Environment", "id", envId, "userAdmin", "password");
        userExchange = envReader.getKeyValue("Environment", "id", envId, "userExchange", "userName");
        passwordExchange = envReader.getKeyValue("Environment", "id", envId, "userExchange", "password");

    }


    public String getIp(){
        return ip;
    }
    /**
     * This method obtain admin URL
     * @return admin URL
     */
    public String getAdminURL(){
        return adminURL;
    }

    /**
     * This method return the tablet URL
     * @return tablet URL
     */
    public String getTabletURL(){
        return tabletURL;
    }

    /**
     * This method return the Room Manager Services URL
     * @return Room Manager Services URL
     */
    public String getRoomManagerService(){
        return roomManagerService;
    }

    /**
     * This method return the Home tablet URL
     * @return the home tablet URL
     */
    public String getHometabletURL(){
        return  hometabletURL;
    }

    /**
     * This method return user name of the admin
     * @return user name of the admin
     */
    public String getUserNameAdmin(){
        return userNameAdmin;
    }

    /**
     * This method return password of the user name of the admin
     * @return password of the user name
     */
    public String getPasswordAdmin(){
        return passwordAdmin;
    }

    /**
     * This method return the name of the exchange user
     * @return exchange user
     */
    public String getUserExchange(){
        return userExchange;
    }

    /**
     * This method return the password of the exchange user
     * @return password of the exchange user
     */
    public String getPasswordExchange(){
        return passwordExchange;
    }

    /**
     * This method return the id of the environment
     * @return id environment
     */
    public String getEnvId(){
        return envId;
    }


    /**
     * This method obtains the Admin Home URL
     * @return the admin URL
     */
    public String getAdminHomeURL() {
        return adminHomeURL;
    }

    /**
     * This method obtains the domain Email
     * @return a String of the domain Email
     */
    public String getDomainEmail(){
        return domainEmail;
    }

    /**
     * This method return the mongo data base port
     * @return String with the number of the port
     */
    public String getdbPort() {
        return dbPort;
    }
}
