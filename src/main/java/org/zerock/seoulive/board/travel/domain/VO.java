package org.zerock.seoulive.board.travel.domain;

import lombok.Value;

import java.util.Date;

@Value
public class VO {

    private Integer seq;
    private String writer;
    private String category;
    private String title;
    private String content;
    private String address;
    private Integer total;
    private Date write_Date;
    private Date modify_Date;

    public DTO toDTO() {
        DTO dto = new DTO();

        dto.setSeq(seq);
        dto.setWriter(writer);
        dto.setCategory(category);
        dto.setTitle(title);
        dto.setContent(content);
        dto.setAddress(address);
        dto.setTotal(total);

        return dto;
    }

} // end class
