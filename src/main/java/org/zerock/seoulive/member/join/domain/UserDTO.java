package org.zerock.seoulive.member.join.domain;

import lombok.Data;


@Data
public class UserDTO {
    private String userEmail;
    private String userPassword;
    private String userNickName;
    private String birthDate;
    private String userGender;
    private String userIntroduction;
    private String profileImg;


} // end class
