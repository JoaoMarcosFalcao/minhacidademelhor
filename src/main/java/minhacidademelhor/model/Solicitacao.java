package minhacidademelhor.model;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Solicitacao {

	private long id;
	private LocalDate dataAbertura;
	//private List<Anexo> anexos;
	private Usuario usuario;
	private LocalDate dataResposta;
	private LocalDate dataPrevisaoSolucao;
	
	public Solicitacao() {
		super();
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	//public List<Anexo> getAnexos() {
	//	return anexos;
	//}
	//public void setAnexos(List<Anexo> anexos) {
	//	this.anexos = anexos;
	//}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public LocalDate getDataResposta() {
		return dataResposta;
	}
	public void setDataResposta(LocalDate dataResposta) {
		this.dataResposta = dataResposta;
	}
	public LocalDate getDataPrevisaoSolucao() {
		return dataPrevisaoSolucao;
	}
	public void setDataPrevisaoSolucao(LocalDate dataPrevisaoSolucao) {
		this.dataPrevisaoSolucao = dataPrevisaoSolucao;
	}
	
}
