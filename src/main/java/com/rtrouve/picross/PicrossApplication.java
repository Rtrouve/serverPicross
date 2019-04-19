package com.rtrouve.picross;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PicrossApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicrossApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner init(GridRepository repo) {
		return args -> {
			Grid grid = new Grid();
			List<List<Case>> solution = new ArrayList<List<Case>>();
			int state;
			String color;
			for(int i = 0; i < 5; i++) {
				ArrayList<Case> temp = new ArrayList<Case>();
				for(int j = 0; j < 5; j++) {
					state = (int) Math.floor(Math.random() * 2);
					color = state == 0 ? "white" : "black";
					Case inter = new Case();
					inter.setState(state);
					inter.setColor(color);
					temp.add(inter);
				}
				solution.add(temp);
			}
			
			grid.setSolution(solution);
			repo.save(grid);
		};
	}

}
