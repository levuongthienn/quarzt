/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.qrcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.annotation.In;
import vn.vnpay.commons.beans.FileBean;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "QRCodeUpdateQrReq", description = "Update Qrcode Request")
public class QRCodeUpdateQrReq {

    @ApiModelProperty(value = "Qrcode id", required = true)
    @NotNull
    private int qrcodeId;

    @ApiModelProperty(value = "Tên sản phẩm")
    @NotNull
    @Size(max = 19, message = "Tối đa 19 ký tự.")
    @Pattern(regexp = "^[0-9a-zA-Z\\s]*$", message = "Chỉ nhập chữ tiếng việt không dấu và số.Cho phép nhập tối đa 19 ký tự.")
    private String productName;

    @ApiModelProperty(value = "Giá tiền")
//    @Pattern(regexp = "^[0-9]{0,10}$", message = "Cho phép nhập tối đa 10 ký tự, không tính dấu phẩy.")
//    @Size(min= 0, message = "Số tiền không nhập giá trị âm.")
    private long amount; //So tien * 100

    @ApiModelProperty(value = "Loại tiền", required = true)
    @NotNull
    private String ccyCode;

    @ApiModelProperty(value = "Ghi chú")
    @Size(max = 19, message = "Tối đa 19 ký tự.")
    @Pattern(regexp = "^[0-9a-zA-Z\\s]*$", message = "Cho phép nhập số và ký tự không dấu. Tối đa 19 ký tự.")
    private String note;

    @ApiModelProperty(value = "Thời hạn Qrcode. Format: dd/MM/yyyy HH:mm:ss")
    @NotNull
    private String expireDate;

    @ApiModelProperty(value = "Loại Qr. Qr sản phẩm: 02, QR termianl: 03", required = true, example = "02")
    @In(values = {"01", "02", "03", "04"})
    @NotNull
    private String payType;

    @ApiModelProperty(notes = "Hình ảnh")
    @NotNull
    private FileBean image;

    @ApiModelProperty(value = "Data Qrcode", example = "null")
//    @NotNull
    private String dataQr;
}
