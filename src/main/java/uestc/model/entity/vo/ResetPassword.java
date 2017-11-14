package uestc.model.entity.vo;

public class ResetPassword {
    private String email;
    private String newpassword;
    private String token;

    public ResetPassword() {
    }

    public ResetPassword(String email, String newpassword, String token) {
        this.email = email;
        this.newpassword = newpassword;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ResetPassword{" +
                "email='" + email + '\'' +
                ", newpassword='" + newpassword + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
