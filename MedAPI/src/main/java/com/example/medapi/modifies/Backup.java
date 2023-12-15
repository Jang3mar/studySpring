package com.example.medapi.modifies;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Backup")
public class Backup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_backup;

    @Column(name = "file_Name")
    private String file_Name;

    @Column(name = "time_stamp")
    private LocalDateTime time_stamp;

    public Long getId_backup() {
        return id_backup;
    }

    public void setId_backup(Long id_backup) {
        this.id_backup = id_backup;
    }

    public String getFile_Name() {
        return file_Name;
    }

    public void setFile_Name(String file_Name) {
        this.file_Name = file_Name;
    }

    public LocalDateTime getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(LocalDateTime time_stamp) {
        this.time_stamp = time_stamp;
    }

    public Backup() {}

    public Backup(Long id_backup, String file_Name, LocalDateTime time_stamp) {
        this.id_backup = id_backup;
        this.file_Name = file_Name;
        this.time_stamp = time_stamp;
    }
}
