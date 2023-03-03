package kg.bektur.Restaurant.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class AbstractEntity implements Serializable {
    @Id
    @Column(name = "id", insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "created", updatable = false)
    LocalDateTime createdAt;
    @Column(name = "updated", insertable = false)
    LocalDateTime updatedAt;
    @Column(name = "deleted")
    boolean deleted;

    @PrePersist
    public void toCreate() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }

}
