package com.rtrouve.picross;

import com.rtrouve.picross.bean.Grid;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PicrossApplication {

	Integer[][] SOL_GRID_1 = new Integer[][] {
		 new Integer[] {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
		 new Integer[] {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
		 new Integer[] {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
		 new Integer[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
		 new Integer[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		 new Integer[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
		 new Integer[] {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
		 new Integer[] {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
		 new Integer[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
		 new Integer[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		 new Integer[] {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
		 new Integer[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		 new Integer[] {0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0},
		 new Integer[] {0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0},
		 new Integer[] {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
	};
	
	Integer[][] COL_GRID_1 = new Integer[][] {
		 new Integer[] {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
		 new Integer[] {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
		 new Integer[] {0, 0, 2, 2, 2, 2, 3, 3, 3, 2, 3, 0, 0, 0, 0},
		 new Integer[] {0, 2, 2, 3, 2, 3, 3, 3, 3, 2, 3, 3, 3, 3, 0},
		 new Integer[] {0, 2, 2, 3, 2, 2, 3, 3, 3, 3, 2, 3, 3, 3, 3},
		 new Integer[] {0, 2, 2, 2, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 0},
		 new Integer[] {0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0},
		 new Integer[] {0, 0, 2, 2, 2, 1, 2, 2, 2, 2, 2, 0, 0, 0, 0},
		 new Integer[] {0, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 0},
		 new Integer[] {2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2},
		 new Integer[] {3, 3, 3, 2, 1, 0, 1, 1, 1, 1, 0, 1, 1, 3, 3},
		 new Integer[] {3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3},
		 new Integer[] {0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0},
		 new Integer[] {0, 2, 2, 2, 2, 2, 0, 0, 0, 2, 2, 2, 2, 2, 0},
		 new Integer[] {2, 2, 2, 2, 2, 2, 0, 0, 0, 2, 2, 2, 2, 2, 2},
	};

	Integer[][] SOL_GRID_2 = new Integer[][] {
		 new Integer[] {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
		 new Integer[] {1, 1, 0, 1, 1, 0, 0, 0, 1, 1},
		 new Integer[] {0, 1, 1, 0, 1, 1, 1, 1, 1, 0},
		 new Integer[] {0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
		 new Integer[] {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
		 new Integer[] {0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
		 new Integer[] {0, 1, 0, 1, 1, 0, 0, 0, 1, 1},
		 new Integer[] {0, 1, 1, 0, 0, 0, 1, 0, 0, 0},
		 new Integer[] {0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
		 new Integer[] {0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
	};
	
	Integer[][] COL_GRID_2 = new Integer[][] {
		 new Integer[] {9, 3, 3, 9, 0, 0, 0, 0, 0, 9},
		 new Integer[] {9, 9, 3, 9, 9, 0, 0, 0, 9, 9},
		 new Integer[] {0, 9, 9, 3, 9, 9, 9, 9, 9, 3},
		 new Integer[] {0, 0, 9, 9, 3, 3, 3, 3, 3, 9},
		 new Integer[] {0, 0, 9, 3, 3, 3, 3, 3, 3, 3},
		 new Integer[] {0, 0, 9, 3, 9, 3, 3, 3, 3, 9},
		 new Integer[] {0, 9, 3, 9, 9, 3, 3, 3, 9, 9},
		 new Integer[] {0, 1, 1, 3, 3, 3, 9, 3, 3, 3},
		 new Integer[] {0, 1, 1, 3, 3, 9, 9, 9, 3, 3},
		 new Integer[] {0, 0, 9, 9, 3, 3, 3, 3, 3, 9},
	};
	
	public static void main(String[] args) {
		SpringApplication.run(PicrossApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner init(GridRepository repo) {
		return args -> {
			
			Grid grid_1 = new Grid();
			grid_1.setSolution(SOL_GRID_1);
			grid_1.setColor(COL_GRID_1);
			grid_1.setSize(15);
			grid_1.setDifficulty(2);
			repo.save(grid_1);
			
			Grid grid_2 = new Grid();
			grid_2.setSolution(SOL_GRID_2);
			grid_2.setColor(COL_GRID_2);
			grid_2.setSize(10);
			grid_2.setDifficulty(2);
			repo.save(grid_2);
			
			for(int nb = 2; nb < 10; nb++) {
				int size = 5;
				Grid grid = new Grid();
				int state;
				Integer[][] sol = new Integer[size][size];
				Integer[][] col = new Integer[size][size];
				//String color;
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						state = (int) Math.floor(Math.random() * 2);
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
