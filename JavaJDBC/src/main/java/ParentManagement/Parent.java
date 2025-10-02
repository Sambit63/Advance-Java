package ParentManagement;

public class Parent {
	private int id;
	private String name;
	private long phno;
	public Parent() {
	}
	public Parent(int id, String name, long phno) {
		super();
		this.id = id;
		this.name = name;
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + ", phno=" + phno + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
}
