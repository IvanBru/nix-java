package entity;

public class OrderLine {

	private Long id;
	private Long id_item;
	private Long id_order;
	private Long quantity;
	
	public OrderLine() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_item() {
		return id_item;
	}

	public void setId_item(Long id_item) {
		this.id_item = id_item;
	}

	public Long getId_order() {
		return id_order;
	}

	public void setId_order(Long id_order) {
		this.id_order = id_order;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_item == null) ? 0 : id_item.hashCode());
		result = prime * result + ((id_order == null) ? 0 : id_order.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderLine other = (OrderLine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_item == null) {
			if (other.id_item != null)
				return false;
		} else if (!id_item.equals(other.id_item))
			return false;
		if (id_order == null) {
			if (other.id_order != null)
				return false;
		} else if (!id_order.equals(other.id_order))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", id_item=" + id_item + ", id_order=" + id_order + ", quantity=" + quantity
				+ "]";
	}
	
}
