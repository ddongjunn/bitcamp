package bit.com.a.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsParam {
	private String choice;
	private String search;
	private int pageNumber;
	
	private int start;
	private int end;
}
