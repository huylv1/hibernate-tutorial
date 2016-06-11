package com.madhusudhan.jh.advanced.cascade.one2one;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PostDetails {
 
    @Id
    private Long id;
 
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();
 
    private boolean visible;
 
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Post post;
 
    public Long getId() {
        return id;
    }
 
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    /**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	public void setPost(Post post) {
        this.post = post;
    }
}
