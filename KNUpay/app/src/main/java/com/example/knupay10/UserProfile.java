package com.example.knupay10;

public class UserProfile {
    public String username;
    public String useremail;
    public String userphonenr;
    public Integer userbalance;

    public UserProfile(String username, String useremail, String userphonenr, Integer userbalance) {
        this.username = username;
        this.useremail = useremail;
        this.userphonenr = userphonenr;
        this.userbalance = userbalance;
    }
}
