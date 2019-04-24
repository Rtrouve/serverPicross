package com.rtrouve.picross;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Grid {
	private @Id @GeneratedValue Long id;
	
	private int size;
	private int difficulty;
	@Lob
	private Integer[][] solution; 
	@Lob
	private Integer[][] color;
}