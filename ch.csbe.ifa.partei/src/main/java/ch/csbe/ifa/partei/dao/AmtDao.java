package ch.csbe.ifa.partei.dao;

import java.util.List;

import org.hibernate.Query;

import ch.csbe.ifa.partei.model.Amt;

public class AmtDao {
	@SuppressWarnings("unchecked")
	public List<Amt> list(){
		Query query = Database.getInstance().getSession().createQuery("from Amt");

		return query.list();
	}
}
