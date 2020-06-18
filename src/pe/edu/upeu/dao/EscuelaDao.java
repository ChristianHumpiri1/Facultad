package pe.edu.upeu.dao;

import java.util.List;

import pe.edu.upeu.entity.Escuela;

public interface EscuelaDao {
	public int create(Escuela u);
	public int update(Escuela u);
	public int delete(int id);
	public Escuela read(int id);
	public List<Escuela> readAll();
}
