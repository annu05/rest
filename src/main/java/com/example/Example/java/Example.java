package com.example.Example.java;

import com.example.Example.java.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uId",
        "status",
        "clientContext",
        "expirationMillis",
        "sinceModifiedToken",
        "location",
        "users",
        "totalBatchCount",
        "totalCount",
        "batchCount"
})
public class Example {

    @JsonProperty("uId")
    private String uId;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("clientContext")
    private String clientContext;
    @JsonProperty("expirationMillis")
    private Integer expirationMillis;
    @JsonProperty("sinceModifiedToken")
    private String sinceModifiedToken;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("users")
    private List<User> users = null;
    @JsonProperty("totalBatchCount")
    private String totalBatchCount;
    @JsonProperty("totalCount")
    private Integer totalCount;
    @JsonProperty("batchCount")
    private Integer batchCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("uId")
    public String getUId() {
        return uId;
    }

    @JsonProperty("uId")
    public void setUId(String uId) {
        this.uId = uId;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("clientContext")
    public String getClientContext() {
        return clientContext;
    }

    @JsonProperty("clientContext")
    public void setClientContext(String clientContext) {
        this.clientContext = clientContext;
    }

    @JsonProperty("expirationMillis")
    public Integer getExpirationMillis() {
        return expirationMillis;
    }

    @JsonProperty("expirationMillis")
    public void setExpirationMillis(Integer expirationMillis) {
        this.expirationMillis = expirationMillis;
    }

    @JsonProperty("sinceModifiedToken")
    public String getSinceModifiedToken() {
        return sinceModifiedToken;
    }

    @JsonProperty("sinceModifiedToken")
    public void setSinceModifiedToken(String sinceModifiedToken) {
        this.sinceModifiedToken = sinceModifiedToken;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("users")
    public List<User> getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @JsonProperty("totalBatchCount")
    public String getTotalBatchCount() {
        return totalBatchCount;
    }

    @JsonProperty("totalBatchCount")
    public void setTotalBatchCount(String totalBatchCount) {
        this.totalBatchCount = totalBatchCount;
    }

    @JsonProperty("totalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("totalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("batchCount")
    public Integer getBatchCount() {
        return batchCount;
    }

    @JsonProperty("batchCount")
    public void setBatchCount(Integer batchCount) {
        this.batchCount = batchCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}