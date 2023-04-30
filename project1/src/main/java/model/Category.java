package model;

public class Category {
	private int category_num;
	private String name;
	private int boardid;

	public int getCategory_num() {
		return category_num;
	}

	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	@Override
	public String toString() {
		return "Category [category_num=" + category_num + ", name=" + name + ", boardid=" + boardid + "]";
	}
}
