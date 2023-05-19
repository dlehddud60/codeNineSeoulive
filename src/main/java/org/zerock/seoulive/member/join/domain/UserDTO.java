package org.zerock.seoulive.member.join.domain;

import lombok.Data;


@Data
public class UserDTO {
    private String email;
    private String password;
    private String nickName;
    private String birthDate;
    private String gender;
    private String introduction;
    private String joinDate;
    private String profileImg;

    private boolean rememberMe;


} // end class
