package gov.omsb.vehpc.appeal.dto.web;

public class EquivalencyAppealStatus {
	
	
	 	private long eQAppealId;

	    private long statusId;

	    private long eqLevelId;

	    private boolean iscommitte;

	    private boolean isAdmin;

	    private boolean isPresident;

	    private long lruserId;

	    private String message;
	    
	    private String dateCreated;
	    
	    private String fullName;
	    
	    private String eqLevel;
	    
	    private String roleType;
	    
	    

		public String getEqLevel() {
			return eqLevel;
		}

		public void setEqLevel(String eqLevel) {
			this.eqLevel = eqLevel;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(String dateCreated) {
			this.dateCreated = dateCreated;
		}

		public long geteQAppealId() {
			return eQAppealId;
		}

		public void seteQAppealId(long eQAppealId) {
			this.eQAppealId = eQAppealId;
		}

		public long getStatusId() {
			return statusId;
		}

		public void setStatusId(long statusId) {
			this.statusId = statusId;
		}

		public long getEqLevelId() {
			return eqLevelId;
		}

		public void setEqLevelId(long eqLevelId) {
			this.eqLevelId = eqLevelId;
		}


		

		public boolean isIscommitte() {
			return iscommitte;
		}

		public void setIscommitte(boolean iscommitte) {
			this.iscommitte = iscommitte;
		}

		public boolean isIsAdmin() {
			return isAdmin;
		}

		public void setIsAdmin(boolean isIsAdmin) {
			this.isAdmin = isIsAdmin;
		}

		

		public boolean isIsPresident() {
			return isPresident;
		}

		public void setIsPresident(boolean isIsPresident) {
			this.isPresident = isIsPresident;
		}

		public long getLruserId() {
			return lruserId;
		}

		public void setLruserId(long lruserId) {
			this.lruserId = lruserId;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getRoleType() {
			return roleType;
		}

		public void setRoleType(String roleType) {
			this.roleType = roleType;
		}
	    
		
	    

}
