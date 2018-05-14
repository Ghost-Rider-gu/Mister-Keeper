package corp.siendev.com.misterkeeper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = {"userPassword", "deletedDate"}, allowGetters = true)
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank
    public String userName;

    @NotBlank
    public String userLogin;

    @NotBlank
    public String userPassword;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    public Date deletedDate;

}
