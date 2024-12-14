package org.dev.xoobackend.pojo;

public class exceptionHandle {
    private String Error;

    public exceptionHandle(String error) {
        Error = error;
    }
    public exceptionHandle() {

    }
    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }


}
