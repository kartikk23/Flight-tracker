package com.kartik.flighttracker;

public class model {

    String AAname, DAname, Atime, Dtime;

    public model(String AAname, String DAname, String atime, String dtime) {
        this.AAname = AAname;
        this.DAname = DAname;
        Atime = atime;
        Dtime = dtime;
    }

    public String getAAname() {
        return AAname;
    }

    public void setAAname(String AAname) {
        this.AAname = AAname;
    }

    public String getDAname() {
        return DAname;
    }

    public void setDAname(String DAname) {
        this.DAname = DAname;
    }

    public String getAtime() {
        return Atime;
    }

    public void setAtime(String atime) {
        Atime = atime;
    }

    public String getDtime() {
        return Dtime;
    }

    public void setDtime(String dtime) {
        Dtime = dtime;
    }
}
