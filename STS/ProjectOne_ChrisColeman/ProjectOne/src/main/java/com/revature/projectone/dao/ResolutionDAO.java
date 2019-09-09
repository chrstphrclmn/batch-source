package com.revature.projectone.dao;

import java.util.List;

import com.revature.projectone.model.Resolution;

public interface ResolutionDAO {

	public List<Resolution> getResolutions();
	public Resolution getResolutionById();
	public int createResolution(Resolution res);
	public int updateResolution(Resolution res);
	
}
