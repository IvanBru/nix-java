package entity;

import java.sql.Date;

public class Order {

	private Long id;
	private Long id_customer;
	private Date date;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_customer() {
		return id_customer;
	}

	public void setId_customer(Long id_customer) {
		this.id_customer = id_customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_customer == null) ? 0 : id_customer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_customer == null) {
			if (other.id_customer != null)
				return false;
		} else if (!id_customer.equals(other.id_customer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", id_customer=" + id_customer + ", date=" + date + "]";
	}
	
}
