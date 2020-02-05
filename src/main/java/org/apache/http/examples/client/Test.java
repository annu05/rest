package org.apache.http.examples.client;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Test {

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



}