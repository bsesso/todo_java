package todolist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;


@Entity
class TodoItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String content;

	@Column(name="done", columnDefinition="boolean default false")
	private boolean done;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@CreationTimestamp
	private Date createdAt;

	public Integer getId() {
		return id;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}
}