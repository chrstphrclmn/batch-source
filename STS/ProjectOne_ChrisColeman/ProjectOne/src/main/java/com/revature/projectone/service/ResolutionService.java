package com.revature.projectone.service;

import java.util.List;

import com.revature.projectone.model.Resolution;

public interface ResolutionService {
	
	public List<Resolution> getResolutions();
	public Resolution getResolutionById(int id);
	public int createResolution(Resolution res);
	public int updateResolution(Resolution res);

}
