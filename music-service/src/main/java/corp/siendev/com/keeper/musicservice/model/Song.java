package corp.siendev.com.keeper.musicservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "music")
public class Song {
    private Long id;
    private String name;
    private String lyrics;
    private Album album;
    private Artist artist;
}
