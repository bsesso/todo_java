package todolist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class TodoItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String content;
	private boolean done;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}