package org.zerock.seoulive.member.join.domain;

import lombok.Value;
import lombok.extern.log4j.Log4j2;

// 1. VO 패턴에 따라 클래스를 설계
// 2. Target Table의 1개의 행을 읽기전용(Immutable)으로 저장가능한 필드 설계
// 3. Lombok annotation 활용 -> Clean Class 설계
// 4. VO 패턴은
//    1) 테이블의 명세(스키마, DESC명령)에 나온 컬럼 순서대로 필드 선언
//    2) 테이블의 각 컬럼 타입은 호환가능한 자바 타입으로 선언
//    3) 모든 필드(각 컬럼)를 매개변수로 가지는 생성자 선언
//    4) getter 메소드를 통해서 필드의 값을 READ만 할 수 있게 함

@Value
//@Getter(AccessLevel.PUBLIC) // 각 필드별로 Getter 메소드 자동생성 (접근제한자 조절이 가능)
//@AllArgsConstructor     // 모든 필드를 순서대로 매개변수로 가지는 생성자 선언
//@EqualsAndHashCode      // 중복판단 이중 알고리즘에 맞게 자동으로 오버라이딩 (Set, Map 컬렉션에 대응)
//@ToString
@Log4j2
public class UserVO {
    private String email;
    private String password;
    private String nickName;
    private String birthDate;
    private String gender;
    private String introduction;
    private String joinDate;
    private String profileImg;

    public UserDTO toDTO() {
        log.trace("toDTO() invoked");

        UserDTO dto = new UserDTO();
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setNickName(nickName);
        dto.setBirthDate(birthDate);
        dto.setGender(gender);
        dto.setIntroduction(introduction);
        dto.setProfileImg(profileImg);

        log.info("\t + dto : {}", dto);

        return dto;
    } // toDTO

} // end class
