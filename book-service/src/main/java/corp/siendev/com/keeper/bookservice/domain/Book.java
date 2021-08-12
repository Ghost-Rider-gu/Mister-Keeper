/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "books")
@NoArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 136067348552556409L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String bookUuid;

    @NotEmpty
    private String title;

    private String description;

    @NotEmpty
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name="author_uuid", nullable=false)
    private Author author;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
