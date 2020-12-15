package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@ToString(includeFieldNames = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Data Response report merchant type", description = "Dữ liệu tìm kiếm báo cáo theo loại hình kinh doanh")
public class ReportMerchantTypeRes extends DataSearchRes {

    @ApiModelProperty(value = "Tổng số terminal")
    private Long totalTid;

    @ApiModelProperty(value = "Tổng số merchant")
    private Long totalMid;

    @ApiModelProperty(value = "Tổng số giao dịch")
    private Long totalTran;

    @Builder(builderMethodName = "childBuilder")
    public ReportMerchantTypeRes(Integer totalRow, Long totalAmount, Long totalRealAmount, long totalMid, long totalTid, long totalTran, Object data) {
        super(totalRow, totalAmount, totalRealAmount, data);
        this.totalMid = totalMid;
        this.totalTid = totalTid;
        this.totalTran = totalTran;
    }


    public static ReportMerchantTypeRes of(Integer totalRow, long totalAmount, long totalRealAmount, long totalMid, long totalTid, long totalTran, Object data) {
        return ReportMerchantTypeRes.childBuilder()
                .totalRow(totalRow)
                .totalAmount(totalAmount)
                .totalRealAmount(totalRealAmount)
                .totalMid(totalMid)
                .totalTid(totalTid)
                .totalTran(totalTran)
                .data(data)
                .build();
    }

//    public static void main(String[] args) {
//        System.out.println(ReportMerchantTypeRes.of(1,2,3,4,5,6));
//    }

}
