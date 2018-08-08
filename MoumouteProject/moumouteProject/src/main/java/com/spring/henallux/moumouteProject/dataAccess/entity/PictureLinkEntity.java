package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "picturelink")
public class PictureLinkEntity
{
    @Id
    @Column(name = "link")
    private String link;

    @JoinColumn(name = "wigid", referencedColumnName = "id")
    @ManyToOne
    private WigEntity wig;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public WigEntity getWig() {
        return wig;
    }

    public void setWig(WigEntity wig) {
        this.wig = wig;
    }
}
