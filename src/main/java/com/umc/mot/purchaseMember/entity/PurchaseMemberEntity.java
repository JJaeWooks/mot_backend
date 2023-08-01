package com.umc.mot.purchaseMember.entity;

import com.umc.mot.auditable.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseMemberEntity extends Auditable {
    private int purchaseMemberId; //구매자 회원 식별자

    private int id; //회원아이디

    private String name ; //회원 이름

    private String imageUrl; //회원 이메일

    private String phone; //회원 전화번호

    private String Pw; //회원 비밀번호

    private String host; // 회원 역할

    private String token; //토큰


}
