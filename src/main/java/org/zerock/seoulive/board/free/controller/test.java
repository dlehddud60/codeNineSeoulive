package org.zerock.seoulive.board.free.controller;

public class test {
    public static void main(String[] args) {


        for (int i = 1; i <= 100; i++) {
            System.out.println("INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)\n" +
                    "VALUES ("+i+", '이동영"+i+"', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);");
        }
    }
}
