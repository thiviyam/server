

////// this is for ALLTABLE DATA /////////////////////////////

package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Alltable;

public interface Cheftable extends JpaRepository<Alltable, Integer>
{
	
	  @Query("from Alltable")
      public List<Alltable> getall();
	
	  @Query("select email from Alltable where chefid = ?1")
      public String getchefid(long id);
	  
	  @Query("select chefid from Alltable where email = ?1")
	  public Integer checkloginemail(String email);
	  
	  @Query("select password from Alltable where email = ?1")
	  public String checkloginpwd(String email);
	  
	  @Query("select user_name from User where email = ?1 and password = ?2")
	  public String getId(String email, String password);
	  
	  @Query("select name from Alltable where email = ?1")
	  public String getnamefromemail(String email);
	  
	  @Query("select name from Alltable where password = ?1")
	  public String getnamefrompwd( String password);
}
