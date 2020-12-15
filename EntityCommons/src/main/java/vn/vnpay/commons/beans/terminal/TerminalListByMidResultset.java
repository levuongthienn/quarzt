/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.terminal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//import vn.vnpay.backend.annotation.ValidatedSafeHtml;
//import vn.vnpay.backend.validategroup.CreateTerminal;

/**
 *
 * @author thanhld
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalListByMidResultset {
    private int rowNum;
    private int id;
    private String terminalId;
    private String terminalName;
    private String terminalBusinessAddress;
    private String createDate;
    private String processDate;
    private String taxCode;
    private long merchantId;
    private int status;
    private String statusClass;
    private String statusDescription;
    private int accountId;
    private String accountHolder;
    private String accountNumber;
    private String bankCode;
    private String bankName;
    private String branch;
    private String currency;
    private int accountVnmartId;
    private String accountVnmart;
    private String nameAccountVnmart;
    private int levelTerminal;

}
