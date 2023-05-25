package com.MainApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Model.Vote;
@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
	
	long countByVote(String vote);
	
	Vote findByUsername(String username);

}
