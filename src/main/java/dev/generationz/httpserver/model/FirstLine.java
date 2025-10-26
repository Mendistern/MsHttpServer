package dev.generationz.httpserver.model;

import dev.generationz.httpserver.model.enums.MsMethod;

public class FirstLine {
    private MsMethod method;
    private String location;
    private String version;

    public MsMethod getMethod() {
        return method;
    }

    public void setMethod(MsMethod method) {
        this.method = method;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "FirstLine{" +
                "method=" + method +
                ", location='" + location + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
