package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="student_details")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer studentId;

	@Column(name = "name")
	private String studentName;

	@Column(name = "fee")
	private Double studentFee;

	@Column(name = "is_current_student")
	private Boolean isCurrentStudent;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "modifiedAt")
	@LastModifiedDate
	private Date modifiedAt;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Double getStudentFee() {
		return studentFee;
	}

	public void setStudentFee(Double studentFee) {
		this.studentFee = studentFee;
	}

	public Boolean getIsCurrentStudent() {
		return isCurrentStudent;
	}

	public void setIsCurrentStudent(Boolean isCurrentStudent) {
		this.isCurrentStudent = isCurrentStudent;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [studentId=");
		builder.append(studentId);
		builder.append(", studentName=");
		builder.append(studentName);
		builder.append(", studentFee=");
		builder.append(studentFee);
		builder.append(", isCurrentStudent=");
		builder.append(isCurrentStudent);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", modifiedAt=");
		builder.append(modifiedAt);
		builder.append("]");
		return builder.toString();
	}

}
