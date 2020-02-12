package com.example.Example.java;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "clientUserIdStr",
        "inviteCode",
        "status",
        "inviteUrl",
        "userId"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("clientUserIdStr")
    private String clientUserIdStr;
    @JsonProperty("inviteCode")
    private String inviteCode;
    @JsonProperty("status")
    private String status;
    @JsonProperty("inviteUrl")
    private String inviteUrl;
    @JsonProperty("userId")
    private Integer userId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("clientUserIdStr")
    public String getClientUserIdStr() {
        return clientUserIdStr;
    }

    @JsonProperty("clientUserIdStr")
    public void setClientUserIdStr(String clientUserIdStr) {
        this.clientUserIdStr = clientUserIdStr;
    }

    @JsonProperty("inviteCode")
    public String getInviteCode() {
        return inviteCode;
    }

    @JsonProperty("inviteCode")
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("inviteUrl")
    public String getInviteUrl() {
        return inviteUrl;
    }

    @JsonProperty("inviteUrl")
    public void setInviteUrl(String inviteUrl) {
        this.inviteUrl = inviteUrl;
    }

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
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