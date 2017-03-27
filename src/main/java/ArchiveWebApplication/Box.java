package ArchiveWebApplication;

import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by 33558 on 14.03.2017.
 */

@Entity
@Table(name = "box")
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String name;
    @Column(name = "archive", columnDefinition = "LONGBLOB NOT NULL")
    private byte[] archive;
    @Column
    private Date date;

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", archive=" + Arrays.toString(archive) +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArchive(byte[] archive) {
        this.archive = archive;
    }

    public byte[] getArchive() {
        return archive;
    }

    public Box() {
    }
}
