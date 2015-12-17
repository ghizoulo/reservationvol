package reservation.validators;

import javax.validation.constraints.NotNull;


public class PassagerClient {
		@NotNull
	    private String nomP;
		@NotNull
	    private String prenomP;
		@NotNull
	    private String num_passport;
		@NotNull
	    private String dateExpiration;
		@NotNull
	    private String nationalite;
	    
		@NotNull
	    private String nomC;
		
		@NotNull
		private String prenomC;
		
		@NotNull
		private String adresseC;
		
		@NotNull
		private String telephoneC;
		
		@NotNull
		private String mailC;

		public String getNomP() {
			return nomP;
		}

		public void setNomP(String nomP) {
			this.nomP = nomP;
		}

		public String getPrenomP() {
			return prenomP;
		}

		public void setPrenomP(String prenomP) {
			this.prenomP = prenomP;
		}

		public String getNum_passport() {
			return num_passport;
		}

		public void setNum_passport(String num_passport) {
			this.num_passport = num_passport;
		}

		public String getDateExpiration() {
			return dateExpiration;
		}

		public void setDateExpiration(String dateExpiration) {
			this.dateExpiration = dateExpiration;
		}

		public String getNationalite() {
			return nationalite;
		}

		public void setNationalite(String nationalite) {
			this.nationalite = nationalite;
		}

		public String getNomC() {
			return nomC;
		}

		public void setNomC(String nomC) {
			this.nomC = nomC;
		}

		public String getPrenomC() {
			return prenomC;
		}

		public void setPrenomC(String prenomC) {
			this.prenomC = prenomC;
		}

		public String getAdresseC() {
			return adresseC;
		}

		public void setAdresseC(String adresseC) {
			this.adresseC = adresseC;
		}

		public String getTelephoneC() {
			return telephoneC;
		}

		public void setTelephoneC(String telephoneC) {
			this.telephoneC = telephoneC;
		}

		public String getMailC() {
			return mailC;
		}

		public void setMailC(String mailC) {
			this.mailC = mailC;
		}
	   
	   
}
