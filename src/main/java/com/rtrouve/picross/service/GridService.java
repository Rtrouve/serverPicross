package com.rtrouve.picross.service;

import com.rtrouve.picross.bean.Grid;
import com.rtrouve.picross.dao.GridDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GridService {

    @Autowired
    private GridDAO gridDAO;

    public Grid getGrid(int id) throws Exception {
        Optional<Grid> gridFetched = gridDAO.get(id);

        if (gridFetched.isPresent()) {
            return gridFetched.get();
        } else {
            throw new Exception("TODO Better Exception");
        }
    }
}
