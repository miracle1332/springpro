package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@RequestMapping("/board")
@RestController //레스트컨트롤러 어노테이션을 붙이면 @ResponseBody를 생략할 수 있다.
//레스트콘트롤러는 ajax통신을 할때 쓰는 컨트롤러라고 보면 된다.
//@ResponseBody(JSON응답)
public class BoardRestController { 
		
	@Autowired
	BoardMapper boardMapper;
	
	@GetMapping("/all")
	public List<Board> boardList() {
		List<Board> list = boardMapper.getLists();
		return list; //객체를 json데이터 형식으로 변환해서 리턴(응답)하겠다.
		//@ResponseBody 이객체를 쓰면 json데이터포맷으로 변환해줌.
		//*****@ResponseBody -> jackson-databind API를 pom.xml에 추가<dependency>해야함!!!
		//뷰의 형태가 아닌 json데이터 포맷의 형태로 응답함.//
	}
	
	//@RequestMapping("/boardInsert.do")
	@PostMapping("/new")
	public void boardInsert(Board vo) {
		boardMapper.boardInsert(vo); //등록성공
		//void지만 @responsebody를 사용하여 success하면 제어권이 main.jsp의 loadList로 넘어가서 loadList가 보여짐
	}
	
	@DeleteMapping("/{idx}")
	public void boardDelete(@PathVariable("idx") int idx) {
		boardMapper.boardDelete(idx);
	}
	
	@PutMapping("/update")
	public void boardUpdate(@RequestBody Board vo) {
		boardMapper.boardUpdate(vo);
	}
	
	@GetMapping("/{idx}")
	public Board boardContent(@PathVariable("idx") int idx) {
		Board vo = boardMapper.boardContent(idx);
		return vo; //vo -> JSON
	}
	
	@PutMapping("/count/{idx}")
	public Board boardCount(@PathVariable("idx") int idx) {
		boardMapper.boardCount(idx);
		Board vo = boardMapper.boardContent(idx);
		return vo;
	}
}
