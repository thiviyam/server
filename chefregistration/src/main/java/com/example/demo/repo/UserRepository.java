package com.example.demo.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Alltable;
import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
  List<User> findById(long Id);
  
  @Query("from User")
  public List<User> getall();
  
  @Query("select COALESCE(id,0) from User where email = ?1")
  public Long checkloginemail(String email);
  
  @Query("select password from User where email = ?1")
  public String checkloginpwd(String email);

  @Query("select user_name from User where email = ?1 and password = ?2")
  public String getId(String email, String password);
  
  @Query("select user_name from User where email = ?1")
  public String getnamefromemail(String email);
  
  @Query("select user_name from User where password = ?1")
  public String getnamefrompwd( String password);
  
  @Query("from User where email = ?1")
  public List<User> getuser( String email);
}