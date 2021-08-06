/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "authors")
@NoArgsConstructor
public class Author implements Serializable {

    private static final long serialVersionUID = 190667348552556409L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String authorUuid;

    @Lob
    private String bio;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;
}
