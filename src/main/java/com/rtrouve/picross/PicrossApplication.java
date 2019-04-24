package com.rtrouve.picross;

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
			for(int nb = 0; nb < 10; nb++) {
				int size = 5;
				Grid grid = new Grid();
				int state;
				Integer[][] sol = new Integer[size][size];
				Integer[][] col = new Integer[size][size];
				//String color;
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						state = (int) Math.floor(Math.random() * 2);
						/*color = state == 0 ? "white" : "black";
						Case inter = new Case();
						inter.setState(state);
						inter.setColor(color);*/
						sol[i][j] = state;
						col[i][j] = state == 0 ? 0 : ((int) Math.floor(Math.random() * 2)) == 0 ? 1 : 2;
					}
				}
				grid.setSolution(sol);
				grid.setColor(col);
				grid.setSize(size);
				grid.setDifficulty(5);
				repo.save(grid);
			}
		};
	}

}
