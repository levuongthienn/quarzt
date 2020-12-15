/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
/**
 *
 * @author Truong
 */
@ToString
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationMcBean {
    private String merchantCode;
    private String organizationID;
    private String organizationMerchanID;
    private String organizationName;
    private boolean registed;
}
