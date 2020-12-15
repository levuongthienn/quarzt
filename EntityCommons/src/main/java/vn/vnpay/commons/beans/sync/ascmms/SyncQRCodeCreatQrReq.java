/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.sync.ascmms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.vnpay.commons.annotation.In;
import vn.vnpay.commons.beans.FileBean;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "QRCodeCreatQrReq", description = "Creat Qrcode Request")
public class SyncQRCodeCreatQrReq {
    @ApiModelProperty(value = "Mã merchant", required = true)
    @NotNull
    private String merchantCode;// Ma merchant
    
    @ApiModelProperty(value = "Mã điểm bán", required = true)
    @NotNull
    private String terminalId;// Diem thu
    
    @ApiModelProperty(value = "Mã sản phẩm")
    @NotNull
    @Size(max= 13, message = "Tối đa 13 ký tự.")
    @Pattern(regexp = "^[0-9A-Z]*$", message = "Chỉ nhập chữ tiếng việt in hoa không dấu và số.Cho phép nhập tối đa 13 ký tự.")
    private String productId; //Ma San pham
    
    @ApiModelProperty(value = "Tên sản phẩm")
    @NotNull
    @Size(max= 19, message = "Tối đa 19 ký tự.")
    @Pattern(regexp = "^[0-9a-zA-Z\\s]*$", message = "Chỉ nhập chữ tiếng việt không dấu và số.Cho phép nhập tối đa 19 ký tự.")
    private String productName;
    
//    @ApiModelProperty(value = "Mã master merchant")
//    @NotNull
//    private String masterMerCode;
    
    @ApiModelProperty(value = "Loại Qr. Qr SP: 02, QR terminal: 03", required = true, example = "02")
    @In(values = {"01","02","03","04"})
    @NotNull
    private String payType; // Kieu thanh toán
    
    @ApiModelProperty(value = "Giá tiền")
//    @Pattern(regexp = "^[0-9]{0,10}$", message = "Cho phép nhập tối đa 10 ký tự, không tính dấu phẩy.")
//    @Size(min= 0, max=10, message = "Số tiền không nhập giá trị âm.")
    private long amount; //So tien * 100
    
    @ApiModelProperty(value = "Ngày hết hạn, format: dd/MM/yyyy HH:mm:ss")
    @NotNull
    private String expDate;//Ngay het han
    
    @ApiModelProperty(value = "Ghi chú")
    @Size(max= 19, message = "Tối đa 19 ký tự.")
    @Pattern(regexp = "^[0-9a-zA-Z\\s]*$", message = "Cho phép nhập số và ký tự không dấu. Tối đa 19 ký tự.")
    private String desc; // mo ta 
    
    @ApiModelProperty(value = "Người tạo", required = true)
    @NotNull
    private String creator;
    
    @ApiModelProperty(notes = "Hình ảnh")
    @NotNull
    private FileBean image;
    
}
