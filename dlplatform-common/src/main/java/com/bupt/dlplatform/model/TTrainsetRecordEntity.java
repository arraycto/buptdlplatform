package com.bupt.dlplatform.model;;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhongling
 * @since 2019-09-18
 */
@Data
@Accessors(chain = true)
@TableName("t_trainset_record")
public class TTrainsetRecordEntity{

    private static final long serialVersionUID = 1L;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String trainsetId;

    private String userId;


}
