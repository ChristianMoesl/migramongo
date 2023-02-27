package com.rinoto.migramongo;

import java.util.Date;

import com.rinoto.migramongo.MigraMongoStatus.MigrationStatus;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MigrationRun {

    protected String info;
    protected MigrationStatus status;
    protected String statusMessage;
    @Builder.Default
    protected Date createdAt = new Date();
    protected Date updatedAt;

    public MigrationRun update(MigrationStatus status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.updatedAt = new Date();
        return this;
    }
}
