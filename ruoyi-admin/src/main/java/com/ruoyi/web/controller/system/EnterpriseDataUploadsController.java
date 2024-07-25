package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.EnterpriseDataUploads;
import com.ruoyi.system.service.IEnterpriseDataUploadsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 上传数据Controller
 * 
 * @author ruoyi
 * @date 2024-07-25
 */
@RestController
@RequestMapping("/system/uploads")
public class EnterpriseDataUploadsController extends BaseController
{
    @Autowired
    private IEnterpriseDataUploadsService enterpriseDataUploadsService;

    /**
     * 查询上传数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:uploads:list')")
    @GetMapping("/list")
    public TableDataInfo list(EnterpriseDataUploads enterpriseDataUploads)
    {
        startPage();
        List<EnterpriseDataUploads> list = enterpriseDataUploadsService.selectEnterpriseDataUploadsList(enterpriseDataUploads);
        return getDataTable(list);
    }

    /**
     * 导出上传数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:uploads:export')")
    @Log(title = "上传数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EnterpriseDataUploads enterpriseDataUploads)
    {
        List<EnterpriseDataUploads> list = enterpriseDataUploadsService.selectEnterpriseDataUploadsList(enterpriseDataUploads);
        ExcelUtil<EnterpriseDataUploads> util = new ExcelUtil<EnterpriseDataUploads>(EnterpriseDataUploads.class);
        util.exportExcel(response, list, "上传数据数据");
    }

    /**
     * 获取上传数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:uploads:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(enterpriseDataUploadsService.selectEnterpriseDataUploadsById(id));
    }

    /**
     * 新增上传数据
     */
    @PreAuthorize("@ss.hasPermi('system:uploads:add')")
    @Log(title = "上传数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EnterpriseDataUploads enterpriseDataUploads)
    {
        return toAjax(enterpriseDataUploadsService.insertEnterpriseDataUploads(enterpriseDataUploads));
    }

    /**
     * 修改上传数据
     */
    @PreAuthorize("@ss.hasPermi('system:uploads:edit')")
    @Log(title = "上传数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EnterpriseDataUploads enterpriseDataUploads)
    {
        return toAjax(enterpriseDataUploadsService.updateEnterpriseDataUploads(enterpriseDataUploads));
    }

    /**
     * 删除上传数据
     */
    @PreAuthorize("@ss.hasPermi('system:uploads:remove')")
    @Log(title = "上传数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(enterpriseDataUploadsService.deleteEnterpriseDataUploadsByIds(ids));
    }
}
