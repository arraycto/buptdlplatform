package com.bupt.dlplatform.service.impl;

import com.bupt.dlplatform.data.ResponseCode;
import com.bupt.dlplatform.exception.ServiceException;
import com.bupt.dlplatform.mapper.MDisplayEntityRepository;
import com.bupt.dlplatform.model.MDataEntity;
import com.bupt.dlplatform.model.MDisplayEntity;
import com.bupt.dlplatform.service.DataDisplayService;
import com.bupt.dlplatform.util.IdGenerator;
import com.bupt.dlplatform.util.TypeUtil;
import com.bupt.dlplatform.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by huhx on 2020/10/3
 */
@Slf4j
@Service
public class DataDisplayServiceImpl implements DataDisplayService {
    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private MDisplayEntityRepository mDisplayEntityRepository;


    /**
     * 新建配置
     */
    @Override
    public ResponseVO createMDisplayEntity(MDisplayEntityInputVO request){
        long  nowTimestamp =  System.currentTimeMillis();
        ResponseVO responseVO = new ResponseVO(ResponseCode.SYSTEM_EXCEPTION);

        try {
            MDisplayEntity mDisplayEntity = new MDisplayEntity();
            mDisplayEntity.setId(idGenerator.nextId());
            mDisplayEntity.setName( request.getName() != null ? request.getName() : "" );
            mDisplayEntity.setDesc( request.getDesc() != null ? request.getDesc() : "" );
            if( request.getType() != null ){
                mDisplayEntity.setType( request.getType() );
            }else{
                throw new ServiceException("必须提供type");
            }
            mDisplayEntity.setConfigs( request.getConfigs() );
            if( request.getDataId() != null ){
                mDisplayEntity.setDataId( request.getDataId() );
            }else{
                throw new ServiceException("必须提供DataId");
            }
            mDisplayEntity.setCreateTimestamp(nowTimestamp);
            mDisplayEntity.setIsDeleted(false);
            mDisplayEntityRepository.save(mDisplayEntity);

            responseVO.setCode(ResponseCode.OK.value());
            responseVO.setMsg(ResponseCode.OK.getDescription());
            responseVO.setData("OK");
            return responseVO;

        }catch ( ServiceException e ){
            log.error("MConfig更新异常", e);
            return responseVO;
        }catch (Exception e){
            log.error("MConfig更新异常", e);
            return responseVO;
        }
    }

    /**
     * 更新配置
     */
    @Override
    public ResponseVO updateMDisplayEntity(MDisplayEntityInputVO request){
        ResponseVO responseVO =new ResponseVO(ResponseCode.SYSTEM_EXCEPTION);

        try {
            Optional<MDisplayEntity> opt = mDisplayEntityRepository.findById(request.getId());
            MDisplayEntity mDisplayEntity;
            if( opt.isPresent() ){
                mDisplayEntity = opt.get();
            }else{
                throw new ServiceException("未找到该数据");
            }

            if( request.getName() != null ){
                mDisplayEntity.setName( request.getName() );
            }
            if( request.getDesc() != null ){
                mDisplayEntity.setDesc( request.getDesc() );
            }
            if( request.getConfigs() != null ){
                mDisplayEntity.setConfigs( request.getConfigs() );
            }
            if( request.getDataId() != null ){
                mDisplayEntity.setDataId( request.getDataId() );
            }
            mDisplayEntityRepository.save(mDisplayEntity);

            responseVO.setCode(ResponseCode.OK.value());
            responseVO.setMsg(ResponseCode.OK.getDescription());
            responseVO.setData("OK");
            return responseVO;

        }catch (Exception e){
            log.error("MConfig更新异常", e);
            return responseVO;
        }
    }

    /**
     * 读取一个配置（Id方式）
     */
    @Override
    public ResponseVO<MDisplayEntityOutputVO> getMDisplayEntityById(String id){
        ResponseVO responseVO =new ResponseVO(ResponseCode.SYSTEM_EXCEPTION);

        try {
            MDisplayEntity mDisplayEntity;
            Optional<MDisplayEntity> opt = mDisplayEntityRepository.findById(id); //"N1310975139973697536"
            if( opt.isPresent() ){
                mDisplayEntity = opt.get();
                if( mDisplayEntity.getIsDeleted() ){
                    throw new ServiceException("数据已删除");
                }
            }else{
                throw new ServiceException("未找到该数据");
            }

            responseVO.setCode(ResponseCode.OK.value());
            responseVO.setMsg(ResponseCode.OK.getDescription());
            responseVO.setData(new MDisplayEntityOutputVO(mDisplayEntity));
            return responseVO;
        }catch( ServiceException e){
            log.error("MConfig读取异常", e);
            return responseVO;
        }catch (Exception e){
            log.error("MConfig读取异常", e);
            return responseVO;
        }
    }

    /**
     * 删除配置
     */
    @Override
    public ResponseVO deleteMDisplayEntity(String id){
        ResponseVO responseVO = new ResponseVO(ResponseCode.SYSTEM_EXCEPTION);

        try {
            MDisplayEntity mDisplayEntity;
            Optional<MDisplayEntity> opt = mDisplayEntityRepository.findById(id); //"N1310975139973697536"
            if( opt.isPresent() ){
                mDisplayEntity = opt.get();
                mDisplayEntity.setIsDeleted(true);
                mDisplayEntityRepository.save(mDisplayEntity);
            }else{
                throw new ServiceException("未找到该数据");
            }

            responseVO.setCode(ResponseCode.OK.value());
            responseVO.setMsg(ResponseCode.OK.getDescription());
            responseVO.setData("OK");
            return responseVO;

        }catch (Exception e){
            log.error("MConfig删除异常", e);
            return responseVO;
        }
    }
}
