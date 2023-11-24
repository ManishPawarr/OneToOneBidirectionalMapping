package com.example.OneToOneMapping.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OneToOneMapping.Entity.Instructor;
import com.example.OneToOneMapping.Entity.InstructorDetails;
import com.example.OneToOneMapping.Repository.InstructorRepository;

@RestController
public class InstructorController {

	@Autowired
	private InstructorRepository iRepo;

	@GetMapping("/get")
	public List<Instructor> getList() {
		if (iRepo.findAll().isEmpty()) {
			System.out.println("Nothing in list");
			return null;
		} else {
			return iRepo.findAll();
		}
	}

	@PostMapping("/post")
	public ResponseEntity<String> post(@RequestBody Instructor instructor) {
		if (iRepo.save(instructor) != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Added Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not added, Some error occurred");
		}
	}

	@GetMapping("/get/{id}")
	public Optional<Instructor> getInstructor(@PathVariable Long id) {
		if (iRepo.findById(id) != null) {
			return iRepo.findById(id);
		} else {
			return Optional.empty();
		}
	}
//
//	@PutMapping("/put/{id}")
//	public ResponseEntity<Map<String, String>> update(@PathVariable Long id, @RequestBody Instructor newInstructor) {
//		Optional<Instructor> instructor = iRepo.findById(id);
//		Map<String, String> response = new HashMap<>();
//		if (instructor.isPresent()) {
//			Instructor currentInstructor = instructor.get();
//
//			if (newInstructor.getName() != null) {
//				currentInstructor.setName(newInstructor.getName());
//			}
//			if (newInstructor.getDate() != null) {
//				currentInstructor.setDate(newInstructor.getDate());
//			}
//			if (newInstructor.getEmail() != null) {
//				currentInstructor.setEmail(newInstructor.getEmail());
//			}
//
//			if (newInstructor.getInstructor() != null) {
//				InstructorDetails currentDetails = currentInstructor.getInstructor();
//				InstructorDetails newDetails = newInstructor.getInstructor();
//
//				if (newDetails.getHobby() != null) {
//					currentDetails.setHobby(newDetails.getHobby());
//				}
//				if (newDetails.getChannel() != null) {
//					currentDetails.setChannel(newDetails.getChannel());
//				}
//			}
//			iRepo.save(currentInstructor);
//			response.put("message", "Updated Successfully");
//			response.put("Response", "success");
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
//		} else {
//			response.put("message", "Not updated, No user present with id : " + id);
//			response.put("Response", "Error");
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
//		}
//	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		iRepo.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
	}

//	@DeleteMapping("/delete/detail/{id}")
//	public ResponseEntity<String> deleteDetail(@PathVariable Long id) {
//		Instructor instructor = iRepo.findById(id).get();
//		if (instructor.getInstructor() != null) {
//			instructor.setInstructor(null);
//			iRepo.save(instructor);
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
//		} else {
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cannot Delete");
//		}
//	}
}
