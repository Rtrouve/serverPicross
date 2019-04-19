package com.rtrouve.picross;

import lombok.Data;

@Data
public class Grid {
	private final Long id;
	
	private Case[][] solution;
}
