package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller //이클래스가 컨트롤러구나 하는 식별의 의미
public class BoardController { // =new BoardController (우리가 하지 않지만 스프링컨테이너라는 메모리안에 보드컨트롤러라는 객체가 만들어짐.
	

	@RequestMapping("/")
	public String main() {
		return "main";
	}
	

}
 