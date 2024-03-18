package com.example.SpringDataJPAManyToManyMapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringDataJPAManyToManyMapping.dao.MovieRepository;
import com.example.SpringDataJPAManyToManyMapping.entity.Movie;

@Service
public class TheaterService {
	@Autowired
	private MovieRepository mrepo;
	public void saveMovie(Movie movie) {
		try {
			mrepo.save(movie);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
