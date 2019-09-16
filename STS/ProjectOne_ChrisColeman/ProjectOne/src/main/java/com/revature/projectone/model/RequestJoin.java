package com.revature.projectone.model;

public class RequestJoin {
	private Request request;
	private Resolution resolution;
	
	public RequestJoin(Request request, Resolution resolution) {
		super();
		this.request = request;
		this.resolution = resolution;
	}
	public RequestJoin() {
		super();
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Resolution getResolution() {
		return resolution;
	}
	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		result = prime * result + ((resolution == null) ? 0 : resolution.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestJoin other = (RequestJoin) obj;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		if (resolution == null) {
			if (other.resolution != null)
				return false;
		} else if (!resolution.equals(other.resolution))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RequestJoin [request=" + request + ", resolution=" + resolution + "]";
	}
	
	

}
