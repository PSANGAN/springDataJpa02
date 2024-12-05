package com.pcgs.springDataJpa;

import com.pcgs.springDataJpa.entity.Student;
import com.pcgs.springDataJpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
		"spring.jpa.hibernate.ddl-auto=validate"
})
class SpringDataJpaApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCrud() {
		//Create
		Student student = new Student("Alisa Simmons", "2022AN50123");
		Student returnedStudent = studentRepository.save(student);
		assertNotNull(returnedStudent.getId());

		//Update
		returnedStudent.setName("Alissa Simmons");
		Student updatedStudent = studentRepository.save(returnedStudent);
		assertEquals("Alissa Simmons", updatedStudent.getName());

		//Read
		Student foundStudent = studentRepository.findById(1L).get();
		assertEquals(1L, foundStudent.getId());

		//Delete
		studentRepository.delete(foundStudent);
		assertFalse(studentRepository.existsById(1L));
	}

}
