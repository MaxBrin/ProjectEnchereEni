package fr.eni.projetenchere.bo;

import java.io.Serializable;

public class Retrait implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int noArticle;
		private String rue;
		private String codePostal;
		private String ville;
		
		
		public Retrait() {
			super();
		}


		public Retrait(String rue, String codePostal, String ville) {
			super();
			this.rue = rue;
			this.codePostal = codePostal;
			this.ville = ville;
		}


		public Retrait(int noArticle, String rue, String codePostal, String ville) {
			super();
			this.noArticle = noArticle;
			this.rue = rue;
			this.codePostal = codePostal;
			this.ville = ville;
		}


		public int getNoArticle() {
			return noArticle;
		}


		public void setNoArticle(int noArticle) {
			this.noArticle = noArticle;
		}


		public String getRue() {
			return rue;
		}


		public void setRue(String rue) {
			this.rue = rue;
		}


		public String getCodePostal() {
			return codePostal;
		}


		public void setCodePostal(String codePostal) {
			this.codePostal = codePostal;
		}


		public String getVille() {
			return ville;
		}


		public void setVille(String ville) {
			this.ville = ville;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		@Override
		public String toString() {
			return "Retrait [noArticle=" + noArticle + ", rue=" + rue + ", codePostal=" + codePostal + ", ville="
					+ ville + "]";
		}
		
		
}
