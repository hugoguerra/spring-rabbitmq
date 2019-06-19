package test.rabbit.demo.vo;

public class SampleRequest {

    private String userId;
    private String password;

    public SampleRequest(){}

    public SampleRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{ \"userId\" : \"" + getUserId() + "\",\n" + "\"password\" : \"" + getPassword() + "\"\n" + "}";
    }
}
