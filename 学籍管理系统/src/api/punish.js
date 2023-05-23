import request from '@/utils/request'

export function getList(current, pageSize) {
  return request({
    url: `/punish/list/${current}/${pageSize}`,
    method: 'get'
  })
}

export function edit(url, punish) {
  return request({
    url: url,
    method: 'post',
    data: punish,
    headers: {
      'Content-type': 'application/json'
    }
  })
}

export function del(id) {
  return request({
    url: `/punish/del/${id}`,
    method: 'delete'
  })
}