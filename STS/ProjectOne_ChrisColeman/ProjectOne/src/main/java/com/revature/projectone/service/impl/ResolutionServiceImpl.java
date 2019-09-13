package com.revature.projectone.service.impl;

import java.util.List;

import com.revature.projectone.dao.impl.ResolutionDAOImpl;
import com.revature.projectone.model.Resolution;
import com.revature.projectone.service.ResolutionService;

public class ResolutionServiceImpl implements ResolutionService {
	
	ResolutionDAOImpl resolutionDAO = new ResolutionDAOImpl();

	@Override
	public List<Resolution> getResolutions() {
		return resolutionDAO.getResolutions();
	}

	@Override
	public Resolution getResolutionById(int id) {

		return resolutionDAO.getResolutionById(id);
	}

	@Override
	public int createResolution(Resolution res) {

		return resolutionDAO.createResolution(res);
	}

	@Override
	public int updateResolution(Resolution res) {

		return resolutionDAO.updateResolution(res);
	}

}
