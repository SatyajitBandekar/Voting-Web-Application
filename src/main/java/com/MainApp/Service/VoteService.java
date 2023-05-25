package com.MainApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Model.Vote;
import com.MainApp.Repository.VoteRepository;

@Service
public class VoteService {
	
	@Autowired
	private VoteRepository vRepo;
	
	
	public Vote saveVote(Vote vote)
	{
		return vRepo.save(vote);
	}
	
	public long countVotes(String vote)
	{
		return vRepo.countByVote(vote);
	}
	
	public Vote getByUsername(String username)
	{
		return vRepo.findByUsername(username);
	}

}
