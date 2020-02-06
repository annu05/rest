package org.apache.http.examples.client;

import com.fasterxml.jackson.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "clientUserIdStr",
        "inviteCode",
        "status",
        "inviteUrl",
        "userId"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Test {

    @JsonProperty("uId")
    private String uId;
    @JsonProperty("clientContext")
    private String clientContext;
    @JsonProperty("location")
    private Test location;
    @JsonProperty("locationName")
    private String locationName;

        @JsonProperty("clientUserIdStr")
        private String clientUserIdStr;
        @JsonProperty("inviteCode")
        private String inviteCode;
        @JsonProperty("status")
        private String status2;
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
            return status2;
        }

        @JsonProperty("status")
        public void setStatus(String status) {
            this.status2 = status2;
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
    @JsonProperty("uId")
    public String getUId() {
        return uId;
    }
    @JsonProperty("clientContext")
    public String getClientContext() {
        return clientContext;
    }
    @JsonProperty("location")
    public Test getLocation() {
        return location;
    }



    @JsonProperty("users")
    private List<Test> users = null;
    @JsonProperty("users")
    public List<Test> getUsers() {
        return users;
    }


}