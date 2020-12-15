/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class TerminalInfo {

    private int id;
    
    @ApiModelProperty(value = "Mã terminal")
    private String terminalId;
    
    
    private int merchantId;
    
    @ApiModelProperty(value = "Tên terminal")
    private String terminalName;
    
    @ApiModelProperty(value = "Địa chỉ đăng ký kinh doanh của terminal")
    private String terminalAddress;
    
    @ApiModelProperty(value = "Mã số thuế/CMND/DKKD")
    private String taxCode;
    
    @ApiModelProperty(value = "Website")
    private String website;
    
    @ApiModelProperty(value = "Website terminal")
    private String websiteBusiness;
    
    @ApiModelProperty(value = "Facebook")
    private String facebook;
    
    @ApiModelProperty(value = "Thông tin MCC quốc tế")
    private MerchantTypeBean mccQT;
    
    @ApiModelProperty(value = "Sản phẩm kinh doanh")
    private long businessProduct;
//    
//    @ApiModelProperty(value = "Tên MCC quốc tế")
//    private String businessProductName;
    
    @ApiModelProperty(value = "Thông tin MCC nội địa")
    private InternalMccBean mccND;
    
//    @ApiModelProperty(value = "Mã MCC nội địa")
//    private long mcc;
//    
//    @ApiModelProperty(value = "Tên MCC nội địa")
//    private String mccName;
    
    @ApiModelProperty(value = "Mô tả sản phẩm kinh doanh")
    private String productDescription;
    
    @ApiModelProperty(value = "Đăng ký dịch vụ QRCODE. (1: Đăng ký, 2: Không đăng ký)")
    private long registerQr;
    
    @ApiModelProperty(value = "Đăng ký dịch vụ Cổng thanh toán. (1: Đăng ký, 2: Không đăng ký)")
    private long registerVnpayment;
    
    @ApiModelProperty(value = "Thông tin tài khoản thụ hưởng")
    private AccEnjoymentBean accEnjoymentBean;
    
    @ApiModelProperty(value = "ID account")
    private long accountId;
//    
//    @ApiModelProperty(value = "Chủ tài khoản thụ hưởng")
//    private String nameAccEnjoyment;
//    
//    @ApiModelProperty(value = "Số tài khoản thụ hưởng")
//    private String numberAccEnjoyment;
//    
//    @ApiModelProperty(value = "Tên ngân hàng thụ hưởng")
//    private String bankNameAccEnj;
//    
//    @ApiModelProperty(value = "Mã ngân hàng")
//    private String bankCode;
//    
//    @ApiModelProperty(value = "Chi nhánh ngân hàng thụ hưởng")
//    private String branchAccEnj;
    
    @ApiModelProperty(value = "Loại tiền tệ", example = "VND")
    private String currencyCode;
    
    @ApiModelProperty(value = "Thông tin ví")
    private AccountVnmartBean accVnmart;
    
//    @ApiModelProperty(value = "Id ví vnpay")
//    private int accountVnmartId;
//    
//    @ApiModelProperty(value = "Tên ví vnpay")
//    private String accountVnmartName;
//    
//    @ApiModelProperty(value = "Số ví vnpay")
//    private String accountVnmartNumber;
    
    @ApiModelProperty(value = "Trangj thái terminal")
    private long status;
    
    @ApiModelProperty(value = "Ngày tạo")
    private String createdDate;
    
    @ApiModelProperty(value = "Ngày cập nhật")
    private String modifyDate;
    
    @ApiModelProperty(value = "Terminal đầu tiên của merchant")
    private String theFirst;
    
    @ApiModelProperty(value = "Khóa (User này đang tác động)")
    private String userLock;
    
    @ApiModelProperty(value = "Địa chỉ kinh doanh")
    private String businessAddress;
    
    @ApiModelProperty(value = "Đăng ký nhận thông báo qua SMS")
    private long registerSms;
    
    @ApiModelProperty(value = "Đăng ký nhận thông báo qua OTT")
    private long registerOtt;
    
    @ApiModelProperty(value = "User app")
    private String terminalAppUser;
    
    @ApiModelProperty(value = "Mã dịch vụ (Billing)")
    private String serviceCode;
    
    @ApiModelProperty(value = "User tạo")
    private String createUser;
    
    @ApiModelProperty(value = "Tài liệu terminal")
    private String terminalDocument;
    
    @ApiModelProperty(value = "Số thẻ visa")
    private String visaPan;
    
    @ApiModelProperty(value = "Số thẻ master")
    private String masterPan;
    
    @ApiModelProperty(value = "Số thẻ unionpay")
    private String unionpayPan;
    
    @ApiModelProperty(value = "Tên file")
    private String fileName;
    
    @ApiModelProperty(value = "Mã tình/thành phố")
    private String provinceCode;
    
    @ApiModelProperty(value = "Mã quận/huyện")
    private String districtCode;
    
    @ApiModelProperty(value = "Mã Phường/xã")
    private String wardsCode;
    
    @ApiModelProperty(value = "Số thẻ JCB")
    private String jcbPan;
//    private String twJcbPan;
//    private String ascBranch;
    
    @ApiModelProperty(value = "Số thẻ DCI")
    private String dciPan;
    
    @ApiModelProperty(value = "Phí on us")
    private long feeOnUs;
    
    @ApiModelProperty(value = "Phí off us")
    private long feeOfUs;
    
    @ApiModelProperty(value = "Cấp bậc terminal")
    private String levelTerminal;
    
    
    @ApiModelProperty(value = "Thông chi nhánh phát riển")
    private DepartmentBean departmentBean;
    
//    @ApiModelProperty(value = "Mã chi nhánh")
//    private String departmentId;
//    
//    @ApiModelProperty(value = "Tên chi nhánh")
//    private String departmentName;
    
    
    @ApiModelProperty(value = "Thông nhân viên")
    private StaffBean staffBean;
    
//    @ApiModelProperty(value = "Mã nhân viên")
//    private int staffId;
//    
//    @ApiModelProperty(value = "Tên nhân viên")
//    private String staffName;
    
    @ApiModelProperty(value = "User xử lý")
    private String processUser;
    
    @ApiModelProperty(value = "Mã lý do từ chối")
    private long deniedApproveCode;
    
    @ApiModelProperty(value = "Mô tả lý do từ chối")
    private String deniedApproveDesc;
    
    @ApiModelProperty(value = "Id cấp chi nhánh")
    private long branchTerminalId;
    
    @ApiModelProperty(value = "Tên cấp chi nhánh")
    private String branchTerminalName;
    
}
