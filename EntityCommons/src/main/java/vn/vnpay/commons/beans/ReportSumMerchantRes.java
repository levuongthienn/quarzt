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
@ApiModel(value = "Data Response report merchant type", description = "Dữ liệu tìm kiếm báo cáo tổng hợp theo merchant")
public class ReportSumMerchantRes extends DataSearchRes {

    @ApiModelProperty(value = "Tổng số giao dịch")
    private Long totalTran;

    @Builder(builderMethodName = "childBuilder")
    public ReportSumMerchantRes(Integer totalRow, Long totalAmount, Long totalRealAmount, long totalTran, Object data) {
        super(totalRow, totalAmount, totalRealAmount, data);
        this.totalTran = totalTran;
    }


    public static ReportSumMerchantRes of(Integer totalRow, long totalAmount, long totalRealAmount, long totalTran, Object data) {
        return ReportSumMerchantRes.childBuilder()
                .totalRow(totalRow)
                .totalAmount(totalAmount)
                .totalRealAmount(totalRealAmount)
                .totalTran(totalTran)
                .data(data)
                .build();
    }

//    public static void main(String[] args) {
//        System.out.println(ReportMerchantTypeRes.of(1,2,3,4,5,6));
//    }

}
