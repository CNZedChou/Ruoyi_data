package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EnterpriseDataUploads;

/**
 * 上传数据Service接口
 * 
 * @author ruoyi
 * @date 2024-07-25
 */
public interface IEnterpriseDataUploadsService 
{
    /**
     * 查询上传数据
     * 
     * @param id 上传数据主键
     * @return 上传数据
     */
    public EnterpriseDataUploads selectEnterpriseDataUploadsById(Long id);

    /**
     * 查询上传数据列表
     * 
     * @param enterpriseDataUploads 上传数据
     * @return 上传数据集合
     */
    public List<EnterpriseDataUploads> selectEnterpriseDataUploadsList(EnterpriseDataUploads enterpriseDataUploads);

    /**
     * 新增上传数据
     * 
     * @param enterpriseDataUploads 上传数据
     * @return 结果
     */
    public int insertEnterpriseDataUploads(EnterpriseDataUploads enterpriseDataUploads);

    /**
     * 修改上传数据
     * 
     * @param enterpriseDataUploads 上传数据
     * @return 结果
     */
    public int updateEnterpriseDataUploads(EnterpriseDataUploads enterpriseDataUploads);

    /**
     * 批量删除上传数据
     * 
     * @param ids 需要删除的上传数据主键集合
     * @return 结果
     */
    public int deleteEnterpriseDataUploadsByIds(Long[] ids);

    /**
     * 删除上传数据信息
     * 
     * @param id 上传数据主键
     * @return 结果
     */
    public int deleteEnterpriseDataUploadsById(Long id);
}
