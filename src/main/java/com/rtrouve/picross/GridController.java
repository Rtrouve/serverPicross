package com.rtrouve.picross;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GridController {
	GridRepository repo;
	
	public GridController(GridRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/grid")
	public ResponseEntity<List<Grid>> get(){
		return new ResponseEntity<List<Grid>>(this.repo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/grid/{id}")
	public ResponseEntity<Grid> getById(@PathVariable Long id){
		return new ResponseEntity<Grid>(this.repo.findById(id).get(), HttpStatus.OK);
	}
	
	@PostMapping("/grid")
	public ResponseEntity<Grid> create(@RequestBody Grid grid){
		repo.save(grid);
	}
}
