package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EnterpriseDataUploadsMapper;
import com.ruoyi.system.domain.EnterpriseDataUploads;
import com.ruoyi.system.service.IEnterpriseDataUploadsService;

/**
 * 上传数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-25
 */
@Service
public class EnterpriseDataUploadsServiceImpl implements IEnterpriseDataUploadsService 
{
    @Autowired
    private EnterpriseDataUploadsMapper enterpriseDataUploadsMapper;

    /**
     * 查询上传数据
     * 
     * @param id 上传数据主键
     * @return 上传数据
     */
    @Override
    public EnterpriseDataUploads selectEnterpriseDataUploadsById(Long id)
    {
        return enterpriseDataUploadsMapper.selectEnterpriseDataUploadsById(id);
    }

    /**
     * 查询上传数据列表
     * 
     * @param enterpriseDataUploads 上传数据
     * @return 上传数据
     */
    @Override
    public List<EnterpriseDataUploads> selectEnterpriseDataUploadsList(EnterpriseDataUploads enterpriseDataUploads)
    {
        return enterpriseDataUploadsMapper.selectEnterpriseDataUploadsList(enterpriseDataUploads);
    }

    /**
     * 新增上传数据
     * 
     * @param enterpriseDataUploads 上传数据
     * @return 结果
     */
    @Override
    public int insertEnterpriseDataUploads(EnterpriseDataUploads enterpriseDataUploads)
    {
        return enterpriseDataUploadsMapper.insertEnterpriseDataUploads(enterpriseDataUploads);
    }

    /**
     * 修改上传数据
     * 
     * @param enterpriseDataUploads 上传数据
     * @return 结果
     */
    @Override
    public int updateEnterpriseDataUploads(EnterpriseDataUploads enterpriseDataUploads)
    {
        return enterpriseDataUploadsMapper.updateEnterpriseDataUploads(enterpriseDataUploads);
    }

    /**
     * 批量删除上传数据
     * 
     * @param ids 需要删除的上传数据主键
     * @return 结果
     */
    @Override
    public int deleteEnterpriseDataUploadsByIds(Long[] ids)
    {
        return enterpriseDataUploadsMapper.deleteEnterpriseDataUploadsByIds(ids);
    }

    /**
     * 删除上传数据信息
     * 
     * @param id 上传数据主键
     * @return 结果
     */
    @Override
    public int deleteEnterpriseDataUploadsById(Long id)
    {
        return enterpriseDataUploadsMapper.deleteEnterpriseDataUploadsById(id);
    }
}
