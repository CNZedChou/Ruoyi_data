import request from '@/utils/request'

// 查询上传数据列表
export function listUploads(query) {
  return request({
    url: '/system/uploads/list',
    method: 'get',
    params: query
  })
}

// 查询上传数据详细
export function getUploads(id) {
  return request({
    url: '/system/uploads/' + id,
    method: 'get'
  })
}

// 新增上传数据
export function addUploads(data) {
  return request({
    url: '/system/uploads',
    method: 'post',
    data: data
  })
}

// 修改上传数据
export function updateUploads(data) {
  return request({
    url: '/system/uploads',
    method: 'put',
    data: data
  })
}

// 删除上传数据
export function delUploads(id) {
  return request({
    url: '/system/uploads/' + id,
    method: 'delete'
  })
}
