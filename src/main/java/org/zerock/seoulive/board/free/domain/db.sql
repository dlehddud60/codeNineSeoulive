SELECT *
FROM
    TBL_FREE
ORDER BY
    SEQ desc;

SELECT *
FROM TBL_FREE
WHERE seq=1;

UPDATE TBL_FREE set total_count=total_count+1 where seq=1;


UPDATE TBL_FREE set title='공지사항',writer='이동영',content='안녕하세요 저는 이동영 이라고 합니다.',category='category2',modify_date=SYSDATE where seq=4;

-- CREATE TABLE tbl_free (
--   seq	      NUMBER(8)		 NOT NULL,
--   writer	  VARCHAR2(50)	 NOT NULL,
--   category	  VARCHAR2(20)	 NOT NULL,
--   title	       VARCHAR2(200)		 NOT NULL,
--   content	  VARCHAR2(2000) NOT NULL,
--   write_date	  SYSDATE(4) SYSDATE,
--   modify_date	  DATE NULL,
--   total_count	  NUMBER(8)		DEFAULT 0
-- );

CREATE TABLE tbl_free (
                          seq	        NUMBER(8)  PRIMARY KEY,
                          writer	    VARCHAR2(50)	 NOT NULL,
                          category	  VARCHAR2(20)	 NOT NULL,
                          title	      VARCHAR2(200)	 NOT NULL,
                          content	    VARCHAR2(2000) NOT NULL,
                          write_date	DATE DEFAULT SYSDATE,
                          modify_date	DATE NULL,
                          total_count	NUMBER(8)		 DEFAULT 0

);
CREATE SEQUENCE seq_tbl_free START WITH 1 INCREMENT BY 1;

ALTER TABLE tbl_free ADD CONSTRAINT "PK_TBL_FREE" PRIMARY KEY (
                                                               seq
    );




drop table TBL_FREE;


INSERT INTO tbl_free (seq, writer, category, title, content, write_date, total_count)
VALUES (seq.nextval, '관리자', '카테고리', '공지사항', '공지사항 입니다.', sysdate);



INSERT INTO tbl_free (writer, category, title, content, total_count)
VALUES ('이동영', '카테고리', '공지사항', '공지사항 입니다.',null, 100);

DROP SEQUENCE seq_tbl_free;



CREATE SEQUENCE seq_tbl_free START WITH 1 INCREMENT BY 1 MAXVALUE 10000 CYCLE NOCACHE;

commit;