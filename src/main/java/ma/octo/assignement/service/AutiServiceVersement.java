package ma.octo.assignement.service;

public interface AutiServiceVersement {
	public void auditVersement(String nrCompte,String message,double montant);

	public String auditVirementString(String string);

}
