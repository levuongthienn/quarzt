/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.qrcode.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "QRCodeDataBean", description = "Data qrcode")
public class QRCodeDataBean {
    @ApiModelProperty(value = "Id tự tăng")
    private long id;
    
    @ApiModelProperty(value = "Mã merchant")
    private String merchantCode;
    
    @ApiModelProperty(value = "Tên merchant")
    private String merchantName;
    
    @ApiModelProperty(value = "Mã chi nhánh merchant")
    private String branchMidId;
    
    @ApiModelProperty(value = "Tên chi nhánh merchant")
    private String branchMidName;
    
    @ApiModelProperty(value = "Mã điểm bán")
    private String terminalID;
    
    @ApiModelProperty(value = "Tên điểm bán")
    private String terminalName;
    
    @ApiModelProperty(value = "Mã mcc quốc tê")
    private String merchantType;
    
    @ApiModelProperty(value = "Mã master merchant")
    private String masterMerchant;
    
    @ApiModelProperty(value = "Mã dịch vụ")
    private String serviceCode;
    
    @ApiModelProperty(value = "Mã quốc gia")
    private String countryCode;
    
    @ApiModelProperty(value = "Mã sản phẩm")
    private String productID;
    
    @ApiModelProperty(value = "Tên sản phẩm")
    private String productName;
    
    @ApiModelProperty(value = "Số tiền")
    private String amount;
    
    @ApiModelProperty(value = "Loại tiền")
    private String ccy;
    
    @ApiModelProperty(value = "Mô tả")
    private String note;

    @ApiModelProperty(value = "Loại thanh toán")
    private String payType;
    
    @ApiModelProperty(value = "Số tiền tipAndFee")
    private String tipAndFee;
    
    @ApiModelProperty(value = "Thời hạn qrcode")
    private String expireDate;
    
    @ApiModelProperty(value = "Ngày tạo")
    private String createdDate;
    
    @ApiModelProperty(value = "Người tạo")
    private String creator;

    @ApiModelProperty(value = "Url")
    private String url;

    @ApiModelProperty(value = "Trạng thái. 1: Hoat dong, -1: Tam khoa, 2: Het han")
    private int status;
    
    @ApiModelProperty(value = "Tên hình ảnh")
    private String imageName;
    
    @ApiModelProperty(value = "Đường dẫn hình ảnh")
    private String imageUrl;
    
    @ApiModelProperty(value = "Data qrcode")
    private String qrData;

    @ApiModelProperty(value = "Mã thành phố")
    private String merchantCity;
    
    @ApiModelProperty(value = "Mã bưu điện")
    private String pinCode;
    
    @ApiModelProperty(value = "Mục đích")
    private String perpose; // muc dich
    
    @ApiModelProperty(value = "Phiên bản dữ liệu")
    private String plIndicator;
    
    @ApiModelProperty(value = "Phương thức khởi tạo")
    private String pointOfMethod;
    
    @ApiModelProperty(value = "Mã merchant unpack data qcode")
    private String merchantID;
    
    @ApiModelProperty(value = "Tên termianl unpack data qrcode")
    private String storeID;

    @ApiModelProperty(value = "Id server")
    private int serverID;

    @ApiModelProperty(value = "Loại dữ liệu")
    private int dataType;

    @ApiModelProperty(value = "Phiên bản qrcode")
    private int versionQR;
    
    @ApiModelProperty(value = "")
    private String sphere;
    
    @ApiModelProperty(value = "Mã tham chiếu")
    private String referenceID;

    //Bổ sung thông tin thẻ quốc tế.
    @ApiModelProperty(value = "Visa pan")
    private String visa;
    
    @ApiModelProperty(value = "Master pan")
    private String master;
    
    @ApiModelProperty(value = "Unionpay pan")
    private String unionPay;
    
    @ApiModelProperty(value = "Jcb pan")
    private String jcbPan;
    
    private int rowNum;
    
    @ApiModelProperty(value = "Check thời hạn qrcode. true - Hết hạn")
    private boolean checkExpire;
}
