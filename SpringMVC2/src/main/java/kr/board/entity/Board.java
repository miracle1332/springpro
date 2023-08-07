package kr.board.entity;

import lombok.Data;

//LomBok API :  자동으로 세터게터를 만듬 @Data어노테이션이 만들어준다. 눈에는 안보이지만 내부적으로 세터게터가 생김.outline을 보면 앎.
//이클립스도 lombok api와 연결이 되어있어야한다.

@Data //- LomBok API
public class Board {
	private int idx; //게시판 번호
	private String title; //게시판 제목
	private String content; //게시판 내용
	private String writer; //작성자
	private String indate; //작성일
	private int count; // 조회수
	
	//setter, getter
	
	
	
}
