import request from '@/utils/request'

export function getList(current, pageSize) {
  return request({
    url: `/status/list/${current}/${pageSize}`,
    method: 'get'
  })
}

export function edit(url, status) {
  return request({
    url: url,
    method: 'post',
    data: status,
    headers: {
      'Content-type': 'application/json'
    }
  })
}

export function del(id) {
  return request({
    url: `/status/del/${id}`,
    method: 'delete'
  })
}