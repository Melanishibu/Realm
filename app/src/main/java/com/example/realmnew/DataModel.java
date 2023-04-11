package com.example.realmnew;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DataModel extends RealmObject {

    @PrimaryKey
    private long id;
    private String sname;
    private String sdur;
    private String strk;
    private String sdesc;

    public DataModel(){

    }

    public DataModel(long id, String sname, String sdur, String strk, String sdesc) {
        this.id = id;
        this.sname = sname;
        this.sdur = sdur;
        this.strk = strk;
        this.sdesc = sdesc;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getSname() {
        return sname;
    }

    public void setSdur(String sdur) {
        this.sdur = sdur;
    }
    public String getSdur() {
        return sdur;
    }

    public String getStrk() {
        return strk;
    }
    public void setStrk(String strk) {
        this.strk = strk;
    }

    public String getSdesc() {
        return sdesc;
    }
    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }
}
