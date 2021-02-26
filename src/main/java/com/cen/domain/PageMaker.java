package com.cen.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageMaker {
	
	private int totalCount;	// sql의 결과로 나온 데이터의 전체 갯수
	private int startPage;	
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 5; // 화면에 보여지는 페이지 번호의 숫자(아래 막대기)
	
	private Criteria cri;
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}//init
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {

	    endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

	    startPage = (endPage - displayPageNum) + 1;

	    int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

	    if (endPage > tempEndPage) {
	      endPage = tempEndPage;
	    }

	    prev = startPage == 1 ? false : true;

	    next = endPage * cri.getPerPageNum() >= totalCount ? false : true;

	  }
	
	public String makeQuery(int page) {

	    UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
	        .queryParam("perPageNum", cri.getPerPageNum()).build();

	    return uriComponents.toUriString();
	  }
}
