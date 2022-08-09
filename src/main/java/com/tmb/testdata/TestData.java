package com.tmb.testdata;

import com.creditdatamw.zerocell.annotation.Column;

public class TestData {

    @Column(name = "username",index = 0)
    public String username;

    @Column(name = "workemail", index = 1)
    public String workemail;

    @Column(name= "password",index = 2)
    public String password;

    @Column(name="expectedtitle",index=3)
    public String expectedTitle;

}
