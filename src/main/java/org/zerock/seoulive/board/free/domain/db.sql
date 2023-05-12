SELECT *
FROM
    TBL_FREE
ORDER BY
    SEQ desc;

SELECT *
FROM TBL_FREE
WHERE seq=1;




INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)
VALUES (1, '이동영', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);

INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)
VALUES (2, '이동영2', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);
INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)
VALUES (3, '이동영3', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);
INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)
VALUES (4, '이동영4', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);
INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)
VALUES (5, '이동영5', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);
INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)
VALUES (6, '이동영6', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);
INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)
VALUES (7, '이동영7', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);
INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)
VALUES (8, '이동영8', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);
INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)
VALUES (9, '이동영9', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 100);
INSERT INTO tbl_free (seq, writer, category, title, content, modify_date, total_count)
VALUES (10, '이동영1', '카테고리', '공지사항', '공지사항 입니다.', null, 100);

INSERT INTO tbl_free (writer, category, title, content, total_count)
VALUES ('이동영', '카테고리', '공지사항', '공지사항 입니다.',null, 100);


commit;