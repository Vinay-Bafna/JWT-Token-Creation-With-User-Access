package com.logintoken.jwttoken.ExceptionHandler;

public class ResourceNotFoundException  extends RuntimeException{
    public String resourceName;
    public String  Id;
    public long uid;
    public ResourceNotFoundException(String resourceName,String Id,long uid){
        super(String.format("%s Found with %s:%d",resourceName,Id,uid));
        this.resourceName=resourceName;
        this.Id=Id;
        this.uid=uid;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
