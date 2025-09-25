//we define query here

package com.restAPI.learningRestAPI.repository;
import com.restAPI.learningRestAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {    // <Entity , id type>


}
