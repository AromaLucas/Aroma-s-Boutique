package com.niit.DAO;

import java.util.List;

import com.niit.Model.Suplier;

public interface SuplierDAO {

	public boolean addSuplier(Suplier suplier);
	public boolean updateSuplier(Suplier suplier);
	public boolean deleteSuplier(Suplier suplier);
	public List<Suplier> listSupliers();
	public Suplier getSuplier(int suplierId);

}
