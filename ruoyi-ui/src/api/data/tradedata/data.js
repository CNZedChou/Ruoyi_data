import request from '@/utils/request'

// 查询交易数据列表
export function listData(query) {
  return request({
    url: '/system/data/list',
    method: 'get',
    params: query
  })
}

// 查询交易数据详细
export function getData(id) {
  return request({
    url: '/system/data/' + id,
    method: 'get'
  })
}

// 新增交易数据
export function addData(data) {
  return request({
    url: '/system/data',
    method: 'post',
    data: data
  })
}

// 修改交易数据
export function updateData(data) {
  return request({
    url: '/system/data',
    method: 'put',
    data: data
  })
}

// 删除交易数据
export function delData(id) {
  return request({
    url: '/system/data/' + id,
    method: 'delete'
  })
}
