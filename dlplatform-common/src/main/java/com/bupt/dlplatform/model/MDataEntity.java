package com.bupt.dlplatform.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by huhx on 2020/9/28
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "m_data_entity")
public class MDataEntity<T> {
    @Id
    private String id;

    private String name;

    private Long createTimestamp;

    private Long lastTimestamp;

    private String type; // list,figure,picture,video,map,heartbeat

    private T value;

    private Boolean isDeleted;

}
