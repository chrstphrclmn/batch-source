package com.revature.projectone.model;

public class Resolution {
	
	private int requestId;
	private String managerUsername;
	private boolean decision;
	private String reason;
	
	
	public Resolution(int requestId, String managerUsername, boolean decision, String reason) {
		super();
		this.requestId = requestId;
		this.managerUsername = managerUsername;
		this.decision = decision;
		this.reason = reason;
	}


	public int getRequestId() {
		return requestId;
	}


	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}


	public String getManagerUsername() {
		return managerUsername;
	}


	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}


	public boolean isDecision() {
		return decision;
	}


	public void setDecision(boolean decision) {
		this.decision = decision;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (decision ? 1231 : 1237);
		result = prime * result + ((managerUsername == null) ? 0 : managerUsername.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + requestId;
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
		Resolution other = (Resolution) obj;
		if (decision != other.decision)
			return false;
		if (managerUsername == null) {
			if (other.managerUsername != null)
				return false;
		} else if (!managerUsername.equals(other.managerUsername))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (requestId != other.requestId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Resolution [requestId=" + requestId + ", managerUsername=" + managerUsername + ", decision=" + decision
				+ ", reason=" + reason + "]";
	}
	
	

}
