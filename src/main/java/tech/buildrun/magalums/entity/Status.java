package tech.buildrun.magalums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_status")
public class Status {

    @Id
    private Long statusId;

    private String description;

    public Status() {
    }

    public Status(Long statusId, String description) {
        this.statusId = statusId;
        this.description = description;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {
        PENDING(1L, "pendente"),
        SUCCESS(2L, "sucesso"),
        ERROR(3L, "erro"),
        CANCELLED(4L, "cancelado");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Status toStatus(){
            return new Status(id, description);
        }
    }
}
