package com.rtrouve.picross.controller;

import java.util.List;

import com.rtrouve.picross.GridRepository;
import com.rtrouve.picross.bean.Grid;
import com.rtrouve.picross.service.GridService;
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

import static com.rtrouve.picross.util.Constante.GRID_PATH;

@CrossOrigin
@RestController(GRID_PATH)
public class GridController {
	private GridRepository repo;
	private GridService gridService;
	
	public GridController(GridRepository repo) {
		this.repo = repo;
	}

	@GetMapping("")
	public ResponseEntity<List<Grid>> get() {
		return new ResponseEntity<List<Grid>>(this.repo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Grid> getById(@PathVariable int id) {
		try {
			return new ResponseEntity<Grid>(gridService.getGrid(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>();
		}
		//return new ResponseEntity<Grid>(this.repo.findById(id).get(), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Grid> create(@RequestBody Grid grid) {
		Grid temp =  repo.save(grid);
		return new ResponseEntity<Grid>(temp, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Grid> delete(@PathVariable Long id) {
		repo.deleteById(id);
		return new ResponseEntity<Grid>(HttpStatus.OK);
	}
}
