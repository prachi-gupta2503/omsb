package omsb.vehpc.equivalency.dto.web;

import java.util.List;

public class EquivalencyRequestStatusComments {
private long id;
private String comments;
private List<String> commentedBy;
private long equivalencyRequestId;
private long equivalencyStatusId;
private long commenterUserId;
private String userName;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}

public List<String> getCommentedBy() {
	return commentedBy;
}
public void setCommentedBy(List<String> commentedBy) {
	this.commentedBy = commentedBy;
}
public long getEquivalencyRequestId() {
	return equivalencyRequestId;
}
public void setEquivalencyRequestId(long equivalencyRequestId) {
	this.equivalencyRequestId = equivalencyRequestId;
}

public long getEquivalencyStatusId() {
	return equivalencyStatusId;
}
public void setEquivalencyStatusId(long equivalencyStatusId) {
	this.equivalencyStatusId = equivalencyStatusId;
}
public long getCommenterUserId() {
	return commenterUserId;
}
public void setCommenterUserId(long commenterUserId) {
	this.commenterUserId = commenterUserId;
}

}
