package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Todo implements Serializable { 

	 private String title;  
	    private String detail;
	    private boolean complete;
	    private LocalDateTime regDate;

	    public Todo(String title, String detail) {
	        this.title = title;
	        this.detail = detail;
	        this.complete = false;
	        this.regDate = LocalDateTime.now();
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDetail() {
	        return detail;
	    }

	    public void setDetail(String detail) {
	        this.detail = detail;
	    }

	    public boolean isCompleted() {
	        return complete;
	    }

	    public void setComplete(boolean complete) {
	        this.complete = complete;
	    }

	    public LocalDateTime getRegDate() {
	        return regDate;
	    }

	    public String getFormattedDate() {
	        return String.format("%4d-%2d-%2d %2d:%2d:%2d",
	                regDate.getYear(), regDate.getMonthValue(), regDate.getDayOfMonth(),
	                regDate.getHour(), regDate.getMinute(), regDate.getSecond());
	    }
	
	
	// java.time 패키지
	// LocalDateTime : 날짜, 시간을 나타내는 클래스
	// LocalDateTime.now() : 현재 시간 반환
		
	// 날짜와 시간을 원하는 포맷으로 출력하기
	//  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	//  String formattedDateTime = currentDateTime.format(formatter);
	
}
