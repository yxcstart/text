package com.hit.text.entity;

/**
 * @author yang
 * @create 2021-09-09 9:28
 */

public class SQLStatement {
    private int id;
    private String time;
    private String ip;
    private int port;
    private String statement;

    public SQLStatement() {
    }

    public SQLStatement(String time, String ip, int port, String statement) {
        this.time = time;
        this.ip = ip;
        this.port = port;
        this.statement = statement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
