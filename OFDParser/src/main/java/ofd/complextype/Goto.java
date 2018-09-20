package ofd.complextype;

public class Goto extends Act
{
	// 二选一
	private Dest dest;
	private Bookmark bookmark;
	
	public Dest getDest() {
		return dest;
	}
	public void setDest(Dest dest) {
		this.dest = dest;
	}
	public Bookmark getBookmark() {
		return bookmark;
	}
	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
	
	
}
