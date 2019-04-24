package com.rtrouve.picross;

import com.rtrouve.picross.bean.Grid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface GridRepository extends JpaRepository<Grid, Long> {

}
