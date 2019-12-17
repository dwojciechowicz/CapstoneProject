package com.example.knupay10;

public class UserProfile {
    public String username;
    public String useremail;
    public String userphonenr;
    public Integer userbalance;

    public UserProfile() {}

    public UserProfile(String username, String useremail, String userphonenr, Integer userbalance) {
        this.username = username;
        this.useremail = useremail;
        this.userphonenr = userphonenr;
        this.userbalance = userbalance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserbalance() {
        return userbalance;
    }

    public void setUserbalance(Integer userbalance) {
        this.userbalance = userbalance;
    }
}
