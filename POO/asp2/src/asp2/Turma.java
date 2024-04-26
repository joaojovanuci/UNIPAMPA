package asp2;

import java.util.Date;

public class Turma implements Comparable<Turma>{
	 private long codTurma;
	    private Date dataIni;
	    private Date dataFim;

	    public Turma(long codTurma, Date dataIni, Date dataFim) {
	        this.codTurma = codTurma;
	        this.dataIni = dataIni;
	        this.dataFim = dataFim;
	    }
	    
	    public String toString() {
	        return "Turma:" +
	                "" + codTurma +
	                ", Início=" + dataIni +
	                ", Fim=" + dataFim 
	                ;
	    }

	    public long getCodTurma() {
	        return codTurma;
	    }

	    public void setCodTurma(long codTurma) {
	        this.codTurma = codTurma;
	    }

	    public Date getDataIni() {
	        return dataIni;
	    }

	    public void setDataIni(Date dataIni) {
	        this.dataIni = dataIni;
	    }

	    public Date getDataFim() {
	        return dataFim;
	    }

	    public void setDataFim(Date dataFim) {
	        this.dataFim = dataFim;
	    }

	    @Override
	    public int compareTo(Turma outraTurma) {
	        return Long.compare(this.codTurma, outraTurma.codTurma);
	    }
}
