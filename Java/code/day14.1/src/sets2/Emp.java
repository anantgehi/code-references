package sets2;

public class Emp {
	private int id;
	private String name;
	private String deptId;
	private double salary;

	public Emp(int id, String name, String deptId, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", deptId=" + deptId + ", salary=" + salary + "]";
	}

	
	//IDE GENERATED HASHCODE AND EQUALS METHOD
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
//		result = prime * result + id;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Emp other = (Emp) obj;
//		if (deptId == null) {
//			if (other.deptId != null)
//				return false;
//		} else if (!deptId.equals(other.deptId))
//			return false;
//		if (id != other.id)
//			return false;
//		return true;
//	}

	// follow Mandatory + optional part of the contract between overrirding of
	// hashCode n equals
	// 1. PK n override equals
	@Override
	public boolean equals(Object o) {
		System.out.println("in emp equals");
		if (o instanceof Emp) {
			Emp e = (Emp) o;
			return id == e.id && deptId.equals(e.deptId);
		}
		return false;

	}
	@Override
	public int hashCode()
	{
		System.out.println("in emp's hashCode");
		return 17*(id+deptId.hashCode());		
	}
	

}
