package com.example.OneToOneMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OneToOneMapping.Entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
