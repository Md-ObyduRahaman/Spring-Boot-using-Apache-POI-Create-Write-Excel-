package com.example.studentExcelRest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.createExcel.ExcelGenerator;
import com.example.model.Student;
import com.example.repo.StudentRepo;

@RestController
public class StudentExcelRest 
{
	@Autowired
	private StudentRepo studentRepo;

	public StudentExcelRest(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	@GetMapping("download/student.xlsx")
	public ResponseEntity<InputStreamResource> excelStudentReport() throws IOException
	{
		List<Student> list = (List<Student>)studentRepo.findAll();
		
		ByteArrayInputStream in = ExcelGenerator.studentToExcel(list);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Student.xlsx");
		return ResponseEntity
				.ok()
				.headers(headers)
				.body(new InputStreamResource(in));
	}
	
}
