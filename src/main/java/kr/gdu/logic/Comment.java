package kr.gdu.logic;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Comment {
	private int num;
	private int seq;
	
	@NotEmpty(message="작성자를 입력")
	private String writer;
	
	@NotEmpty(message="비밀번호를 입력")
	private String pass;
	
	@NotEmpty(message="내용을 입력")
	private String content;
	
	private Date regdate;

}
