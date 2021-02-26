package com.cen.domain;

public class Criteria {

  private int page;			// 현재 페이지번호
  private int perPageNum; 	// 한 페이지당 출력하는 데이터의 수 
  private int ct_num;		// 카테고리번호

  public int getCt_num() {
	return ct_num;
  }//getCt_num

  public void setCt_num(int ct_num) {
	  this.ct_num = ct_num;
  }//setCt_num
	
  public Criteria() {
	  	this.page = 1;
	  	this.perPageNum = 16;
  }//init

  public void setPage(int page) {
    if (page <= 0) {
      this.page = 1;
      return;
    }//if
    this.page = page;
  }//setPage

  public void setPerPageNum(int perPageNum) {
    if (perPageNum <= 0 || perPageNum > 100) {
      this.perPageNum = 10;
      return;
    }//if
    this.perPageNum = perPageNum;
  }//setPerPageNum

  public int getPage() {
    return page;
  }//getPage

  // method for MyBatis SQL Mapper -
  public int getPageStart() {
    return (this.page - 1) * perPageNum;
  }//getPageStart

  // method for MyBatis SQL Mapper
  public int getPerPageNum() {
    return this.perPageNum;
  }//getPerPageNum

  
}//end class
