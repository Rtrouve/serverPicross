package com.rtrouve.picross;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class GridController {
	GridRepository repo;
	
	public GridController(GridRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/grid")
	public ResponseEntity<List<Grid>> get() {
		return new ResponseEntity<List<Grid>>(this.repo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/grid/{id}")
	public ResponseEntity<Grid> getById(@PathVariable Long id) {
		return new ResponseEntity<Grid>(this.repo.findById(id).get(), HttpStatus.OK);
	}
	
	@PostMapping("/grid")
	public ResponseEntity<Grid> create(@RequestBody Grid grid) {
		Grid temp =  repo.save(grid);
		return new ResponseEntity<Grid>(temp, HttpStatus.CREATED);
	}
	
	@PutMapping("/grid/{id}")
	public ResponseEntity<Grid> replace(@RequestBody Grid newGrid, @PathVariable Long id) {
		return repo.findById(id)
				.map(grid -> {
					grid.setSize(newGrid.getSize());
					grid.setDifficulty(newGrid.getDifficulty());
					return new ResponseEntity<Grid>(repo.save(grid), HttpStatus.OK);
				})
				.orElseGet(() -> {
					newGrid.setId(id);
					return new ResponseEntity<Grid>(repo.save(newGrid), HttpStatus.CREATED);
				});
	}
	
	@DeleteMapping("/grid/{id}")
	public ResponseEntity<Grid> delete(@PathVariable Long id) {
		repo.deleteById(id);
		return new ResponseEntity<Grid>(HttpStatus.OK);
	}
}
