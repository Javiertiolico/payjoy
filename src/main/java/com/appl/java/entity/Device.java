
package com.appl.java.entity;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "phoneNumber",
    "simNumber",
    "imei",
    "family",
    "model"
})
@Generated("jsonschema2pojo")
public class Device {

    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("simNumber")
    private String simNumber;
    @JsonProperty("imei")
    private String imei;
    @JsonProperty("family")
    private Family family;
    @JsonProperty("model")
    private Model model;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("simNumber")
    public String getSimNumber() {
        return simNumber;
    }

    @JsonProperty("simNumber")
    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    @JsonProperty("imei")
    public String getImei() {
        return imei;
    }

    @JsonProperty("imei")
    public void setImei(String imei) {
        this.imei = imei;
    }

    @JsonProperty("family")
    public Family getFamily() {
        return family;
    }

    @JsonProperty("family")
    public void setFamily(Family family) {
        this.family = family;
    }

    @JsonProperty("model")
    public Model getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(Model model) {
        this.model = model;
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
