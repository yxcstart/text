package com.hit.text.entity;

/**
 * @author yang
 * @create 2021-09-08 23:32
 */
public class Http {
    private int id;
    private String time;
    private String ip;
    private int port;
    private String url;
    private String protocol;
    private String connection;
    private String acceptEncoding;
    private String accept;
    private String target;

    public Http() {
    }

    public Http(String time, String ip, int port, String url, String protocol, String connection, String acceptEncoding, String accept, String target) {
        this.time = time;
        this.ip = ip;
        this.port = port;
        this.url = url;
        this.protocol = protocol;
        this.connection = connection;
        this.acceptEncoding = acceptEncoding;
        this.accept = accept;
        this.target = target;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }


    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
