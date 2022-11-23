package net.e4net.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class JoinDto {
    @NonNull
    private String membId;
    @NonNull
    private String membPw;
    @NonNull
    private String membNm;

    private String mobileNo;
    private String emailAddr;
    private String zipCd;
    private String zipAddr;
    private String detailAddr;
}
