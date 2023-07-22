package testUtils;

public enum APIResources {

    AUTH("/auth"),
    CREATESTOREID("/store/order"),
    GETSTOREID("/store/order/{orderId}"),
    DELETEORDERID("/store/order/{orderId}"),
    ADDPET("/pet"),
    ADDINVALIDPET("/pe"),
    UPLOADIMAGE("pet/{petId}/uploadImage"),
    UPDATEPET("/pet");

    private String resource;

    APIResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
