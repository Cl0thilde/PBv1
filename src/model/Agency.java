package model;

import java.util.List;

public class Agency {

	// Attributes
	private String idAgency, creationDate;
	private AgencyManager agencyManager;
	private List<CustomerAdvisor> listCustomerAdvisors;
	private static char[] idAgencyMaker = { '0', '0', '0', '0', '0' };

	// Constructor
	public Agency(String idAgency, String creationDate, AgencyManager agencyManager,
			List<CustomerAdvisor> listCustomerAdvisors) {
		this.idAgency = idAgency;
		this.creationDate = creationDate;
		this.agencyManager = agencyManager;
		this.listCustomerAdvisors = listCustomerAdvisors;
		idAgency = createID();
	}

	// Getters & setters
	public String getId() {
		return idAgency;
	}

	public void setId(String idAgency) {
		this.idAgency = idAgency;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public AgencyManager getAgencyManager() {
		return agencyManager;
	}

	public void setAgencyManager(AgencyManager agencyManager) {
		this.agencyManager = agencyManager;
	}

	public List<CustomerAdvisor> getListCustomerAdvisors() {
		return listCustomerAdvisors;
	}

	public void setListCustomerAdvisors(List<CustomerAdvisor> listCustomerAdvisors) {
		this.listCustomerAdvisors = listCustomerAdvisors;
	}

	@Override
	public String toString() {
		return "Agency [id=" + idAgency + ", creationDate=" + creationDate + ", agencyManager=" + agencyManager
				+ ", listCustomerAdvisors=" + listCustomerAdvisors + "]";
	}

	private String createID() {
		String newID = "";
		for (int i = 0; i < 5; i++) {
			newID += idAgencyMaker[i];
		}
		for (int i = 4; i >= 0; i--) {
			if (idAgencyMaker[i] == 'z') {
				idAgencyMaker[i] = '0';
			}
			if (idAgencyMaker[i] == '9') {
				idAgencyMaker[i] = 'A';
			} else if (idAgencyMaker[i] == 'z') {
				idAgencyMaker[i] = 'a';
			} else {
				idAgencyMaker[i]++;
			}

		}
		return newID;
	}

}
